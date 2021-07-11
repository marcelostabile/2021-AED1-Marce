package com.ucudal.implementacionesParcial;

import com.ucudal.tdas.*;

public class TArbolBB<T> implements IArbolBB<T> {

    private IElementoAB<T> raiz;

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
    public Lista<T> inOrden() {
        Lista<T> listaInorden = new Lista<>();
        if (!esVacio()) {
            raiz.inOrden(listaInorden);
        }
        return listaInorden;
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
    public Lista<T> preOrden() {
        Lista<T> listaPreOrden = new Lista<>();
        if (!esVacio()) {
            raiz.preOrden(listaPreOrden);
        }
        return listaPreOrden;
    }

    @Override
    public String inOrdenString() {
        if (esVacio()) {        // O(1)
            return "arbol vacio";       // O(1)
        }
        return raiz.inOrden();
    }

    @Override
    public String postOrdenString() {
        if (esVacio()) {        // O(1)
            return "arbol vacio";       // O(1)
        }
        return raiz.postOrden();
    }

    @Override
    public String preOrdenString() {
        if (esVacio()) {        // O(1)
            return null;        // O(1)
        } else {
            return raiz.preOrden();
        }
    }
    @Override
    public int obtenerTamanio() {
        if (!esVacio()) { // O(1)
            return raiz.obtenerTamanio();
        }
        return 0; // O(1)
    }

    @Override
    public int obtenerAltura() {
        if(!esVacio()){     // O(1)
            return raiz.obtenerAltura();
        }
        return -1;      // O(1)
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

    @Override
    public long calcularCosto(int[] FrecExito, int[] FrecNoExito) {
    	if (esVacio()) {
            return 1;
        }
        int[] indiceFE = new int[1];
        int[] indiceFNE = new int[1];
        indiceFE[0] = 1;
        indiceFNE[0] = 0;
        return raiz.calcularCosto(FrecExito, FrecNoExito, indiceFE, indiceFNE, 1);
    }

    @Override
    public void cuentaFrec(Comparable unaClave) {
        if (!esVacio()) {
            raiz.cuentaFrec(unaClave);
        }
    }
    @Override
    public void completaVectores(IElementoAB[] elementos, int[] FrecExito, int[] FrecNoExito) {
        if (!esVacio()) {
            int[] indiceFE = { 1 };
            int[] indiceFNE = { 0 };
            raiz.completaVectores(elementos, FrecExito, FrecNoExito, indiceFE, indiceFNE);
        }
    }
    
}
