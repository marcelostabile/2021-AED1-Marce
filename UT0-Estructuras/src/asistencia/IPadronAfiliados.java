package asistencia;

import tdas.*;

public interface IPadronAfiliados<T> {

    public ILista<IAfiliado> getListaAfiliados();

    public void setListaAfiliados(ILista<IAfiliado> listaAfiliados);

    /**
     * Insertar un nuevo afiliado en el padrón.
     * O(N): Orden Lineal 
     * @param nodoAfiliado
     */
    public void insertarAfiliado(INodo<IAfiliado> nodoAfiliado);

    /**
     * Busca un afiliado y devuelve un nodo afiliado.
     * @param afiliadoCedula
     * @return nodo afiliado.
     */
    public INodo<IAfiliado> buscarAfiliado(int afiliadoCedula);

    /**
     * Actualizar consultas.
     * 
     * Recorrer el padron, para cada afiliado, recorrer la lista de consultas anotadas.
     * Si la consulta tiene valor 1, copio la consulta a lista historica, la elimino de anotadas.
     * Si la consulta tiene valor 2, copio la consulta a lista historica, la elimino de anotadas 
     * y la agrego a la lista de cobranza.
     */
    public ILista<IAfiliado> actualizarConsultas();
    
}
