package almacen;
import java.util.ArrayList;
import java.util.List;

import tdas.*;

public class Almacen implements IAlmacen {

    private String nombre;
    private String direccion;
    private String telefono;
    private TArbolBB<Producto> productos;

    public Almacen(String nombre) {
        this.nombre = nombre;
        this.productos = new TArbolBB<Producto>();
    }

    /**
     * Insertar un producto en el almacen.
     */
    public void insertarProducto(Producto unProducto) {

        TElementoAB<Producto> nuevo = new TElementoAB<>( (Comparable) unProducto.getEtiqueta(), unProducto);
        if (!productos.insertar(nuevo)) {
            this.agregarStock(unProducto.getEtiqueta(), unProducto.getStock());
        }
    }

    /**
     * Imprimir una lista de los productos.
     */
    public String imprimirProductos() {

        // String resultado.
        String resultado = "";
        // Si el almacen contiene productos.
        if (!productos.esVacio()) {
            // Obtengo los productos.
            Lista<Producto> listaProductos = productos.inorden();
            Nodo<Producto> nodoActual = listaProductos.getPrimero();
            while (nodoActual != null) {
                String registro = nodoActual.getEtiqueta() 
                     + "," + nodoActual.getDato().getNombre()
                     + "," + nodoActual.getDato().getPrecio() 
                     + "," + nodoActual.getDato().getStock();
                if (nodoActual.getSiguiente() != null) { registro += "-"; }
                // Agregar el producto al resultado.
                resultado += registro;
                nodoActual = nodoActual.getSiguiente();
            }
        }
        return resultado;
    }

    /**
     * Agregar stock a un producto existente.
     */
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        TElementoAB<Producto> elemProducto = productos.buscar(clave);
        if (elemProducto != null) {
            elemProducto.getDatos().agregarStock(cantidad);
            return true;
        }
        return false;
    }

    /**
     * Restar el stock de un producto.
     * Si el producto queda sin stock retorna -1.
     */
    public Integer restarStock(Comparable clave, Integer cantidad) {
        int stock = 0;
        TElementoAB<Producto> elemProducto = productos.buscar(clave);
        if (elemProducto != null) {
            stock = elemProducto.getDatos().restarStock(cantidad);
            // Si el producto queda sin stock, lo eliminamos.
            if (stock == -1) { productos.eliminar(clave); }
        }
        return stock;
    }

    /**
     * Buscar un producto por código.
     * Si no existe retorna nulo.
     */
    public Producto buscarPorCodigo(Comparable clave) {
        TElementoAB<Producto> elemProducto = productos.buscar(clave);
        if (elemProducto != null) {
            return elemProducto.getDatos();
        }
        return null;
    }

    /**
     * Eliminar un producto del almacen.
     * Si no existe retorna nulo.
     */
    public boolean eliminarProducto(Comparable clave) {
        TElementoAB<Producto> elProducto = productos.buscar(clave);
        if (elProducto != null) {
            this.productos.eliminar(clave);
            return true;
        }
        return false;
    }

    /**
     * Lista de productos ordenados por código.
     */
    public Lista<Producto> listaProductosXCodigo() {
        return this.productos.inorden();
    }

    /**
     * Valor del stock.
     */
    public int valorStock() {
        int valorResultado = 0;
        Lista<Producto> listaProductos = productos.inorden();
        Nodo<Producto> nodoActual = listaProductos.getPrimero();
        while (nodoActual != null) {
            valorResultado += nodoActual.getDato().getStock() * nodoActual.getDato().getPrecio();
            nodoActual = nodoActual.getSiguiente();         
        }
        return valorResultado;
    }

    /**
     * Obtener una Lista<Producto> con todos los productos del almacen.
     * @return uan lista.
     */
    public Lista<Producto> getProductosEnLista(){
        return productos.inorden();
    }

    /**
     * Listar productos por descripción. 
     * Guardar un archivo el resultado.
     */
    public String[] listaOrdenadaDescripcion() {

        // Resultados.
        TArbolBB<Producto> arbolOrdenado = new TArbolBB<>();
        int valorTotalStock = 0;

        // Obtener lista de productos del árbol desordenado y reordenarlos.
        Lista<Producto> listaProductos = this.productos.inorden();
        Nodo<Producto> nodoActual = listaProductos.getPrimero();
        while (nodoActual != null) {
            valorTotalStock += nodoActual.getDato().getPrecio() * nodoActual.getDato().getStock();
            TElementoAB<Producto> unElemento = new TElementoAB<Producto>( (Comparable) nodoActual.getDato().getNombre(), nodoActual.getDato());
            arbolOrdenado.insertar(unElemento);
            nodoActual = nodoActual.getSiguiente();
        }
        System.out.println("Valor Total del Stock: " + valorTotalStock);

        // Listar por consola, obtener salida para archivo.
        List<String> listaOrdenada = new ArrayList<>();
        Lista<Producto> listaAux = arbolOrdenado.inorden();
        Nodo<Producto> nodoAux = listaAux.getPrimero();
        while (nodoAux != null) {
            String dato = nodoAux.getDato().getNombre() + "," + nodoAux.getDato().getPrecio();
            listaOrdenada.add(dato);
            nodoAux = nodoAux.getSiguiente();
        }
        return listaOrdenada.toArray(new String[0]);
    }

    /**
     * Retorna la existencia de un producto y su cantidad de stock.
     * @param codigo del producto
     * @return string
     */
    public String consultaCodigo(Comparable codigoProducto) { 
        TElementoAB<Producto> prod = this.productos.buscar(codigoProducto);
        if (prod != null) {
            return "Producto Existente, Stock: " + prod.getDatos().getStock();
        } else {
            return "Producto no encontrado";
        }
    }

}
