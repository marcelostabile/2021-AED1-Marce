/**
 * AED1: Marcelo Stabile
 */ 
package TDAS;

import java.util.ArrayList;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T dato;

    /**
     * Constructor ElementoAB.
     * @param etiqueta (Comparable)
     * @param datos    (T)
     */
    public TElementoAB(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    public Comparable getEtiqueta() { 
        return etiqueta; 
    }

    public TElementoAB<T> getHijoIzq() { 
        return hijoIzq; 
    }

    public TElementoAB<T> getHijoDer() { 
        return hijoDer; 
    }

    public void setHijoIzq(TElementoAB<T> elemento) { 
        this.hijoIzq = elemento; 
    }

    public void setHijoDer(TElementoAB<T> elemento) { 
        this.hijoDer = elemento; 
    }

    /**
     * Obtener los datos.
     * @return
     */
    public T getDato() {
        return dato;
    }

    /**
     * Método para insertar un elemento (descendiente).
     * 
     * Verificamos si la etiqueta del elementoAB es mayor o menor respecto a la etiqueta de nuestro elemento.
     * Si es menor se inserta recursavimente en el hijo izquierdo, de lo contrario en el hijo derecho.
     * No es pre, post o In-Orden porque no hacemos cambios en el elemento raiz. 
     * @param elemento (T)
     */
    public boolean insertar(TElementoAB<T> elemento) {

        if (elemento.getEtiqueta().compareTo(this.etiqueta) < 0) {   // Etiqueta de menor valor.
            if (hijoIzq == null) {   // Se inserta como hijo izquierdo, si ya tiene se inserta recursivamente.
                hijoIzq = elemento;
                return true;
            } else {
                return hijoIzq.insertar(elemento);
            }
        } else if (elemento.getEtiqueta().compareTo(this.etiqueta) > 0) {   // Etiqueta de mayor valor.
            if (hijoDer == null) {   // Se inserta como hijo derecho, si ya tiene se inserta recursivamente.
                hijoDer = elemento;
                return true;
            } else {
                return hijoDer.insertar(elemento);
            }
        } else {   // Etiqueta repetida, no se inserta.
            return false;
        }
    }

    /**
    * Método para buscar un elemento.
    * 
    * Verificamos si la etiqueta ingresada coincide con este elemento, si coincide retornamos el elemento.
    * Si no coincide recorremos recursivamente los hijos. Si no se encuentra retornamos null.
    * Pre-Orden.
    * @param etiqueta (T)
    */
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.compareTo(this.getEtiqueta()) == 0) {   // La etiqueta de este elemento coincide con la búsqueda.
            return this;

        } else if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
                if (hijoIzq == null) {
                    return null;
                } else {
                    return hijoIzq.buscar(unaEtiqueta);
                }

        } else if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
                if (hijoDer == null) {
                    return null;
                } else {
                    return hijoDer.buscar(unaEtiqueta);
                }

        } else {
            return null;
        }
    }

    /**
     * Imprime en preorden el arbol separado por guiones.
     * 
     * Elemento, HijoIzquierdo, HijoDerecho.
     * @return String conteniendo el PreOrden
     */
    public String preOrden() {

        String cadena = "";
        String separa = "-";

        // Elemento.
        cadena += this.etiqueta.toString();

        // Hijo izquierdo.
        if (hijoIzq != null) {
            cadena += separa;
            cadena += hijoIzq.preOrden();
        }
        // Hijo derecho.
        if (hijoDer != null) {
            cadena += separa;
            cadena += hijoDer.preOrden();
        }
        return cadena;
    }

    /**
     * Imprime en inorden el arbol separado por guiones.
     * 
     * HijoIzquierdo, Elemento, HijoDerecho.
     * @return String conteniendo el InOrden
     */
    public String inOrden() {

        String cadena = "";
        String separa = "-";

        // Hijo izquierdo.
        if (hijoIzq != null) {
            cadena += hijoIzq.inOrden();
            cadena += separa;
        }
        // Elemento.
        cadena += this.etiqueta.toString();
        // Hijo derecho.
        if (hijoDer != null) {
            cadena += separa;
            cadena += hijoDer.inOrden();
        }
        return cadena;
    }

    /**
     * Imprime en postorden el arbol separado por guiones.
     * 
     * HijoIzquierdo, HijoDerecho, Elemento
     * @return String conteniendo el PostOrden
     */
    public String postOrden() {

        String cadena = "";
        String separa = "-";

        // Hijo izquierdo.
        if (hijoIzq != null) {
            cadena += hijoIzq.postOrden();
            cadena += separa;
        }
        // Hijo derecho.
        if (hijoDer != null) {
            cadena += hijoDer.postOrden();
            cadena += separa;
        }
        // Elemento.
        cadena += this.etiqueta.toString();

        return cadena;
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        // TODO Auto-generated method stub
        return null;
    }



    /**
     * Método para determinar la altura del árbol.
     * 
     * @return entero.
     */
    public int calcularAltura() {

        int A1 = -1;
        int A2 = -1;
        if (this.hijoIzq != null) {
            A1 = this.hijoIzq.calcularAltura();
        }
        if (this.hijoDer != null) {
            A2 = this.hijoDer.calcularAltura();
        }

        if (A1 > A2) {
            return A1 + 1;
        } else {
            return A2 + 1;
        }
    }

    /**
     * Calcular tamaño.
     * 
     * Recorro recursivamente el árbol, por cada nodo sumo uno, retorno el
     * resultado.
     * @return entero
     */
    public int calcularTamano() {

        int T1 = 0;
        int T2 = 0;

        // Hijo izquierdo.
        if (hijoIzq != null) {
            T1 += hijoIzq.calcularTamano();
        }
        // Hijo derecho.
        if (hijoDer != null) {
            T2 += hijoDer.calcularTamano();
        }
        // Retornar tamaño.
        return T1 + T2 + 1;
    }

    /**
     * Calcular hojas.
     * 
     * Recorro recursivamente el árbol, por cada hoja sumo uno, retorno el
     * resultado.
     * 
     * @return entero
     */
    public int calcularHojas() {

        // Hoja.
        if (hijoIzq == null && hijoDer == null)
            return 1;

        // Cantidad de Hojas.
        int H1 = 0;
        int H2 = 0;

        // Hijo izquierdo.
        if (hijoIzq != null) {
            H1 += hijoIzq.calcularHojas();
        }
        // Hijo derecho.
        if (hijoDer != null) {
            H2 += hijoDer.calcularHojas();
        }

        // Retornar valor.
        return H1 + H2;
    }

    /**
     * Calcular elementos internos.
     * 
     * Recorro recursivamente el árbol, por cada elemento que no es hoja sumo uno, retorno el resultado.
     * @return entero
     */
    public int calcularInternos() {

        int IntIzq = 0;
        int IntDer = 0; 

        // Si es hoja retorna cero.
        if ((hijoIzq == null) && (hijoDer == null)) {
            return 0;
        } else {
            // Hijo izquierdo.
            if (hijoIzq != null) {
                IntIzq += hijoIzq.calcularInternos();
            }
            // Hijo derecho.
            if (hijoDer != null) {
                IntDer += hijoDer.calcularInternos();
            }
            // Retornar valor.
            return IntIzq + IntDer + 1;
        }
    }

    /**
     * Calcular elementos internos completos.
     * 
     * Recorro recursivamente el árbol, por cada elemento interno completo sumo uno, retorno el resultado.
     * @return entero
     */
    public int calcularInternosCompletos() {

        int ComIzq = 0;
        int ComDer = 0; 

        // Si es hoja retorna cero.
        if ( (hijoIzq == null) && (hijoDer == null) ) {
            return 0;
        } else { 
            // Hijo izquierdo.
            if (hijoIzq != null) {
                ComIzq = hijoIzq.calcularInternosCompletos();
            }

            // Hijo derecho.
            if (hijoDer != null) {
                ComDer = hijoDer.calcularInternosCompletos();
            }
        }

        // Retornar valores.
        if ( (hijoIzq != null) && (hijoDer != null) ) {
            return ComIzq + ComDer + 1;
        } else {
            return ComIzq + ComDer;
        }
    }

    /**
     * Obtener el nodo con la menor clave del árbol.
     * @return nodo de menor clave.
     */
    public TElementoAB<T> obtenerClaveMenor() {

        // Padre.
        TElementoAB<T> elementoAux = this;

        // Hijo.
        if (hijoIzq != null) {
            elementoAux = this.hijoIzq.obtenerClaveMenor();
        }

        // Devuelvo elemento con menor clave.
        return elementoAux;
    }

    /**
     * Obtener el nodo con la mayor clave del árbol.
    * @return nodo de mayor clave.
    */
    public TElementoAB<T> obtenerClaveMayor() {

        // Padre.
        TElementoAB<T> elementoAux = this;

        // Hijo.
        if (hijoDer != null) {
            elementoAux = this.hijoDer.obtenerClaveMayor();
        }

        // Devuelvo elemento con mayor clave.
        return elementoAux;
    }

    /**
     * Método para determinar si el árbol de binario de búsqueda.
     * @return boolean, true si el árbol de de búsqueda.
     */
    public boolean esABB() {

        /**
         * Condiciones ABB:
         * 1 - El nodo no tiene hijos > true
         * 2 - Si tiene ambos hijos y se cumple hijoIzq < nodo < hijoDer -> true
         * 3 - Si tiene hijoizq y es menor al nodo -> true
         * 4 - Si tiene hijoder y es mayor al nodo -> true
         */
        if (hijoIzq == null && hijoDer == null) {   // 1
            return true;
        }

        if (hijoIzq != null && hijoDer == null) {   // 2
            return (hijoIzq.getEtiqueta().compareTo(this.getEtiqueta()) < 0) == hijoIzq.esABB();
        }

        if (hijoIzq == null && hijoDer != null) {   // 3
            return (hijoDer.getEtiqueta().compareTo(this.getEtiqueta()) > 0) == hijoDer.esABB();
        }

        if (hijoIzq != null && hijoDer != null) {   // 4
            return ((hijoIzq.getEtiqueta().compareTo(this.getEtiqueta()) < 0) == hijoIzq.esABB()) 
                == ((hijoDer.getEtiqueta().compareTo(this.getEtiqueta()) > 0) == hijoDer.esABB());
        }

        return false;
    }

    /**
     * Determinar el nivel de un nodo a partir de una etiqueta.
     * 
     * @return nivel del nodo.
     */
    public int nivelNodo(Comparable unaEtiqueta) {

        int resultado = -1;   // Default, no encontrado.

        // Verificamos si el elemento actual coincide con la busqueda, retornamos uno.
        // En caso contrario, si no tiene hijos, no se encontró, retornamos -1.
        if (unaEtiqueta.compareTo(this.etiqueta) == 0) {   // Encontrado.
            return 1;
        } else {
            if ((hijoIzq == null) && (hijoDer == null)) {   // No Encontrado.
                return -1;
            }
        }

        // Si tiene hijos, continuamos la búsqueda recursivamente.
        if ((unaEtiqueta.compareTo(this.etiqueta) < 0) && (hijoIzq != null)) {
            resultado = hijoIzq.nivelNodo(unaEtiqueta);
        }

        if ((unaEtiqueta.compareTo(this.etiqueta) > 0) && (hijoDer != null)) {
            resultado = hijoDer.nivelNodo(unaEtiqueta);
        }

        // Evaluamos el resultado de la búsqueda, si lo encontramos retornamos el nivel + 1, sino retornamos -1.
        if (resultado >= 0) {
            return resultado += 1;
        } else {
            return resultado;
        }
    }

    /**
     * Lista las hojas indicando su nivel.
     * 
     * Listar todas las hojas, cada una con su nivel. Usar dos parámetros en el método de
     * nodo: un entero para ir llevando el nivel y una lista Strings “nodo.etiqueta – nivel”
     * para ir agregando las etiquetas de las hojas y su nivel)
     * listaDeHojas(): devuelve una lista de String “etiqueta – nivel”
     */
    public ArrayList<String> listaDeHojas(int nivel, ArrayList<String> listadoHojas) {

        // Si es hoja, agrega la información a la lista.
        if ( (hijoIzq == null) && (hijoDer == null) ) {
            listadoHojas.add(this.etiqueta + "-" + nivel);
            return listadoHojas;
        }

        // Si no es hoja, sigo recorriendo recursivamente.
        if (hijoIzq != null) {
            listadoHojas = hijoIzq.listaDeHojas(nivel + 1, listadoHojas);
        }

        // Si no es hoja, sigo recorriendo recursivamente.
        if (hijoDer != null) {
            listadoHojas = hijoDer.listaDeHojas(nivel + 1, listadoHojas);
        }

        return listadoHojas;
    }

    /**
     * Devuelve la cantidad de nodos de un cierto nivel de un árbol binario.
     * @param nivel
     * @return cantidad de nodos.
     */
    public int nodosEnNivel(int nivelActual, int nivelObjetivo) {

        int cantNodos = 0;

        // Si el nivel actual coincide con el nivel objetivo, se agrega el nodo actual al contador.
        if (nivelActual == nivelObjetivo) {
            cantNodos += 1;    
        }

        if (hijoIzq != null) {
            cantNodos += hijoIzq.nodosEnNivel(nivelActual + 1, nivelObjetivo);
        }
        if (hijoDer != null) {
            cantNodos += hijoDer.nodosEnNivel(nivelActual + 1, nivelObjetivo);
        }

        return cantNodos;
    }

}
