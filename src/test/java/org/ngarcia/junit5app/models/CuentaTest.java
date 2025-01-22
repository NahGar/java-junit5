package org.ngarcia.junit5app.models;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testNombreCuenta() {
        Cuenta cuenta = new Cuenta("Carlitos", new BigDecimal("1000.12345"));
        //cuenta.setPersona("Carlitos");

        String esperado = "Carlitos";
        String actual = cuenta.getPersona();
        //Assertions.assertEquals(esperado,real);
        assertEquals(esperado,actual);
        assertTrue(actual.equals("Carlitos"));

    }

    @Test
    void testSaldoCuenta() {
        Cuenta cuenta = new Cuenta("Carlitos", new BigDecimal("1000.12345"));

        assertEquals(1000.12345,cuenta.getSaldo().doubleValue());
        //prueba que el saldo no sea negativo
        //compareTo devuelve -1 (menor), 0 (igual), 1 (mayor)
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        //lo mismo
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testReferenciaCuenta() {
        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("8900.9997"));
        Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.9997"));

        //assertNotEquals(cuenta2, cuenta);
        assertEquals(cuenta2, cuenta);

    }
}