package procesador;

import archivos.ManejadorArchivosGenerico;

public class procesadorWISErrorFile {

    public static void procesarWISErrorFile(String dirEntrada, String dirSalida, String nomArchivoEntrada, String archivoReporte) {

        // registrarData y registrarError los iniciailizo en false, lineaData y lineaError los iniciailizo en nulo.
        Boolean registrarData = false;
        Boolean registrarError = false;
        String lineaData = "";
        String lineaError = "";

        // Creamos arrayList donde se guardan las lineas del archivo.
        String[] listaLineasArchivo = new String[0];
        String[] lineaArray = new String[0];
        String[] lineasReporte = {"Archivo: " + nomArchivoEntrada,"","",""};

        // Leemos el archivo.
        listaLineasArchivo = ManejadorArchivosGenerico.leerArchivo(dirEntrada + nomArchivoEntrada);

        // Recorremos las lineas leidas.
        for (String linea : listaLineasArchivo) {

            //     Si la linea actual contiene "===Data" o registrarData es true entonces, registrarData es true, lineaData es igual lineaData concatenada con la linea actual leida.
            if (linea.contains("Data") == true || registrarData == true) {
                registrarData = true;
                lineaData = lineaData + linea;
            }

            //     Si la linea actual contiene "[Error]" o registrarError es true entonces, registrarError es true, lineaError es igual lineaError concatenada con la linea actual leida.
            if (linea.contains("[ERROR]") == true || registrarError == true) {
                registrarError = true;
                lineaError = lineaError + linea;
            }

            if (linea.isBlank() && registrarData == true) {
                registrarData = false;

                if (lineaData.contains("==Data: DTOWisConfirmacionRecepcion") == true) {
                    lineaData = lineaData.replaceAll("==Data: DTOWisConfirmacionRecepcion", "").replaceAll(" ", "").replaceAll("\\[", "").replaceAll("\\]", "");
                    lineaArray = lineaData.split(",");
                    lineaData = "Datos: " + lineaArray[3] + " * " + lineaArray[0];
                }

                if (lineaData.contains("==Data: DTOWisAnulacionPedido") == true) {
                    lineaData = lineaData.replaceAll("==Data: DTOWisAnulacionPedido", "").replaceAll("pedidos=DTOWisPedidoAnuladocodigo", "").replaceAll(" ", "").replaceAll("\\[", "").replaceAll("\\]", "");
                    lineaArray = lineaData.split(",");
                    lineaData = "Datos: " + lineaArray[1] + " * " + lineaArray[2];
                }
                lineasReporte[1] = lineaData;    // Guardamos en la lista.
            }

            if (linea.isBlank() && registrarError == true) {
                registrarError = false;
                lineaError = lineaError.replaceAll("\\[", "").replaceAll("\\]", "");
                lineasReporte[2] = lineaError;    // Guardamos en la lista.
                lineasReporte[3] = "\n";    // Guardamos en la lista.
            }
            
        }
        
        // Resultados por pantalla.
        System.out.println(lineasReporte[0]);
        System.out.println(lineaData);
        System.out.println(lineaError);
        System.out.println("\n");

        // Resultados guardados en el archivo.
        ManejadorArchivosGenerico.escribirArchivo(dirSalida + archivoReporte, lineasReporte);
    }
}
