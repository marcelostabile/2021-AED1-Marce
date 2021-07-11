package com.ucudal.tdas;

public interface INodo<T> {

    
    /**
     * devuelve el dato del nodo
     * @return 
     */
    public T getDato();

    
    /**
     * setea el dato del nodo 
     *
     */
    public void setDato(T dato);
    
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
     * Imprime los datos del nodo
     */
    
    public void imprimir();

    /**
     * Imprime la etiqueta del nodo
     */
    
    public void imprimirEtiqueta();

    
    /**
     * Retorna la etiqueta del nodo
     *
     * @return etiqueta del nodo
     */
    public Comparable getEtiqueta();

}
