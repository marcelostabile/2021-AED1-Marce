import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;


import tdas.*;

public class FactorialTest {

    Factorial factorial= new Factorial();

    @Test
    @DisplayName("Test para validar el resultado de el factorial iterativo")
    public void testIterativo() {
        assertEquals(362880, factorial.iterativo(9), "Deberian devolver 362880");
        assertEquals(1, factorial.iterativo(0), "Deberian devolver 1");
    }


    @Test
    @DisplayName("Test para validar el resultado de el factorial recursivo")
    public void testRecursivo() {
        assertEquals(362880, factorial.recursiva(9), "Deberian devolver 362880");
        assertEquals(1, factorial.recursiva(0), "Deberian devolver 1");
    }


}