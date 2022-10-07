package br.com.veloe.rnf.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExceptionResponseTest {
    ExceptionResponse exceptionResponse = new ExceptionResponse("message", Integer.valueOf(0));

    @Test
    void testSetMessage() {
        exceptionResponse.setMessage("message");
    }

    @Test
    void testSetCode() {
        exceptionResponse.setCode(Integer.valueOf(0));
    }

    @Test
    void testEquals() {
        boolean result = exceptionResponse.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = exceptionResponse.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = exceptionResponse.hashCode();
        Assertions.assertEquals(954928544, result);
    }

    @Test
    void testToString() {
        String result = exceptionResponse.toString();
        Assertions.assertNotNull(result);
    }

    @Test
    void testBuilder() {
        ExceptionResponse.ExceptionResponseBuilder result = ExceptionResponse.builder();
        Assertions.assertNotNull(result);
    }
}