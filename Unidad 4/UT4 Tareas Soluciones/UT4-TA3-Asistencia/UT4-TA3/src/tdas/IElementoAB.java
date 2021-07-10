package tdas;

import java.util.*;

public interface IElementoAB<T> {

    /**
     * Obtiene el valor de la etiqueta del nodo.
     * @return Etiqueta del nodo.
     */
    public Comparable getEtiqueta();

    /**
     * Retorna la etiqueta del elemento como string.
     * @return
     */
    public String imprimir();

    /**
     * Retorna los datos contenidos en el elemento.
     * @return
     */
    public T getDatos();

    /**
     * Obtiene el hijo izquierdo del nodo.
     * @return
     */
    public TElementoAB<T> getHijoIzq();

    /**
     * Asigna el hijo izquierdo del nodo.
     * @return Elemento a ser asignado como hijo izquierdo.
     */
    public void setHijoIzq(TElementoAB<T> elemento);

    /**
     * Obtiene el hijo derecho del nodo.
     * @return Hijo derecho del nodo.
     */
    public TElementoAB<T> getHijoDer();

    /**
     * Asigna el hijo derecho del nodo.
     * @return Elemento a ser asignado como hijo derecho.
     */
    public void setHijoDer(TElementoAB<T> elemento);

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", retorna falso.
     * @param unElemento Elemento<T> a insertar.
     * @return Boolean, true si lo inserta.
     */
    public boolean insertar(TElementoAB<T> elemento);

    /**
     * Busca un elemento dentro del árbol.
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar.
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta);

    /**
     * Eliminar un elemento a partir de una etiqueta dada.
     * @param unaEtiqueta
     */
    public TElementoAB eliminar(Comparable unaEtiqueta);

    /**
     * Imprime en preorden el arbol separado por guiones.
     * 
     * Elemento, HijoIzquierdo, HijoDerecho.
     * @return String conteniendo el PreOrden
     */
    public String preOrden();

    /**
     * Imprime en PreOrden los elementos del árbol, separados por guiones.
     * @return una lista conteniendo los elementos separados por guiones.
     */
    public Lista<T> preorden(Lista<T> lista);

    /**
     * Imprime en inorden el arbol separado por guiones.
     * 
     * HijoIzquierdo, Elemento, HijoDerecho.
     * @return String conteniendo el InOrden
     */
    public String inOrden();

    /**
     * Imprime en InOrden los elementos del árbol, separados por guiones.
     * @return una lista conteniendo los elementos separados por guiones.
     */
    public Lista<T> inorden(Lista<T> lista);

        /**
     * Imprime en postorden el arbol separado por guiones.
     * 
     * HijoIzquierdo, HijoDerecho, Elemento
     * @return String conteniendo el PostOrden
     */
    public String postOrden();

    /**
     * Imprime en PostOrden los elementos del árbol, separados por guiones.
     * @return una lista conteniendo los elementos separados por guiones.
     */
    public Lista<T> postorden(Lista<T> lista);

    /**
     * Retorna la altura del arbol cuya raiz es la del nodo actual.
     * @return Altura del subarbol.
     */
    public int obtenerAltura();

    /**
     * Retorna el tamaño del arbol cuya raiz es la del nodo actual.
     * @return tamaño del subarbol.
     */
    public int obtenerTamanio();

    /**
     * Retorna el nivel del elemento cuya etiqueta es la pasada por par�metro.
     * @param unaEtiqueta
     * @return Nivel
     */
    public int obtenerNivel(Comparable unaEtiqueta);

    /**
     * Retorna la cantidad de hojas del arbol cuya raiz es la del nodo actual.
     * @return Cantidad de hojas del subarbol.
     */
    public int obtenerCantidadHojas();

    /**
     * Calcular elementos internos.
     * Recorro recursivamente el árbol, por cada elemento que no es hoja sumo uno, retorno el resultado.
     * @return entero
     */
    public Integer cantInternos();

    /**
     * Calcular elementos internos completos.
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

    /**
     * Retorna la Trayectoria Interna del Árbol.
     * @return
     */
    public Integer longTrayInt(Integer nivel);

    /**
     * Retorna la Trayectoria Externa del Árbol.
     * @return
     */
    public Integer longTrayExt(Integer nivel);

}
