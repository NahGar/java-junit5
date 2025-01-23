package org.ngarcia.junit5app.models;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import org.ngarcia.junit5app.exceptions.DineroInsuficienteException;

class CuentaTest {

    @Test
    void testNombreCuenta() {
        Cuenta cuenta = new Cuenta("Carlitos", new BigDecimal("1000.12345"));
        //cuenta.setPersona("Carlitos");

        String esperado = "Carlitos";
        String actual = cuenta.getPersona();
        //Assertions.assertEquals(esperado,real);
        assertNotNull(actual);
        assertEquals(esperado,actual);
        assertTrue(actual.equals("Carlitos"));
    }

    @Test
    void testSaldoCuenta() {
        Cuenta cuenta = new Cuenta("Carlitos", new BigDecimal("1000.12345"));
        assertNotNull(cuenta.getSaldo());
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
    
    @Test
    void testDebitoCuenta() {
        Cuenta cuenta = new Cuenta("Pepe",new BigDecimal("1000.12345"));
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }
    
    @Test
    void testCreditoCuenta() {
        Cuenta cuenta = new Cuenta("Pepe",new BigDecimal("1000.12345"));
        cuenta.credito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue());
        assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
    }
    
    @Test
    void testDineroInsuficienteCuenta() {
        Cuenta cuenta = new Cuenta("Pepe",new BigDecimal("1000.12345"));
        Exception ex = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal(1001));
        });
        String actual = ex.getMessage();
        String esperado = "Dinero insuficiente";
        assertEquals(esperado, actual);
    }
}