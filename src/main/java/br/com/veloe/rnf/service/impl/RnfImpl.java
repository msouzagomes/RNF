package br.com.veloe.rnf.service.impl;

import br.com.veloe.rnf.builder.EntityBuilder;
import br.com.veloe.rnf.client.OneSignalClient;
import br.com.veloe.rnf.config.StatusEnvio;
import br.com.veloe.rnf.entity.*;
import br.com.veloe.rnf.model.request.ConfiguracaoVeiculo;
import br.com.veloe.rnf.model.request.Nf;
import br.com.veloe.rnf.model.request.TransacoesRnf;
import br.com.veloe.rnf.repository.*;
import br.com.veloe.rnf.service.RnfService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RnfImpl implements RnfService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private OneSignalClient oneSignalClient;

    @Autowired
    private EntityBuilder entityBuilder;
    private ConfigRnfRepository configRnfRepository;
    private ConfigEcRepository configEcRepository;
    private ConfiguracaoVeiculoRepository configuracaoVeiculoRepository;
    private ClienteRepository clienteRepository;
    private NfRepository nfRepository;
    private EnderecoRepository enderecoRepository;
    private ItemRepository itemRepository;
    private ImpostoRepository impostoRepository;
    private CombustivelRepository combustivelRepository;
    private CideRepository cideRepository;

    private ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger logger = LogManager.getLogger(RnfImpl.class);

    public RnfImpl(ConfigRnfRepository configRnfRepository, ConfigEcRepository configEcRepository, ConfiguracaoVeiculoRepository configuracaoVeiculoRepository, ClienteRepository clienteRepository, NfRepository nfRepository, EnderecoRepository enderecoRepository, ItemRepository itemRepository, ImpostoRepository impostoRepository, CombustivelRepository combustivelRepository, CideRepository cideRepository) {
        this.configRnfRepository = configRnfRepository;
        this.configEcRepository = configEcRepository;
        this.configuracaoVeiculoRepository = configuracaoVeiculoRepository;
        this.clienteRepository = clienteRepository;
        this.nfRepository = nfRepository;
        this.enderecoRepository = enderecoRepository;
        this.itemRepository = itemRepository;
        this.impostoRepository = impostoRepository;
        this.combustivelRepository = combustivelRepository;
        this.cideRepository = cideRepository;
    }
    @Transactional(rollbackOn = Exception.class)
    @Override
    public Object postRnfTransacao(TransacoesRnf transacoesRnf, String statusEnvio) {
        try {
            if(StatusEnvio.EMITIDA.getDescricao().equalsIgnoreCase(statusEnvio)){
                this.updateShippingStatus(transacoesRnf);
            }else{
                List<RNFRoboEmissorNfConfigRnfEntity> result = this.configRnfRepository.findByConfigRnfIdAndIdFilial(transacoesRnf.getConfigRnf().getId(),transacoesRnf.getConfigRnf().getIdFilial());
                if(result.isEmpty()){
                    RNFRoboEmissorNfConfigRnfEntity configRnfEntity = this.configRnfRepository.save(this.entityBuilder.getConfigRnfEntity(transacoesRnf.getConfigRnf(), statusEnvio));
                    this.configEcRepository.save(this.entityBuilder.getConfigEcEntity(configRnfEntity, transacoesRnf.getConfigEc()));
                    this.saveConfiguracaoVeiculo(configRnfEntity, transacoesRnf.getConfigRnf().getConfiguracaoVeiculos());
                    this.saveNf(configRnfEntity, transacoesRnf.getNfs());
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.registerModule(new JavaTimeModule());
                    this.oneSignalClient.sendMessage(mapper.writeValueAsString(transacoesRnf), transacoesRnf.getConfigEc().getId());
                    return new ResponseEntity<>("Success", HttpStatus.OK);
                }
            }
        }catch (Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("ID já enviado " + transacoesRnf.getConfigRnf().getId() + "IdFilial  " + transacoesRnf.getConfigRnf().getIdFilial(), HttpStatus.NOT_FOUND);
    }
    public void saveConfiguracaoVeiculo(RNFRoboEmissorNfConfigRnfEntity configRnfEntity, List<ConfiguracaoVeiculo> confVeiculos) {
        confVeiculos.stream().forEach(c->{
            this.configuracaoVeiculoRepository.save(this.entityBuilder.getConfiguracaoVeiculo(configRnfEntity, c));
        });
    }
    public void saveNf(RNFRoboEmissorNfConfigRnfEntity configRnfEntity, List<Nf> nfs) {
        nfs.stream().forEach(n->{
            RNFRoboEmissorNfNfEntity nf = this.nfRepository.save(this.entityBuilder.getNfEntity(configRnfEntity, n));
            RNFRoboEmissorNfClienteEntity cliente = this.clienteRepository.save(this.entityBuilder.getClienteEntity(nf, n.getCliente()));
            RNFRoboEmissorNfEnderecoEntity endereco = this.enderecoRepository.save(this.entityBuilder.getEnderecoEntity(cliente, n.getCliente().getEndereco(), n.getEnviarPorEmail()));
            n.getItens().stream().forEach(i->{
                RNFRoboEmissorNfItemEntity item = this.itemRepository.save(this.entityBuilder.getItemEntity(nf,i));
                RNFRoboEmissorNfImpostoEntity imposto = this.impostoRepository.save(this.entityBuilder.getImpostoEntity(item,i.getImpostos()));
                RNFRoboEmissorNfCombustivelEntity combustivel = this.combustivelRepository.save(this.entityBuilder.getCombustivelEntity(item,i.getCombustivel()));
                RNFRoboEmissorNfCideEntity cide = this.cideRepository.save(this.entityBuilder.getCideEntity(combustivel, i.getCombustivel().getCide()));
            });
        });
    }

    public void updateShippingStatus(TransacoesRnf transacoesRnf){
        List<RNFRoboEmissorNfConfigRnfEntity> result = this.configRnfRepository.findByConfigRnfIdAndIdFilial(transacoesRnf.getConfigRnf().getId(),transacoesRnf.getConfigRnf().getIdFilial());
        result.stream().forEach(r->{
            if(!r.getStatusEnvio().equalsIgnoreCase(StatusEnvio.EMITIDA.getDescricao())){
                r.setStatusEnvio(StatusEnvio.EMITIDA.getDescricao());
                this.configRnfRepository.save(r);
            }
        });
    }
}
