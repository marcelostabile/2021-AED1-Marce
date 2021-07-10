package com.ucudal.ta11;

import com.ucudal.tdas.Lista;

public interface IArbolAutores {

    /*
     * Devuelve la lista de libros de ese autor
    */
    public Lista<Libro> listarTitulos(String elAutor);


    public Lista<Autor> todosLosCoautores(String elAutor);
}
