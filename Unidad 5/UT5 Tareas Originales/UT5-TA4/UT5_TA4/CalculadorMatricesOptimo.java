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

       
        /* Paso 1, para h = 0, 
            wii = bii y pii = wii
            y completar la matriz W:  wij = wij-1+ aj + bj 
       
        completa las sentencias necesarias
	         
        
        */

       /* Paso 2,  para h = 1 
        pij = wij + pii + pjj 
        
        completa las sentencias necesarias
       */

       
       
       /* Paso 3   para h = 2 hasta h = N
        
        completa las sentencias necesarias 
        
      */


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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
