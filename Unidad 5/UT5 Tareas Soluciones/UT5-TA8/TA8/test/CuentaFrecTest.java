import tdas.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class CuentaFrecTest {

    private TArbolBB<String> arbolito;

    TElementoAB<String> elem1;
    TElementoAB<String> elem2;
    TElementoAB<String> elem3;
    TElementoAB<String> elem4;
    TElementoAB<String> elem5;

    @BeforeEach
    public void setUp() throws Exception {
        arbolito = new TArbolBB<>();
        elem1 = new TElementoAB<>("B", "B");
        elem2 = new TElementoAB<>("A", "A");
        elem3 = new TElementoAB<>("D", "D");
        elem4 = new TElementoAB<>("X", "X");
        arbolito.insertar(elem1);
        arbolito.insertar(elem2);
        arbolito.insertar(elem3);
        arbolito.insertar(elem4);
    }

    @Test
    public void cuentaFrecInvalida() {
        arbolito.cuentaFrec("C");
        arbolito.cuentaFrec("C");
        arbolito.cuentaFrec("@");
        arbolito.cuentaFrec("AB");
        arbolito.cuentaFrec("Z");
        arbolito.cuentaFrec("V");
        assertEquals(2, arbolito.buscar("D").getFrecNoExitoIzq());
        assertEquals(1, arbolito.buscar("A").getFrecNoExitoIzq());
        assertEquals(1, arbolito.buscar("A").getFrecNoExitoDer());
        assertEquals(1, arbolito.buscar("X").getFrecNoExitoIzq());
        assertEquals(1, arbolito.buscar("X").getFrecNoExitoDer());
    }

    @Test
    public void cuentaFrecValida() {
        arbolito.cuentaFrec("A");
        arbolito.cuentaFrec("A");
        arbolito.cuentaFrec("A");
        arbolito.cuentaFrec("B");
        arbolito.cuentaFrec("D");
        arbolito.cuentaFrec("X");
        assertEquals(3, arbolito.buscar("A").getFrecExito());
        assertEquals(1, arbolito.buscar("B").getFrecExito());
        assertEquals(1, arbolito.buscar("D").getFrecExito());
        assertEquals(1, arbolito.buscar("X").getFrecExito());
    }

    @Test
    public void cuentaFrecAcumulada() {
        arbolito.cuentaFrec("A");
        assertEquals(1, arbolito.buscar("A").getFrecExito());
        arbolito.cuentaFrec("A");
        assertEquals(2, arbolito.buscar("A").getFrecExito());
        arbolito.cuentaFrec("A");
        assertEquals(3, arbolito.buscar("A").getFrecExito());
    }
}