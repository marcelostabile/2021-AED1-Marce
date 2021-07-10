package tdas;

import mutualista.*;

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
     * pone las etiquetas del recorrido en inorden en una TLista.
     *
     * @param unaLista
     */
    public void inOrden(Lista<T> unaLista);

    
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
   
    public IElementoAB eliminar(Comparable unaEtiqueta);
    
    public String imprimir();

    public void indizar(Lista<Especialidad> especialidades);
}
