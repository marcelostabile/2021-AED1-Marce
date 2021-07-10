package tdas;

import java.util.*;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    /**
     * Obtiene el valor de la etiqueta del nodo.
     * @return Etiqueta del nodo.
     */
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * Retorna la etiqueta del elemento como string.
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    /**
     * Retorna los datos contenidos en el elemento.
     * @return
     */
    public T getDatos() {
        return datos;
    }

    /**
     * Obtiene el hijo izquierdo del nodo.
     * @return
     */
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    /**
     * Asigna el hijo izquierdo del nodo.
     * @return Elemento a ser asignado como hijo izquierdo.
     */
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;
    }

    /**
     * Obtiene el hijo derecho del nodo.
     * @return Hijo derecho del nodo.
     */
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }
    
    /**
     * Asigna el hijo derecho del nodo.
     * @return Elemento a ser asignado como hijo derecho.
     */
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", retorna falso.
     * @param unElemento Elemento<T> a insertar.
     * @return Boolean, true si lo inserta.
     */
    public boolean insertar(TElementoAB<T> unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    /**
     * Busca un elemento dentro del árbol.
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar.
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    /**
     * Eliminar un elemento a partir de una etiqueta dada.
     * @param unaEtiqueta
     */
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }
        if (unaEtiqueta.compareTo(this.getEtiqueta()) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }
        return quitaElNodo();
    }

    private TElementoAB quitaElNodo() {
        if (hijoIzq == null) { // solo tiene un hijo o es hoja
            return hijoDer;
        }
        if (hijoDer == null) { // solo tiene un hijo o es hoja
            return hijoIzq;
        }
        // tiene los dos hijos, buscamos el lexicograficamente anterior
        TElementoAB elHijo = hijoIzq;
        TElementoAB elPadre = this;
        while (elHijo.hijoDer != null) {
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }
        if (elPadre != this) {
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(hijoIzq);
        }
        // Caso en el que el nodo a eliminar tiene como hijos a dos hojas
        elHijo.setHijoDer(hijoDer);
        setHijoIzq(null); // para que no queden referencias y ayudar al collector
        setHijoDer(null);
        // Devuelve el hijo izquierdo
        return elHijo;
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
     * Imprime en PreOrden los elementos del árbol, separados por guiones.
     * @return una lista conteniendo los elementos separados por guiones.
     */
    public Lista<T> preorden(Lista<T> lista) {

        // Elemento.
        Nodo<T> unNodo = new Nodo<T>( (Comparable) this.getEtiqueta(), this.getDatos());
        lista.insertar(unNodo);

        // Hijo izquierdo.
        if (hijoIzq != null) {
            lista = hijoIzq.preorden(lista);
        }

        // Hijo derecho.
        if (hijoDer != null) {
            lista = hijoDer.preorden(lista);
        }

        // Devolver lista con resultados.
        return lista;
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
     * Imprime en InOrden los elementos del árbol, separados por guiones.
     * @return una lista conteniendo los elementos separados por guiones.
     */
    public Lista<T> inorden(Lista<T> lista) {

        // Hijo izquierdo.
        if (hijoIzq != null) {
            lista = hijoIzq.preorden(lista);
        }

        // Elemento.
        Nodo<T> unNodo = new Nodo<T>( (Comparable) this.getEtiqueta(), this.getDatos());
        lista.insertar(unNodo);

        // Hijo derecho.
        if (hijoDer != null) {
            lista = hijoDer.preorden(lista);
        }

        // Devolver lista con resultados.
        return lista;
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

    /**
     * Imprime en PostOrden los elementos del árbol, separados por guiones.
     * @return una lista conteniendo los elementos separados por guiones.
     */
    public Lista<T> postorden(Lista<T> lista) {

        // Hijo izquierdo.
        if (hijoIzq != null) {
            lista = hijoIzq.preorden(lista);
        }

        // Hijo derecho.
        if (hijoDer != null) {
            lista = hijoDer.preorden(lista);
        }

        // Elemento.
        Nodo<T> unNodo = new Nodo<T>( (Comparable) this.getEtiqueta(), this.getDatos());
        lista.insertar(unNodo);

        // Devolver lista con resultados.
        return lista;
    }

    /**
     * Retorna la altura del arbol.
     * @return Altura del arbol.
     */
    public int obtenerAltura() {
        int A1 = -1;
        int A2 = -1;
        if (this.hijoIzq != null) {
            A1 = this.hijoIzq.obtenerAltura();
        }
        if (this.hijoDer != null) {
            A2 = this.hijoDer.obtenerAltura();
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
    public int obtenerTamanio() {
        int T1 = 0;
        int T2 = 0;

        // Hijo izquierdo.
        if (hijoIzq != null) {
            T1 = hijoIzq.obtenerTamanio();
        }
        // Hijo derecho.
        if (hijoDer != null) {
            T2 = hijoDer.obtenerTamanio();
        }
        // Retornar tamaño.
        return T1 + T2 + 1;
    }

    /**
     * Determinar el nivel de un nodo a partir de una etiqueta.
     * 
     * @return nivel del nodo.
     */
    public int obtenerNivel(Comparable unaEtiqueta) {
        int resultado = -1; // Default, no encontrado.

        // Verificamos si el elemento actual coincide con la busqueda, retornamos cero.
        // En caso contrario, si no tiene hijos, no se encontró, retornamos -1.
        if (unaEtiqueta.compareTo(this.etiqueta) == 0) { // Encontrado.
            return 1;
        } else {
            if ((hijoIzq == null) && (hijoDer == null)) { // No Encontrado.
                return -1;
            }
        }

        // Si tiene hijos, continuamos la búsqueda recursivamente.
        if ((unaEtiqueta.compareTo(this.etiqueta) < 0) && (hijoIzq != null)) {
            resultado = hijoIzq.obtenerNivel(unaEtiqueta);
        }

        if ((unaEtiqueta.compareTo(this.etiqueta) > 0) && (hijoDer != null)) {
            resultado = hijoDer.obtenerNivel(unaEtiqueta);
        }

        // Evaluamos el resultado de la búsqueda, si lo encontramos retornamos el nivel
        // + 1, sino retornamos -1.
        if (resultado >= 0) {
            return resultado += 1;
        } else {
            return resultado;
        }
    }

    /**
     * Calcular hojas.
     * Recorro recursivamente el árbol, por cada hoja sumo uno, retorno el
     * resultado.
     * @return entero
     */
    public int obtenerCantidadHojas() {
        // Hoja.
        if (hijoIzq == null && hijoDer == null) {
            return 1;
        }
        // Cantidad de Hojas.
        int H1 = 0;
        int H2 = 0;

        // Hijo izquierdo.
        if (hijoIzq != null) {
            H1 += hijoIzq.obtenerCantidadHojas();
        }
        // Hijo derecho.
        if (hijoDer != null) {
            H2 += hijoDer.obtenerCantidadHojas();
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
    public Integer cantInternos() {
        int subArbolIzquierdo = 0;
        int subArbolDerecho = 0;

        if (hijoIzq == null && hijoDer == null) {
            return 0;
        }

        if (hijoIzq != null) {
            subArbolIzquierdo = hijoIzq.cantInternos();
        }
        if (hijoDer != null) {
            subArbolDerecho = hijoDer.cantInternos();
        }

        return subArbolIzquierdo + subArbolDerecho + 1;
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

    /**
     * Retorna la Trayectoria Interna del Árbol.
     * @return
     */
    public Integer longTrayInt(Integer nivel) {
        Integer nivelResultado = 0;
        if (hijoIzq != null) {
            nivelResultado += hijoIzq.longTrayInt(nivel + 1);
        }
        if (hijoDer != null) {
            nivelResultado += hijoDer.longTrayInt(nivel + 1);
        }
        return nivelResultado + nivel;
    }

    /**
     * Retorna la Trayectoria Externa del Árbol.
     * @return
     */
    public Integer longTrayExt(Integer nivel) {
        Integer contador = 0;
        if (hijoIzq == null) {
            contador += nivel + 1;
        } else {
            contador += hijoIzq.longTrayExt(nivel + 1);
        }
        if (hijoDer == null) {
            contador += nivel + 1;
        } else {
            contador += hijoDer.longTrayExt(nivel + 1);
        }
        return contador;
    }

}
