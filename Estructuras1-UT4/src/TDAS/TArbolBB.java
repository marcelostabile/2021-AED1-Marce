/**
 * AED1: Marcelo Stabile
 */ 
package TDAS;

import java.util.ArrayList;

public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    public int contador = 0;

    /**
     * Constructor ArbolBB.
     */
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

        contador++;

        if (this.raiz == null) {
            this.raiz = unElemento;
            return true;
        } else {
            boolean res = this.raiz.insertar(unElemento);
            return res;
        }
    }

    /**
     * Busca un elemento dentro del árbol.
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar.
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

        if (this.raiz == null) {
            return null;
        } else {
            return this.raiz.buscar(unaEtiqueta);
        }
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

    // @Override
    // public void eliminar(Comparable unaEtiqueta) {
    //     // TODO Auto-generated method stub

    /**
     * Método para determinar la altura del árbol.
     * @return entero.
     */
    public int altura() {

        if (this.raiz != null) {
            return this.raiz.calcularAltura();
        } else {
            return 0;
        }
    }

    /**
     * Método para determinar el tamaño del árbol.
     * @return entero.
     */
    public int tamano() {
        if (this.raiz != null) {
            return this.raiz.calcularTamano();
        } else {
            return 0;
        }
    }

    /**
     * Método para determinar la cantidad de hojas del árbol.
     * @return entero.
     */
    public int hojas() {
        if (this.raiz != null) {
            return this.raiz.calcularHojas();
        } else {
            return 0;
        }
    }

    /**
     * Método para determinar la cantidad de elementos internos del árbol.
     * @return entero.
     */
    public int internos() {
        if (this.raiz != null) {
            return this.raiz.calcularInternos();
        } else {
            return 0;
        }
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
     * Devuelve true si el árbol es vacío.
     */
    public boolean esVacio() {
        return (raiz == null);
    }


    // /**
    //  * Obtener la clave inmediata anterior a una clave dada (pasada por parámetro).
    //  * anterior(Comparable etiqueta)
    //  * devuelve un nodo del ABB, nulo si la etiqueta del parámetro es la menor del árbo
    //  */
    // public TElementoAB<T> anterior(Comparable etiqueta) {

    //     if (this.raiz != null) {
    //         return this.raiz.claveInmediataAnterior(etiqueta);
    //     }
    //     return null;
    // }

}
