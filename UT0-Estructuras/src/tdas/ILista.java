package tdas;

public interface ILista<T> {

    /**
     * Obtener el primer elemento de la lista.
     */
    public INodo<T> getPrimero();

    /**
     * Insertar primero.
     * @param nodo
     */
    public void insertarPrimero(INodo<T> nodo);

    /**
     * Metodo encargado de agregar un nodo al final de la lista.
     * @param nodo - Nodo a agregar
     */
    public void insertarUltimo(INodo<T> nodo);

    /**
     * Insertar nodo ordenado.
     * @param clave
     * @return
     */
    public boolean insertarNodoOrdenado(INodo<T> nodo);

    /**
     * Metodo encargado de buscar un nodo cuya clave es la indicada.
     * @param clave - Clave del nodo a buscar.
     * @return El nodo encontrado. En caso de no encontrarlo, retornar null.
     */
    public INodo<T> buscar(Comparable clave);

    /**
     * Metodo encargado de eliminar un nodo cuya clave es la indicada.
     * @param clave Clave del nodo a eliminar.
     * @return True en caso de que la eliminaci�n haya sido efectuada con �xito.
     */
    public boolean eliminar(Comparable clave);

    /**
     * Retorna la cantidad de elementos de la lista. En caso de que la lista
     * este vacía, retornar 0.
     * @return Cantidad de elementos de la lista.
     */
    public int cantElementos();

    /**
     * Indica si la lista contiene o no elementos.
     * @return Si tiene elementos o no.
     */
    public boolean esVacia();

    /**
     * Vaciamos la lista estableciendo primero como null.
    public void vaciar();

    /**
     * Metodo encargado de imprimir en consola las etiquetas de los nodos
     * contenidos en la lista.
     * @return string
     */
    public String imprimir();

    /**
     * Metodo encargado de imprimir en consola las etiquetas de los nodos
     * contenidos en la lista, incluyendo un separador especifico.
     * @return string
     */
    public String imprimir(String separador);

    /**
     * Metodo encargado de imprimir en consola los datos de los nodos
     * contenidos en la lista.
     * @return string
     */
    public String imprimirDatos();

    /**
     * Metodo encargado de imprimir en consola los datos de los nodos
     * contenidos en la lista, incluyendo un separador especifico.
     * @return string
     */
    public String imprimirDatos(String separador);

}