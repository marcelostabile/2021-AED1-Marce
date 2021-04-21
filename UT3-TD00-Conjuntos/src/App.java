import java.util.ArrayList;

import acciones.consola;
import operadoresDeConjuntos.operadoresDeConjuntos;

public class App {

    public static void main(String[] args) throws Exception {

        System.out.println("Comenzando ejecución...");

        ArrayList<Integer> conjuntoA = new ArrayList<Integer>();
        ArrayList<Integer> conjuntoB = new ArrayList<Integer>();

        conjuntoA.add(1);
        conjuntoA.add(2);
        conjuntoA.add(3);

        conjuntoB.add(1);
        conjuntoB.add(5);
        conjuntoB.add(3);

        System.out.println("Imprimir listas: ");
        consola.imprimir(conjuntoA);
        consola.imprimir(conjuntoB);

        // System.out.println("Unión: ");
        // consola.imprimir( operadoresDeConjuntos.union(conjuntoA, conjuntoB) );

        // System.out.println("Intersección: ");
        // consola.imprimir( operadoresDeConjuntos.interseccion(conjuntoA, conjuntoB) );

        // System.out.println("Diferencia: ");
        // consola.imprimir( operadoresDeConjuntos.diferencia(conjuntoA, conjuntoB) );

        // System.out.println("Diferencia Simétrica: ");
        // consola.imprimir( operadoresDeConjuntos.diferenciaSimetrica(conjuntoA, conjuntoB) );

        // System.out.println("Complemento: ");
        // consola.imprimir( operadoresDeConjuntos.complementoConjuntoA(conjuntoA, 1, 10) );

        System.out.println("Producto Cartesiano: ");
        consola.imprimirArrayDeArrays( operadoresDeConjuntos.productoCartesiano(conjuntoA, conjuntoB) );

        System.out.println("Finalizado.");
    }

}
