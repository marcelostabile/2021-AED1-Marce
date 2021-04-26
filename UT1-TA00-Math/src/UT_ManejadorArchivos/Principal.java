package UT_ManejadorArchivos;

public class Principal {

    public static void pruebaManejador () {
        
        /* Instanciamos el manejador de archivos. */
        ManejadorArchivos mgr = new ManejadorArchivos();

        /* Arreglo String. */
        String[] listaLineasArchivo = {"Linea 1", "Linea 2", "Linea 3", "Linea 4"};
        int[] listaEnteros = {10, 15, 20, 25, 30};

        /* Definir ruta y nombre del archivo. */
        String rutaArch = "C:\\AED1\\UT1\\src\\UT_ManejadorArchivos\\";
        String nomArch = "texto.txt";

        /* Convertir int array en string array. */
        String[] listaLineasEnteros = new String[listaEnteros.length];
        for (int i=0; i < listaEnteros.length; i++) {
            listaLineasEnteros[i] = String.valueOf(listaEnteros[i]);
        }
        
        /* Escribir en el archivo. */
        mgr.escribirArchivo(rutaArch + nomArch, listaLineasArchivo);
        mgr.escribirArchivo(rutaArch + nomArch, listaLineasEnteros);

        /* Leer archivo e imprimir en pantalla. */
        mgr.leerArchivo(rutaArch + nomArch);
    }
}
