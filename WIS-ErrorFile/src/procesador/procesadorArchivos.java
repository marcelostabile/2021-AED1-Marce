package procesador;

import java.io.File;
import java.io.FilenameFilter;

public class procesadorArchivos {
    
    public static void procesarArchivos(String directorioBase, String archivoReporte) {

        String dirEntrada = directorioBase + "1-Entrada\\";
        String dirSalida = directorioBase + "2-Salida\\";

        /*
        Archivos de entrada
        */
        FilenameFilter archivosSeleccionados = new FilenameFilter() {
            public boolean accept(File dirEntrada, String nomArchivo) {
                return nomArchivo.endsWith("txt");
            }
        };

        File f = new File(dirEntrada);
        String[] listaArchivos = f.list(archivosSeleccionados);

        // Recorrer la lista de archivos, procesar cada uno.
        int contador = 0;
        for (int i=0; i < listaArchivos.length; i++) {
            procesadorWISErrorFile.procesarWISErrorFile(dirEntrada, dirSalida, listaArchivos[i], archivoReporte);
            contador++;
        }
        System.out.println("Archivos procesados: " + contador);
    }
}
