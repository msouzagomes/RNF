package br.com.veloe.rnf.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StatusEnvioTest {


    @Test
    void testValues() {
        String result = StatusEnvio.NAOEMITIDA.getDescricao();
        Assertions.assertEquals("NAOEMITIDA", result);
    }

    @Test
    void testValueOf() {
        String result = StatusEnvio.EMITIDA.getDescricao();
        Assertions.assertEquals(StatusEnvio.EMITIDA.getDescricao(), result);
    }
}