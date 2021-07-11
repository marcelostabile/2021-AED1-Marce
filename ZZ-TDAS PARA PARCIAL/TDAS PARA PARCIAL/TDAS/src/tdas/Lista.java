package tdas;

public class Lista<T> implements ILista<T> {

    private INodo<T> primero = null;

    /**
     *  Este metodo getPrimero es de orden constante : O(1)
     */
    @Override
    public INodo<T> getPrimero() {    // Obtener el primero de la lista.
        if(primero != null){    // O(1)
            return this.primero;    // O(1)
        }
        return null;    // O(1)
    }

    /**
     *  Este metodo getPrimero es de orden constante : O(1)
     */
    public void insertarPrimero(INodo<T> nodo) {
        nodo.setSiguiente(this.primero);    // O(1)
        this.primero = nodo;    // O(1)
    }   

    /**
     *  Este metodo insertarUltimo es de orden lineal : O(N), siendo N el largo de nuestra lista
     */
    @Override
    public void insertarUltimo(INodo<T> nodo) {    // Insertamos un nodo luego del último.

        if (primero == null) {    // Si no hay elementos en la lista lo insertamos primero. // O(1)
            primero = nodo;     // O(1)

        }else{
            INodo<T> actual = primero;    // Hay elementos previos en la lista, tomamos el primero.     // O(1)
            while (actual.getSiguiente() != null) {    // Recorremos la lista hasta el último. Por lo tanto este bucle es de O(N) ya que cambia el tiempo si cambia el tamaño de la lista
                actual = actual.getSiguiente();     // O(1)
            }
            actual.setSiguiente(nodo);    // Insertamos el nodo luego del último.    // O(1)
        }
    }

    /**
     *  Este metodo insertarNodoOrdenado es de orden lineal : O(N), siendo N el largo de la lista
     */
    public boolean insertarNodoOrdenado(INodo<T> nodo) {

        // Validamos que el nodo no sea nulo
        if (nodo == null) {     // O(1)
            return false;       // O(1)
        }
        
        // Lista está vacía, lo insertamos primero.
        if (this.esVacia()) {       // O(1)
            nodo.setSiguiente(null);        // O(1)
            this.primero = nodo;        // O(1)
            return true;        // O(1)
        }

        // Recorremos la lista para insertarlo ordenado.
        INodo<T> nodoActual;        // O(1)
        INodo<T> nodoSiguiente;     // O(1)

        nodoActual = this.primero;      // O(1)
        nodoSiguiente = nodoActual.getSiguiente();      // O(1)

        // Caso: primero es mayor, lo agregamos primero y el primero anterior queda siguiente.
        if (primero.compareTo(nodo.getEtiqueta()) > 0) {        // O(1)
            nodo.setSiguiente(this.primero);        // O(1)
            this.primero = nodo;        // O(1)
            return true;        // O(1)
        }

        // Recorremos la lista hasta encontrar su lugar.
        while (nodoSiguiente != null && nodoSiguiente.compareTo(nodo.getEtiqueta()) < 0){      // O(N)
            nodoActual = nodoActual.getSiguiente();     // O(1)
            nodoSiguiente = nodoActual.getSiguiente();      // O(1)
        }
        nodoActual.setSiguiente(nodo);      // O(1)
        nodo.setSiguiente(nodoSiguiente);       // O(1)
        return true;        // O(1)
    }

    /**
     *  Este metodo buscar es de orden lineal : O(N), siendo N el largo de la lista.
     */
    @Override
    public INodo<T> buscar(Comparable clave) {    // Buscar un nodo por su clave y retornamos el nodo.

        if (primero == null) {    // Lista vacia = retornamos nulo. // O(1)
            return null;        // O(1)

        }else{
            INodo<T> actual = primero;   // Hay elementos en la lista, tomamos el primero.      // O(1)
            while(actual != null) {    // Recorremos la lista hasta el último. Como recorre hasta el final O(N), ya que cambia el tiempo si cambia el tamaño de la lista
                if (clave.compareTo(actual.getEtiqueta()) == 0) {    // Comparamos la clave buscada con la clave del nodo actual, si coincide lo retornamos.    // O(1)
                    return actual;      // O(1)
                }
                actual = actual.getSiguiente();     // O(1)
            }
        }
        return null;    // Si no encontramos el nodo retornamos nulo.   // O(1)
    }

