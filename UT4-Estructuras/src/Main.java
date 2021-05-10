import archivos.*;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import TDAS.*;

public class Main {
    
    public static void main(String[] args) throws Exception {

        System.out.println("Comenzando...\n");

        /**
         * Cargar archivos claves1.txt
         */
        TArbolBB<Integer> arbol1 = new TArbolBB<>();
        
        String[] archivo1 = ManejadorArchivosGenerico.leerArchivo("src\\claves1.txt");
        for (String linea : archivo1) {
            if (!linea.equals("")) {
                TElementoAB<Integer> unElemento = new TElementoAB<Integer>(Integer.parseInt(linea), Integer.parseInt(linea));
                arbol1.insertar(unElemento);
            }
        }
        System.out.println("Contador Insertar: " + arbol1.contador + "\n");

        System.out.println("Altura: " + arbol1.altura());
        System.out.println("Tamaño: " + arbol1.tamano());
        System.out.println("Hojas: " + arbol1.hojas());
        System.out.println("Internos: " + arbol1.internos());
        System.out.println("Internos Completos: " + arbol1.completos());
        System.out.println("PreOrden: " + arbol1.preOrden());
        System.out.println("InOrden: " + arbol1.inOrden());
        System.out.println("PostOrden: " + arbol1.postOrden());
        System.out.println("Buscar 192: Etiqueta del nodo obtenido: " + arbol1.buscar(192).getEtiqueta());
        System.out.println("Nivel Nodo 192: " + arbol1.nivelNodoABB(192));
        System.out.println("Clave Menor: " + arbol1.claveMenor().getEtiqueta());
        System.out.println("Clave Mayor: " + arbol1.claveMayor().getEtiqueta());
        System.out.println("Confirmar Árbol ABB: " + arbol1.esABB());
        System.out.println("\n");

        // /**
        //  * Cargar archivos claves2.txt
        //  */
        // TArbolBB<Integer> arbol2 = new TArbolBB<>();
        
        // String[] archivo2 = ManejadorArchivosGenerico.leerArchivo("src\\claves2.txt");
        // for (String linea : archivo2) {
        //     if (!linea.equals("")) {
        //         TElementoAB<Integer> unElemento = new TElementoAB<Integer>(Integer.parseInt(linea), Integer.parseInt(linea));
        //         arbol2.insertar(unElemento);
        //     }
        // }
        // System.out.println("Contador Insertar: " + arbol2.contador + "\n");

        // System.out.println("Altura: " + arbol2.altura());
        // System.out.println("Tamaño: " + arbol2.tamano());
        // System.out.println("Hojas: " + arbol2.hojas());
        // System.out.println("Internos: " + arbol2.internos());
        // System.out.println("Internos Completos: " + arbol2.completos());
        // System.out.println("PreOrden: " + arbol2.preOrden());
        // System.out.println("InOrden: " + arbol2.inOrden());
        // System.out.println("PostOrden: " + arbol2.postOrden());
        // System.out.println("Buscar 192: " + arbol2.buscar(192));
        // System.out.println("Nivel Nodo 192: " + arbol2.nivelNodoABB(192));
        // System.out.println("Clave Menor: " + arbol2.claveMenor().getEtiqueta());
        // System.out.println("Clave Mayor: " + arbol2.claveMayor().getEtiqueta());
        // //System.out.println("Confirmar Árbol ABB: " + arbol2.esABB());

    }
}
