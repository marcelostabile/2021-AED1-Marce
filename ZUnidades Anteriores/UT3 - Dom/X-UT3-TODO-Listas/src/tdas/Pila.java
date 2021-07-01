package tdas;

public class Pila<T> extends Lista<T> implements IPila<T> {

    /**
     * Top: lo consideramos el primer elemento de la pila.
    */
    
    /**
     * Método: apilar - push.
     * @param nodo
    */
    public void apilar_push(INodo<T> nodo) {
        this.insertarPrimero(nodo);
    }

    /**
     * Método: desapilar - pop.
     * @return nodo desapilado, nulo si la pila está vacía.
     */
    public INodo<T> desapilar_pop() {
        if (!this.esVacia()) {
            INodo<T> nodo = this.getPrimero();
            this.eliminar(this.getPrimero().getEtiqueta());
            return nodo;
        } else {
            return null;    // Pila vacía.
        }
    }
    
    /**
     * Método: verifica si la pila está vacía.
     * @return boolean.
     */
    public boolean estaVacia() {
        return this.esVacia();
    }

    /**
     * Método: Top.
     * @return nodo
     */
    public INodo<T> getTop() {
        return this.getPrimero();
    }

}
