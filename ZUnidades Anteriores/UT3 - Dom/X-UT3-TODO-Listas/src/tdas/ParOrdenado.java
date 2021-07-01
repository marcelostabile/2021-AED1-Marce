package tdas;

public class ParOrdenado<K, V> implements IParOrdenado<K, V> { 

    private K clave;
    private V valor;
    
    public ParOrdenado(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public K getClave() {
        return clave;
    }

    public V getValor() {
        return valor;
    }

}