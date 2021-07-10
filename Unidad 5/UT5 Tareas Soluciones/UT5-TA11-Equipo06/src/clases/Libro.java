package clases;
import tdas.*;
public class Libro {
    private final String ISBN;
    private final String titulo;
    private final Lista<Autor> autores;
    
    
    public Libro (String elISBN, String elNombre) {
        this.ISBN = elISBN;
        this.titulo = elNombre;
        
        this.autores  = new Lista<>();
        
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitulo() {
        return titulo;
    }


    public  Lista<Autor> getAutores(){
        return autores;
    }
    
    public void agregarAutor(Autor elAutor) {
        autores.insertar(new Nodo<Autor>(elAutor.getNombre(), elAutor));
    }
    
    
    public String imprimir(){
        return (ISBN  + " - "+ this.titulo);
    }


}
