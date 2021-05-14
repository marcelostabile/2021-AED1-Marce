package src_claves;

import archivos.*;
import TDAS.*;
import java.util.*;

public class Principal {

    public void Ejecutar() {
    
        /**
         * Ejercicio: CLAVES
         */

        // CLAVE 1
        System.out.println("Carga archivo claves 1\n");

        // Crear arbol y cargar archivo.
        TArbolBB<Integer> arbol = new TArbolBB<>();

        String[] archivo = ManejadorArchivosGenerico.leerArchivo("src\\src_claves_archivos\\claves1.txt");
        for (String linea : archivo) {
            if (!linea.equals("")) {
                // registro = linea.split();
                TElementoAB<Integer> unElemento = new TElementoAB<Integer>(Integer.parseInt(linea), Integer.parseInt(linea));
                arbol.insertar(unElemento);
            }
        }
        System.out.println("Contador Insertar: " + arbol.contador + "\n");

        System.out.println("Altura: " + arbol.altura());
        System.out.println("Tamaño: " + arbol.tamano());
        System.out.println("Hojas: " + arbol.hojas());
        System.out.println("Internos: " + arbol.internos());
        System.out.println("Internos Completos: " + arbol.completos());
        System.out.println("Clave Menor: " + arbol.claveMenor());
        System.out.println("Clave Mayor: " + arbol.claveMayor());
        System.out.println("Confirmar Árbol ABB: " + arbol.esABB());
        System.out.println("Buscar 192: nodo obtenido: " + arbol.buscar(192));
        System.out.println("nivelNodo 5354: " + arbol.nivelNodoABB(11988));
        System.out.println("nivelNodo 2601: " + arbol.nivelNodoABB(2601));
        System.out.println("nivelNodo 9999: " + arbol.nivelNodoABB(9999));
        System.out.println("\n");
        System.out.println("PreOrden: " + arbol.preOrden() + "\n");
        System.out.println("InOrden: " + arbol.inOrden() + "\n");
        System.out.println("PostOrden: " + arbol.postOrden() + "\n");
        ArrayList<String> listaHojas = arbol.listaDeHojas();
        for (String registro : listaHojas) {
            System.out.println(registro);
        }
        System.out.println("Cant. Nodos Nivel 1: " + arbol.enNivel(1));
        System.out.println("Cant. Nodos Nivel 3: " + arbol.enNivel(3));
        System.out.println("Cant. Nodos Nivel 5: " + arbol.enNivel(5));

        // CLAVE 2
        System.out.println("Carga archivo claves 2\n");

        // Crear arbol y cargar archivo.
        TArbolBB<Integer> arbol2 = new TArbolBB<>();
        
        String[] archivo2 = ManejadorArchivosGenerico.leerArchivo("src\\src_claves_archivos\\claves2.txt");
        for (String linea : archivo2) {
            if (!linea.equals("")) {
                // registro = linea.split();
                TElementoAB<Integer> unElemento = new TElementoAB<Integer>(Integer.parseInt(linea), Integer.parseInt(linea));
                arbol2.insertar(unElemento);
            }
        }
        System.out.println("Contador Insertar: " + arbol2.contador + "\n");

        System.out.println("Altura: " + arbol2.altura());
        System.out.println("Tamaño: " + arbol2.tamano());
        System.out.println("Hojas: " + arbol2.hojas());
        System.out.println("Internos: " + arbol2.internos());
        System.out.println("Internos Completos: " + arbol2.completos());
        System.out.println("Clave Menor: " + arbol2.claveMenor());
        System.out.println("Clave Mayor: " + arbol2.claveMayor());
        System.out.println("Confirmar Árbol ABB: " + arbol2.esABB());
        System.out.println("Buscar 192: nodo obtenido: " + arbol2.buscar(192));
        System.out.println("nivelNodo 104: " + arbol2.nivelNodoABB(104));
        System.out.println("nivelNodo 1277: " + arbol2.nivelNodoABB(1277));
        System.out.println("nivelNodo 9999: " + arbol2.nivelNodoABB(9999));
        System.out.println("\n");
        System.out.println("PreOrden: " + arbol2.preOrden() + "\n");
        System.out.println("InOrden: " + arbol2.inOrden() + "\n");
        System.out.println("PostOrden: " + arbol2.postOrden() + "\n");
        ArrayList<String> listaHojas2 = arbol2.listaDeHojas();
        for (String registro : listaHojas2) {
            System.out.println(registro);
        }
        System.out.println("Cant. Nodos Nivel 1: " + arbol2.enNivel(1));
        System.out.println("Cant. Nodos Nivel 3: " + arbol2.enNivel(3));
        System.out.println("Cant. Nodos Nivel 5: " + arbol2.enNivel(5));

        // CLAVE 3
        System.out.println("Carga archivo claves 3\n");

        // Crear arbol y cargar archivo.
        TArbolBB<Integer> arbol3 = new TArbolBB<>();
        
        String[] archivo3 = ManejadorArchivosGenerico.leerArchivo("src\\src_claves_archivos\\claves3.txt");
        for (String linea : archivo3) {
            if (!linea.equals("")) {
                // registro = linea.split();
                TElementoAB<Integer> unElemento = new TElementoAB<Integer>(Integer.parseInt(linea), Integer.parseInt(linea));
                arbol3.insertar(unElemento);
            }
        }
        System.out.println("Contador Insertar: " + arbol3.contador + "\n");

        System.out.println("Altura: " + arbol3.altura());
        System.out.println("Tamaño: " + arbol3.tamano());
        System.out.println("Hojas: " + arbol3.hojas());
        System.out.println("Internos: " + arbol3.internos());
        System.out.println("Internos Completos: " + arbol3.completos());
        System.out.println("Clave Menor: " + arbol3.claveMenor());
        System.out.println("Clave Mayor: " + arbol3.claveMayor());
        System.out.println("Confirmar Árbol ABB: " + arbol3.esABB());
        System.out.println("Buscar 192: nodo obtenido: " + arbol3.buscar(192));
        System.out.println("nivelNodo 5354: " + arbol3.nivelNodoABB(5354));
        System.out.println("nivelNodo 2601: " + arbol3.nivelNodoABB(2601));
        System.out.println("nivelNodo2 9999: " + arbol3.nivelNodoABB(9999));
        System.out.println("\n");
        System.out.println("PreOrden: " + arbol3.preOrden() + "\n");
        System.out.println("InOrden: " + arbol3.inOrden() + "\n");
        System.out.println("PostOrden: " + arbol3.postOrden() + "\n");
        ArrayList<String> listaHojas3 = arbol3.listaDeHojas();
        for (String registro : listaHojas3) {
            System.out.println(registro);
        }
        System.out.println("Cant. Nodos Nivel 1: " + arbol3.enNivel(1));
        System.out.println("Cant. Nodos Nivel 3: " + arbol3.enNivel(3));
        System.out.println("Cant. Nodos Nivel 4: " + arbol3.enNivel(4));
        System.out.println("Cant. Nodos Nivel 5: " + arbol3.enNivel(5));
        System.out.println("Cant. Nodos Nivel 6: " + arbol3.enNivel(6));
        
    }

}