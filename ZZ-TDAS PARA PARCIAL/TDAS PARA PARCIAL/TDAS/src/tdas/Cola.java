package tdas;

public class Cola<T> extends Lista<T> implements ICola<T> {

    /**
     * El metodo encolar es de orden lineal O(N), siendo N el largo de la cola.
     */
    @Override
    public void encolar(INodo<T> nodo) {
        this.insertarUltimo(nodo); // O(N)
    }

    /**
     * El metodo desencolar es de orden lineal O(N), siendo N el largo de la cola.
     */
    @Override
    public INodo<T> desencolar() {
        INodo<T> temp = new Nodo<>(this.getPrimero().getEtiqueta(),this.getPrimero().getDato());    // O(1)
        this.eliminar(this.getPrimero().getEtiqueta());    // O(N) 
        return temp;     // O(1)
    }
    
}
