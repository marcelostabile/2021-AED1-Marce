
package tdas;

public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    /**
     * @param unElemento
     * @return
     */
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    @Override
    public Lista<T> inOrden() {
        Lista<T> listaInorden = new Lista<>();
        if (!esVacio()) {

            raiz.inOrden(listaInorden);
        }
        return listaInorden;

    }

    @Override
    public Lista<T> preOrden() {
        Lista<T> listaPreOrden = new Lista<>();
        if (!esVacio()) {

            raiz.preOrden(listaPreOrden);
        }
        return listaPreOrden;
    }

    @Override
    public Lista<T> postOrden() {
        Lista<T> listaPostOrden = new Lista<>();
        if (!esVacio()) {

            raiz.postOrden(listaPostOrden);
        }
        return listaPostOrden;

    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
    }

    /**
     * @return
     */
    public boolean esVacio() {
        return (raiz == null);
    }

    /**
     * @return True si habían elementos en el árbol, false en caso contrario
     */
    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    public int altura() {
        if (!esVacio()) { // O(1)
            return raiz.altura();
        }
        return -1; // O(1)
    }

    public int tamano() {
        if (!esVacio()) { // O(1)
            return raiz.tamano();
        }
        return 0; // O(1)
    }

    @Override
    public long calcularCosto(int[] FrecExito, int[] FrecNoExito) {
        if (esVacio()) {
            return 1;
        }
        int[] indiceFE = new int[1];
        int[] indiceFNE = new int[1];
        indiceFE[0] = 0;
        indiceFNE[0] = 0;
        return raiz.calcularCosto(FrecExito, FrecNoExito, indiceFE, indiceFNE, 1);
    }

    public void cuentaFrec(Comparable unArgumento) {
        if (!esVacio()) {
            raiz.cuentaFrec(unArgumento);
        }
    }

    public void completaVectores(Comparable[] claves, int[] frecExito, int[] frecNoExito) {
        if (!esVacio()) {
            int[] indiceFE = { 0 };
            int[] indiceFNE = { 0 };
            raiz.completaVectores(claves, frecExito, frecNoExito, indiceFE, indiceFNE);
        }
    }

    public boolean cumpleAVL(){
        boolean[] cumple = {true};
        if (esVacio()){
            return cumple[0];
        }
        raiz.cumpleAVL(cumple);
        return cumple[0];
    }
}
