/**
 * AED1: Marcelo Stabile
 */ 
package TDAS;

import java.util.ArrayList;

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
    public TElementoAB<T> getHijoIzq();

    /**
     * Obtiene el hijo derecho del nodo.
     *
     * @return Hijo derecho del nodo.
     */
    public TElementoAB<T> getHijoDer();

    /**
     * Asigna el hijo izquierdo del nodo.
     *
     * @return Elemento a ser asignado como hijo izquierdo.
     */
    public void setHijoIzq(TElementoAB<T> elemento);

    /**
     * Asigna el hijo derecho del nodo.
     *
     * @return Elemento a ser asignado como hijo derecho.
     */
    public void setHijoDer(TElementoAB<T> elemento);

    /**
     * Retorna los datos contenidos en el elemento.
     * @return
     */
    public T getDato();

    /**
     * Método para insertar un elemento (descendiente).
     * 
     * Verificamos si la etiqueta del elementoAB es mayor o menor respecto a la etiqueta de nuestro elemento.
     * Si es menor se inserta recursavimente en el hijo izquierdo, de lo contrario en el hijo derecho.
     * No es pre, post o In-Orden porque no hacemos cambios en el elemento raiz. 
     * @param elemento (T)
     */
    public boolean insertar(TElementoAB<T> elemento);

    /**
    * Método para buscar un elemento.
    * 
    * Verificamos si la etiqueta ingresada coincide con este elemento, si coincide retornamos el elemento.
    * Si no coincide recorremos recursivamente los hijos. Si no se encuentra retornamos null.
    * Pre-Orden.
    * @param etiqueta (T)
    */
    public TElementoAB<T> buscar(Comparable unaEtiqueta);

    /**
     * Imprime en preorden el arbol separado por guiones.
     * 
     * Elemento, HijoIzquierdo, HijoDerecho.
     * @return String conteniendo el PreOrden
     */
    public String preOrden();

    /**
     * Imprime en inorden el arbol separado por guiones.
     * 
     * HijoIzquierdo, Elemento, HijoDerecho.
     * @return String conteniendo el InOrden
     */
    public String inOrden();

    /**
     * Imprime en postorden el arbol separado por guiones.
     * 
     * HijoIzquierdo, HijoDerecho, Elemento
     * @return String conteniendo el PostOrden
     */
    public String postOrden();

    /**
     * Imprime en PreOrden los elementos del árbol, separados por guiones.
     * @return una lista conteniendo los elementos separados por guiones.
     */
    public Lista<T> preorden(Lista<T> lista);

    /**
     * Imprime en InOrden los elementos del árbol, separados por guiones.
     * @return una lista conteniendo los elementos separados por guiones.
     */
    public Lista<T> inorden(Lista<T> lista);

    /**
     * Imprime en PostOrden los elementos del árbol, separados por guiones.
     * @return una lista conteniendo los elementos separados por guiones.
     */
    public Lista<T> postorden(Lista<T> lista);

	/**
     * Elimina un elemento dada una etiqueta.
     * @param unaEtiqueta
     * @return 
     */
    public TElementoAB eliminar(Comparable unaEtiqueta);

    /**
     * Método para determinar la altura del árbol.
     * 
     * @return entero.
     */
    public int calcularAltura();

    /**
     * Calcular tamaño.
     * 
     * Recorro recursivamente el árbol, por cada nodo sumo uno, retorno el
     * resultado.
     * @return entero
     */
    public int calcularTamano();

    /**
     * Calcular hojas.
     * 
     * Recorro recursivamente el árbol, por cada hoja sumo uno, retorno el
     * resultado.
     * 
     * @return entero
     */
    public int calcularHojas();

    /**
     * Calcular elementos internos.
     * 
     * Recorro recursivamente el árbol, por cada elemento que no es hoja sumo uno, retorno el resultado.
     * @return entero
     */
    public int calcularInternos();

    /**
     * Calcular elementos internos completos.
     * 
     * Recorro recursivamente el árbol, por cada elemento interno completo sumo uno, retorno el resultado.
     * @return entero
     */
    public int calcularInternosCompletos();

    /**
     * Obtener el nodo con la menor clave del árbol.
     * @return nodo de menor clave.
     */
    public TElementoAB<T> obtenerClaveMenor();

    /**
     * Obtener el nodo con la mayor clave del árbol.
    * @return nodo de mayor clave.
    */
    public TElementoAB<T> obtenerClaveMayor();

    /**
     * Método para determinar si el árbol de binario de búsqueda.
     * @return boolean, true si el árbol de de búsqueda.
     */
    public boolean esABB();

    /**
     * Determinar el nivel de un nodo a partir de una etiqueta.
     * 
     * @return nivel del nodo.
     */
    public int nivelNodo(Comparable unaEtiqueta);

    /**
     * Lista las hojas indicando su nivel.
     * 
     * Listar todas las hojas, cada una con su nivel. Usar dos parámetros en el método de
     * nodo: un entero para ir llevando el nivel y una lista Strings “nodo.etiqueta – nivel”
     * para ir agregando las etiquetas de las hojas y su nivel)
     * listaDeHojas(): devuelve una lista de String “etiqueta – nivel”
     */
    public ArrayList<String> listaDeHojas(int nivel, ArrayList<String> listadoHojas);

    /**
     * Devuelve la cantidad de nodos de un cierto nivel de un árbol binario.
     * @param nivel
     * @return cantidad de nodos.
     */
    public int nodosEnNivel(int nivelActual, int nivelObjetivo);

}
