package br.com.veloe.rnf.controller;

import br.com.veloe.rnf.model.request.*;
import br.com.veloe.rnf.service.RnfService;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class RnfControllerTest {
    @Mock
    RnfService rnfService;
    @Mock
    Logger log;
    @InjectMocks
    RnfController rnfController;
    private AutoCloseable closeable;

    @BeforeEach
    public void openMocks() {
        closeable = MockitoAnnotations.openMocks(this);
    }
    @AfterEach
    public void releaseMocks() throws Exception {
        closeable.close();
    }

    @Test
    void testRnfTransacao() {
      assertDoesNotThrow(() -> {
        when(rnfService.postRnfTransacao(any(), anyString())).thenReturn("postRnfTransacaoResponse");

        ResponseEntity<HttpStatus> result = rnfController.rnfTransacao(new TransacoesRnf(new ConfigRnf("id", new GregorianCalendar(2022, Calendar.AUGUST, 30, 11, 47).getTime(), new GregorianCalendar(2022, Calendar.AUGUST, 30, 11, 47).getTime(), "idFilial", Arrays.<ConfiguracaoVeiculo>asList(new ConfiguracaoVeiculo("id", "idVeiculo", new HashMap<String, Object>() {{
            put("String", "additionalProperties");
        }})), Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", Boolean.TRUE, new HashMap<String, Object>() {{
            put("String", "additionalProperties");
        }}), new ConfigEc("id", "envioAutomatico", new GregorianCalendar(2022, Calendar.AUGUST, 30, 11, 47).getTime(), "dataFim", "ecId", new HashMap<String, Object>() {{
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
        Assertions.assertEquals(null, result);
                }
        );
    }
}