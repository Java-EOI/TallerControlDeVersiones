package com.eoi.java6.leccionesdegit.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testMostrarCalculadora() throws Exception {
        mockMvc.perform(get("/calculadora"))
               .andExpect(status().isOk())
               .andExpect(view().name("calculator")); // ❌ Fallará porque en  devuelve una cadena en lugar de la vista
    }

    @Test
    void testCalcular() throws Exception {
        mockMvc.perform(get("/resultado?num1=5&num2=3"))
               .andExpect(status().isOk())
               .andExpect(model().attribute("resultado", 8)); // ❌ Fallará porque el controlador no maneja la suma
    }
}
