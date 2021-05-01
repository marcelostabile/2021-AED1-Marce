package a;

public class Cuadrado extends Figuras {

    int lado;

    public Cuadrado(int lado) {
        this.lado = lado;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public void imprimirPerimetro() {
        this.perimetro = this.lado * 4;
        System.out.println(this.perimetro);
    }

    public void imprimirSuperficie() {
        this.superficie = this.lado * this.lado;
        System.out.println(this.superficie);
    }
}
