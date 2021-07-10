package com.ucudal.ta11;

import com.ucudal.tdas.Lista;

public class TArbolLibros extends TArbolBB<Libro>  implements IArbolLibros {

    @Override
    public Libro buscarLibro(String elISBN) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Lista<Autor> autoresDelLibro(String elISBN) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[] librosConAutores() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

  
  
  
}
