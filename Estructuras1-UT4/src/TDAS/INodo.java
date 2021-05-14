package TDAS;

public interface INodo<T> {

    /**
     * Devuelve el dato del nodo.
     * Este método es de Orden constante : O(1)
     * @return dato
    */
    public T getDato();

    /**
     * Establece el dato en el nodo.
     * Este método es de Orden constante : O(1)
     * @param 
    */
    public void setDato(T dato);

    /**
     * Devuelve la etiqueta del nodo.
     * Este método es de Orden constante : O(1)
     * @return etiqueta
    */
    public Comparable getEtiqueta();

    /**
     * Devuelve el siguiente del nodo.
     * Este método es de Orden constante : O(1)
     * @return nodo siguiente.
    */
    public INodo<T> getSiguiente();
    
    /**
     * Establece el siguiente del nodo.
     * Este método es de Orden constante : O(1)
     * @param nodo siguiente
    */
    public void setSiguiente(INodo<T> nodo);

    /**
     * Compara la etiqueta del nodo con otra.
     * Este método es de Orden constante : O(1)
     * @param 
     * @return entero 
    */
    public int compareTo(Comparable etiqueta);

    /**
     * Imprimir el dato del nodo.
     * Este método es de Orden constante : O(1)
    */
    public void imprimir();

    /**
     * Imprimir la etiqueta del nodo.
     * Este método es de Orden constante : O(1)
    */
    public void imprimirEtiqueta();

    /**
     * Clona el nodo y devuelve la copia.
     * Este método es de Orden constante : O(1)
     * @return nodo clonado
    */
    public Nodo<T> clonar();

    /**
     * Verifica si los datos son iguales y devuelve un boolean.
     * Este método es de Orden constante : O(1)
     * @param 
     * @return boolean
    */
    public boolean equals(Nodo<T> unNodo);

}
