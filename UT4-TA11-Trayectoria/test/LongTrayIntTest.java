import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import tdas.*;

public class LongTrayIntTest {

    private TArbolBB<Integer> vacio = new TArbolBB<>();
    private TArbolBB<Integer> raiz = new TArbolBB<>();
    private TArbolBB<Integer> normal = new TArbolBB<>();

    @BeforeEach
    public void setUp() throws Exception {

        raiz.insertar(new TElementoAB<Integer>(3651, 3651));

        normal.insertar(new TElementoAB<Integer>(12, 3651));
        normal.insertar(new TElementoAB<Integer>(1, 3683));
        normal.insertar(new TElementoAB<Integer>(7, 3683));
        normal.insertar(new TElementoAB<Integer>(4, 3683));
        normal.insertar(new TElementoAB<Integer>(9, 3683));
        normal.insertar(new TElementoAB<Integer>(3, 3683));

    }

    @Test
    @DisplayName("Test para arbol vacio ")
    public void testArbolVacio() {
        assertEquals(0, vacio.longTrayInt(), "Deberia de dar 0");
    }

    @Test
    @DisplayName("Test para arbol que no deberia de cambiar su estado ")
    public void testMantieneEstado() {
        raiz.longTrayInt();
        vacio.longTrayInt();
        assertEquals(1, raiz.obtenerTamanio(), "El estado se mantiene");
        assertEquals(0, vacio.obtenerTamanio(), "El estado se mantiene");
    }

    @Test
    @DisplayName("Test para arbol con raiz ")
    public void testArbolConRaiz() {
        assertEquals(1, raiz.longTrayInt(), "Deberia de dar 1");
    }

    @Test
    @DisplayName("Test para arbol normal")
    public void testArbolNormal() {
        assertEquals(19, normal.longTrayInt(), "Deberia de dar 19");
    }
}