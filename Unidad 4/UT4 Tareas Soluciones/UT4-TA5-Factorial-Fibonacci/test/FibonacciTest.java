import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;


import tdas.*;

public class FibonacciTest {

    Fibonacci fibonacci= new Fibonacci();



    @Test
    @DisplayName("Test para validar el resultado de Fibonacci binario")
    public void testBinario() {
        assertEquals(6765, fibonacci.binario(20), "Deberian devolver 6765");
        assertEquals(0, fibonacci.binario(0), "Deberian devolver 0");
        assertEquals(1, fibonacci.binario(1), "Deberian devolver 1");
        assertEquals(1, fibonacci.binario(2), "Deberian devolver 1");
        assertEquals(2, fibonacci.binario(3), "Deberian devolver 2");
    }


    @Test
    @DisplayName("Test para validar el resultado de Fibonacci lineal")
    public void testLineal() {

        assertTrue(fibonacci.lineal(20)[0].equals(fibonacci.binario(20)) && fibonacci.lineal(20)[1].equals(fibonacci.binario(19)));

        assertTrue(fibonacci.lineal(0)[0].equals(fibonacci.binario(0)) && fibonacci.lineal(0)[1].equals(fibonacci.binario(0)));

        assertTrue(fibonacci.lineal(1)[0].equals(fibonacci.binario(1)) && fibonacci.lineal(1)[1].equals(fibonacci.binario(0)));

        assertTrue(fibonacci.lineal(2)[0].equals(fibonacci.binario(2)) && fibonacci.lineal(2)[1].equals(fibonacci.binario(1)));

        assertTrue(fibonacci.lineal(3)[0].equals(fibonacci.binario(3)) && fibonacci.lineal(3)[1].equals(fibonacci.binario(2)));
        
    }


}