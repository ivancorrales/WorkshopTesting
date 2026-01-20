package es.fplumara.dam1.workshoptesting.core.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    public void sumaBasica() {
        int resultado = 2 + 5;
        assertEquals(7, resultado, "El resultado es incorrecto");
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "2,3,5",
            "-1,1,0"
    })
    public void sumaParametrizada(int a, int b, int resultadoEsperado) {
        int resultado = a + b;
        assertEquals(resultadoEsperado, resultado, "El resultado es incorrecto");
    }

    @ParameterizedTest
    @CsvSource({
            "'  John','john'",
            "'JANE','jane'",
            "'Jane   ','jane'"
    })
    public void normalizaNombre(String original, String resultadoEsperado) {
        String resultado = original.trim().toLowerCase();
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void divisionEntera() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            Calculator calculator = new Calculator();
            calculator.divide(4, 0);
        });
        assertEquals("División por 0 no está permitida", ex.getMessage());
    }
}
