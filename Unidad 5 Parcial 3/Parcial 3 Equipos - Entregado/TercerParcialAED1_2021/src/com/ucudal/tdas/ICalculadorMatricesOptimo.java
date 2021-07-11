package com.ucudal.tdas;

public interface ICalculadorMatricesOptimo {

    public void armarArbolBinario(int i, int j, IElementoAB[] elementos, IArbolBB elArbolBB);

    public void encontrarOptimo(int cantElem, int[] FrecExito, int[] FrecNoExito);

}
