package TA3;

import java.io.*;
import java.util.ArrayList;

public class ContadorPalabras {

    /*
    Clase que cuenta las palabras de una frase.
    Para ser considerada, una palabra debe contener al menos un cáracter alfanumérico.
    Las palabras se separan por uno o más espacios.
    */

    public int contarPalabras (String frase) { 

        char caracter;
        int cuentaPalabras = 0;
        boolean buscarPalabraNueva = true;

        for (int i = 0; i <= frase.length()-1; i++) {    // Recorremos la cadena letra a letra.

            caracter = frase.charAt(i);    // Toma una letra con tipo char.

            if (Character.isDigit(caracter) || Character.isLetter(caracter)) {    // Evaluamos que sea letra o número, descartando espacios.

                if (buscarPalabraNueva == true) cuentaPalabras++;    // Evaluamos que estemos buscando una nueva palabra.

                buscarPalabraNueva = false;
            } else {    
                buscarPalabraNueva = true;    // Es un espacio.
            }
        }
        return cuentaPalabras;    // Retornamos el total de palabras.
    }


    public int[] contarPalabrasVocalesConsonantesLargas (String frase) {

        char caracter;
        int[] cuentaPalabrasVocalesConsonantesLargas = new int[4];
        int cuentaLargoPalabra = 0;
        int largoPalabraMax = 5;
        boolean buscarPalabraNueva = true;

        for (int i = 0; i <= frase.length()-1; i++) {    // Recorremos la cadena letra a letra.

            caracter = frase.charAt(i);    // Toma una letra con tipo char.

            if (Character.isDigit(caracter) || Character.isLetter(caracter)) {    // Evaluamos que sea letra o número, descartando espacios.

                if (buscarPalabraNueva == true) {
                    
                    cuentaPalabrasVocalesConsonantesLargas[0]++;    // Evaluamos que estemos buscando una nueva palabra.
                    cuentaLargoPalabra = 1;    // Iniciamos la cuenta de caracteres para esta palabra.
                } else {
                    cuentaLargoPalabra++;    // Es parte de la palabra, agrego uno a la cuenta.
                }

                buscarPalabraNueva = false;

                if (Character.isLetter(caracter)) {    // Si es una letra, sumamos vocal o consonante según corresponda.

                    if (esVocal(caracter)) {

                        cuentaPalabrasVocalesConsonantesLargas[1]++;    // vocal.
                    } else {
                        cuentaPalabrasVocalesConsonantesLargas[2]++;    // consonante.
                    }
                }
            } else {    // Es un espacio.
                buscarPalabraNueva = true;
            }

            if ((i == frase.length()-1) || (buscarPalabraNueva)) {

                if (cuentaLargoPalabra >= largoPalabraMax) cuentaPalabrasVocalesConsonantesLargas[3]++;
            }
        }
        return cuentaPalabrasVocalesConsonantesLargas;    // Retornamos el total de palabras.
    }


    private boolean esVocal (char letra) {

        if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u' || 
            letra == 'á' || letra == 'é' || letra == 'í' || letra == 'ó' || letra == 'ú' ||
            letra == 'ä' || letra == 'ë' || letra == 'ï' || letra == 'ö' || letra == 'ü') {    // Evaluamos si es una vocal.
            return true;    // vocal.
        } else {
            return false;    // consonante.
        }
    }


    public String[] obtenerLineas (String archivo) {

        /*
        Parte 1: descripción con lenguaje natural.

        El método recibe un string indicando la ruta y nombre del archivo.
        Inicializamos un ArrayList "lineasArchivo" donde almacenaremos las líneas leídas del archivo.
        Decido utilizar un ArrayList porque desconozco el largo del archivo.
        Para la lectura del archivo empleamos las clases de Java: FileReader y BufferedReader del paquete java.io.*
        FileReader nos permite acceder al archivo para su lectura y BufferedReader lo utilizamos para leer línea a línea.
        Empleamos un bucle while para recorrer todo el archivo línea a línea hasta el final.
        Para cada línea leída, agregamos a nuestro ArrayList un registro.
        Dentro del while también empleamos un contador incremental "posicion" que nos permitirá devolver en pantalla la cantidad de líneas leídas.
        Una vez finalizada la lectura, imprimimos en pantalla la cantidad de líneas del archivo.
        Necesitamos instanciar un vector String "lineas" y volcar nuestro ArrayList en este, para luego retornar el vector, cumpliendo con los requerimientos solicitados.
        */    

        ArrayList<String> lineasArchivo = new ArrayList<>();    // Uso ArrayList porque no puedo usar String[] si desconozco el largo del archivo.
        int posicion = 0;
        FileReader fr;    // Instanciamos la clase de java que nos permite leer un archivo.
    
        try {
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);    // Clase de java que nos permite almacenar en el búffer las lineas.
            String lineaActual = br.readLine();

            while (lineaActual != null) {     // Recorremos el archivo hasta el final.

                lineaActual = br.readLine();
                lineasArchivo.add(lineaActual);     // Almacenamos la linea en la lista.
                posicion++;
            }

            br.close();
        }
        catch (FileNotFoundException e) {     // ErrorHandler - archivo no encontrado.
            System.out.println("Error al leer el archivo " + archivo);
            e.printStackTrace();
        }
        catch (IOException e) {     // ErrorHandler - error de In/Out.
            System.out.println("Error al leer el archivo " + archivo);
            e.printStackTrace();
        }

        System.out.println("Archivo leido satisfactoriamente.");    // Confirmación de lectura exítosa.

        System.out.println("Se leyeron " + (posicion) + " líneas en el archivo.");

        String[] lineas = lineasArchivo.toArray(new String[0]);

        return lineas;
    }


    public int cantPalabras (String[] lineasArchivo) {

        /*
        Parte 1: descripción con lenguaje natural.

        El método recibe un array de String conteniendo las lineas de un archivo leido.
        Es posible utilizar el método "String[] obtenerLineas (String archivo)" para generar este archivo.
        Se inicializa la variable que cuenta las palabras.
        Empleamos una sentencia condicional for para recorrer el archivo registro a registro hasta el final.
        Para cada registro, correspondiente a una linea del archivo, empleamos el método contarPalabras(lineasArchivo) 
        para contar las palabras de una frase y acumulamos el resultado en la variable cantPalabras.
        Una vez finalizado el for, retornamos la variable cantPalabras.
        */

        int cantPalabras =  0;

        for (int i = 0; i < lineasArchivo.length-1; i++) {
            
            cantPalabras += contarPalabras(lineasArchivo[i]);
        }
        return cantPalabras;
    }
}
