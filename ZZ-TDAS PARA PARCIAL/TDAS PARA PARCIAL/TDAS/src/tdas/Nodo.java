package tdas;

public class Nodo<T> implements INodo<T> {

    private final Comparable etiqueta;
    private T dato;
    private INodo<T> siguiente = null;

    /**
     *  El constructor Nodo es de Orden constante : O(1)
     */
    public Nodo(Comparable etiqueta, T dato ) {
        this.etiqueta = etiqueta;   // O(1)
        this.dato = dato;       // O(1)
    }

    /**
     *  Este metodo getDato es de Orden constante : O(1)
     */
    public T getDato() {
        return this.dato;       // O(1)
    }

    /**
     *  Este metodo setDato es de Orden constante : O(1)
     */
    public void setDato(T dato) {
        this.dato = dato;       // O(1)
    }

    /**
     *  Este metodo getEtiqueta es de Orden constante : O(1)
     */
    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;       // O(1)
    }

    /**
     *  Este metodo imprimir es de Orden constante : O(1)
     */
    @Override
    public void imprimir() {
        System.out.println(dato.toString());    // O(1)   
    }

    /**
     *  Este metodo imprimirEtiqueta es de Orden constante : O(1)
     */
    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);      // O(1)
    }

    /**
     *  Este metodo clonar es de Orden constante : O(1)
     */
    public Nodo<T> clonar() {
        return new Nodo<>(this.etiqueta, this.dato);        // O(1)
    }

    /**
     *
     * @param unNodo
     * @return
     */

    /**
     *  Este metodo equals es de Orden constante : O(1)
     */
    public boolean equals(Nodo unNodo) {
        return this.dato.equals(unNodo.getDato());      // O(1)
    }

    /**
     *  Este metodo compareTo es de Orden constante : O(1)
     */
    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);       // O(1)
    }   

    /**
     *  Este metodo getSiguiente es de Orden constante : O(1)
     */
    @Override
    public INodo<T> getSiguiente() {
        return this.siguiente;      // O(1)
    }

    /**
     *  Este metodo setSiguiente es de Orden constante : O(1)
     */
    @Override
    public void setSiguiente(INodo<T> nodo) {
        this.siguiente = nodo;      // O(1)
    }
    
}
