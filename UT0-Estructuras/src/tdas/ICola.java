package tdas;

public interface ICola<T> {

    /**
     * Cabeza: lo consideramos el primer elemento de la cola.
    */

    /**
     * Método: agregar - add.
     * @param nodo
    */
    public void agregar_add(INodo<T> nodo);

    /**
     * Método: quitar- remover.
     * @return nodo removido, nulo si la cola está vacía.
     */
    public INodo<T> quitar_remove();

    /**
     * Método: verifica si la cola está vacía.
     * @return boolean.
     */
    public boolean estaVacia();

    /**
     * Método: obtener cabeza.
     * @return nodo
     */
    public INodo<T> getCabeza();

    /**
     * Extienden de Lista.
     */

    /**
     * Imprime en consola las etiquetas de los nodos de la lista.
     * Se incluye un separador entre los valores obtenidos.
     * Este método es orden lineal : O(N)
     * @return cadena obtenida.
     */
    public String imprimir(String separador);

}
