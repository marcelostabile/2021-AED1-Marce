package com.ucudal;

import com.ucudal.ta11.*;
import com.ucudal.tdas.Lista;
import com.ucudal.tdas.Nodo;
import com.ucudal.utils.ManejadorArchivosGenerico;

public class Ppal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        /* Crear el arbol de libros, el arbol inicial de autores y el arbol que sera el optimo
        */
        TArbolLibros libreria = new TArbolLibros(); //arbol en donde van a estar todos los libros por isbn
        TArbolBB<Autor> autoresBase = new TArbolBB(); // cargamos todos los autores aca para luego calcular las frecuencias
        TArbolAutores autoresOptimo = new TArbolAutores(); // este va a ser el optimo
        
        /* Cargar los libros en la libreria a partir del archivo "libros.txt” Cada línea tiene ISBN y titulo
         * Cargar los autores a partir  del archivo "autoresLibreria-Libros.txt” 
         * Cada línea tiene nombre de autor e ISBN de libro. 
         * A cada autor asociar sus libros. A cada libro asociar sus autores.
        */
        cargarDatos(libreria, autoresBase);
        
        /*Utilizando el archivo "busquedasGlobalesAutores", calcular las frecuencias de búsquedas exitosas y no exitosas 
        */
        cargarFrecuencias(autoresBase);
        
        /* Crear los vectores necesarios, cargarle los datos calculados en el arbol base inicial
         * Calcular los valores de las matrices a partir de los vestores de datos
         * Armar el árbol de busqueda óptimo para los autores
        */
        armarABO(autoresBase, autoresOptimo);
        
        /* dado un autor, emitir una lista con los títulos de sus libros 
         * y generar un archivo de salida "autor-libros.txt"
        */
        String elAutor = "Bill Bryson";
        Lista<Libro> librosDelAutor = autoresOptimo.listarTitulos(elAutor);
        salidaLibrosDelAutor(librosDelAutor, elAutor);
        
        /* dado un ISBN de libro, emitir una lista con los nombres de sus autores 
         * y generar un archivo de salida "libros-autor.txt"
         */
        String idLibro = "140449175";
        Lista<Autor> autoresLibro = libreria.autoresDelLibro(idLibro);
        salidaAutoresDelLibro(autoresLibro, idLibro);
        
         /* listar todos libros ordenados por ISBN, con t[itulo y todos los coautores de cada libro 
         * y generar un archivo de salida "salida-todosLosLibros.txt"
         */
        String[] todosLosLibros = libreria.librosConAutores();
        ManejadorArchivosGenerico.escribirArchivo("src/salida-todosLosLibros.txt",todosLosLibros);

        Lista<Autor> coautoresDeTodosLosLibrosDe = autoresOptimo.todosLosCoautores(elAutor);
        salidaTodosLosCoautores(coautoresDeTodosLosLibrosDe, elAutor);
     
        
    } // Fin del metodo "main"

    // comienzan los metodos estaticos auxiliars del main
    
    public static void cargarDatos(TArbolLibros libreria, TArbolBB<Autor> autores) {
        /*
         * Crear los libros  y cargarlos en la libreria a partir
         * del archivo "libros.txt” Cada línea tiene ISBN y titulo
         */
        

        /*
         * Crear los autores y cargarlos en la lista de autores a partir
         * del archivo "autores.txt” Cada línea tiene nombre de autor e ISBN de libro
         */
        
    } // Fin del metodo cargarDatos

    public static void cargarFrecuencias(TArbolBB<Autor> autoresBase) {
        
        
    } //Fin del metodo cargarFrecuencias
    
    public static void armarABO(TArbolBB autoresBase, TArbolAutores losAutores){
       
    }//fin del metodo armarABO
    
    public static void salidaLibrosDelAutor(Lista<Libro> librosDelAutor, String elAutor) {
       
    }// fin del metodo de generar la salida de los libros por autor
    
    public static void salidaAutoresDelLibro(Lista<Autor> losAutores, String idLibro){
        
    }// fin del metodo de generar la salida de los autores de un libro

    public static void salidaTodosLosCoautores(Lista<Autor> autores, String autor){

    }// fin del metodo de generar la salida de los coautores

} //fin de la clase main