    /* @Override
    public boolean eliminar(Comparable clave) {     // Eliminar un producto dada una clave.
        if (this.estaVacia()) {     // Verificamos si la lista esta vacía.
            return false;
        }
        else
        {
            if (clave.compareTo(this.primero.getEtiqueta()) == 0) {     // Validamos si es el primer elemento de la lista.
                this.primero = primero.getSiguiente();
                return true;
            }
            else
            {
                INodo<T> actual = primero;    // Recorremos la lista, cuando encontramos el elemento lo eliminamos.
                while (actual.getSiguiente() != null) {
                    if (clave.compareTo(actual.getSiguiente().getEtiqueta()) == 0) {     // Eliminamos el nodo, referenciando en el elemento anterior el elemento siguiente.
                        INodo<T> theNextToTheOneToBeDeleted = actual.getSiguiente().getSiguiente();
                        actual.setSiguiente(theNextToTheOneToBeDeleted);
                        return true;
                    }
                    actual = actual.getSiguiente();
                }
                if(actual.getEtiqueta().equals(clave)){
                    this.buscar(actual.getEtiqueta()).setSiguiente(null); // En caso que se encuentre en el ultimo elemento de la lista.
                    return true;
                }
                return false;
            }
        }

    } */

    /**
     *  Este metodo eliminar es de orden lineal : O(N), siendo N el largo de la lista.
     */
    public boolean eliminar(Comparable clave) {

        /* Caso: lista vacia */
        if (this.primero == null) { return false; }     // O(1)

        /* Caso: elimino el primero */
        if (clave.compareTo(this.primero.getEtiqueta()) == 0) {    // Eliminamos el primero.       // O(1)
            this.primero = this.primero.getSiguiente();     // O(1)
            return true;        // O(1)
        }

        /* Caso: debo buscar en la lista */

        /*
        Hacemos referencia al nodo anterior y nodo actual.
        Recorremos la lista, si actual coincide con el buscado: a "siguiente" del nodo anterior le referenciamos el siguiente del nodo actual.
        Si actual no tiene "siguiente", quedará null el "siguiente" del nodo anterior, dejandolo en último lugar.
        */
        INodo<T> nodoAnterior = primero;       // O(1)
        INodo<T> actual = primero.getSiguiente();       // O(1)

        while (actual != null) {    // En el peor de los casos se recorre toda la lista para eliminar el ultimo nodo entonces el orden es lineal O(N) ya que cambia el tiempo si cambia el tamaño de la lista
            if (clave.compareTo(actual.getEtiqueta()) == 0) {       // O(1)
                nodoAnterior.setSiguiente(actual.getSiguiente());       // O(1)
                return true;        // O(1)
            }
            nodoAnterior = actual;      // O(1)
            actual = actual.getSiguiente();     // O(1)
        }
        return false;    // No se encontró el producto en la lista.     // O(1)
    }

    /*
    Verificamos si la lista está vacía.
    */
    /**
     *  Este metodo estaVacia es orden constante : O(1)
     */
    public boolean esVacia()
    {
        return (this.primero == null);      // O(1)
    }

    /**
     *  Este metodo imprimir es orden lineal : O(N), siendo N el largo de la lista.
     */
    @Override
    public String imprimir() {
        String impresion = "";      // O(1)
        if (primero!=null)      // O(1)
        {
            INodo<T> actual = primero;      // O(1)
            while (actual != null)      // O(N)
            {
                if(actual.getSiguiente()!=null){        // O(1)
                    impresion+=actual.getEtiqueta()+"\n";       // O(1)
                }
                else{
                    impresion+=actual.getEtiqueta();        // O(1)
                }
                actual = actual.getSiguiente();     // O(1)
            }
        }
        return impresion;       // O(1)
    }
    
    /**
     *  Este metodo imprimir es orden lineal : O(N), siendo N el largo de la lista.
     */
    @Override
    public String imprimir(String separador) {
        String impresion = "";      // O(1)
        if (primero!=null)      // O(1)
        {
            INodo<T> actual = primero;      // O(1)
            while (actual != null)      // O(N)
            {   
                if(actual.getSiguiente()!=null){       // O(1)
                    impresion+=actual.getEtiqueta()+ separador;     // O(1)
                }
                else{
                    impresion+=actual.getEtiqueta();        // O(1)
                }
                actual = actual.getSiguiente();     // O(1)
            }
        }
        return impresion;       // O(1)
    }

    /**
     *  Este metodo cantElementos es orden lineal : O(N), siendo N el largo de la lista.
     */
    @Override
    public int cantElementos() {

        int contador = 0;       // O(1)

        INodo<T> actual = primero;     // Recorremos la lista y acumulamos el total de elementos en el contador.    // O(1)
        while (actual != null) {    // Recorres hasta el final de la lista en el peor de los casos por lo tanto es de orden O(N) ya que cambia el tiempo si cambia el tamaño de la lista.
            contador++;     // O(1)
            actual = actual.getSiguiente();     // O(1)
        }
        return contador;       // O(1)
    }

    /**
     *  Este metodo vaciar es orden constante : O(1)
     */
    public void vaciar() {
        this.primero = null;        // O(1)
    }
}
