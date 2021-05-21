package implementacionesParcial;

import tdas.INodo;
import tdas.*;

/*
Implementación del TDA Conjunto para el ejercicio 1. 
*/
public class Conjunto<T> extends Lista<T>{

    /*
      Operación que retorna la diferencia simétrica entre el conjunto (this) y el parámetro otroConjunto.
    */
    public Conjunto<T> diferenciaSimetrica(Conjunto<T> otroConjunto) {

        Conjunto<T> conjuntoResultado = new Conjunto<T>();

        // Conjunto A
        INodo<T> actual = this.getPrimero();
        while (actual != null) {
            if (otroConjunto.buscar(actual.getEtiqueta()) == null) {
                conjuntoResultado.insertar(new Nodo<>(actual.getEtiqueta(), actual.getDato()));
            }
            actual = actual.getSiguiente();
        }

        // Conjunto B
        actual = otroConjunto.getPrimero();
        while (actual != null) {
            if ( (this.buscar(actual.getEtiqueta()) == null) && (conjuntoResultado.buscar(actual.getEtiqueta()) == null) ) {
                conjuntoResultado.insertar(new Nodo<>(actual.getEtiqueta(), actual.getDato()));
            }
            actual = actual.getSiguiente();
        }
        return conjuntoResultado;
    }

    /*
        Operación que inserta un elemento a un conjunto. 
    */
    @Override
    public void insertar(INodo<T> nodo) {
        // En este caso el insertar debe ser sin repetidos.
        if (this.buscar(nodo.getEtiqueta()) == null) {
            this.insertar(nodo);
        }
    }
    
}
