package tdas2;

import tdas.*;

public interface IPila<T> {

    /**
     * Top: lo consideramos el primer elemento de la pila.
    */
    
    /**
     * Apilar - push.
     * @param nodo
    */
    public void apilar_push(Nodo<T> nodo);

    /**
     * Desapilar - pop.
     * @return nodo desapilado, nulo si la pila está vacía.
     */
    public Nodo<T> desapilar_pop();
   
    /**
     * Verifica si la pila está vacía.
     * @return boolean.
     */
    public boolean estaVacia();

    /**
     * Top.
     * @return nodo
     */
    public Nodo<T> getTop();

    /**
     * Retorna un string con las etiquetas de los nodos de la lista.
     * Se incluye un separador entre los valores obtenidos.
     * @return cadena obtenida.
     */
    public String imprimir(String separador);

}
