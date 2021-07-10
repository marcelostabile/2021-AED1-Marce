package com.ucudal.ta11;

import com.ucudal.tdas.IElementoAB;
import com.ucudal.tdas.Lista;
import com.ucudal.tdas.IArbolBB;

public class TArbolBB<T> implements IArbolBB<T> {

    private IElementoAB<T> raiz;

    @Override
    public IElementoAB<T> getRaiz(){
        return this.raiz;
    }

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public void TArbolBB() {
        raiz = null;
    }

    @Override
    public boolean insertar(IElementoAB<T> unElemento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
       throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public void eliminar(Comparable unaEtiqueta) {
       throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean esVacio() {
       throw new UnsupportedOperationException("Not supported yet.");
    }

   public Lista<T> inOrden() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Lista<T> postOrden() {
        return null;
    }

    @Override
    public Lista<T> preOrden() {
        return null;
    }

    @Override
    public String inOrdenString() {
        return null;
    }

    @Override
    public String postOrdenString() {
        return null;
    }

    @Override
    public String preOrdenString() {
        return null;
    }


    @Override
    public long calcularCosto(int[] FrecExito, int[] FrecNoExito) {
    	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int obtenerAltura(){
        return 0;
    }

    @Override
    public void cuentaFrec(Comparable unaClave) {
      throw new UnsupportedOperationException("Not supported yet.");
    
    }

    @Override
    public void completaVectores(IElementoAB[] elementos, int[] FrecExito, int[] FrecNoExito) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    @Override
    public int obtenerTamanio() {
       throw new UnsupportedOperationException("Not supported yet.");
    }

}
