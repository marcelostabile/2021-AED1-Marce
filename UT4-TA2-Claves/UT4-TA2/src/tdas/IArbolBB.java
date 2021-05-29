package tdas;

import java.util.ArrayList;

public interface IArbolBB<T> {

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", retorna falso.
     * @param unElemento Elemento<T> a insertar.
     * @return Boolean, true si lo inserta.
     */
    public boolean insertar(TElementoAB<T> unElemento);

    /**
     * Busca un elemento dentro del árbol.
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar.
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta);

    /**
     * Imprime en PreOrden los elementos del árbol, separados por guiones.
     * @return String conteniendo el preorden separado por guiones.
     */
    public String preOrden();

    /**
     * Imprime en InOrden los elementos del árbol, separados por guiones.
     * @return String conteniendo el preorden separado por guiones.
     */
    public String inOrden();

    /**
     * Imprime en PostOrden los elementos del árbol, separados por guiones.
     * @return String conteniendo el preorden separado por guiones.
     */
    public String postOrden();

    /**
     * Imprime en PreOrden los elementos del árbol, separados por guiones.
     * @return una lista conteniendo los elementos separados por guiones.
     */
    public Lista<T> preorden();

    /**
     * Imprime en InOrden los elementos del árbol, separados por guiones.
     * @return una lista conteniendo los elementos separados por guiones.
     */
    public Lista<T> inorden();

    /**
     * Imprime en PostOrden los elementos del árbol, separados por guiones.
     * @return una lista conteniendo los elementos separados por guiones.
     */
    public Lista<T> postorden();

    // /**
    //  * Elimina un elemento dada una etiqueta.
    //  * @param unaEtiqueta 
    //  */
    // public void eliminar(Comparable unaEtiqueta);

    /**
     * Método para determinar la altura del árbol.
     * @return entero.
     */
    public int altura();

    /**
     * Método para determinar el tamaño del árbol.
     * @return entero.
     */
    public int tamano();

    /**
     * Método para determinar la cantidad de hojas del árbol.
     * @return entero.
     */
    public int hojas();

    /**
     * Método para determinar la cantidad de elementos internos del árbol.
     * @return entero.
     */
    public int internos();

    /**
     * Método para determinar la cantidad de elementos internos completos del árbol.
     * @return entero.
     */
    public int completos();

    /**
     * Obtener el nodo con la menor clave del árbol.
     * @return nodo de menor clave.
     */
    public TElementoAB<T> claveMenor();

    /**
     * Obtener el nodo con la mayor clave del árbol.
     * @return nodo de mayor clave.
     */
    public TElementoAB<T> claveMayor();

    /**
     * Método para determinar si el árbol de binario de búsqueda.
     * @return boolean, true si el árbol de de búsqueda.
     */
    public boolean esABB();

    /**
     * Método para determinar la cantidad de nodos en determinado nivel.
     * @param unaEtiqueta
     * @return cantidad de nodos en el nivel.
     */
    public Integer nivelNodoABB(Comparable unaEtiqueta);

    /**
     * Lista las hojas indicando su nivel.
     * 
     * Listar todas las hojas, cada una con su nivel. Usar dos parámetros en el método de
     * nodo: un entero para ir llevando el nivel y una lista Strings “nodo.etiqueta – nivel”
     * para ir agregando las etiquetas de las hojas y su nivel)
     * listaDeHojas(): devuelve una lista de String “etiqueta – nivel”
     */
    public ArrayList<String> listaDeHojas();

    /**
     * Devuelve la cantidad de nodos de un cierto nivel de un árbol binario.
     */
    public int enNivel(int nivel);

    // /**
    //  * Obtener la clave inmediata anterior a una clave dada (pasada por parámetro).
    //  * anterior(Comparable etiqueta)
    //  * devuelve un nodo del ABB, nulo si la etiqueta del parámetro es la menor del árbo
    //  */
    // public TElementoAB<T> anterior(Comparable etiqueta);

    /**
     * Devuelve true si el árbol es vacío.
     */
    public boolean esVacio();

}

