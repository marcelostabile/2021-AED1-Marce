package almacen;

import tdas.*;

public interface IAlmacen {
    
    public ILista<IProducto> getListaProductos();

    /**
     * Insertar último un nuevo elemento, creamos un nodo y lo insertamos en la lista.
     * @param unProducto
     */
    public void insertarProducto(IProducto unProducto);
    
    /**
     * Insertar último un nuevo elemento, recibimos un nodo y lo insertamos en la lista.
     * @param nodoProducto
     */
    public void insertarProducto(INodo<IProducto> nodoProducto);

    /**
     * Insertar últimos múltiples elementos a partir de un array String[] que recibimos.
     */
    public void cargaMasivaProductos(String[] listaProductos);
    
}
