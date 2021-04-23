import java.util.ArrayList;
import conjuntos.*;

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

        System.out.println("Finalizado.");
    }
}