package tdas;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import clases.*;
public class TArbolAutores extends TArbolBB<Autor> implements IArbolAutores {

    @Override
    public Lista<Libro> listarTitulos(String elAutor) {
        if(esVacio()){
            return null;
        }
        TElementoAB<Autor> elem = this.buscar(elAutor);
        if(elem != null){
            return elem.getDatos().getLibros();
        }
        return null;
    }   


}
