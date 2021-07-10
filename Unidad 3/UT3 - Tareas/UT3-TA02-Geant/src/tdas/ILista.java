package tdas;

public interface ILista<T> {

    /**
     * Obtener el primer elemento de la lista.
     * Este método es de orden constante : O(1)
     * @return nodo primero
    */
    public INodo<T> getPrimero();

    /**
     * Insertar el nuevo elemento en lugar del primero de la lista.
     * Este método es de orden constante : O(1)
     * @param nodo nuevo
    */
    public void insertarPrimero(INodo<T> nodo);

    /**
     * Insertar el nuevo elemento al final de la lista.
     * Este método es de orden lineal : O(N)
     * @param nodo nuevo
     */
    public void insertarUltimo(INodo<T> nodo);

    /**
     * Insertar el nuevo elemento de manera ordenada en la lista.
     * Este método es de orden lineal : O(N)
     * @param nodo nuevo
     * @return boolean
     */
    public boolean insertarNodoOrdenado(INodo<T> nodo);

    /**
     * Búsqueda de un nodo por su clave.
     * Este método buscar es de orden lineal : O(N)
     * @param clave (etiqueta).
     * @return nodo encontrado, si no encuentra retorna null.
     */
    public INodo<T> buscar(Comparable clave);

    /**
     * Elimina un nodo de acuerdo a la clave ingresada.
     * Este método eliminar es de orden lineal : O(N)
     * @param clave (etiqueta)
     * @return boolean. 
     */
    public boolean eliminar(Comparable clave);

    /**
     * Retorna la cantidad de elementos de la lista.
     * Si está vacía retorna cero.
     * Este método es orden lineal : O(N)
     * @return cantidad de elementos, si está vacía retorna cero.
    */
    public int cantElementos();

    /**
     * Indica si la lista contiene o no elementos.
     * Este método estaVacia es orden constante : O(1)
     * @return boolean.
     */
    public boolean esVacia();

    /**
     * Vaciamos la lista, establecemos primero como null.
     * Este método estaVacia es orden constante : O(1)
     */
    public void vaciar();

    /**
     * Imprime en consola las etiquetas de los nodos de la lista.
     * Este método es orden lineal : O(N)
     * @return cadena obtenida.
     */
    public String imprimir();

    /**
     * Imprime en consola las etiquetas de los nodos de la lista.
     * Se incluye un separador entre los valores obtenidos.
     * Este método es orden lineal : O(N)
     * @return cadena obtenida.
     */
    public String imprimir(String separador);

    /**
     * Imprime en consola los datos de los nodos de la lista.
     * Este método es orden lineal : O(N)
     * @return cadena obtenida.
     */
    public String imprimirDatos();

    /**
     * Imprime en consola los datos de los nodos de la lista.
     * Se incluye un separador entre los valores obtenidos.
     * Este método es orden lineal : O(N)
     * @return cadena obtenida.
     */
    public String imprimirDatos(String separador);

}