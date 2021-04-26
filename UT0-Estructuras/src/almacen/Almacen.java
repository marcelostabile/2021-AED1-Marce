package almacen;

import tdas.*;

public class Almacen implements IAlmacen {
    
    // Lista de productos.
    public ILista<IProducto> listaProductos;

    public Almacen() {
        this.listaProductos = new Lista<IProducto>();;
    }

    public ILista<IProducto> getListaProductos() {
        return listaProductos;
    }

    /**
     * Insertar último un nuevo elemento, creamos un nodo y lo insertamos en la lista.
     * @param unProducto
     */
    public void insertarProducto(IProducto unProducto) {
        INodo<IProducto> nodoProducto = new Nodo<IProducto>(unProducto.getCodigoProd(), unProducto);
        if (listaProductos.buscar(nodoProducto.getEtiqueta()) == null ) { listaProductos.insertarUltimo(nodoProducto); }
    }

    /**
     * Insertar último un nuevo elemento, recibimos un nodo y lo insertamos en la lista.
     * @param nodoProducto
     */
    public void insertarProducto(INodo<IProducto> nodoProducto) {
        if (listaProductos.buscar(nodoProducto.getEtiqueta()) == null ) { listaProductos.insertarUltimo(nodoProducto); }
    }

    /**
     * Insertar últimos múltiples elementos a partir de un array String[] que recibimos.
     */
    public void cargaMasivaProductos(String[] listaProductos) {
        for (String registro : listaProductos) {
            String[] datos = registro.split(",");
            IProducto unProducto = new Producto(Integer.parseInt(datos[0]), datos[1], Double.parseDouble(datos[2]), Integer.parseInt(datos[3]));
            this.insertarProducto(unProducto);
        }
    }

    /**
     * Búsqueda de productos por nombre parcial.
     * @return productos que coinciden con la búsqueda.
     */
    public String buscarPorNombreParcial(String nombreBuscado) {
        
        String resultadosBusqueda = "";

        /* 
        * Método contains es sensible a mayúsculas y minúsculas.
        * Para eliminar esto convierto el nombre buscado y los nombre de productos a mayúsculas para la comparación.
        */
        String nombreBuscadoMAY = nombreBuscado.toUpperCase();
        String nombreProductoMAY = "";

        INodo<IProducto> actual = this.productos.getPrimero();
        while (actual != null) {
            nombreProductoMAY = actual.getDato().getNombre().toUpperCase();
            if (nombreProductoMAY.contains(nombreBuscadoMAY)) {
                String cod = actual.getDato().getEtiqueta().toString();
                String nom = actual.getDato().getNombre();
                String pre = actual.getDato().getPrecio().toString();
                String stk = actual.getDato().getStock().toString();
                resultadosBusqueda += (cod + "," + nom + "," + pre + "," + stk); 
                if (actual.getSiguiente() != null) { resultadosBusqueda += "\n"; }
            }
            actual = actual.getSiguiente();
        }
        return resultadosBusqueda;    // Retorna los resultados, si la lista está vacía retorna vacío.
    } 

}
