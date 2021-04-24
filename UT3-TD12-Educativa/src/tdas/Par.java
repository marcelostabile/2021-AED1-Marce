package tdas;

public class Par<T1, T2> implements IPar<T1, T2> { 

    private T1 valor1;
    private T2 valor2;

    public Par(T1 valor1, T2 valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public T1 getValor1() {
        return valor1;
    }
    public void setValor1(T1 valor1) {
        this.valor1 = valor1;
    }
    public T2 getValor2() {
        return valor2;
    }
    public void setValor2(T2 valor2) {
        this.valor2 = valor2;
    }

}