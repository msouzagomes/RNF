package br.com.veloe.rnf.service.impl;

import br.com.veloe.rnf.builder.EntityBuilder;
import br.com.veloe.rnf.client.OneSignalClient;
import br.com.veloe.rnf.entity.*;
import br.com.veloe.rnf.model.request.*;
import br.com.veloe.rnf.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import static org.mockito.Mockito.*;

class RnfImplTest {
    @Mock
    JmsTemplate jmsTemplate;
    @Mock
    OneSignalClient oneSignalClient;
    @Mock
    EntityBuilder entityBuilder;
    @Mock
    ConfigRnfRepository configRnfRepository;
    @Mock
    ConfigEcRepository configEcRepository;
    @Mock
    ConfiguracaoVeiculo configuracaoVeiculo;
    @Mock
    ConfiguracaoVeiculoRepository configuracaoVeiculoRepository;
    @Mock
    ClienteRepository clienteRepository;
    @Mock
    NfRepository nfRepository;
    @Mock
    EnderecoRepository enderecoRepository;
    @Mock
    ItemRepository itemRepository;
    @Mock
    ImpostoRepository impostoRepository;
    @Mock
    CombustivelRepository combustivelRepository;
    @Mock
    CideRepository cideRepository;
    @Mock
    ObjectMapper objectMapper;
    @Mock
    Logger logger;
    @Mock
    org.slf4j.Logger log;
    @InjectMocks
    RnfImpl rnfImpl;
    private AutoCloseable closeable;

    @BeforeEach
    public void openMocks() {
        closeable = MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(rnfImpl, "entityBuilder", entityBuilder);
    }
    @AfterEach
    public void releaseMocks() throws Exception {
        closeable.close();
    }

