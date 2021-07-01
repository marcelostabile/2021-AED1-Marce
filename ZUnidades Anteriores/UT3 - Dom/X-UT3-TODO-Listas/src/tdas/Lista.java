package tdas;

public class Lista<T> implements ILista<T> {

    private INodo<T> primero;

    /**
     * Obtener el primer elemento de la lista.
     * Este método es de orden constante : O(1)
     * @return nodo primero
    */
    public INodo<T> getPrimero() {
        if(primero != null){
            return this.primero;
        }
        return null;
    }

    /**
     * Insertar el nuevo elemento en lugar del primero de la lista.
     * Este método es de orden constante : O(1)
     * @param nodo nuevo
    */
    public void insertarPrimero(INodo<T> nodo) {
        nodo.setSiguiente(this.primero);
        this.primero = nodo;
    }

    /**
     * Insertar el nuevo elemento al final de la lista.
     * Este método es de orden lineal : O(N)
     * @param nodo nuevo
     */
    public void insertarUltimo(INodo<T> nodo) {    // Insertamos un nodo luego del último.

        if (this.primero == null) {    // Si no hay elementos en la lista lo insertamos primero.
            this.primero = nodo;
        }
        else {
            INodo<T> actual = this.primero;    // Hay elementos previos en la lista, tomamos el primero.
            while (actual.getSiguiente() != null) {    // Recorremos la lista hasta el último. Por lo tanto este bucle es de O(N) ya que cambia el tiempo si cambia el tamaño de la lista
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nodo);    // Insertamos el nodo luego del último.
        }
    }

    /**
     * Insertar el nuevo elemento de manera ordenada en la lista.
     * Este método es de orden lineal : O(N)
     * @param nodo nuevo
     * @return boolean
     */
    public boolean insertarNodoOrdenado(INodo<T> nodo) {
        // Validamos que el nodo no sea nulo
        if (nodo == null) {
            return false;
        }
        
        // Lista está vacía, lo insertamos primero.
        if (this.esVacia()) { 
            nodo.setSiguiente(null);
            this.primero = nodo;
            return true;
        }

        // Recorremos la lista para insertarlo ordenado.
        INodo<T> nodoActual;
        INodo<T> nodoSiguiente;

        nodoActual = this.primero;
        nodoSiguiente = nodoActual.getSiguiente();

        // Caso: primero es mayor, lo agregamos primero y el primero anterior queda siguiente.
        if (primero.compareTo(nodo.getEtiqueta()) > 0) { 
            nodo.setSiguiente(this.primero);
            this.primero = nodo;
            return true;
        }

        // Recorremos la lista hasta encontrar su lugar.
        while (nodoSiguiente != null && nodoSiguiente.compareTo(nodo.getEtiqueta()) < 0){
            nodoActual = nodoActual.getSiguiente();
            nodoSiguiente = nodoActual.getSiguiente();
        }
        nodoActual.setSiguiente(nodo);
        nodo.setSiguiente(nodoSiguiente);
        return true;
    }

    /**
     * Búsqueda de un nodo por su clave.
     * Este método buscar es de orden lineal : O(N)
     * @param clave (etiqueta).
     * @return nodo encontrado, si no encuentra retorna null.
     */
    public INodo<T> buscar(Comparable clave) {
        
        if (primero == null) {    // Lista vacia = retornamos nulo.
            return null;
        } 
        else {
            INodo<T> actual = primero;   // Hay elementos en la lista, tomamos el primero.
            while(actual != null) {    // Recorremos la lista hasta el último. Como recorre hasta el final O(N), ya que cambia el tiempo si cambia el tamaño de la lista
                if (clave.compareTo(actual.getEtiqueta()) == 0) {    // Comparamos la clave buscada con la clave del nodo actual, si coincide lo retornamos.
                    return actual;
                }
                actual = actual.getSiguiente();
            }
        }
        return null;    // Si no encontramos el nodo retornamos nulo.
    }

