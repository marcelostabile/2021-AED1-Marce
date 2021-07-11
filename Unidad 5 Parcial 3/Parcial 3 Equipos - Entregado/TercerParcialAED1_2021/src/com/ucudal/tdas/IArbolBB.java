package com.ucudal.tdas;

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
    public Lista<T> inOrden();

    /**
     *
     *
     * @return una Lista con los elementos del recorrido postOrden.
     *
     */
    public Lista<T> postOrden();

    /**
     *
     *
     * @return una Lista con los elementos del recorrido preOrden.
     *
     */
    public Lista<T> preOrden();


    /** Imprime en InOrden los elementos del arbol, separados por guiones.
     *
     * @return String conteniendo el inorden separado por guiones.
     **/
    public String inOrdenString();


     /** Imprime en PostOrden los elementos del arbol, separados por guiones.
      *
      * @return String conteniendo el postorden separado por guiones.
     **/
    public String postOrdenString();


     /** * Imprime en PreOrden los elementos del arbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     **/
    public String preOrdenString();

  
    /**
     * Retorna el tamaño del arbol.
     *
     * @return Tamaño del arbol.
     */
    public int obtenerTamanio();

   /**
    * Retorna la altura del arbol.
    *
    * @return Altura del arbol.
    */
    public int obtenerAltura();

  
    public void eliminar(Comparable unaEtiqueta);

    public boolean esVacio();

    /**
     * @return the raiz
     */
    public IElementoAB<T> getRaiz();

    /**
     *
     * @param FrecExito
     * @param FrecNoExito
     * @return
     */
    public long calcularCosto(int[] FrecExito, int[] FrecNoExito);

    public void cuentaFrec(Comparable unaClave); // incrementa el campo de frecuencia que corresponda a ese argumento de búsqueda.  

    public void completaVectores(IElementoAB[] elementos, int[] FrecExito, int[] FrecNoExito); // completa los vectores correspondientes.
    
}