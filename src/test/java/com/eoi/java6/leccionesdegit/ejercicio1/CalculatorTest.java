package com.eoi.java6.leccionesdegit.ejercicio1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testSumar() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.sumar(2, 3), "El método sumar() debe devolver 5 para (2,3)");
    }

    @Test
    void testDividir() {
        Calculator calc = new Calculator();
        assertEquals(2, calc.dividir(6, 3), "El método dividir() debe devolver 2 para (6,3)");
    }
}
