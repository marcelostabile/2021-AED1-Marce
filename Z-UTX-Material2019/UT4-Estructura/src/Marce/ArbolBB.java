package tdas;

public class ArbolBB<T> implements IArbolBB<T> {
    
    private ElementoAB<T> raiz;

    /**
     * Constructor ArbolBB.
     */
    public ArbolBB() {
        raiz = null;
    }

    /**
     * Insertar un elemento en el árbol.
     * 
     * @param unElemento (T)
     */
    public boolean insertar(ElementoAB<T> unElemento) {

        if (this.raiz == null) {
            this.raiz = unElemento;
            return true;
        } else {
            return this.raiz.insertar(unElemento);
        }
    }

    /**
    * Método para buscar un elemento.
    * 
    * @param etiqueta (T)
    */
    public ElementoAB<T> buscar(Comparable unaEtiqueta) {

        if (this.raiz == null) {
            return null;
        } else {
            return this.raiz.buscar(unaEtiqueta);
        }
    }

    /**
     * Recorrido pre-orden.
     * 
     * @return cadena (string), vacío retorna null.
     */
    public String preOrden() {

        if (this.raiz == null) {
            return null;
        } else {
            return this.raiz.preOrden();
        }
    }

    /**
     * Recorrido post-orden.
     * 
     * @return cadena (string), vacío retorna null.
     */
    public String postOrden() {

        if (this.raiz == null) {
            return null;
        } else {
            return this.raiz.postOrden();
        }
    }

    /**
     * Recorrido in-orden.
     * 
     * @return cadena (string), vacío retorna null.
     */
    public String inOrden() {

        if (this.raiz == null) {
            return null;
        } else {
            return this.raiz.inOrden();
        }
    }

    /**
     * Método para determinar la altura del árbol.
     * 
     * @return entero.
     */
    public int obtenerAltura() {

        if (this.raiz != null) {
            return this.raiz.calcularAltura();
        } else {
            return 0;
        }
    }

    /**
     * Método para determinar el tamaño del árbol.
     * 
     * @return entero.
     */
    public int obtenerTamano() {
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
    public int obtenerHojas() {
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
    public int obtenerInternos() {
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
    public int obtenerInternosCompletos() {
        if (this.raiz != null) {
            return this.raiz.calcularInternosCompletos();
        } else {
            return 0;
        }
    }

    // /**
    //  * Método para determinar la cantidad de nodos de cierto nivel del árbol.
    //  * @param nivel (int)
    //  * @return entero
    //  */
    // public int enNivel(int nivel) {

    //     if (this.raiz != null) {
    //         return this.raiz.enNivel();
    //     } else {
    //         return 0;
    //     }
    // }

}
