package Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void createInstance(){
        calculator = new Calculator();
    }

    @Test
    void add() {
        assertEquals(30.70f,calculator.add(20.50f,10.20f));
    }

    @Test
    void subtract() {
        assertEquals(10.30f,calculator.subtract(20.50f,10.20f));
    }

    @Test
    @DisplayName("Divisione con parametri validi")
    void divide() {
        assertEquals(3.3f,calculator.divide(17.16f,5.2f),0.001);
    }

    @Test
    @DisplayName("Divisione con parametri NON validi")
    void divideNotValid() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10.5f,0));
    }

    @Test
    void multiply() {
        assertEquals(17.16f,calculator.multiply(3.3f,5.2f));
    }
}