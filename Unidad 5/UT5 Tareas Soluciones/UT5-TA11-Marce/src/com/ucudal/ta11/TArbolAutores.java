package com.ucudal.ta11;

import com.ucudal.tdas.Lista;

public class TArbolAutores extends TArbolBB<Autor> implements IArbolAutores {

    @Override
    public Lista<Libro> listarTitulos(String elAutor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Lista<Autor> todosLosCoautores(String elAutor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
