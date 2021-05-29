package tdas;

public interface IPila<T> {

    /* Método: apilar - push.
     * @param nodo
    */
    public void apilar_push(INodo<T> nodo);

    /**
     * Método: desapilar - pop.
     * @return nodo desapilado, nulo si la pila está vacía.
    */
    public INodo<T> desapilar_pop();
   
    /**
     * Método: verifica si la pila está vacía.
     * @return boolean.
    */
    public boolean estaVacia();

    /**
     * Método: Top.
     * @return nodo
     */
    public INodo<T> getTop();

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
