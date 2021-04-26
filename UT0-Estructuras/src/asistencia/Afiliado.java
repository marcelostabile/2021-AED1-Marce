package asistencia;

import tdas.*;

public class Afiliado implements IAfiliado {

    // Constructor.

    Comparable cedula;
    String nombre;
    String apellido;
    ILista<IConsulta> consultasAnotadas;
    ILista<IConsulta> consultasHistoricas;

    public Afiliado(Comparable cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.consultasAnotadas = new Lista<>();
        this.consultasHistoricas = new Lista<>();
    }

    // Métodos.

    public Comparable getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public ILista<IConsulta> getConsultasAnotadas() {
        return consultasAnotadas;
    }

    public ILista<IConsulta> getConsultasHistoricas() {
        return consultasHistoricas;
    }

    /**
     * Insertar consultas anotadas.
     * O(N) : Orden Lineal.
     */
    public void insertarConsultaAnotada(INodo<IConsulta> nodoConsultaAnotada) { 
        this.consultasAnotadas.insertarUltimo(nodoConsultaAnotada);
    }

    /**
     * Insertar consultas históricas.
     * O(N) : Orden Lineal.
     */
    public void insertarConsultaHistorica(INodo<IConsulta> nodoConsultaHistorica) {
        this.consultasHistoricas.insertarUltimo(nodoConsultaHistorica);
    }

}
