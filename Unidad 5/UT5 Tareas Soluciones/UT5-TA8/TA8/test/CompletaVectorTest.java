import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import tdas.*;

public class CompletaVectorTest {

    private TArbolBB<String> arbolVacio;
    private TArbolBB<String> arbol;

    TElementoAB<String> elem1;
    TElementoAB<String> elem2;
    TElementoAB<String> elem3;

    Comparable claves[] = new Comparable[3];
    int fE[] = new int[3];
    int fNE[] = new int[4];
    int coste = 49;

    @BeforeEach
    public void setUp() throws Exception {

        arbolVacio = new TArbolBB<>();
        arbol = new TArbolBB<>();
        elem1 = new TElementoAB<>("A", "A");
        elem2 = new TElementoAB<>("B", "B");
        elem3 = new TElementoAB<>("C", "C");
        arbol.insertar(elem2);
        arbol.insertar(elem1);
        arbol.insertar(elem3);
    }

    @Test
    public void testCompletaVectoresArbol() {
        arbol.cuentaFrec("A");
        arbol.cuentaFrec("B");
        arbol.cuentaFrec("B");
        arbol.cuentaFrec("B");
        arbol.cuentaFrec("C");
        arbol.cuentaFrec("C");
        arbol.cuentaFrec("C");
        arbol.cuentaFrec("C");
        arbol.cuentaFrec("C");
        arbol.cuentaFrec("C");
        arbol.cuentaFrec("C");

        arbol.cuentaFrec("1");
        arbol.cuentaFrec("1");
        arbol.cuentaFrec("2");
        arbol.cuentaFrec("BA");
        arbol.cuentaFrec("BA");
        arbol.cuentaFrec("BA");
        arbol.cuentaFrec("BA");
        arbol.cuentaFrec("X");
        arbol.cuentaFrec("Y");
        arbol.cuentaFrec("Z");
        arbol.completaVectores(claves, fE, fNE);
        assertEquals(49, arbol.calcularCosto(fE, fNE));
    }

    @Test
    public void testCompletaVectoresArbolVacio() {
        arbolVacio.completaVectores(claves, fE, fNE);
        assertEquals(1, arbolVacio.calcularCosto(fE, fNE));

    }

}
