import java.util.*;
import conjuntos.*;
import tdas.*;

public class main {
    
    public static void main(String[] args) {

        System.out.println("Comenzando ejecución...");

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

        // Conjunto con TDA Lista.
        TConjunto<Integer> conjunto1 = new TConjunto<>();
        TConjunto<Integer> conjunto2 = new TConjunto<>();

        conjunto1.insertarElementos(conjuntoA);
        conjunto2.insertarElementos(conjuntoB);

        System.out.println("Conjunto1 - elementos: " + conjunto1.cantElementos());
        System.out.println("Conjunto2 - elementos: " + conjunto2.cantElementos() + "\n");

        System.out.println("Unión: ");
        conjunto1.imprimirTConjunto(conjunto1.union(conjunto2));

        System.out.println("Intersección: ");
        conjunto1.imprimirTConjunto(conjunto1.interseccion(conjunto2));

        System.out.println("Diferencia: ");
        conjunto1.imprimirTConjunto(conjunto1.diferencia(conjunto2));

        System.out.println("Diferencia Simétrica: ");
        conjunto1.imprimirTConjunto(conjunto1.diferenciaSimetrica(conjunto2));

        System.out.println("Complemento: ");
        conjunto1.imprimirTConjunto(conjunto1.complemento(conjunto2));

        System.out.println("Finalizado.");
    }
}