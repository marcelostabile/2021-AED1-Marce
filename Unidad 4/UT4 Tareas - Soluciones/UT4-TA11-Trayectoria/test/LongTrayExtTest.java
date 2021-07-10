import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import tdas.*;

public class LongTrayExtTest {

    IArbolBB<Integer> arbolVacio;
    IArbolBB<Integer> arbol;
    IArbolBB<Integer> arbol2;

    @BeforeEach
    public void setUp() throws Exception {
        arbolVacio = new TArbolBB();

        arbol = new TArbolBB();
        arbol.insertar(new TElementoAB<Integer>(36, 36));
        arbol.insertar(new TElementoAB<Integer>(49, 49));
        arbol.insertar(new TElementoAB<Integer>(57, 57));
        arbol.insertar(new TElementoAB<Integer>(41, 41));
        arbol.insertar(new TElementoAB<Integer>(83, 83));
        arbol.insertar(new TElementoAB<Integer>(99, 99));

        arbol2 = new TArbolBB();
        arbol2.insertar(new TElementoAB<Integer>(36, 36));
        arbol2.insertar(new TElementoAB<Integer>(41, 41));
        arbol2.insertar(new TElementoAB<Integer>(49, 49));
        arbol2.insertar(new TElementoAB<Integer>(57, 57));
        arbol2.insertar(new TElementoAB<Integer>(83, 83));
        arbol2.insertar(new TElementoAB<Integer>(99, 99));
    }

    @Test
    @DisplayName("Test para validar que un arbol vacio devuelve 0")
    public void testArbolVacio() {
        assertEquals(arbolVacio.longTrayExt(), 0);
    }

    @Test
    @DisplayName("Test para validar que el arbol no cambia")
    public void testArbolNoCambia() {
        String expected = arbol.inOrden();
        arbol.longTrayExt();
        assertEquals(expected, arbol.inOrden());
    }

    @Test
    @DisplayName("Test para validar resultado de un arbol normal")
    public void testArbolNormal() {
        assertEquals(31, arbol.longTrayExt(), "Deberia de dar 31");
    }

    @Test
    @DisplayName("Test para validar el arbol lineal")
    public void testArbolLineal() {
        assertEquals(34, arbol2.longTrayExt(), "Debe dar 34");
    }
}
