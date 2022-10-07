package br.com.veloe.rnf.builder;


import br.com.veloe.rnf.entity.*;
import br.com.veloe.rnf.model.request.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;

import static org.junit.Assert.assertTrue;

class EntityBuilderTest {
    EntityBuilder entityBuilder = new EntityBuilder();

    @Test
    void testGetConfigRnfEntity() {
        RNFRoboEmissorNfConfigRnfEntity result = entityBuilder.getConfigRnfEntity(ConfigRnf.builder().build(), null);
        assertTrue(result instanceof RNFRoboEmissorNfConfigRnfEntity);
    }

    @Test
    void testGetConfigEcEntity() {
        RNFRoboEmissorNfConfigEcEntity result = entityBuilder.getConfigEcEntity(new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), Boolean.TRUE, "NAOEMITIDA"), ConfigEc.builder().build());
        assertTrue(result instanceof RNFRoboEmissorNfConfigEcEntity);
    }

    @Test
    void testGetConfiguracaoVeiculo() {
        RNFRoboEmissorNfConfiguracaoVeiculoEntity result = entityBuilder.getConfiguracaoVeiculo(new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), Boolean.TRUE,"NAOEMITIDA"), ConfiguracaoVeiculo.builder().build());
        assertTrue(result instanceof RNFRoboEmissorNfConfiguracaoVeiculoEntity);
    }

    @Test
    void testGetNfEntity() {
        RNFRoboEmissorNfNfEntity result = entityBuilder.getNfEntity(new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), Boolean.TRUE, "NAOEMITIDA"), Nf.builder().build());
        assertTrue(result instanceof RNFRoboEmissorNfNfEntity);
    }

    @Test
    void testGetClienteEntity() {
        RNFRoboEmissorNfClienteEntity result = entityBuilder.getClienteEntity(new RNFRoboEmissorNfNfEntity("id", "nfsId", "ambienteEmissao", "naturezaOperacao", "tipoOperacao", "finalidade", Boolean.TRUE, "indicadorPresencaConsumidor", new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), Boolean.TRUE,"NAOEMITIDA")), Cliente.builder().build());
        assertTrue(result instanceof RNFRoboEmissorNfClienteEntity);
    }

    @Test
    void testGetEnderecoEntity() {
        RNFRoboEmissorNfEnderecoEntity result = entityBuilder.getEnderecoEntity(new RNFRoboEmissorNfClienteEntity("id", "tipoPessoa", "indicadorContribuinteICMS", "nome", "email", "telefone", "cpfCnpj", new RNFRoboEmissorNfNfEntity("id", "nfsId", "ambienteEmissao", "naturezaOperacao", "tipoOperacao", "finalidade", Boolean.TRUE, "indicadorPresencaConsumidor", new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), Boolean.TRUE, "NAOEMITIDA"))), Endereco.builder().build(), Boolean.TRUE);
        assertTrue(result instanceof RNFRoboEmissorNfEnderecoEntity);
    }

    @Test
    void testGetItemEntity() {
        RNFRoboEmissorNfItemEntity result = entityBuilder.getItemEntity(new RNFRoboEmissorNfNfEntity("id", "nfsId", "ambienteEmissao", "naturezaOperacao", "tipoOperacao", "finalidade", Boolean.TRUE, "indicadorPresencaConsumidor", new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), Boolean.TRUE, "NAOEMITIDA")), Iten.builder().build());
        assertTrue(result instanceof RNFRoboEmissorNfItemEntity);
    }

    @Test
    void testGetImpostoEntity() {
        RNFRoboEmissorNfImpostoEntity result = entityBuilder.getImpostoEntity(new RNFRoboEmissorNfItemEntity("id", "cfop", "codigo", "descricao", "ncm", Integer.valueOf(0), "unidadeMedida", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), new RNFRoboEmissorNfNfEntity("id", "nfsId", "ambienteEmissao", "naturezaOperacao", "tipoOperacao", "finalidade", Boolean.TRUE, "indicadorPresencaConsumidor", new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), Boolean.TRUE, "NAOEMITIDA"))), Impostos.builder()
                .icms(Icms.builder().build())
                .pis(Pis.builder().build())
                .cofins(Cofins.builder().build())
                .percentualAproximadoTributos(PercentualAproximadoTributos.builder()
                        .simplificado(Simplificado.builder().percentual(100.00).build()).build()).build());
        assertTrue(result instanceof RNFRoboEmissorNfImpostoEntity);
    }

    @Test
    void testGetCombustivelEntity() {
        RNFRoboEmissorNfCombustivelEntity result = entityBuilder.getCombustivelEntity(new RNFRoboEmissorNfItemEntity("id", "cfop", "codigo", "descricao", "ncm", Integer.valueOf(0), "unidadeMedida", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), new RNFRoboEmissorNfNfEntity("id", "nfsId", "ambienteEmissao", "naturezaOperacao", "tipoOperacao", "finalidade", Boolean.TRUE, "indicadorPresencaConsumidor", new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), Boolean.TRUE, "NAOEMITIDA"))), Combustivel.builder().build());
        assertTrue(result instanceof RNFRoboEmissorNfCombustivelEntity);
    }

    @Test
    void testGetCideEntity() {
        RNFRoboEmissorNfCideEntity result = entityBuilder.getCideEntity(new RNFRoboEmissorNfCombustivelEntity("id", "codigoProdutoANP", "percentualGasNatural", "codif", Integer.valueOf(0), "ufConsumo", new RNFRoboEmissorNfItemEntity("id", "cfop", "codigo", "descricao", "ncm", Integer.valueOf(0), "unidadeMedida", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), new RNFRoboEmissorNfNfEntity("id", "nfsId", "ambienteEmissao", "naturezaOperacao", "tipoOperacao", "finalidade", Boolean.TRUE, "indicadorPresencaConsumidor", new RNFRoboEmissorNfConfigRnfEntity("id", "configRnfId", LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), "idFilial", Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", LocalDateTime.of(2022, Month.JULY, 29, 10, 41, 9).toInstant(ZoneOffset.UTC), Boolean.TRUE, "NAOEMITIDA")))), Cide.builder().build());
        assertTrue(result instanceof RNFRoboEmissorNfCideEntity);
    }
}