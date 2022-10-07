package br.com.veloe.rnf.client;

import br.com.veloe.rnf.service.RnfService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class RnfClientTest {
    @Mock
    RnfService rnfService;
    @Mock
    Logger log;
    @InjectMocks
    RnfClient rnfClient;
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
    void testOrderRnf() throws Exception {
         assertDoesNotThrow(
                 () -> {
                     when(rnfService.postRnfTransacao(any(), anyString())).thenReturn("postRnfTransacaoResponse");
                     rnfClient.orderRnf("{}");
                 }
                 );
    }

    @Test
    void testOrderFinisher() throws Exception {
        rnfClient = new RnfClient();
        rnfClient.orderFinisher("orderFinisher");
    }
}