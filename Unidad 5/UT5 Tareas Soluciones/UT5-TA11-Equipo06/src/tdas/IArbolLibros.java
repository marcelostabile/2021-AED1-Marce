package tdas;
import clases.*;
public interface IArbolLibros {
    /*
   * Devuelve el libro correspondiente a ese ISBN
   */ 
    public Libro buscarLibro(String elISBN);

    /*
    * Devuelve la lista de los autores de ese libro
    */
    public Lista<Autor> autoresDelLibro(String elISBN);

    /*
    * Devuelve un array de strings
    * cada elemento del array contiene el ISBN y el nombre del libro, separados por una coma
    * luego del nombre del libro van dos puntos y luego los autores del libro separados por una coma
    */
    public String[] librosConAutores();

    
}
