package tdas;

public class Nodo<T> implements INodo<T> {

    private final Comparable etiqueta;
    private T dato;
    private INodo<T> siguiente = null;

    /**
     * El constructor Nodo es de Orden constante : O(1)
    */
    public Nodo(Comparable etiqueta, T dato ) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    /**
     * Devuelve el dato del nodo.
     * Este método es de Orden constante : O(1)
     * @return dato
    */
    public T getDato() {
        return this.dato;
    }

    /**
     * Establece el dato en el nodo.
     * Este método es de Orden constante : O(1)
     * @param 
    */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * Devuelve la etiqueta del nodo.
     * Este método es de Orden constante : O(1)
     * @return etiqueta
    */
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    /**
     * Devuelve el siguiente del nodo.
     * Este método es de Orden constante : O(1)
     * @return nodo siguiente.
    */
    public INodo<T> getSiguiente() {
        return this.siguiente;
    }

    /**
     * Establece el siguiente del nodo.
     * Este método es de Orden constante : O(1)
     * @param nodo siguiente
    */
    public void setSiguiente(INodo<T> nodo) {
        this.siguiente = nodo;
    }

    /**
     * Compara la etiqueta del nodo con otra.
     * Este método es de Orden constante : O(1)
     * @param 
     * @return entero 
    */
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }

    /**
     * Imprimir el dato del nodo.
     * Este método es de Orden constante : O(1)
    */
    public void imprimir() {
        System.out.println(dato.toString());
    }

    /**
     * Imprimir la etiqueta del nodo.
     * Este método es de Orden constante : O(1)
    */
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta.toString());
    }

    /**
     * Clona el nodo y devuelve la copia.
     * Este método es de Orden constante : O(1)
     * @return nodo clonado
    */
    public Nodo<T> clonar() {
        return new Nodo<>(this.etiqueta, this.dato);
    }

    /**
     * Verifica si los datos son iguales y devuelve un boolean.
     * Este método es de Orden constante : O(1)
     * @param 
     * @return boolean
    */
    public boolean equals(Nodo<T> unNodo) {
        return this.dato.equals(unNodo.getDato());
    }

}