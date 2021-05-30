package pilas_colas;

import tdas.*;

public class Principal {
    
    public void main() {

        System.out.println("* * * Pila * * *");
        IPila<Integer> miPila = new Pila<>();

        miPila.apilar_push(new Nodo<Integer>(10, 10));
        miPila.apilar_push(new Nodo<Integer>(20, 20));
        miPila.apilar_push(new Nodo<Integer>(30, 30));
        miPila.apilar_push(new Nodo<Integer>(40, 40));
        miPila.apilar_push(new Nodo<Integer>(50, 50));
        miPila.imprimir(",");

        System.out.println("Cabeza: " + miPila.getTop().getEtiqueta().toString());
        INodo<Integer> nodoElim1 = miPila.desapilar_pop();

        System.out.println("Elim1: " + nodoElim1.getEtiqueta());
        INodo<Integer> nodoElim2 = miPila.desapilar_pop();

        System.out.println("Elim2: " + nodoElim2.getEtiqueta());
        miPila.imprimir(",");
        
        System.out.println("Cabeza: " + miPila.getTop().getEtiqueta().toString()); 

        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        System.out.println("* * * Cola * * *");
        ICola<Integer> miCola = new Cola<>();

        miCola.agregar_add(new Nodo<Integer>(10, 10));
        miCola.agregar_add(new Nodo<Integer>(20, 20));
        miCola.agregar_add(new Nodo<Integer>(30, 30));
        miCola.agregar_add(new Nodo<Integer>(40, 40));
        miCola.agregar_add(new Nodo<Integer>(50, 50));
        miCola.imprimir(",");

        INodo<Integer> nodoElim01 = miCola.quitar_remove();
        INodo<Integer> nodoElim02 = miCola.quitar_remove();
        miCola.imprimir(",");

        nodoElim01.imprimir();
        nodoElim02.imprimir();

        System.out.println(miCola.estaVacia());
        System.out.println(miCola.getCabeza().getEtiqueta().toString());

    }
}
