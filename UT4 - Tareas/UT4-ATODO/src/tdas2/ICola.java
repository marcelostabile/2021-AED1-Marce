package tdas2;
import tdas.*;

public interface ICola<T> {

    // Cabeza: el primer elemento de la cola.

    /**
     * Agregar - add
     * @param nodo
    */
    public void agregar_add(Nodo<T> nodo);

    /**
     * Quitar - remove
     * @return nodo removido, nulo si la cola está vacía.
     */
    public Nodo<T> quitar_remove();

    /**
     * Verifica si la cola está vacía.
     * @return boolean.
     */
    public boolean estaVacia();

    /**
     * Obtener cabeza.
     * @return nodo
     */
    public Nodo<T> getCabeza();

    /**
     * Extienden de Lista.
     */

    /**
     * Retorna un string con las etiquetas de los nodos de la lista.
     * Se separan de acuerdo al separador ingresado.
     * @return cadena obtenida.
     */
    public String imprimir(String separador);

}
