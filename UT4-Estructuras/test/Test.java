import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import TDAS.*;

public class TElementoTest {

    /**
     * arbol vacio
     * arbol solo raiz
     * arbol raiz y un hijo
     * arbol raiz y dos hijos
     * arbol balanceado hacia un lado
     * arbol completo
     * arbol desbalanceado 
     */
    @Test
    @DisplayName("Test de Inserción")
    public void testInsertar(int tamanoEsperado) {
        assertEquals(tamanoEsperado, arbol3.insertar(1545), "No se pudo insertar el elemento");
    }

}
