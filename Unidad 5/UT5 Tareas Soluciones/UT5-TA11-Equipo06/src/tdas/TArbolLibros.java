package tdas;
import java.sql.Array;
import java.util.ArrayList;

import clases.*;
public class TArbolLibros extends TArbolBB<Libro>  implements IArbolLibros {

    @Override
    public Libro buscarLibro(String elISBN) {
        if(esVacio()){
            return null;
        }
        TElementoAB<Libro> libro = this.buscar(elISBN);
        if(libro != null){
            return libro.getDatos();
        }
        return null;
    }

    @Override
    public Lista<Autor> autoresDelLibro(String elISBN) {
        if(esVacio()){
            return null;
        }
        TElementoAB<Libro> libro = this.buscar(elISBN);
        if(libro != null){
            return libro.getDatos().getAutores();
        }
        return null;
    }

    @Override
    public String[] librosConAutores() {
        Lista<Libro> libros = this.inOrden();
        Nodo<Libro> libro = libros.getPrimero();
        ArrayList<String> libConAut = new ArrayList<>();
        while(libro != null){
            try{
                libConAut.add(libro.getDato().getTitulo() +":"+ autoresDelLibro(libro.getDato().getISBN()).imprimir("-"));
            }catch(NullPointerException e){
                System.out.println(libro.getEtiqueta() + "No tiene autores");
            }
            libro = libro.getSiguiente();
        }
        return libConAut.toArray(new String[0]);
    }

}
