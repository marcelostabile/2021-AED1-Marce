package tdas;

public interface INodo<T> {

     /**
     * devuelve el dato del nodo
     * @return 
     */
    public T getDato();

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    public void setDato(T dato);

    /**
     * Retorna la etiqueta del nodo
     *
     * @return etiqueta del nodo
     */
    public Comparable getEtiqueta();

    /**
     * devuelve el siguiente del nodo
     * @return 
     */
    public INodo<T> getSiguiente();
    
    /**
     * "engancha" otro nodo a continuacion
     * 
     */
    public void setSiguiente(INodo<T> nodo);

    /**
     *
     * @param etiqueta
     * @return devueve -1 si this tiene una etiqueta menor, 0 si son iguales, 1
     * si es mayor
     */
    public int compareTo(Comparable etiqueta);

    /**
     * Imprime los datos del nodo
     */
    public void imprimir();

    /**
     * Imprime la etiqueta del nodo
     */
    public void imprimirEtiqueta();

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    public Nodo<T> clonar();

     /**
     *  Este metodo es de Orden constante : O(1)
     */
    public boolean equals(Nodo<T> unNodo);

}
