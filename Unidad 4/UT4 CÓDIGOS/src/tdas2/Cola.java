package tdas2;
import tdas.*;

public class Cola<T> extends Lista<T> implements ICola<T> {

    // Cabeza: el primer elemento de la cola.

    /**
     * Agregar - add
     * @param nodo
    */
    public void agregar_add(Nodo<T> nodo) {
        this.insertar(nodo);
    }

    /**
     * Quitar - remove
     * @return nodo removido, nulo si la cola está vacía.
     */
    public Nodo<T> quitar_remove() {
        if (!this.esVacia()) {
            Nodo<T> nodo = this.getPrimero();
            this.eliminar(this.getPrimero().getEtiqueta());
            return nodo;
        } else {
            return null;    // Pila vacía.
        }
    }

    /**
     * Verifica si la cola está vacía.
     * @return boolean.
     */
    public boolean estaVacia() {
        return this.esVacia();
    }

    /**
     * Obtener cabeza.
     * @return nodo
     */
    public Nodo<T> getCabeza() {
        return this.getPrimero();
    }

    /**
     * Retorna un string con las etiquetas de los nodos de la lista.
     * Se separan de acuerdo al separador ingresado.
     * @return cadena obtenida.
     */
    public String imprimir(String separador) {
        String resultado = "";
        if (!this.esVacia()) {
            Nodo<T> nodo = this.getCabeza();
            while (nodo != null) {
                resultado += nodo.getEtiqueta().toString();
                if (nodo.getSiguiente() != null) { resultado += separador; }
                nodo = nodo.getSiguiente();
            }
        }
        return resultado;
    }
    
}