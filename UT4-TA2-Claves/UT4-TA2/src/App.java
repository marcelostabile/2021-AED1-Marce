import java.util.ArrayList;

import archivos.ManejadorArchivosGenerico;
import tdas.IArbolBB;
import tdas.TArbolBB;
import tdas.TElementoAB;

public class App {
    public static void main(String[] args) throws Exception {

        // Crear dos árboles
        TArbolBB<Integer> arbolBB1 = new TArbolBB<>();
        TArbolBB<Integer> arbolBB2 = new TArbolBB<>();


        // Cargar las claves de los archivos
        String[] archivo1 = ManejadorArchivosGenerico.leerArchivo("src//claves1.txt");
        for (String linea : archivo1) { 
            if (linea.length() > 0) {
                TElementoAB<Integer> unElemento = new TElementoAB<>(Integer.parseInt(linea), Integer.parseInt(linea));
                arbolBB1.insertar(unElemento);
            }
        }
        System.out.println("Contador 1: " + arbolBB1.contador + "\n");

        System.out.println("Altura: " + arbolBB1.altura());
        System.out.println("Tamaño: " + arbolBB1.tamano());
        System.out.println("Hojas: " + arbolBB1.hojas());
        System.out.println("Internos: " + arbolBB1.internos());
        System.out.println("Internos Completos: " + arbolBB1.completos());
        System.out.println("Clave Menor: " + arbolBB1.claveMenor());
        System.out.println("Clave Mayor: " + arbolBB1.claveMayor());
        System.out.println("Confirmar Árbol ABB: " + arbolBB1.esABB());
        System.out.println("Buscar 192: nodo obtenido: " + arbolBB1.buscar(192));
        System.out.println("nivelNodo 5354: " + arbolBB1.nivelNodoABB(11988));
        System.out.println("nivelNodo 2601: " + arbolBB1.nivelNodoABB(2601));
        System.out.println("nivelNodo 9999: " + arbolBB1.nivelNodoABB(9999));
        System.out.println("\n");
        System.out.println("PreOrden: " + arbolBB1.preOrden() + "\n");
        System.out.println("InOrden: " + arbolBB1.inOrden() + "\n");
        System.out.println("PostOrden: " + arbolBB1.postOrden() + "\n");
        ArrayList<String> listaHojas = arbolBB1.listaDeHojas();
        for (String registro : listaHojas) {
            System.out.println(registro);
        }
        System.out.println("Cant. Nodos Nivel 1: " + arbolBB1.enNivel(1));
        System.out.println("Cant. Nodos Nivel 3: " + arbolBB1.enNivel(3));
        System.out.println("Cant. Nodos Nivel 5: " + arbolBB1.enNivel(5));


        // Cargar las claves de los archivos
        String[] archivo2 = ManejadorArchivosGenerico.leerArchivo("src//claves2.txt");
        for (String linea : archivo2) {
            if (linea.length() > 0) {
                TElementoAB<Integer> unElemento = new TElementoAB<>(Integer.parseInt(linea), Integer.parseInt(linea));
                arbolBB2.insertar(unElemento);
            }
        }
        System.out.println("Contador 2: " + arbolBB2.contador + "\n");
        
        System.out.println("Altura: " + arbolBB2.altura());
        System.out.println("Tamaño: " + arbolBB2.tamano());
        System.out.println("Hojas: " + arbolBB2.hojas());
        System.out.println("Internos: " + arbolBB2.internos());
        System.out.println("Internos Completos: " + arbolBB2.completos());
        System.out.println("Clave Menor: " + arbolBB2.claveMenor());
        System.out.println("Clave Mayor: " + arbolBB2.claveMayor());
        System.out.println("Confirmar Árbol ABB: " + arbolBB2.esABB());
        System.out.println("Buscar 192: nodo obtenido: " + arbolBB2.buscar(192));
        System.out.println("nivelNodo 104: " + arbolBB2.nivelNodoABB(104));
        System.out.println("nivelNodo 1277: " + arbolBB2.nivelNodoABB(1277));
        System.out.println("nivelNodo 9999: " + arbolBB2.nivelNodoABB(9999));
        System.out.println("\n");
        System.out.println("PreOrden: " + arbolBB2.preOrden() + "\n");
        System.out.println("InOrden: " + arbolBB2.inOrden() + "\n");
        System.out.println("PostOrden: " + arbolBB2.postOrden() + "\n");
        ArrayList<String> listaHojas2 = arbolBB2.listaDeHojas();
        for (String registro : listaHojas2) {
            System.out.println(registro);
        }
        System.out.println("Cant. Nodos Nivel 1: " + arbolBB2.enNivel(1));
        System.out.println("Cant. Nodos Nivel 3: " + arbolBB2.enNivel(3));
        System.out.println("Cant. Nodos Nivel 5: " + arbolBB2.enNivel(5));

    }
}
