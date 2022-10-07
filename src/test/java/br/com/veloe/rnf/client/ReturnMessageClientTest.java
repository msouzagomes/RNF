package br.com.veloe.rnf.client;

import br.com.veloe.rnf.model.request.Nf;
import br.com.veloe.rnf.model.request.TransacoesRnf;
import br.com.veloe.rnf.service.RnfService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ReturnMessageClientTest {
    @Mock
    OneSignalClient oneSignalClient;
    @Mock
    RnfService rnfService;
    @Mock
    Logger log;
    @InjectMocks
    ReturnMessageClient returnMessageClient;

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
    public void testGetMessage() throws Exception {
        when(rnfService.postRnfTransacao(any(), anyString())).thenReturn("postRnfTransacaoResponse");
        returnMessageClient.getMessage();
    }
}