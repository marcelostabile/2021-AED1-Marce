package com.ucudal.ta11;

import com.ucudal.tdas.IElementoAB;
import com.ucudal.tdas.Lista;

public class TElementoAB<T> implements IElementoAB<T> {

    private final Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private final T datos;
    private int frecExito;
    private int frecNoExitoIzq;
    private int frecNoExitoDer;

    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
        frecExito = 0;
        frecNoExitoIzq = 0;
        frecNoExitoDer = 0;
    }

    @Override
    public Comparable getEtiqueta() {
        return null;
    }

    public TElementoAB getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB getHijoDer() {
        return hijoDer;
    }

    @Override
    public void setHijoIzq(IElementoAB<T> elemento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setHijoDer(IElementoAB<T> elemento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IElementoAB<T> buscar(Comparable unaEtiqueta) {
        return null;
    }

    @Override
    public boolean insertar(IElementoAB<T> elemento) {
        return false;
    }

    @Override
    public String inOrden() {
        return null;
    }

    @Override
    public String preOrden() {
        return null;
    }

    @Override
    public String postOrden() {
        return null;
    }

    @Override
    public void inOrden(Lista<T> unaLista) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void preOrden(Lista<T> unaLista) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void postOrden(Lista<T> unaLista) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T getDatos() {
        return null;
    }

    @Override
    public int obtenerTamanio() {
        return 0;
    }

    @Override
    public int obtenerAltura() {
        return 0;
    }

    @Override
    public IElementoAB eliminar(Comparable unaEtiqueta) {
        return null;
    }

    @Override
    public IElementoAB clonar() {
        return null;
    }

    @Override
    public String imprimir() {
        return null;
    }

    @Override
    public int calcularCosto(int[] FrecExito, int[] FrecNoExito, int[] indiceFE, int[] indiceFNE, int nivel) {
        return 0;
    }

    @Override
    public void completaVectores(IElementoAB[] elementos, int[] FrecExito, int[] FrecNoExito, int[] indiceFE, int[] indiceFNE) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void cuentaFrec(Comparable unaClave) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