    /**
     * Elimina un nodo de acuerdo a la clave ingresada.
     * Este método eliminar es de orden lineal : O(N)
     * @param clave (etiqueta)
     * @return boolean. 
     */
    public boolean eliminar(Comparable clave) {

        /* Caso: lista vacia */
        if (this.primero == null) { return false; }

        /* Caso: elimino el primero */
        if (clave.compareTo(this.primero.getEtiqueta()) == 0) {
            this.primero = this.primero.getSiguiente();
            return true;
        } else {
            /* Caso: debo buscar en la lista
            * Hacemos referencia al nodo anterior y nodo actual.
            * Recorremos la lista, si actual coincide con el buscado: a "siguiente" del nodo anterior le referenciamos el siguiente del nodo actual.
            * Si actual no tiene "siguiente", quedará null el "siguiente" del nodo anterior, dejandolo en último lugar.
            */
            INodo<T> nodoAnterior = primero;
            INodo<T> actual = primero.getSiguiente();

            while (actual != null) {    // En el peor de los casos se recorre toda la lista para eliminar el ultimo nodo entonces el orden es lineal O(N) ya que cambia el tiempo si cambia el tamaño de la lista
                if (clave.compareTo(actual.getEtiqueta()) == 0) {
                    nodoAnterior.setSiguiente(actual.getSiguiente());
                    return true;
                }
                nodoAnterior = actual;
                actual = actual.getSiguiente();
            }
        }
        return false;    // No se encontró el producto en la lista.
    }

    /**
     * Retorna la cantidad de elementos de la lista.
     * Si está vacía retorna cero.
     * Este método es orden lineal : O(N)
     * @return cantidad de elementos, si está vacía retorna cero.
    */
    public int cantElementos() {
        int contador = 0;
        INodo<T> actual = this.primero;     // Recorremos la lista y acumulamos el total de elementos en el contador. 
        while (actual != null) {    // Recorres hasta el final de la lista en el peor de los casos por lo tanto es de orden O(N) ya que cambia el tiempo si cambia el tamaño de la lista.
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    /**
     * Indica si la lista contiene o no elementos.
     * Este método estaVacia es orden constante : O(1)
     * @return boolean.
     */
    public boolean esVacia() {
        return (this.primero == null);
    }

    /**
     * Vaciamos la lista, establecemos primero como null.
     * Este método estaVacia es orden constante : O(1)
     */
    public void vaciar() {
        this.primero = null;
    }

    /**
     * Imprime en consola las etiquetas de los nodos de la lista.
     * Este método es orden lineal : O(N)
     * @return cadena obtenida.
     */
    public String imprimir() {
        String cadena = "";
        if ( !esVacia() ) {
            INodo<T> nodoActual = this.primero;
            while (nodoActual != null) {
                cadena += nodoActual.getEtiqueta().toString();
                nodoActual = nodoActual.getSiguiente();
            }
        }
        System.out.println(cadena);
        return cadena;
    }

    /**
     * Imprime en consola las etiquetas de los nodos de la lista.
     * Se incluye un separador entre los valores obtenidos.
     * Este método es orden lineal : O(N)
     * @return cadena obtenida.
     */
    public String imprimir(String separador) {
        String cadena = "";
        if ( !esVacia() ) {
            INodo<T> nodoActual = this.primero;
            while (nodoActual != null) {
                cadena += nodoActual.getEtiqueta().toString();
                if (nodoActual.getSiguiente() != null) { cadena += separador; }
                nodoActual = nodoActual.getSiguiente();
            }
        }
        System.out.println(cadena);
        return cadena;
    }

    /**
     * Imprime en consola los datos de los nodos de la lista.
     * Este método es orden lineal : O(N)
     * @return cadena obtenida.
     */
    public String imprimirDatos() {
        String cadena = "";
        if ( !esVacia() ) {
            INodo<T> nodoActual = this.primero;
            while (nodoActual != null) {
                cadena += nodoActual.getDato().toString();
                nodoActual = nodoActual.getSiguiente();
            }
        }
        System.out.println(cadena);
        return cadena;
    }

    /**
     * Imprime en consola los datos de los nodos de la lista.
     * Se incluye un separador entre los valores obtenidos.
     * Este método es orden lineal : O(N)
     * @return cadena obtenida.
     */
    public String imprimirDatos(String separador) {
        String cadena = "";
        if ( !esVacia() ) {
            INodo<T> nodoActual = this.primero;
            while (nodoActual != null) {
                cadena += nodoActual.getDato().toString();
                if (nodoActual.getSiguiente() != null) { cadena += separador; }
                nodoActual = nodoActual.getSiguiente();
            }
        }
        System.out.println(cadena);
        return cadena;
    }

}