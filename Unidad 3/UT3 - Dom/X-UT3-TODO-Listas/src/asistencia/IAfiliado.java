package asistencia;

import tdas.*;

public interface IAfiliado {

    public Comparable getCedula();

    public String getNombre();

    public String getApellido();

    public ILista<IConsulta> getConsultasAnotadas();

    public ILista<IConsulta> getConsultasHistoricas();

    /**
     * Insertar consultas anotadas.
     * O(N) : Orden Lineal.
     */
    public void insertarConsultaAnotada(INodo<IConsulta> nodoConsultaAnotada);

    /**
     * Insertar consultas históricas.
     * O(N) : Orden Lineal.
     */
    public void insertarConsultaHistorica(INodo<IConsulta> nodoConsultaHistorica);

}
