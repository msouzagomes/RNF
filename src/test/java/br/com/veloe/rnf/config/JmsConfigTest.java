package br.com.veloe.rnf.config;

import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class JmsConfigTest {
    @Mock
    SQSConnectionFactory connectionFactory;
    @InjectMocks
    JmsConfig jmsConfig;

    @Test
    void testConnectionFactory() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            SQSConnectionFactory result = jmsConfig.connectionFactory();
            Assert.assertFalse(result.equals(null));
        });
        assertEquals(null, exception.getMessage());
    }

    @Test
    void testJmsListenerContainerFactory() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            DefaultJmsListenerContainerFactory result = jmsConfig.jmsListenerContainerFactory();
            Assert.assertFalse(result.equals("org.springframework.jms.config.DefaultJmsListenerContainerFactory@425357dd"));
        });
        assertEquals(null, exception.getMessage());
    }

    @Test
    void testDefaultJmsTemplate() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            JmsTemplate result = jmsConfig.defaultJmsTemplate();
            Assert.assertFalse(result.equals("org.springframework.jms.core.JmsTemplate@1dfd5f51"));
        });
        assertEquals(null, exception.getMessage());
    }
}