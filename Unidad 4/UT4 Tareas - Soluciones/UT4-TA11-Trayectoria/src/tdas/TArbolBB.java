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
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    /**
     * @return recorrida en inorden del arbol, null en caso de ser vacío
     */
    public String inOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.inOrden();
        }
    }

    /**
     * @return recorrida en preOrden del arbol, null en caso de ser vacío
     */
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

    @Override
    public Lista<T> inorden() {
        Lista<T> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new Lista<T>();
            raiz.inOrden(listaInorden);
        }
        return listaInorden;

    }

    @Override
    public int obtenerAltura() {
        if (this.raiz != null) {
            return this.raiz.obtenerAltura();
        } else {
            return 0;
        }
    }

    public Integer longTrayExt() {
        if (esVacio()) {
            return 1;
        }
        return this.raiz.longTrayExt(1);
    }

    @Override
    public int obtenerTamanio() {
        if (this.raiz != null) {
            return this.raiz.obtenerTamanio();
        } else {
            return 0;
        }
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        if (raiz == null) {
            return -1;
        }
        return raiz.obtenerNivel(unaEtiqueta);
    }

    @Override
    public int obtenerCantidadHojas() {
        if (this.raiz != null) {
            return this.raiz.obtenerCantidadHojas();
        } else {
            return 0;
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
    }

    public Integer longTrayInt() {
        if (esVacio()) {
            return 0;
        }
        return this.raiz.longTrayInt(1);
    }

    public Integer cantInternos() {
        if (esVacio()) {
            return 0;
        }
        return raiz.cantInternos();
    }

    public Integer longTrayIntProm() {
        if (esVacio()) {
            return 0;
        }
        return this.longTrayInt() / this.obtenerTamanio();
    }

    public Integer longTrayExtProm() {
        if (esVacio()) {
            return 1;
        }
        return this.longTrayExt() / (this.obtenerTamanio() + 1);
    }
}
