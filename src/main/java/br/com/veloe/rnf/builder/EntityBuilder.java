package br.com.veloe.rnf.builder;

import br.com.veloe.rnf.config.StatusEnvio;
import br.com.veloe.rnf.entity.*;
import br.com.veloe.rnf.model.request.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
@AllArgsConstructor
@Builder
@Data
public class EntityBuilder {

   public RNFRoboEmissorNfConfigRnfEntity getConfigRnfEntity(ConfigRnf configRnf, String statusEnvio){
        return RNFRoboEmissorNfConfigRnfEntity.builder()
                .id(this.getUuidApp())
                .configRnfId(configRnf.getId())
                .dataInicio(configRnf.getDataInicio() != null? configRnf.getDataInicio().toInstant(): null)
                .dataFim(configRnf.getDataFim() != null? configRnf.getDataFim().toInstant(): null)
                .idFilial(configRnf.getIdFilial())
                .mostrarPlaca(configRnf.getMostrarPlaca())
                .mostrarCentroCusto(configRnf.getMostrarCentroCusto())
                .agruparNotaPor(configRnf.getAgruparNotaPor())
                .ativo(configRnf.getAtivo())
                .statusEnvio(!StringUtils.isNotEmpty(statusEnvio)?StatusEnvio.NAOEMITIDA.getDescricao():statusEnvio)
                .dataInclusao(Instant.now())
                .build();
    }
    public RNFRoboEmissorNfConfigEcEntity getConfigEcEntity(RNFRoboEmissorNfConfigRnfEntity rnfRoboEmissorNfConfigRnfEntity, ConfigEc configEc) {
        return RNFRoboEmissorNfConfigEcEntity.builder()
                .id(this.getUuidApp())
                .configEcId(configEc.getId())
                .rnfRoboEmissorNfConfigRnfEntity(rnfRoboEmissorNfConfigRnfEntity)
                .envioAutomatico(configEc.getEnvioAutomatico())
                .dataInicio(configEc.getDataInicio() != null?configEc.getDataInicio().toInstant():null)
                .dataFim(rnfRoboEmissorNfConfigRnfEntity.getDataFim())
                .ecId(configEc.getEcId())
                .build();
    }
    public RNFRoboEmissorNfConfiguracaoVeiculoEntity getConfiguracaoVeiculo(RNFRoboEmissorNfConfigRnfEntity rnfRoboEmissorNfConfigRnfEntity, ConfiguracaoVeiculo configuracaoVeiculos) {
        return RNFRoboEmissorNfConfiguracaoVeiculoEntity.builder()
                .id(this.getUuidApp())
                .idVeiculo(configuracaoVeiculos.getIdVeiculo())
                .configuracaoVeiculosId(configuracaoVeiculos.getId())
                .rnfRoboEmissorNfConfigRnfEntity(rnfRoboEmissorNfConfigRnfEntity)
                .build();
    }
    public RNFRoboEmissorNfNfEntity getNfEntity(RNFRoboEmissorNfConfigRnfEntity rnfRoboEmissorNfConfigRnfEntity, Nf nf) {
        return RNFRoboEmissorNfNfEntity.builder()
                .id(this.getUuidApp())
                .nfsId(nf.getId())
                .ambienteEmissao(nf.getAmbienteEmissao())
                .naturezaOperacao(nf.getNaturezaOperacao())
                .tipoOperacao(nf.getTipoOperacao())
                .finalidade(nf.getFinalidade())
                .consumidorFinal(nf.getConsumidorFinal())
                .indicadorPresencaConsumidor(nf.getIndicadorPresencaConsumidor())
                .rnfRoboEmissorNfConfigRnfEntity(rnfRoboEmissorNfConfigRnfEntity)
                .build();
    }
    public RNFRoboEmissorNfClienteEntity getClienteEntity(RNFRoboEmissorNfNfEntity rnfRoboEmissorNfNfEntity, Cliente cliente) {
       return RNFRoboEmissorNfClienteEntity.builder()
               .id(this.getUuidApp())
               .tipoPessoa(cliente.getTipoPessoa())
               .indicadorContribuinteICMS(cliente.getIndicadorContribuinteICMS())
               .nome(cliente.getNome())
               .email(cliente.getEmail())
               .telefone(cliente.getTelefone())
               .cpfCnpj(cliente.getCpfCnpj())
               .rnfRoboEmissorNfNfEntity(rnfRoboEmissorNfNfEntity)
               .build();
    }
    public RNFRoboEmissorNfEnderecoEntity getEnderecoEntity(RNFRoboEmissorNfClienteEntity rnfRoboEmissorNfClienteEntity, Endereco endereco, Boolean enviarPorEmail) {
       return RNFRoboEmissorNfEnderecoEntity.builder()
               .id(this.getUuidApp())
               .uf(endereco.getUf())
               .cidade(endereco.getCidade())
               .logradouro(endereco.getLogradouro())
               .numero(endereco.getNumero())
               .complemento(endereco.getComplemento())
               .bairro(endereco.getBairro())
               .cep(endereco.getCep())
               .enviarPorEmail(enviarPorEmail)
               .rnfRoboEmissorNfClienteEntity(rnfRoboEmissorNfClienteEntity)
               .build();
    }
    public RNFRoboEmissorNfItemEntity getItemEntity(RNFRoboEmissorNfNfEntity rnfRoboEmissorNfNfEntity, Iten i) {
       return RNFRoboEmissorNfItemEntity.builder()
               .id(this.getUuidApp())
               .cfop(i.getCfop())
               .codigo(i.getCodigo())
               .descricao(i.getDescricao())
               .ncm(i.getNcm())
               .quantidade(i.getQuantidade())
               .valorUnitario(i.getValorUnitario())
               .frete(i.getFrete())
               .outrasDespesas(i.getOutrasDespesas())
               .rnfRoboEmissorNfNfEntity(rnfRoboEmissorNfNfEntity)
               .build();
    }
    public RNFRoboEmissorNfImpostoEntity getImpostoEntity(RNFRoboEmissorNfItemEntity rnfRoboEmissorNfItemEntity, Impostos impostos) {
       return RNFRoboEmissorNfImpostoEntity.builder()
               .id(this.getUuidApp())
               .tributoSimplificadoPercentual(impostos.getPercentualAproximadoTributos().getSimplificado().getPercentual())
               .fonte(impostos.getPercentualAproximadoTributos().getFonte())
               .icmsOrigem(impostos.getIcms().getOrigem())
               .icmsSituacaoTributaria(impostos.getIcms().getSituacaoTributaria())
               .pisSituacaoTributaria(impostos.getPis().getSituacaoTributaria())
               .cofinsSituacaoTributaria(impostos.getCofins().getSituacaoTributaria())
               .rnfRoboEmissorNfItemEntity(rnfRoboEmissorNfItemEntity)
               .build();
    }
    public RNFRoboEmissorNfCombustivelEntity getCombustivelEntity(RNFRoboEmissorNfItemEntity rnfRoboEmissorNfItemEntity, Combustivel combustivel) {
       return RNFRoboEmissorNfCombustivelEntity.builder()
               .id(this.getUuidApp())
               .codigoProdutoANP(combustivel.getCodigoProdutoANP())
               .percentualGasNatural(combustivel.getPercentualGasNatural())
               .codif(combustivel.getCodif())
               .quantidadeFaturadaTempAmbiente(combustivel.getQuantidadeFaturadaTempAmbiente())
               .ufConsumo(combustivel.getUfConsumo())
               .rnfRoboEmissorNfItemEntity(rnfRoboEmissorNfItemEntity)
               .build();
    }
    public RNFRoboEmissorNfCideEntity getCideEntity(RNFRoboEmissorNfCombustivelEntity rnfRoboEmissorNfCombustivelEntity, Cide cide) {
       return RNFRoboEmissorNfCideEntity.builder()
                    .id(this.getUuidApp())
                   .quantidadeBaseCalculo(cide.getQuantidadeBaseCalculo())
                   .valorAliquota(cide.getValorAliquota())
                   .valor(cide.getValor())
                   .rnfRoboEmissorNfCombustivelEntity(rnfRoboEmissorNfCombustivelEntity)
               .build();
    }
    private String getUuidApp(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
