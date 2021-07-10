import tdas.*;
public interface ICalculadorMatricesOptimo {

    //public int calcularCosto();
    void armarArbolBinario(int i, int j, TElementoAB[] elementos, TArbolBB elArbolBB);

    public void encontrarOptimo(int cantElem, int[] FrecExito, int[] FrecNoExito);

}
