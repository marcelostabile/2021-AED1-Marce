package habitacion;

import java.util.ArrayList;

public class Habitacion {

    String habitacionNombre = "";

    ArrayList<Techo> techos = new ArrayList<>();
    ArrayList<Pared> paredes = new ArrayList<>();
    ArrayList<Piso> pisos = new ArrayList<>();
    ArrayList<Abertura> aberturas = new ArrayList<>();

    public Habitacion(String habitacionNombre) {
        this.habitacionNombre = habitacionNombre;
    }

    public void agregarTecho(String nombre, double largo, double ancho) {
        Techo techo = new Techo(nombre, largo, ancho);
        this.techos.add(techo);
    }

    public void agregarPared(String nombre,double altura, double ancho) {
        Pared pared = new Pared(nombre, altura, ancho);
        this.paredes.add(pared);
    }

    public void agregarAbertura(String nombre,double altura, double ancho) {
        Abertura abertura = new Abertura(nombre, altura, ancho);
        this.aberturas.add(abertura);
    }

    public void agregarPiso(String nombre,double largo, double ancho) {
        Piso piso = new Piso(nombre, largo, ancho);
        this.pisos.add(piso);
    }

    // private double calcularSuperficieBrutaTechos() {
    //     double superficieTechos = 0.00;
    //     for (Techo techo : this.techos) {
    //         superficieTechos += (techo.largo * techo.ancho);
    //     }
    //     return superficieTechos;
    // }

    // private double calcularSuperficieBrutaParedes() {
    //     double superficieParedes = 0.00;
    //     for (Pared pared : this.paredes) {
    //         superficieParedes += (pared.largo * pared.ancho);
    //     }
    //     return superficieParedes;
    // }

    // private double calcularSuperficieBrutaPisos() {
    //     double superficiePisos = 0.00;
    //     for (Piso piso : this.pisos) {
    //         superficiePisos += (piso.largo * piso.ancho);
    //     }
    //     return superficiePisos;
    // }

    // public double calcularSuperficieBrutaAberturas() {
    //     double superficieAberturas = 0.00;
    //     for (Abertura abertura : aberturas) {
    //         superficieAberturas += (abertura.largo * abertura.ancho);
    //     }
    //     return superficieAberturas;
    // }

}
