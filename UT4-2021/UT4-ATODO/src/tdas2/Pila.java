package tdas2;
import tdas.*;

public class Pila<T> extends Lista<T> implements IPila<T> {

    /**
     * Top: lo consideramos el primer elemento de la pila.
    */
    
    /**
     * Apilar - push.
     * @param nodo
    */
    public void apilar_push(Nodo<T> nodo) {
        this.insertarPrimero(nodo);
    }

    /**
     * Desapilar - pop.
     * @return nodo desapilado, nulo si la pila está vacía.
     */
    public Nodo<T> desapilar_pop() {
        if (!this.esVacia()) {
            Nodo<T> nodo = this.getPrimero();
            this.eliminar(this.getPrimero().getEtiqueta());
            return nodo;
        } else {
            return null;    // Pila vacía.
        }
    }
    
    /**
     * Verifica si la pila está vacía.
     * @return boolean.
     */
    public boolean estaVacia() {
        return this.esVacia();
    }

    /**
     * Top.
     * @return nodo
     */
    public Nodo<T> getTop() {
        return this.getPrimero();
    }

    /**
     * Retorna un string con las etiquetas de los nodos de la lista.
     * Se incluye un separador entre los valores obtenidos.
     * @return cadena obtenida.
     */
    public String imprimir(String separador) {
        String resultado = "";
        if (!this.esVacia()) {
            Nodo<T> nodo = this.getPrimero();
            while (nodo != null) {
                resultado += nodo.getEtiqueta().toString();
                if (nodo.getSiguiente() != null) { resultado += separador; }
                nodo = nodo.getSiguiente();
            }
        }
        return resultado;
    }

}
