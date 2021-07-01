import tdas.*;
import archivos.*;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        TArbolBB elArbolLista = new TArbolBB();
        TArbolBB elArbolRandom = new TArbolBB();
        TArbolBB elArbolLleno = new TArbolBB();
        ArmarLleno armador = new ArmarLleno();

        String[] lineasClavesOrd = ManejadorArchivosGenerico.leerArchivo("UT4-TA11\\src\\255ord.txt");
        String[] lineasClavesRandom = ManejadorArchivosGenerico.leerArchivo("UT4-TA11\\src\\255rand.txt");
        int cantElementos = lineasClavesOrd.length;
        System.out.println("La cantidad de elementos leídos es: " + cantElementos);

        for (String l : lineasClavesOrd) {
            String[] datosPalabra = l.split(" ");
            TElementoAB<String> nuevoNodo = new TElementoAB<>(Integer.parseInt(datosPalabra[0].trim()),
                    datosPalabra[0].trim());
            elArbolLista.insertar(nuevoNodo);
        }
        System.out.println();
        for (String l : lineasClavesRandom) {
            String[] datosPalabra = l.split(" ");
            TElementoAB<String> nuevoNodo = new TElementoAB<>(Integer.parseInt(datosPalabra[0].trim()),
                    datosPalabra[0].trim());
            elArbolRandom.insertar(nuevoNodo);
        }
        armador.armarArbolLleno(0, cantElementos - 1, lineasClavesOrd, elArbolLleno);

        System.out.println();
        System.out.println("El tamanio del arbol lista es: " + elArbolLista.obtenerTamanio());
        System.out.println("La altura del arbol lista es: " + elArbolLista.obtenerAltura());
        System.out.println("La cantidad de hojas del arbol lista es: " + elArbolLista.obtenerCantidadHojas());
        System.out.println("La cantidad de nodos internos arbol lista es: " + elArbolLista.cantInternos());
        System.out.println("La longitud de trayectoria interna del arbol lista es: " + elArbolLista.longTrayInt());
        System.out.println(
                "La longitud de trayectoria interna promedio del arbol lista es: " + elArbolLista.longTrayIntProm());
        System.out.println("La longitud de trayectoria externa del arbol lista es: " + elArbolLista.longTrayExt());
        System.out.println(
                "La longitud de trayectoria externa promedio del arbol lista es: " + elArbolLista.longTrayExtProm());
        System.out.println();
        System.out.println("El tamanio del arbol random es: " + elArbolLista.obtenerTamanio());
        System.out.println("La altura del arbol random es: " + elArbolRandom.obtenerAltura());
        System.out.println("La cantidad de hojas del arbol random es: " + elArbolRandom.obtenerCantidadHojas());
        System.out.println("La cantidad de nodos internos arbol random es: " + elArbolRandom.cantInternos());
        System.out.println("La longitud de trayectoria interna del arbol random es: " + elArbolRandom.longTrayInt());
        System.out.println(
                "La longitud de trayectoria interna promedio del arbol random es: " + elArbolRandom.longTrayIntProm());
        System.out.println("La longitud de trayectoria externa del arbol random es: " + elArbolRandom.longTrayExt());
        System.out.println(
                "La longitud de trayectoria externa promedio del arbol random es: " + elArbolRandom.longTrayExtProm());
        System.out.println();
        System.out.println("El tamanio del arbol lleno es: " + elArbolLleno.obtenerTamanio());
        System.out.println("La altura del arbol lleno es: " + elArbolLleno.obtenerAltura());
        System.out.println("La cantidad de hojas del arbol lleno es: " + elArbolLleno.obtenerCantidadHojas());
        System.out.println("La cantidad de nodos internos arbol lleno es: " + elArbolLleno.cantInternos());
        System.out.println("La longitud de trayectoria interna del arbol lleno es: " + elArbolLleno.longTrayInt());
        System.out.println(
                "La longitud de trayectoria interna promedio del arbol lleno es: " + elArbolLleno.longTrayIntProm());
        System.out.println("La longitud de trayectoria externa del arbol lleno es: " + elArbolLleno.longTrayExt());
        System.out.println(
                "La longitud de trayectoria externa promedio del arbol lleno es: " + elArbolLleno.longTrayExtProm());
        System.out.println();

    }
}