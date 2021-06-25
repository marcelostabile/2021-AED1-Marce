package tdas;

import java.util.ArrayList;

public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", retorna falso.
     * @param unElemento Elemento<T> a insertar.
     * @return Boolean, true si lo inserta.
     */
    public boolean insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    /**
     * Busca un elemento dentro del árbol.
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar.
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    /**
     * Eliminar un elemento a partir de una etiqueta dada.
     * @param unaEtiqueta
     */
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
    }

    /**
     * Retorna true si el árbol es vacío.
     * @return
     */
    public boolean esVacio() {
        return (raiz == null);
    }

    /**
     * Vacía el árbol estableciendo la raiz en nulo.
     * @return True si habían elementos en el árbol, false en caso contrario
     */
    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    /**
     * Imprime en PreOrden los elementos del árbol, separados por guiones.
     * @return String conteniendo el preorden separado por guiones.
     */
    public String preOrden() {
        if (this.raiz == null) {
            return null;
        } else {
            return this.raiz.preOrden();
        }
    }

    /**
     * Imprime en PreOrden los elementos del árbol, separados por guiones.
     * @return una lista conteniendo los elementos separados por guiones.
     */
    public Lista<T> preorden() {
        Lista<T> listaResultado = null;
        if (!esVacio()) {
            listaResultado = new Lista<T>();
            raiz.preorden(listaResultado);
        }
        return listaResultado;
    }

    /**
     * Imprime en InOrden los elementos del árbol, separados por guiones.
     * @return String conteniendo el preorden separado por guiones.
     */
    public String inOrden() {
        if (this.raiz == null) {
            return null;
        } else {
            return this.raiz.inOrden();
        }
    }

    /**
     * Imprime en InOrden los elementos del árbol, separados por guiones.
     * @return una lista conteniendo los elementos separados por guiones.
     */
    public Lista<T> inorden() {
        Lista<T> listaResultado = null;
        if (!esVacio()) {
            listaResultado = new Lista<T>();
            raiz.inorden(listaResultado);
        }
        return listaResultado;
    }

    /**
     * Imprime en PostOrden los elementos del árbol, separados por guiones.
     * @return String conteniendo el preorden separado por guiones.
     */
    public String postOrden() {
        if (this.raiz == null) {
            return null;
        } else {
            return this.raiz.postOrden();
        }
    }

    /**
     * Imprime en PostOrden los elementos del árbol, separados por guiones.
     * @return una lista conteniendo los elementos separados por guiones.
     */
    public Lista<T> postorden() {
        Lista<T> listaResultado = null;
        if (!esVacio()) {
            listaResultado = new Lista<T>();
            raiz.postorden(listaResultado);
        }
        return listaResultado;
    }

    /**
     * Retorna la altura del arbol.
     * @return Altura del arbol.
     */
    public int obtenerAltura() {
        if (this.raiz != null) {
            return this.raiz.obtenerAltura();
        } else {
            return 0;
        }
    }

    /**
     * Retorna el tamaño del árbol
     * @return  tamaño del árbol.
     */
    public int obtenerTamanio() {
        if (this.raiz != null) {
            return this.raiz.obtenerTamanio();
        } else {
            return 0;
        }
    }

    /**
     * Retorna el nivel del arbol a partir de la etiqueta indicada
     * @param unaEtiqueta
     * @return Nivel
     */
    public int obtenerNivel(Comparable unaEtiqueta) {
        if (raiz == null) {
            return -1;
        }
        return raiz.obtenerNivel(unaEtiqueta);
    }

    /**
     * Método para determinar la cantidad de hojas del árbol.
     * @return entero.
     */
    public int obtenerCantidadHojas() {
        if (this.raiz != null) {
            return this.raiz.obtenerCantidadHojas();
        } else {
            return 0;
        }
    }

    /**
     * Método para determinar la cantidad de elementos internos del árbol.
     * @return entero.
     */
    public Integer cantInternos() {
        if (esVacio()) {
            return 0;
        }
        return raiz.cantInternos();
    }

    /**
     * Método para determinar la cantidad de elementos internos completos del árbol.
     * @return entero.
     */
    public int completos() {
        if (this.raiz != null) {
            return this.raiz.calcularInternosCompletos();
        } else {
            return 0;
        }
    }

    /**
     * Obtener el nodo con la menor clave del árbol.
     * @return nodo de menor clave.
     */
    public TElementoAB<T> claveMenor() {

        if (raiz != null) {
            return this.raiz.obtenerClaveMenor();
        } else {
            return null;
        }
    }

    /**
     * Obtener el nodo con la mayor clave del árbol.
     * @return nodo de mayor clave.
     */
    public TElementoAB<T> claveMayor() {

        if (raiz != null) {
            return this.raiz.obtenerClaveMayor();
        } else {
            return null;
        }
    }

    /**
     * Método para determinar si el árbol de binario de búsqueda.
     * @return boolean, true si el árbol de de búsqueda.
     */
    public boolean esABB() {

        if (raiz != null) {
            return this.raiz.esABB();
        } else {
            return false;
        }
    }

    /**
     * Método para determinar la cantidad de nodos en determinado nivel.
     * @param unaEtiqueta
     * @return cantidad de nodos en el nivel.
     */
    public Integer nivelNodoABB(Comparable unaEtiqueta) {
        if (raiz == null) {
            return 0;
        }
        return raiz.nivelNodo(unaEtiqueta);
    }

    /**
     * Lista las hojas indicando su nivel.
     * 
     * Listar todas las hojas, cada una con su nivel. Usar dos parámetros en el método de
     * nodo: un entero para ir llevando el nivel y una lista Strings “nodo.etiqueta – nivel”
     * para ir agregando las etiquetas de las hojas y su nivel)
     * listaDeHojas(): devuelve una lista de String “etiqueta – nivel”
     */
    public ArrayList<String> listaDeHojas() {

        ArrayList<String> listaHojas = new ArrayList<>();

        if (this.raiz != null) {
            listaHojas = this.raiz.listaDeHojas(1, listaHojas);
        }
        return listaHojas;
    }

    /**
     * Devuelve la cantidad de nodos de un cierto nivel de un árbol binario.
     */
    public int enNivel(int nivel) {

        if (this.raiz != null) {
            return this.raiz.nodosEnNivel(1, nivel);
        }
        return 0;
    };

    /**
     * Retorna la Trayectoria Interna del Árbol.
     * @return
     */
    public Integer longTrayInt() {
        if (esVacio()) {
            return 0;
        }
        return this.raiz.longTrayInt(1);
    }

    /**
     * Retorna el promedio de la Trayectoria Interna del Árbol.
     * @return
     */
    public Integer longTrayIntProm() {
        if (esVacio()) {
            return 0;
        }
        return this.longTrayInt() / this.obtenerTamanio();
    }

    /**
     * Retorna la Trayectoria Externa del Árbol.
     * @return
     */
    public Integer longTrayExt() {
        if (esVacio()) {
            return 1;
        }
        return this.raiz.longTrayExt(1);
    }

    /**
     * Retorna el promedio de la Trayectoria Externa del Árbol.
     * @return
     */
    public Integer longTrayExtProm() {
        if (esVacio()) {
            return 1;
        }
        return this.longTrayExt() / (this.obtenerTamanio() + 1);
    }
    
}
