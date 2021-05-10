/**
 * AED1: Marcelo Stabile
 */ 
package TDAS;

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
     * Método para determinar la cantidad de nodos en determinado nivel.
     * @param unaEtiqueta
     * @return cantidad de nodos en el nivel.
     */
    public Integer nivelNodoABB(Comparable unaEtiqueta);

}