    @Test
    void testPostRnfTransacao() {
                    when(entityBuilder.getConfigRnfEntity(any(), anyString())).thenReturn(new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), Boolean.TRUE, "statusEnvio"));
                    when(entityBuilder.getConfigEcEntity(any(), any())).thenReturn(new RNFRoboEmissorNfConfigEcEntity("id", "configEcId", "envioAutomatico", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), "ecId", new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), Boolean.TRUE, "statusEnvio")));
                    when(entityBuilder.getConfiguracaoVeiculo(any(), any())).thenReturn(new RNFRoboEmissorNfConfiguracaoVeiculoEntity("id", "configuracaoVeiculosId", "idVeiculo", new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), Boolean.TRUE, "statusEnvio")));
                    when(entityBuilder.getNfEntity(any(), any())).thenReturn(new RNFRoboEmissorNfNfEntity("id", "nfsId", "ambienteEmissao", "naturezaOperacao", "tipoOperacao", "finalidade", Boolean.TRUE, "indicadorPresencaConsumidor", new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), Boolean.TRUE, "statusEnvio")));
                    when(entityBuilder.getClienteEntity(any(), any())).thenReturn(new RNFRoboEmissorNfClienteEntity("id", "tipoPessoa", "indicadorContribuinteICMS", "nome", "email", "telefone", "cpfCnpj", new RNFRoboEmissorNfNfEntity("id", "nfsId", "ambienteEmissao", "naturezaOperacao", "tipoOperacao", "finalidade", Boolean.TRUE, "indicadorPresencaConsumidor", new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), Boolean.TRUE, "statusEnvio"))));
                    when(entityBuilder.getEnderecoEntity(any(), any(), anyBoolean())).thenReturn(new RNFRoboEmissorNfEnderecoEntity("id", "uf", "cidade", "logradouro", "numero", "complemento", "bairro", "cep", Boolean.TRUE, new RNFRoboEmissorNfClienteEntity("id", "tipoPessoa", "indicadorContribuinteICMS", "nome", "email", "telefone", "cpfCnpj", new RNFRoboEmissorNfNfEntity("id", "nfsId", "ambienteEmissao", "naturezaOperacao", "tipoOperacao", "finalidade", Boolean.TRUE, "indicadorPresencaConsumidor", new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), Boolean.TRUE, "statusEnvio")))));
                    when(entityBuilder.getItemEntity(any(), any())).thenReturn(new RNFRoboEmissorNfItemEntity("id", "cfop", "codigo", "descricao", "ncm", Integer.valueOf(0), "unidadeMedida", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), new RNFRoboEmissorNfNfEntity("id", "nfsId", "ambienteEmissao", "naturezaOperacao", "tipoOperacao", "finalidade", Boolean.TRUE, "indicadorPresencaConsumidor", new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), Boolean.TRUE, "statusEnvio"))));
                    when(entityBuilder.getImpostoEntity(any(), any())).thenReturn(new RNFRoboEmissorNfImpostoEntity("id", Double.valueOf(0), "fonte", Integer.valueOf(0), "icmsSituacaoTributaria", "pisSituacaoTributaria", "cofinsSituacaoTributaria", new RNFRoboEmissorNfItemEntity("id", "cfop", "codigo", "descricao", "ncm", Integer.valueOf(0), "unidadeMedida", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), new RNFRoboEmissorNfNfEntity("id", "nfsId", "ambienteEmissao", "naturezaOperacao", "tipoOperacao", "finalidade", Boolean.TRUE, "indicadorPresencaConsumidor", new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), Boolean.TRUE, "statusEnvio")))));
                    when(entityBuilder.getCombustivelEntity(any(), any())).thenReturn(new RNFRoboEmissorNfCombustivelEntity("id", "codigoProdutoANP", "percentualGasNatural", "codif", Integer.valueOf(0), "ufConsumo", new RNFRoboEmissorNfItemEntity("id", "cfop", "codigo", "descricao", "ncm", Integer.valueOf(0), "unidadeMedida", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), new RNFRoboEmissorNfNfEntity("id", "nfsId", "ambienteEmissao", "naturezaOperacao", "tipoOperacao", "finalidade", Boolean.TRUE, "indicadorPresencaConsumidor", new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), Boolean.TRUE, "statusEnvio")))));
                    when(entityBuilder.getCideEntity(any(), any())).thenReturn(new RNFRoboEmissorNfCideEntity("id", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), new RNFRoboEmissorNfCombustivelEntity("id", "codigoProdutoANP", "percentualGasNatural", "codif", Integer.valueOf(0), "ufConsumo", new RNFRoboEmissorNfItemEntity("id", "cfop", "codigo", "descricao", "ncm", Integer.valueOf(0), "unidadeMedida", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), new RNFRoboEmissorNfNfEntity("id", "nfsId", "ambienteEmissao", "naturezaOperacao", "tipoOperacao", "finalidade", Boolean.TRUE, "indicadorPresencaConsumidor", new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), Boolean.TRUE, "statusEnvio"))))));
                    when(configRnfRepository.findByConfigRnfIdAndIdFilial(anyString(), anyString())).thenReturn(Arrays.<RNFRoboEmissorNfConfigRnfEntity>asList(new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), Boolean.TRUE, "statusEnvio")));

                    Object result = rnfImpl.postRnfTransacao(new TransacoesRnf(new ConfigRnf("id", new GregorianCalendar(2022, Calendar.AUGUST, 30, 10, 9).getTime(), new GregorianCalendar(2022, Calendar.AUGUST, 30, 10, 9).getTime(), "idFilial", Arrays.<ConfiguracaoVeiculo>asList(new ConfiguracaoVeiculo("id", "idVeiculo", new HashMap<String, Object>() {{
                        put("String", "additionalProperties");
                    }})), Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", Boolean.TRUE, new HashMap<String, Object>() {{
                        put("String", "additionalProperties");
                    }}), new ConfigEc("id", "envioAutomatico", new GregorianCalendar(2022, Calendar.AUGUST, 30, 10, 9).getTime(), "dataFim", "ecId", new HashMap<String, Object>() {{
                        put("String", "additionalProperties");
                    }}), Arrays.<Nf>asList(new Nf("id", "ambienteEmissao", "naturezaOperacao", "tipoOperacao", "finalidade", Boolean.TRUE, "indicadorPresencaConsumidor", new Cliente("tipoPessoa", "indicadorContribuinteICMS", "nome", "email", "telefone", "cpfCnpj", new Endereco("uf", "cidade", "logradouro", "numero", "complemento", "bairro", "cep", new HashMap<String, Object>() {{
                        put("String", "additionalProperties");
                    }}), new HashMap<String, Object>() {{
                        put("String", "additionalProperties");
                    }}), Boolean.TRUE, Arrays.<Iten>asList(new Iten("cfop", "codigo", "descricao", "ncm", Integer.valueOf(0), "unidadeMedida", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), new Combustivel("codigoProdutoANP", "percentualGasNatural", "codif", Integer.valueOf(0), "ufConsumo", new Cide(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), new HashMap<String, Object>() {{
                        put("String", "additionalProperties");
                    }}), new HashMap<String, Object>() {{
                        put("String", "additionalProperties");
                    }}), new Impostos(new PercentualAproximadoTributos(new Simplificado(Double.valueOf(0), new HashMap<String, Object>() {{
                        put("String", "additionalProperties");
                    }}), "fonte", new HashMap<String, Object>() {{
                        put("String", "additionalProperties");
                    }}), new Icms("situacaoTributaria", Integer.valueOf(0), new HashMap<String, Object>() {{
                        put("String", "additionalProperties");
                    }}), new Pis("situacaoTributaria", new HashMap<String, Object>() {{
                        put("String", "additionalProperties");
                    }}), new Cofins("situacaoTributaria", new HashMap<String, Object>() {{
                        put("String", "additionalProperties");
                    }}), new HashMap<String, Object>() {{
                        put("String", "additionalProperties");
                    }}), new HashMap<String, Object>() {{
                        put("String", "additionalProperties");
                    }})), "informacoesAdicionais", new HashMap<String, Object>() {{
                        put("String", "additionalProperties");
                    }})), new HashMap<String, Object>() {{
                        put("String", "additionalProperties");
                    }}), "statusEnvio");
    }

    @Test
    void testSaveConfiguracaoVeiculo() {
            when(entityBuilder.getConfiguracaoVeiculo(any(), any()))
                    .thenReturn(new RNFRoboEmissorNfConfiguracaoVeiculoEntity("id", "configuracaoVeiculosId", "idVeiculo", new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59)
                            .toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), Boolean.TRUE, "statusEnvio")));
            rnfImpl.saveConfiguracaoVeiculo(new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), Boolean.TRUE, "statusEnvio"), Arrays.<ConfiguracaoVeiculo>asList(new ConfiguracaoVeiculo("id", "idVeiculo", new HashMap<String, Object>() {{
                put("String", "additionalProperties");
            }})));
    }

    @Test
    void testSaveNf() {
            rnfImpl.saveNf(new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), Boolean.TRUE, "statusEnvio"), Arrays.<Nf>asList(new Nf("id", "ambienteEmissao", "naturezaOperacao", "tipoOperacao", "finalidade", Boolean.TRUE, "indicadorPresencaConsumidor", new Cliente("tipoPessoa", "indicadorContribuinteICMS", "nome", "email", "telefone", "cpfCnpj", new Endereco("uf", "cidade", "logradouro", "numero", "complemento", "bairro", "cep", new HashMap<String, Object>() {{
                put("String", "additionalProperties");
            }}), new HashMap<String, Object>() {{
                put("String", "additionalProperties");
            }}), Boolean.TRUE, Arrays.<Iten>asList(new Iten("cfop", "codigo", "descricao", "ncm", Integer.valueOf(0), "unidadeMedida", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), new Combustivel("codigoProdutoANP", "percentualGasNatural", "codif", Integer.valueOf(0), "ufConsumo", new Cide(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), new HashMap<String, Object>() {{
                put("String", "additionalProperties");
            }}), new HashMap<String, Object>() {{
                put("String", "additionalProperties");
            }}), new Impostos(new PercentualAproximadoTributos(new Simplificado(Double.valueOf(0), new HashMap<String, Object>() {{
                put("String", "additionalProperties");
            }}), "fonte", new HashMap<String, Object>() {{
                put("String", "additionalProperties");
            }}), new Icms("situacaoTributaria", Integer.valueOf(0), new HashMap<String, Object>() {{
                put("String", "additionalProperties");
            }}), new Pis("situacaoTributaria", new HashMap<String, Object>() {{
                put("String", "additionalProperties");
            }}), new Cofins("situacaoTributaria", new HashMap<String, Object>() {{
                put("String", "additionalProperties");
            }}), new HashMap<String, Object>() {{
                put("String", "additionalProperties");
            }}), new HashMap<String, Object>() {{
                put("String", "additionalProperties");
            }})), "informacoesAdicionais", new HashMap<String, Object>() {{
                put("String", "additionalProperties");
            }})));
    }

    @Test
    void testUpdateShippingStatus() {
                when(configRnfRepository.findByConfigRnfIdAndIdFilial(anyString(), anyString())).thenReturn(Arrays.<RNFRoboEmissorNfConfigRnfEntity>asList(new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.AUGUST, 30, 10, 9, 59).toInstant(ZoneOffset.UTC), Boolean.TRUE, "statusEnvio")));
                rnfImpl.updateShippingStatus(new TransacoesRnf(new ConfigRnf("id", new GregorianCalendar(2022, Calendar.AUGUST, 30, 10, 9).getTime(), new GregorianCalendar(2022, Calendar.AUGUST, 30, 10, 9).getTime(), "idFilial", Arrays.<ConfiguracaoVeiculo>asList(new ConfiguracaoVeiculo("id", "idVeiculo", new HashMap<String, Object>() {{
                    put("String", "additionalProperties");
                }})), Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", Boolean.TRUE, new HashMap<String, Object>() {{
                    put("String", "additionalProperties");
                }}), new ConfigEc("id", "envioAutomatico", new GregorianCalendar(2022, Calendar.AUGUST, 30, 10, 9).getTime(), "dataFim", "ecId", new HashMap<String, Object>() {{
                    put("String", "additionalProperties");
                }}), Arrays.<Nf>asList(new Nf("id", "ambienteEmissao", "naturezaOperacao", "tipoOperacao", "finalidade", Boolean.TRUE, "indicadorPresencaConsumidor", new Cliente("tipoPessoa", "indicadorContribuinteICMS", "nome", "email", "telefone", "cpfCnpj", new Endereco("uf", "cidade", "logradouro", "numero", "complemento", "bairro", "cep", new HashMap<String, Object>() {{
                    put("String", "additionalProperties");
                }}), new HashMap<String, Object>() {{
                    put("String", "additionalProperties");
                }}), Boolean.TRUE, Arrays.<Iten>asList(new Iten("cfop", "codigo", "descricao", "ncm", Integer.valueOf(0), "unidadeMedida", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), new Combustivel("codigoProdutoANP", "percentualGasNatural", "codif", Integer.valueOf(0), "ufConsumo", new Cide(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), new HashMap<String, Object>() {{
                    put("String", "additionalProperties");
                }}), new HashMap<String, Object>() {{
                    put("String", "additionalProperties");
                }}), new Impostos(new PercentualAproximadoTributos(new Simplificado(Double.valueOf(0), new HashMap<String, Object>() {{
                    put("String", "additionalProperties");
                }}), "fonte", new HashMap<String, Object>() {{
                    put("String", "additionalProperties");
                }}), new Icms("situacaoTributaria", Integer.valueOf(0), new HashMap<String, Object>() {{
                    put("String", "additionalProperties");
                }}), new Pis("situacaoTributaria", new HashMap<String, Object>() {{
                    put("String", "additionalProperties");
                }}), new Cofins("situacaoTributaria", new HashMap<String, Object>() {{
                    put("String", "additionalProperties");
                }}), new HashMap<String, Object>() {{
                    put("String", "additionalProperties");
                }}), new HashMap<String, Object>() {{
                    put("String", "additionalProperties");
                }})), "informacoesAdicionais", new HashMap<String, Object>() {{
                    put("String", "additionalProperties");
                }})), new HashMap<String, Object>() {{
                    put("String", "additionalProperties");
                }}));
    }
}