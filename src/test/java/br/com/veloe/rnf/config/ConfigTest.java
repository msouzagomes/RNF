package br.com.veloe.rnf.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class ConfigTest {
    @Mock
    Logger log;
    @InjectMocks
    Config config;

    @Test
    void testSetOneSignalUrl() {
        Exception exception = assertThrows(Exception.class, () -> {
            config.setOneSignalUrl("oneSignalUrl");
        });
        assertEquals(null, exception.getMessage());
    }

    @Test
    void testSetOneSignalAppId() {
        Exception exception = assertThrows(Exception.class, () -> {
            config.setOneSignalAppId("oneSignalAppId");
        });
        assertEquals(null, exception.getMessage());
    }

    @Test
    void testSetOneSignalRestKey() {
        Exception exception = assertThrows(Exception.class, () -> {
            config.setOneSignalRestKey("oneSignalRestKey");
        });
        assertEquals(null, exception.getMessage());
    }

    @Test
    void testSetOneSignalAppIdReturn() {
        Exception exception = assertThrows(Exception.class, () -> {
            config.setOneSignalAppIdReturn("oneSignalAppIdReturn");
        });
        assertEquals(null, exception.getMessage());
    }

    @Test
    void testSetOneSignalRestKeyReturn() {
        Exception exception = assertThrows(Exception.class, () -> {
            config.setOneSignalRestKeyReturn("oneSignalRestKeyReturn");
        });
        assertEquals(null, exception.getMessage());
    }

    @Test
    void testEquals() {
        Exception exception = assertThrows(Exception.class, () -> {
            boolean result = config.equals("o");
            Assertions.assertEquals(false, result);
        });
        assertEquals(null, exception.getMessage());
    }

    @Test
    void testCanEqual() {
        Exception exception = assertThrows(Exception.class, () -> {
            boolean result = config.canEqual("other");
            Assertions.assertEquals(false, result);
        });
        assertEquals(null, exception.getMessage());
    }

    @Test
    void testHashCode() {
        Exception exception = assertThrows(Exception.class, () -> {
            int result = config.hashCode();
            Assertions.assertEquals(1244954382, result);
        });
        assertEquals(null, exception.getMessage());
    }

    @Test
    void testToString() {
        Exception exception = assertThrows(Exception.class, () -> {
            String result = config.toString();
            Assertions.assertEquals("Config(oneSignalUrl=null, oneSignalAppId=null, oneSignalRestKey=null, oneSignalAppIdReturn=null, oneSignalRestKeyReturn=null)", result);
        });
        assertEquals(null, exception.getMessage());
    }
}