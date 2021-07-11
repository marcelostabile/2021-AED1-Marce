package com.ucudal.tdas;

public interface IElementoAB<T> {

     /**
     * Obtiene el valor de la etiqueta del nodo.
     *
     * @return Etiqueta del nodo.
     */
    public Comparable getEtiqueta();

    /**
     * Obtiene el hijo izquierdo del nodo.
     *
     * @return Hijo Izquierdo del nodo.
     */
    public IElementoAB<T> getHijoIzq();

    /**
     * Obtiene el hijo derecho del nodo.
     *
     * @return Hijo derecho del nodo.
     */
    public IElementoAB<T> getHijoDer();

    /**
     * Asigna el hijo izquierdo del nodo.
     *
     * @return Elemento a ser asignado como hijo izquierdo.
     */
    public void setHijoIzq(IElementoAB<T> elemento);

    /**
     * Asigna el hijo derecho del nodo.
     *
     * @return Elemento a ser asignado como hijo derecho.
     */
    public void setHijoDer(IElementoAB<T> elemento);

    /**
     * Busca un elemento dentro del arbol con la etiqueta indicada.
     *
     * @param unaEtiqueta del nodo a buscar
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public IElementoAB<T> buscar(Comparable unaEtiqueta);

    /**
     * Inserta un elemento dentro del arbol.
     *
     * @param elemento Elemento a insertar.
     * @return Exito de la operaci�n.
     */
    public boolean insertar(IElementoAB<T> elemento);

    /**
     * Imprime en inorden el arbol separado por guiones.
     *
     * @return String conteniendo el InOrden
     */
    public String inOrden();

    /**
     * Imprime en preorden el arbol separado por guiones.
     *
     * @return String conteniendo el preOrden
     */
    public String preOrden();

    /**
     * Imprime en postorden el arbol separado por guiones.
     *
     * @return String conteniendo el postOrden
     */
    public String postOrden();

    /**
     * pone las etiquetas del recorrido en inorden en una Lista.
     *
     * @param unaLista
     */
    public void inOrden(Lista<T> unaLista);

    /**
     * pone las etiquetas del recorrido en preorden en una Lista.
     *
     * @param unaLista
     */
    public void preOrden(Lista<T> unaLista);


    /**
     * pone las etiquetas del recorrido en postorden en una Lista.
     *
     * @param unaLista
     */
    public void postOrden(Lista<T> unaLista);

    /**
     * Retorna los datos contenidos en el elemento.
     *
     * @return
     */
    public T getDatos();

    /**
     * Retorna el tamaño del arbol cuya raiz es la del nodo actual.
     *
     * @return tamaño del subarbol.
     */
    public int obtenerTamanio();

    /**
     * Retorna la altura del subarbol.
     *
     * @return Altura del subarbol.
     */
    public int obtenerAltura();
   
    public IElementoAB eliminar(Comparable unaEtiqueta);

    public IElementoAB clonar();
    
    public String imprimir();

    public int calcularCosto(int[] FrecExito, int[] FrecNoExito, int[] indiceFE, int[] indiceFNE, int nivel);

    void completaVectores(IElementoAB[] elementos, int[] FrecExito, int[] FrecNoExito, int[] indiceFE, int[] indiceFNE);   // completa los vectores correspondientes.

    void cuentaFrec(Comparable unaClave); // incrementa el campo de frecuencia que corresponda a ese argumento de búsqueda.
}
