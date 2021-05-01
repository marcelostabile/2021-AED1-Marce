package almacen;

import tdas.*;

public class Almacen implements IAlmacen {

    // Lista desordenada.
    public ILista<Integer> listaDesordenada;

    // Lista ordenada: impares de menor a mayor, pares de menor a mayor.
    public ILista<Integer> listaOrdenada;

    public Almacen() {
        this.listaDesordenada = new Lista<>();
        this.listaOrdenada = new Lista<>();
    }

    public ILista<Integer> getListaDesordenada() {
        return listaDesordenada;
    }

    public void setListaDesordenada(ILista<Integer> listaDesordenada) {
        this.listaDesordenada = listaDesordenada;
    }

    public ILista<Integer> getListaOrdenada() {
        return listaOrdenada;
    }

    public void setListaOrdenada(ILista<Integer> listaOrdenada) {
        this.listaOrdenada = listaOrdenada;
    }

    /**
     * Insertar elementos en la lista desordenada.
     */
    public void insertarArticuloUltimo(INodo<Integer> nodo) {
        this.listaDesordenada.insertarUltimo(nodo);
    }
    /**
     * Método para ordenar la lista desordenada.
     *
     * Creamos la lista ordenada final.
     * Recorro la lista desordenada elemento por elemento.
     * Para cada nodo verifico si la etiqueta es par o impar.
     * Si es impar, lo inserto ordenado en la lista ordenada final.
     * Los pares los inserto en una segunda lista auxiliar.
     * Cuando finalizo el recorrido, inserto todos los elementos de la lista pares al final de lista final.
    */
    public ILista<Integer> ordenaParesImpares() {

        // Lista auxiliar para pares.
        ILista<Integer> listaAuxiliar = new Lista<>();
        
        // Si la lista origen está vacía, retorno la lista ordenada vacía.
        if (listaDesordenada.esVacia()) { return listaOrdenada; }

        // Recorro la lista desordenada y voy clasificando los elementos en pares e impares.
        INodo<Integer> actual = this.listaDesordenada.getPrimero();
        while (actual != null) {
            Comparable etiqueta = actual.getEtiqueta();
            if ( Almacen.esPar(Integer.parseInt(etiqueta.toString())) ) {
                listaAuxiliar.insertarNodoOrdenado(new Nodo<Integer>(etiqueta, actual.getDato()));
            } else {
                this.listaOrdenada.insertarNodoOrdenado(new Nodo<Integer>(etiqueta, actual.getDato()));
            }
            actual = actual.getSiguiente();
        }

        // Paso todos los elementos, que son los pares, al final de la lista resultado.
        // Tengo que insertar último para evitar intercalar los pares e impares.
        INodo<Integer> nodoAux = listaAuxiliar.getPrimero();
        while (nodoAux != null) {
            INodo<Integer> nodoCopia = nodoAux.clonar();
            this.listaOrdenada.insertarUltimo(nodoCopia);
            nodoAux = nodoAux.getSiguiente();
        }
        return this.listaOrdenada;
    }
    
    /**
     * Método para determinar si un número es par.
     */
    public static boolean esPar (int numero) {
        if (numero % 2 == 0) return true; else return false;
    }
    
}