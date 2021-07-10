import tdas.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class CumpleAVLTest {

    private TArbolBB<String> arbolito;
    private TArbolBB<String> arbolitoQueNoCumple;
    private TArbolBB<String> vacio;

    TElementoAB<String> elem4;
    TElementoAB<String> elem1;
    TElementoAB<String> elem8;
    TElementoAB<String> elem6;
    TElementoAB<String> elem9;
    TElementoAB<String> elem10;
    TElementoAB<String> elem11;
    TElementoAB<String> elem12;
    TElementoAB<String> elem14;

    @BeforeEach
    public void setUp() throws Exception {

        arbolito = new TArbolBB<>();
        vacio = new TArbolBB<>();
        arbolitoQueNoCumple = new TArbolBB<>();

        elem4 = new TElementoAB<>("4", "");
        elem1 = new TElementoAB<>("1", "");
        elem6 = new TElementoAB<>("6", "");
        elem8 = new TElementoAB<>("8", "");

        elem9 = new TElementoAB<>("9", "");
        elem10 = new TElementoAB<>("10", "");
        elem11 = new TElementoAB<>("11", "");
        elem12 = new TElementoAB<>("12", "");
        elem14 = new TElementoAB<>("14", "");

        arbolito.insertar(elem4);
        arbolito.insertar(elem1);
        arbolito.insertar(elem6);
        arbolito.insertar(elem8);

        arbolitoQueNoCumple.insertar(elem10);
        arbolitoQueNoCumple.insertar(elem11);
        arbolitoQueNoCumple.insertar(elem12);
        arbolitoQueNoCumple.insertar(elem14);
        arbolitoQueNoCumple.insertar(elem9);
    }

    @Test
    public void CumpleAVLTestVacio() {
        assertTrue(vacio.cumpleAVL());
    }

    @Test
    public void CumpleAVLTestCumple() {
        assertTrue(arbolito.cumpleAVL());
    }

    @Test
    public void CumpleAVLTestNoCumple() {
        assertTrue(!arbolitoQueNoCumple.cumpleAVL());
    }

}