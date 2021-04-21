package tdas;

public class Nodo<T> implements INodo<T> {

    private final Comparable etiqueta;
    private T dato;
    private INodo<T> siguiente = null;

    /**
     *  El constructor Nodo es de Orden constante : O(1)
     */
    public Nodo(Comparable etiqueta, T dato ) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    public T getDato() {
        return this.dato;
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    @Override
    public INodo<T> getSiguiente() {
        return this.siguiente;
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    @Override
    public void setSiguiente(INodo<T> nodo) {
        this.siguiente = nodo;
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    @Override
    public void imprimir() {
        System.out.println(dato.toString());
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    public Nodo<T> clonar() {
        return new Nodo<>(this.etiqueta, this.dato);
    }

     /**
     *  Este metodo es de Orden constante : O(1)
     */
    public boolean equals(Nodo<T> unNodo) {
        return this.dato.equals(unNodo.getDato());
    }

}