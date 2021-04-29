package implementacionesParcial;

import tdas.*;

public class ListaOrdenada<T> extends Lista<T> {

    public void insertar(INodo<T> nodo) {
        
        // Validamos que el nodo no sea nulo
        if (nodo != null) {
            
            //INodo<T> primero = this.getPrimero();

            // Lista está vacía, lo insertamos primero.
            if (this.primero == null) { 
                nodo.setSiguiente(null);
                this.primero = nodo;
            } else {
                // Recorremos la lista para insertarlo ordenado.
                INodo<T> nodoActual;
                INodo<T> nodoSiguiente;

                nodoActual = this.primero;
                nodoSiguiente = nodoActual.getSiguiente();

                // Caso: primero es mayor, lo agregamos primero y el primero anterior queda siguiente.
                if (this.primero.getEtiqueta().compareTo(nodo.getEtiqueta()) > 0) { 
                    nodo.setSiguiente(this.primero);
                    this.primero = nodo;
                }

                // Recorremos la lista hasta encontrar su lugar.
                while (nodoSiguiente != null && nodoSiguiente.getEtiqueta().compareTo(nodo.getEtiqueta()) < 0){
                    nodoActual = nodoActual.getSiguiente();
                    nodoSiguiente = nodoActual.getSiguiente();
                }
                nodoActual.setSiguiente(nodo);
                nodo.setSiguiente(nodoSiguiente);
            }

        }
    }
    
}
