package tdas;

public interface IElementoAB<T> {

    /**
     * Método para insertar un elemento (descendiente).
     * 
     * Verificamos si la etiqueta del elementoAB es mayor o menor respecto a la etiqueta de nuestro elemento.
     * Si es menor se inserta recursavimente en el hijo izquierdo, de lo contrario en el hijo derecho.
     * No es pre, post o In-Orden porque no hacemos cambios en el elemento raiz. 
     * @param elementoAB (T)
     */
    public boolean insertar(ElementoAB<T> elementoAB);

    /**
    * Método para buscar un elemento.
    * 
    * Verificamos si la etiqueta ingresada coincide con este elemento, si coincide retornamos una copia del elemento.
    * Si no coincide recorremos recursivamente los hijos. Si no se encuentra retornamos null.
    * Pre-Orden.
    * @param etiqueta (T)
    */
    public ElementoAB<T> buscar(Comparable unaEtiqueta);

    /**
     * Recorrido Pre-Orden.
     * 
     * Elemento, HijoIzquierdo, HijoDerecho.
     * @return cadena de etiquetas.
     */
    public String preOrden();

    /**
     * Recorrido Post-Orden.
     * 
     * HijoIzquierdo, HijoDerecho, Elemento
     * @return cadena de etiquetas.
     */
    public String postOrden();

    /**
     * Recorrido In-Orden.
     * 
     * HijoIzquierdo, Elemento, HijoDerecho.
     * @return cadena de etiquetas.
     */
    public String inOrden();
    
}
