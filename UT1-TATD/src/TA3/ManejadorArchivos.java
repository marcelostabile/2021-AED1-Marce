package TA3;

import java.io.*;

/* 
Manejador de Archivos - Lectura, Escritura - Marcelo Stabile.
*/
public class ManejadorArchivos {

    /*
    Método para leer un archivo.
    */
    public void leerArchivo (String nombreCompletoArchivo) {

        FileReader fr;    // Instanciamos la clase de java que nos permite leer un archivo.

        try {
            fr = new FileReader(nombreCompletoArchivo);

            BufferedReader br = new BufferedReader(fr);    // Clase de java que nos permite almacenar en el búffer las lineas.

            String lineaActual = br.readLine();

            while (lineaActual != null) {     // Recorremos el archivo hasta el final.

                System.out.println(lineaActual);    // Imprimimos la linea en pantalla (opcional).

                lineaActual = br.readLine();     // Almacenamos la linea en el búffer.
            }
            br.close();
        }
        catch (FileNotFoundException e) {     // ErrorHandler - archivo no encontrado.
            System.out.println("Error al leer el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        }
        catch (IOException e) {     // ErrorHandler - error de In/Out.
            System.out.println("Error al leer el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        }
        System.out.println("Archivo leido satisfactoriamente.");    // Confirmación de lectura exítosa.
    }


    /*
    Método para escribir en un archivo.

    Recibe: ruta y nombre del archivo, vector String conteniendo las lineas para almacenar en el archivo.
    */
    public void escribirArchivo (String nombreCompletoArchivo, String[] listaLineasArchivo) {

        FileWriter fw;    // Instanciamos la clase de java que nos permite escribir un archivo.

        try {
            fw = new FileWriter(nombreCompletoArchivo, true);    // Parámetros: true agrega al final del archivo, false borra lo anterior.
            
            BufferedWriter bw = new BufferedWriter(fw);    // Clase que nos permite almacenar en el búffer las lineas.

            for (int i = 0; i < listaLineasArchivo.length; i++) {    // Recorremos el string[] hasta el final.

                String lineaActual = listaLineasArchivo[i];    // Tomamos una linea.
                bw.write(lineaActual);    // Escribimos la línea en el archivo.
                bw.newLine();    // Insertamos una nueva línea.
            }
            bw.close();
            fw.close();
        }
        catch (IOException e) {    // ErrorHandler - error de I/O.
            System.out.println("Error al escribir el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        }
    }
}
