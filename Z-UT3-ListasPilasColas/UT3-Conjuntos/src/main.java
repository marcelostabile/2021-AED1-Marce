import java.util.*;
import conjuntos.*;
import tdas.*;

public class main {
    
    public static void main(String[] args) {

        System.out.println("Comenzando ejecución...");

        /* 
         * Conjuntos con arraylist 
        */

        ArrayList<Integer> conjuntoA = new ArrayList<Integer>();
        conjuntoA.add(1);
        conjuntoA.add(2);
        conjuntoA.add(3);

        ArrayList<Integer> conjuntoB = new ArrayList<Integer>();
        conjuntoB.add(1);
        conjuntoB.add(5);
        conjuntoB.add(3);

        System.out.println("Imprimir Conjunto A: ");
        Conjuntos.imprimir(conjuntoA);

        System.out.println("Imprimir Conjunto B: ");
        Conjuntos.imprimir(conjuntoB);

        System.out.println("Unión: ");
        Conjuntos.imprimir( Conjuntos.union(conjuntoA, conjuntoB) );

        System.out.println("Intersección: ");
        Conjuntos.imprimir( Conjuntos.interseccion(conjuntoA, conjuntoB) );

        System.out.println("Diferencia: ");
        Conjuntos.imprimir( Conjuntos.diferencia(conjuntoA, conjuntoB) );

        System.out.println("Diferencia Simétrica: ");
        Conjuntos.imprimir( Conjuntos.diferenciaSimetrica(conjuntoA, conjuntoB) );

        System.out.println("Complemento: ");
        Conjuntos.imprimir( Conjuntos.complementoConjuntoA(conjuntoA, 1, 10) );

        System.out.println("Producto Cartesiano: ");
        Conjuntos.imprimirProductoCartesiano( Conjuntos.productoCartesiano(conjuntoA, conjuntoB) );

        /*
         * Conjuntos con TDA Lista.
        */

        IConjunto<Integer> conjunto1 = new Conjunto<>();
        for (Integer elemento1 : conjuntoA) {
            conjunto1.insertarUltimo(new Nodo<Integer>( (Comparable) elemento1, elemento1));
        }

        IConjunto<Integer> conjunto2 = new Conjunto<>();
        for (Integer elemento2 : conjuntoB) {
            conjunto2.insertarUltimo(new Nodo<Integer>( (Comparable) elemento2, elemento2));
        }

        System.out.println("Conjunto1 - elementos: " + conjunto1.cantElementos());
        System.out.println("Conjunto2 - elementos: " + conjunto2.cantElementos() + "\n");

        System.out.println("Unión: ");
        conjunto1.imprimirConjunto(conjunto1.union(conjunto2));

        System.out.println("Intersección: ");
        conjunto1.imprimirConjunto(conjunto1.interseccion(conjunto2));

        System.out.println("Diferencia: ");
        conjunto1.imprimirConjunto(conjunto1.diferencia(conjunto2));

        System.out.println("Diferencia Simétrica: ");
        conjunto1.imprimirConjunto(conjunto1.diferenciaSimetrica(conjunto2));

        System.out.println("Complemento: ");
        conjunto1.imprimirConjunto(conjunto1.complemento(conjunto2));

        System.out.println("Finalizado.");
    }
}