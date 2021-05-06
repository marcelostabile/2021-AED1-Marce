package tdas;

public class Cola<T> extends Lista<T> implements ICola<T> {

    /**
     * Cabeza: lo consideramos el primer elemento de la cola.
    */

    /**
     * Método: agregar - add.
     * @param nodo
    */
    public void agregar_add(INodo<T> nodo) {
        this.insertarUltimo(nodo);
    }

    /**
     * Método: quitar- remover.
     * @return nodo removido, nulo si la cola está vacía.
     */
    public INodo<T> quitar_remove() {
        if (!this.esVacia()) {
            INodo<T> nodo = this.getPrimero();
            this.eliminar(this.getPrimero().getEtiqueta());
            return nodo;
        } else {
            return null;    // Pila vacía.
        }
    }

    /**
     * Método: verifica si la cola está vacía.
     * @return boolean.
     */
    public boolean estaVacia() {
        return this.esVacia();
    }

    /**
     * Método: obtener cabeza.
     * @return nodo
     */
    public INodo<T> getCabeza() {
        return this.getPrimero();
    }

}