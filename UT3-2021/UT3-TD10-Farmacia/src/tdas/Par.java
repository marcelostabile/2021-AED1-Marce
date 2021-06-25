package tdas;

public class Par<V1, V2> implements IPar<V1, V2> { 

    private V1 valor1;
    private V2 valor2;

    public Par(V1 valor1, V2 valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public V1 getValor1() {
        return valor1;
    }
    public void setValor1(V1 valor1) {
        this.valor1 = valor1;
    }
    public V2 getValor2() {
        return valor2;
    }
    public void setValor2(V2 valor2) {
        this.valor2 = valor2;
    }

}