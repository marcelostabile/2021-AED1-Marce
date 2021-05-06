package almacen;

import tdas.*;

public interface IAlmacen {
    
    public ILista<Integer> ordenaParesImpares();

    public void insertarArticuloUltimo(INodo<Integer> nodo);

    public ILista<Integer> getListaDesordenada();

    public void setListaDesordenada(ILista<Integer> listaDesordenada);

    public ILista<Integer> getListaOrdenada();

    public void setListaOrdenada(ILista<Integer> listaOrdenada);

}
