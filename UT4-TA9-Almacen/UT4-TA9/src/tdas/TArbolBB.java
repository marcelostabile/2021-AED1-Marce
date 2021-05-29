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
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", retorna falso.
     * @param unElemento Elemento<T> a insertar.
     * @return Boolean, true si lo inserta.
     */
    public boolean insertar(TElementoAB<T> unElemento) {
        if (this.raiz == null) {
            this.raiz = unElemento;
            return true;
        } else {
            boolean res = this.raiz.insertar(unElemento);
            return res;
        }
    }

    /**
     * Busca un elemento dentro del árbol.
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar.
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (this.raiz == null) {
            return null;
        } else {
            return this.raiz.buscar(unaEtiqueta);
        }
    }

    /**
     * Devuelve true si el árbol es vacío.
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

    /**
     * Imprime en InOrden los elementos del árbol, separados por guiones.
     * @return String conteniendo el preorden separado por guiones.
     */
    public String inOrden() {

        if (this.raiz == null) {
            return null;
        } else {
            return this.raiz.inOrden();
        }
    }

    /**
     * Imprime en InOrden los elementos del árbol, separados por guiones.
     * @return una lista conteniendo los elementos separados por guiones.
     */
    public Lista<T> inorden() {
        Lista<T> listaResultado = null;
        if (!esVacio()) {
            listaResultado = new Lista<T>();
            raiz.inOrden(listaResultado);
        }
        return listaResultado;
    }

    /**
     * Método para determinar la altura del árbol.
     * @return entero.
     */
    public int obtenerAltura() {
        if (this.raiz != null) {
            return this.raiz.obtenerAltura();
        } else {
            return 0;
        }
    }

    /**
     * Método para determinar el tamaño del árbol.
     * @return entero.
     */
    public int obtenerTamanio() {
        if (this.raiz != null) {
            return this.raiz.obtenerTamanio();
        } else {
            return 0;
        }
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Retorna la cantidad de hojas del arbol.
     *
     * @return Cantidad de hojas del arbol.
     */
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

}