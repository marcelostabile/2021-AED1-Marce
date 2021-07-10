    import tdas.*;
/**
 *
 * @author Ernesto
 */
    public class CalculadorMatricesOptimo implements ICalculadorMatricesOptimo{

    int[][] W;
    int[][] P;
    int[][] R;

    /**
     *
     * @param cantElem
     * @param FrecExito
     * @param FrecNoExito
     */
    @Override
    public void encontrarOptimo(int cantElem, int[] FrecExito, int[] FrecNoExito) {
        int i, j, k, kraiz, h;
        int min, PesoSubArboles;
        kraiz = 0;

        /* Paso 1, para h = 0,
            wii = bii y pii = wii
            y completar la matriz W:  wij = wij-1+ aj + bj
        completa las sentencias necesarias
        */
        for(i = 0; i <= cantElem; i++)
        {
            W[i][i] = FrecNoExito[i];
            P[i][i] = FrecNoExito[i];
        }

        for(i=0; i <= cantElem ; i++){
            for(j = i; j <= cantElem ; j++){
                if(j!=i){
                    W[i][j] = W[i][j-1] + FrecExito[j-1] + FrecNoExito[j];
                }
            }
        }

        /* Paso 2,  para h = 1
        pij = wij + pii + pjj
       */

        for(i = 0 ; i < cantElem; i++){
            j = i+1;
            P[i][j] = W[i][j] + P[i][i] + P[j][j];
            R[i][j]=j;
        }

        /* Paso 3   para h = 2 hasta h = N

        completa las sentencias necesarias

      */
        kraiz = 0;
        for(h = 2 ; h <= cantElem; h++){
            for(i = 0; i <= cantElem-h; i++ ){
                j = i+h;
                min = Integer.MAX_VALUE;
                for(k = i + 1; k <= j; k++){
                    PesoSubArboles = P[i][k-1] + P[k][j];
                    if(min > PesoSubArboles){
                        min = PesoSubArboles;
                        kraiz = k;
                    }
                }
                P[i][j] = min + W[i][j];
                R[i][j] = kraiz;
            }
        }
    }



    public CalculadorMatricesOptimo(int cantElem) {
        crearMatrices(cantElem);
    }

    private void crearMatrices(int cantElem) {
        W = new int[cantElem+1][cantElem+1];
        P = new int[cantElem+1][cantElem+1];
        R = new int[cantElem+1][cantElem+1];
    }

    @Override
    public void armarArbolBinario(int i, int j, String[] Claves, TArbolBB elArbolBB) {
        TElementoAB unNodo;
        int unaraiz;
        if (i < j) {
            unaraiz = R[i][j];
            unNodo = new TElementoAB(Claves[unaraiz-1], Claves[unaraiz-1]);
            elArbolBB.insertar(unNodo);
            armarArbolBinario(i, unaraiz-1, Claves, elArbolBB);
            armarArbolBinario(unaraiz, j, Claves, elArbolBB);
        }
    }
}
