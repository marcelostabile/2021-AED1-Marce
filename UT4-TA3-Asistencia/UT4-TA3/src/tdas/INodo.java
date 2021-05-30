package tdas;

public interface INodo<T> {

    /**
     * Retorna la etiqueta del nodo
     * @return etiqueta del nodo
     */
    public Comparable getEtiqueta();
    
    /**
     * devuelve el dato del nodo
     * @return 
     */
    public T getDato();
    
    /**
     * Retorna el nodo siguiente.
     * @return un nodo T.
     */
    public Nodo<T> getSiguiente();
    
    public void setDato(T dato);

    /**
     * Imprime la etiqueta del nodo
     */
    public void imprimirEtiqueta();

    /**
     * Imprime los datos del nodo
     */
    public void imprimir();

    public void setSiguiente(Nodo<T> nodo);

        /**
     * Compara los datos del nodo con los datos de un nodo dado.
     * @param unNodo
     * @return booleano.
     */
    public boolean equals(Nodo unNodo);

    /**
     * Compara la etiqueta del nodo con una etiqueta dada.
     * @param etiqueta
     * @return devueve -1 si this tiene una etiqueta menor, 0 si son iguales, 1
     * si es mayor
     */
    public int compareTo(Comparable etiqueta);

    /**
     * Retorna una copia del nodo.
     * @return
     */
    public Nodo<T> clonar();

}
