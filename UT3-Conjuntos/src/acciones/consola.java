package acciones;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class consola {
    
    /**
     * Imprimir los valores de un ArrayList por consola.
     */
    public static void imprimir(ArrayList<Integer> listaRecibida) {
        
        for (Integer elem : listaRecibida) {
            System.out.println(elem);
        }
    }

    /**
     * Imprimir los valores de un ArrayList por consola.
     */
    public static void imprimirArrayDeArrays(ArrayList<int[]> listaRecibida) {

        List<int[]> lista = new ArrayList<>(listaRecibida);

        System.out.println(lista.size());

        for (int[] elem : lista) {
            System.out.println(elem.length);
            System.out.println(elem[0]);
        }
        // for (int i=0; i<listaRecibida.size(); i++) {

        //     int[] par = listaRecibida[i];
        //     System.out.println( par(i) );
            
        
    }
    
}