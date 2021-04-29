package habitacion;

import java.util.ArrayList;

import habitacion_partes.*;

public class Habitacion extends Dimension {

    String habitacionNombre = "";

    ArrayList<HTecho> techos = new ArrayList<>();
    ArrayList<HPared> paredes = new ArrayList<>();
    ArrayList<HPiso> pisos = new ArrayList<>();
    ArrayList<HAbertura> aberturas = new ArrayList<>();

    public Habitacion(String habitacionNombre) {
        this.habitacionNombre = habitacionNombre;
    }

    public void agregarTecho(String nombre, double largo, double ancho) {
        HTecho techo = new HTecho(nombre, largo, ancho);
        this.techos.add(techo);
    }

    public void agregarPared(String nombre,double largo, double ancho) {
        HPared pared = new HPared(nombre, largo, ancho);
        this.paredes.add(pared);
    }

    public void agregarAbertura(String nombre,double largo, double ancho) {
        HAbertura abertura = new HAbertura(nombre, largo, ancho);
        this.aberturas.add(abertura);
    }

    public void agregarPiso(String nombre,double largo, double ancho) {
        HPiso piso = new HPiso(nombre, largo, ancho);
        this.pisos.add(piso);
    }

    private double calcularSuperficieBrutaTechos() {
        double superficieTechos = 0.00;
        for (HTecho techo : this.techos) {
            superficieTechos += (techo.largo * techo.ancho);
        }
        return superficieTechos;
    }

    private double calcularSuperficieBrutaParedes() {
        double superficieParedes = 0.00;
        for (HPared pared : this.paredes) {
            superficieParedes += (pared.largo * pared.ancho);
        }
        return superficieParedes;
    }

    private double calcularSuperficieBrutaPisos() {
        double superficiePisos = 0.00;
        for (HPiso piso : this.pisos) {
            superficiePisos += (piso.largo * piso.ancho);
        }
        return superficiePisos;
    }

    public double calcularSuperficieBrutaAberturas() {
        double superficieAberturas = 0.00;
        for (HAbertura abertura : aberturas) {
            superficieAberturas += (abertura.largo * abertura.ancho);
        }
        return superficieAberturas;
    }

}
