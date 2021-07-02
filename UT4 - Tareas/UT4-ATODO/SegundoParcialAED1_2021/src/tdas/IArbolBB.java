package tdas;

public interface IArbolBB<T> {

   /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", retorna falso.
     *
     * @param unElemento Elemento a insertar
     * @return Exito de la operación
     */
    public boolean insertar(IElementoAB<T> unElemento);

    /**
     * Busca un elemento dentro del árbol.
     *
     *
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar. .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public IElementoAB<T> buscar(Comparable unaEtiqueta);

    /**
     *
     *
     * @return una Lista con los elementos del recorrido.
     *
     */
    public Lista<T> inorden();

    /**
  
    /**
     * Retorna el tamaño del arbol.
     *
     * @return Tamaño del arbol.
     */
    public int obtenerTamanio();

  
    public void eliminar(Comparable unaEtiqueta);

    public boolean esVacio();

    /**
     * @return the raiz
     */
    public IElementoAB<T> getRaiz();
    
}