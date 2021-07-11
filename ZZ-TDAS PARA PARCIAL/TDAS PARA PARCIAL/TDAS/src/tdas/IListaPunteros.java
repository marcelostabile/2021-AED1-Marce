package tdas;

public interface IListaPunteros<T> extends ILista<T> {

    public INodo<T> getPrimero();    
    public INodo<T> getUltimo(); 
    
    /**
     * Metodo encargado de agregar un nodo al final de la lista.
     *
     * @param nodo - Nodo a agregar
     */
    public void insertarPrimero(INodo<T> nodo);

}
