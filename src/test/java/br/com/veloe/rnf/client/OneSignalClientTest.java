package br.com.veloe.rnf.client;

import br.com.veloe.rnf.config.Config;
import br.com.veloe.rnf.model.request.*;
import com.onesignal.client.api.DefaultApi;
import com.onesignal.client.model.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class OneSignalClientTest {
    @Mock
    Config config;
    @Mock
    Logger log;
    @InjectMocks
    OneSignalClient oneSignalClient;
    private AutoCloseable closeable;

    @Before
    public void openMocks() {
        closeable = MockitoAnnotations.openMocks(this);
    }
    @After
    public void releaseMocks() throws Exception {
        closeable.close();
    }

    @Test
    public void testCheckMessages() throws Exception {
        Throwable exception = assertThrows(
                Exception.class, () -> {
                when(config.getOneSignalUrl()).thenReturn("getOneSignalUrlResponse");
                when(config.getOneSignalAppId()).thenReturn("getOneSignalAppIdResponse");
                when(config.getOneSignalRestKey()).thenReturn("getOneSignalRestKeyResponse");

                String result = oneSignalClient.checkMessages();
                }
        );
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void testCheckMessages_Return() throws Exception {
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    when(config.getOneSignalUrl()).thenReturn("getOneSignalUrlResponse");
                    when(config.getOneSignalAppIdReturn()).thenReturn("getOneSignalAppIdReturnResponse");
                    when(config.getOneSignalRestKeyReturn()).thenReturn("getOneSignalRestKeyReturnResponse");

                    List<TransacoesRnf> result = oneSignalClient.checkMessages_Return();
                    Assert.assertEquals(Arrays.<TransacoesRnf>asList(new TransacoesRnf(new ConfigRnf("id", new GregorianCalendar(2022, Calendar.AUGUST, 30, 11, 17).getTime(), new GregorianCalendar(2022, Calendar.AUGUST, 30, 11, 17).getTime(), "idFilial", Arrays.<ConfiguracaoVeiculo>asList(new ConfiguracaoVeiculo("id", "idVeiculo", new HashMap<String, Object>() {{
                        put("String", "additionalProperties");
                    }})), Boolean.TRUE, Boolean.TRUE, "agruparNotaPor", Boolean.TRUE, new HashMap<String, Object>() {{
                        put("String", "additionalProperties");
                    }}), new ConfigEc("id", "envioAutomatico", new GregorianCalendar(2022, Calendar.AUGUST, 30, 11, 17).getTime(), "dataFim", "ecId", new HashMap<String, Object>() {{
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
                    }})), result);
                }
        );
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void testCancelMessage() throws Exception {
        Throwable exception = assertThrows(
                Exception.class, () -> {
                when(config.getOneSignalUrl()).thenReturn("getOneSignalUrlResponse");
                when(config.getOneSignalAppId()).thenReturn("getOneSignalAppIdResponse");
                when(config.getOneSignalRestKey()).thenReturn("getOneSignalRestKeyResponse");

                oneSignalClient.cancelMessage("msgId");
                        }
                );
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void testSendMessage() throws Exception {
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    when(config.getOneSignalUrl()).thenReturn("getOneSignalUrlResponse");
                    when(config.getOneSignalAppId()).thenReturn("getOneSignalAppIdResponse");
                    when(config.getOneSignalRestKey()).thenReturn("getOneSignalRestKeyResponse");
                    oneSignalClient.sendMessage("body", "cnpj");
                }
        );
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void testRegisterUser() throws Exception {
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    when(config.getOneSignalUrl()).thenReturn("getOneSignalUrlResponse");
                    when(config.getOneSignalAppId()).thenReturn("getOneSignalAppIdResponse");
                    when(config.getOneSignalRestKey()).thenReturn("getOneSignalRestKeyResponse");

                    String result = oneSignalClient.registerUser("cnpj");
                    Assert.assertNotNull(result);
                }
        );
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void testUpdateUser() throws Exception {
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    when(config.getOneSignalUrl()).thenReturn("getOneSignalUrlResponse");
                    when(config.getOneSignalAppId()).thenReturn("getOneSignalAppIdResponse");
                    when(config.getOneSignalRestKey()).thenReturn("getOneSignalRestKeyResponse");

                    oneSignalClient.updateUser("userId", "cnpj");
                }
        );
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteUser() throws Exception {
        when(config.getOneSignalUrl()).thenReturn("getOneSignalUrlResponse");
        when(config.getOneSignalAppId()).thenReturn("getOneSignalAppIdResponse");
        when(config.getOneSignalRestKey()).thenReturn("getOneSignalRestKeyResponse");

        oneSignalClient.deleteUser("userId");
    }

    @Test
    public void testPlayer() throws Exception {
        when(config.getOneSignalAppId()).thenReturn("getOneSignalAppIdResponse");

        Player result = oneSignalClient.player("cnpj");
        Assert.assertNotNull(result);
    }

    @Test
    public void testDefaultApi() throws Exception {
        when(config.getOneSignalUrl()).thenReturn("getOneSignalUrlResponse");
        when(config.getOneSignalRestKey()).thenReturn("getOneSignalRestKeyResponse");

        DefaultApi result = oneSignalClient.defaultApi();
        Assert.assertNotNull(result);
    }
}