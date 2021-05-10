package tdas;

public interface IArbolBB<T> {

    /**
     * Insertar un elemento en el árbol.
     * @param unElemento (T)
     */
    public boolean insertar(ElementoAB<T> unElemento);

    /**
    * Método para buscar un elemento.
    * 
    * @param etiqueta (T)
    */
    public ElementoAB<T> buscar(Comparable unaEtiqueta);

    /**
     * Recorrido pre-orden.
     * @return cadena (string), vacío retorna null.
     */
    public String preOrden();

    /**
     * Recorrido post-orden.
     * @return cadena (string), vacío retorna null.
     */
    public String postOrden();

    /**
     * Recorrido in-orden.
     * @return cadena (string), vacío retorna null.
     */
    public String inOrden();

}
