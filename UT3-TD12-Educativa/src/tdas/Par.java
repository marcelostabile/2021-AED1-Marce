package tdas;

public class Par<P, S> implements IPar<P, S> { 

    private P valor1;
    private S valor2;

    public Par(P valor1, S valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public P getValor1() {
        return valor1;
    }

    public void setValor1(P valor1) {
        this.valor1 = valor1;
    }

    public S getValor2() {
        return valor2;
    }

    public void setValor2(S valor2) {
        this.valor2 = valor2;
    }

}