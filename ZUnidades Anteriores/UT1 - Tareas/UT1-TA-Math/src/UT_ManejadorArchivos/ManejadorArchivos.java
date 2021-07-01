package UT_ManejadorArchivos;
/* 
* MANEJADOR DE ARCHIVOS - Marcelo Stabile
*/
import java.io.*;

/*
* Clase para lectura y escritura de archivos.
*/
public class ManejadorArchivos {



    /*
    * Método para leer un archivo.
    */
    public void leerArchivo (String nombreCompletoArchivo) {

        FileReader fr;
        try {
            fr = new FileReader(nombreCompletoArchivo);
            BufferedReader br = new BufferedReader(fr);

            String lineaActual = br.readLine();
            while (lineaActual != null) {

                /* Acciones */
                System.out.println(lineaActual);
                lineaActual = br.readLine();
            }
            br.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Error al leer el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        }
        System.out.println("Archivo leido satisfactoriamente.");
    }



    /*
    * Método para escribir en un archivo.
    */
    public void escribirArchivo (String nombreCompletoArchivo, String[] listaLineasArchivo) {

        FileWriter fw;
        try {
            fw = new FileWriter(nombreCompletoArchivo, true);       // true: agrega al final del archivo, false: borra lo anterior.
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < listaLineasArchivo.length; i++) {
                String lineaActual = listaLineasArchivo[i];
                bw.write(lineaActual);
                bw.newLine();
            }
        bw.close();
        fw.close();
        }
        catch (IOException e) {
            System.out.println("Error al escribir el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        }
    }
}
