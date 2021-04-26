package asistencia;

import tdas.*;

public class PadronAfiliados<T> implements IPadronAfiliados<T> {
    
    // Constructor.

    ILista<IAfiliado> listaAfiliados;

    public PadronAfiliados() {
        this.listaAfiliados = new Lista<>();
    }

    // Métodos.

    public ILista<IAfiliado> getListaAfiliados() {
        return listaAfiliados;
    }

    public void setListaAfiliados(ILista<IAfiliado> listaAfiliados) {
        this.listaAfiliados = listaAfiliados;
    }

    /**
     * Insertar un nuevo afiliado en el padrón.
     * O(N): Orden Lineal 
     * @param nodoAfiliado
     */
    public void insertarAfiliado(INodo<IAfiliado> nodoAfiliado) {
        this.listaAfiliados.insertarUltimo(nodoAfiliado);
    }

    /**
     * Busca un afiliado y devuelve un nodo afiliado.
     * @param afiliadoCedula
     * @return nodo afiliado.
     */
    public INodo<IAfiliado> buscarAfiliado(int afiliadoCedula) {
        return this.listaAfiliados.buscar((Comparable) afiliadoCedula);
    }

    /**
     * Actualizar consultas.
     * 
     * Recorrer el padron, para cada afiliado, recorrer la lista de consultas anotadas.
     * Si la consulta tiene valor 1, copio la consulta a lista historica, la elimino de anotadas.
     * Si la consulta tiene valor 2, copio la consulta a lista historica, la elimino de anotadas 
     * y la agrego a la lista de cobranza.
     */
    public ILista<IAfiliado> actualizarConsultas() {

        // Lista cobranzas.
        ILista<IAfiliado> listaCobranzas = new Lista<>();

        // Recorro la lista de afiliados.
        INodo<IAfiliado> nodoAfiliado = this.listaAfiliados.getPrimero();
        while (nodoAfiliado != null) {
            
            // Recorro la lista de consultas anotadas.
            INodo<IConsulta> nodoConsulta = nodoAfiliado.getDato().getConsultasAnotadas().getPrimero();
            while (nodoConsulta != null) {

                // Concurrió a la consulta.
                if (nodoConsulta.getDato().getResultado() != 0) {
                    nodoAfiliado.getDato().insertarConsultaHistorica(nodoConsulta.clonar());
                    nodoAfiliado.getDato().getConsultasAnotadas().eliminar(nodoConsulta.getEtiqueta());

                    // No concurrió, lo agrego a la lista para cobrar.
                    if (nodoConsulta.getDato().getResultado() == 2) { listaCobranzas.insertarUltimo(nodoAfiliado.clonar()); }
                }
                nodoConsulta = nodoConsulta.getSiguiente();
            }
            nodoAfiliado = nodoAfiliado.getSiguiente();
        }
        return listaCobranzas;
    }

}
