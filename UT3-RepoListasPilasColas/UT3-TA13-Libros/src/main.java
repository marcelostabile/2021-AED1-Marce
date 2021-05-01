import java.util.ArrayList;
import java.util.LinkedList;

import archivos.*;
import tdas.*;

public class main {

    public static void main(String[] args) {

        ArrayList<TLibro> unaArrayLista = new ArrayList();// en esta lista cargamos incialmente el archivo de entrada
        ArrayList<TLibro> otraArrayLista = new ArrayList();
        LinkedList<TLibro> unaLinkedLista = new LinkedList();
        ILista<TLibro> miLista = new Lista();

        String[] lineasDatos = ManejadorArchivosGenerico.leerArchivo("C:\\AED1-Marce21\\UT3-TAs\\UT-TA\\src\\libros.txt");
        for (String l: lineasDatos){
            String[] datosLibro = l.split(" ");
            TLibro nuevoLibro = new TLibro(datosLibro[0].trim(), datosLibro[0].trim(), datosLibro[0].trim());
            unaArrayLista.add(nuevoLibro);
        }
        System.out.println("terminada carga inicial y comienza la insercion al pricipio de las tres listas" + "\n");

        //La diferencia de insertar al principio en miLista, en una linked list y en una array list
        //Se repite 20 veces la operacion para que sea mas perceptible la diferencia

        /**
         * INSERCIÓN AL PRINCIPIO DE TDA LISTA.
         */
        long deltaTime = System.nanoTime();

        for (int i = 0; i < 20; i ++){
            miLista.vaciar();
            for (TLibro elLibro : unaArrayLista){
                Nodo<TLibro> nuevoNodo = new Nodo (elLibro.getIsbn(), elLibro);
                miLista.insertarPrimero(nuevoNodo);
            }
        }
        System.out.println("Duración TDA LISTA - inserta al principio: (ms)" +  (deltaTime -= System.nanoTime())/1000000 );
        System.out.println("terminada la insercion al principio en miLista");

        /**
         * INSERCIÓN AL PRINCIPIO DE LINKED LIST.
         */
        deltaTime = System.nanoTime();

        for (int i = 0; i < 20; i ++){
            unaLinkedLista.clear();
            for (TLibro elLibro : unaArrayLista){
                unaLinkedLista.addFirst(elLibro);
            }
        }

        System.out.println("Duración LINKEDLIST - inserta al principio: (ms)" +  (deltaTime -= System.nanoTime())/1000000 );
        System.out.println("terminada la insercion al principio en una linked list");

        /**
         * INSERCIÓN AL PRINCIPIO EN ARRAYLIST.
         */
        deltaTime = System.nanoTime();

        for (int i = 0; i < 20; i ++){
            otraArrayLista.clear();
            for (TLibro libro : unaArrayLista){
                otraArrayLista.add(0, libro);
            }
        }

        System.out.println("Duración ARRAYLIST - inserta al principio: (ms)" +  (deltaTime -= System.nanoTime())/1000000 );
        System.out.println("terminada la insercion al principio en una array list" + "\n");

        System.out.println("comienza la insercion al final de las tres listas");
        //La diferencia de insertar al final en miLista, en una linked list y en una array list
        //Se repite 20 veces la operacion para que sea mas perceptible la diferencia

        /**
         * INSERCIÓN AL FINAL DE TDA LISTA.
         */
        deltaTime = System.nanoTime();

        for (int i = 0; i < 10; i ++){
            miLista.vaciar();
            for (TLibro elLibro : unaArrayLista){
                Nodo<TLibro> nuevoNodo = new Nodo (elLibro.getIsbn(),elLibro);
                miLista.insertarUltimo(nuevoNodo);
            }
        }
        System.out.println("Duración TDA LISTA - inserta al final: (ms)" +  (deltaTime -= System.nanoTime())/1000000 );
        System.out.println("terminada la insercion al final en miLista");

        /**
         * INSERCIÓN AL FINAL DE LINKED LIST.
         */
        deltaTime = System.nanoTime();

        for (int i = 0; i < 10; i ++){
            unaLinkedLista.clear();
            for (TLibro elLibro : unaArrayLista){
                unaLinkedLista.addLast(elLibro);
            }
        }
        System.out.println("Duración LINKEDLIST - inserta al final: (ms)" +  (deltaTime -= System.nanoTime())/1000000 );
        System.out.println("terminada la insercion al final en una linked list");

        /**
         * INSERCIÓN AL FINAL DE ARRAYLIST.
         */
        deltaTime = System.nanoTime();

        for (int i = 0; i < 10; i ++){
            otraArrayLista.clear();
            for (TLibro libro : unaArrayLista){
                otraArrayLista.add(libro);
            }
        }
        System.out.println("Duración ARRAYLIST - inserta al final: (ms)" +  (deltaTime -= System.nanoTime())/1000000 );
        System.out.println("terminada la insercion al final en una array list" + "\n");

        // El problema de recorrer las listas
        System.out.println("comienza el recorrido de las listas");
        deltaTime = System.nanoTime();
        INodo<TLibro> unNodo = miLista.getPrimero();
        while (unNodo != null){
            TLibro elLibro = unNodo.getDato();
            unNodo = unNodo.getSiguiente();
        }
        System.out.println("Duración recorrido TDA LISTA: (ms)" +  (deltaTime -= System.nanoTime())/1000000 );
        System.out.println("terminada de recorrer mi lista");

        deltaTime = System.nanoTime();
        for (int j = 0; j < unaLinkedLista.size(); j ++){
            TLibro elLibro = unaLinkedLista.get(j);
        }
        System.out.println("Duración recorrido LINKEDLIST: (ms)" +  (deltaTime -= System.nanoTime())/1000000 );
        System.out.println("terminada de recorrer la linked list");

        deltaTime = System.nanoTime();
        for (int j = 0; j < otraArrayLista.size(); j ++){
            TLibro elLibro = otraArrayLista.get(j);
        }
        System.out.println("Duración recorrido ARRAYLIST: (ms)" +  (deltaTime -= System.nanoTime())/1000000 );
        System.out.println("terminada de recorrer la array list");
    }
}
