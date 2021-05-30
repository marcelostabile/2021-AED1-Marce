
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
     * @return recorrida en preOrden del arbol, null en caso de ser vacío
     */
    /**
     * @return
     */
    public boolean esVacio() {
        return (getRaiz() == null);
    }

    /**
     * @return the raiz
     */
    public TElementoAB<T> getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(TElementoAB<T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (this.raiz == null) {
            this.setRaiz(unElemento);
            return true;
        }
        
        return raiz.insertar(unElemento);
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (this.raiz == null)
            return null;
        
        return this.raiz.buscar(unaEtiqueta);
    }

    @Override
    public Lista<T> inorden() {
        Lista<T> nuevaLista = null;
        
        if (this.raiz == null)
            return nuevaLista;
        
        nuevaLista = new Lista<T>();
        this.raiz.inOrden(nuevaLista);
        return nuevaLista;
    }

}
