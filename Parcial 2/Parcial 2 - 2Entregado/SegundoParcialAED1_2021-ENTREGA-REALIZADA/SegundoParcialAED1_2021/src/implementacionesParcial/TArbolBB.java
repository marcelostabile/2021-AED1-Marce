package implementacionesParcial;

import tdas.*;

public class TArbolBB<T> implements IArbolBB<T> {

    private IElementoAB<T> raiz;

    public TArbolBB() {
        raiz = null;
    }

    @Override
    public boolean insertar(IElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    @Override
    public IElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    @Override
    public Lista<T> inorden() {
        Lista<T> listaResultado = null;
        if (!esVacio()) {
            listaResultado = new Lista<T>();
            raiz.inOrden(listaResultado);
        }
        return listaResultado;
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
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
    }

    @Override
    public boolean esVacio() {
        return (raiz == null);
    }

    @Override
    public IElementoAB<T> getRaiz() {
        return this.raiz;
    }
    
}
