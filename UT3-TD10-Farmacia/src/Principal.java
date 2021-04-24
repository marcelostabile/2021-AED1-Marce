import archivos.*;
import farmacia.*;

public class Principal {

    public static void main(String[] args) throws Exception {
        
        System.out.println("Comenzando procesamiento..." + "\n");

        String ruta = "C:\\AED1-Marce21\\RepoMarcelo\\UT3-TD10-Farmacia\\src\\archivos\\";

        /**
         * Creamos el almacen.
         */
        IAlmacen alm = new Almacen();

        // Cargar la lista de fármacos con el archivo farmacos.txt
        alm.cargaMasivaFarmacos(ManejadorArchivosGenerico.leerArchivo(ruta + "farmacos.txt"));
        
        // Crear lista de sueros, cargar la lista con el archivo sueros.txt
        alm.cargaMasivaSueros(ManejadorArchivosGenerico.leerArchivo(ruta + "sueros.txt"));

        // Crear lista blanca, cargar la lista con el archivo listablanca.txt
        alm.cargaMasivaListaBlanca(ManejadorArchivosGenerico.leerArchivo(ruta + "listaBlanca.txt"));

        // Crear lista negra, cargar la lista con el archivo listanegra.txt
        alm.cargaMasivaListaNegra(ManejadorArchivosGenerico.leerArchivo(ruta + "listanegra.txt"));

        // Crear lista de preparaciones, cargar la lista con el archivo preparaciones.txt
        alm.cargaMasivaPreparados(ManejadorArchivosGenerico.leerArchivo(ruta + "preparados.txt"));
        
        // Listamos cada preparación y luego el resultado de validar la preparación.
        alm.listarPreparados(ruta);
        
        System.out.println("Proceso finalizado." + "\n");
    }
}
