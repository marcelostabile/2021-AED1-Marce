package tdas;

/**
 *
 * @author ernesto
 * @param <T>
 */
public class Nodo<T> implements INodo<T> {

    private final Comparable etiqueta;
    private T dato;
    private Nodo<T> siguiente = null;

    public Nodo(Comparable etiqueta, T dato ) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    /**
     * Retorna la etiqueta del nodo
     * @return etiqueta del nodo
     */
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    /**
     * devuelve el dato del nodo
     * @return 
     */
    public T getDato() {
        return this.dato;
    }

    /**
     * Retorna el nodo siguiente.
     * @return un nodo T.
     */
    public Nodo<T> getSiguiente() {
        return this.siguiente;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * Imprime la etiqueta del nodo
     */
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

    /**
     * Imprime los datos del nodo
     */
    public void imprimir() {
        System.out.println(dato.toString());
    }

    public void setSiguiente(Nodo<T> nodo) {
        this.siguiente = nodo;
    }

    /**
     * Compara los datos del nodo con los datos de un nodo dado.
     * @param unNodo
     * @return booleano.
     */
    public boolean equals(Nodo unNodo) {
        return this.dato.equals(unNodo.getDato());
    }

    /**
     * Compara la etiqueta del nodo con una etiqueta dada.
     * @param etiqueta
     * @return devueve -1 si this tiene una etiqueta menor, 0 si son iguales, 1
     * si es mayor
     */
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }

    /**
     * Retorna una copia del nodo.
     * @return
     */
    public Nodo<T> clonar() {
        return new Nodo<>(this.etiqueta, this.dato);
    }

}
