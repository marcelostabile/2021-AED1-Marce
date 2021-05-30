package implementacionesParcial;

import tdas.*;

public class ListaOrdenada<T> extends Lista<T> {

    public void insertar(INodo<T> nodo) {
        
        // Validamos que el nodo ingresado no sea nulo.
        if (nodo != null) {

            // Lista está vacía, lo insertamos primero.
            if (super.primero == null) { 
                nodo.setSiguiente(null);
                super.primero = nodo;
            
            } else {
                // Recorremos la lista para insertarlo ordenado.
                INodo<T> nodoActual;
                INodo<T> nodoSiguiente;

                nodoActual = super.primero;
                nodoSiguiente = nodoActual.getSiguiente();

                // Caso: primero es mayor, lo agregamos primero y el primero anterior queda siguiente.
                if (nodoActual.getEtiqueta().compareTo(nodo.getEtiqueta()) > 0) { 
                    nodo.setSiguiente(super.primero);
                    super.primero = nodo;                
                } else {

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
    
}
