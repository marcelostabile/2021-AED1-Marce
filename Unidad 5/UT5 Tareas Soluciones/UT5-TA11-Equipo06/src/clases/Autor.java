package clases;
import tdas.*;
public class Autor {
    
    private String nombre;
    private Lista<Libro> libros;

    public Autor(String nombre) {
        this.nombre = nombre;
        this.libros  = new Lista<Libro>();
    }

    
    public String getNombre() {
        return nombre;
    }

    public  Lista<Libro> getLibros() {
        return libros;
    }

    public void agregarLibro(Libro elLibro) {
        libros.insertar(new Nodo<Libro>(elLibro.getISBN(), elLibro));
    }
    
    

}
