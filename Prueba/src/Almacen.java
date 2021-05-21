package src;
import src.tdas.*;
import java.util.*;
public class Almacen implements IAlmacen {

    private String nombre;
    private String direccion;
    private String telefono;
    private TArbolBB<Producto> productos;

    public Almacen(String nombre) {
        this.nombre = nombre;
        this.productos = new TArbolBB<Producto>();
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        TElementoAB<Producto> nuevo =new TElementoAB<>(unProducto.getEtiqueta(),unProducto);
        if(!productos.insertar(nuevo)){
            agregarStock(unProducto.getEtiqueta(),unProducto.getStock());
        }
    }

    public int cantidadProductos() {
        return productos.obtenerTamanio();
    }

    @Override
    public String imprimirProductos(){
        StringBuilder strings = new StringBuilder();
        Lista<Producto> listaEnlazada = productos.inorden();
        if(listaEnlazada == null){
            return "";
        }
        Nodo<Producto> aux = listaEnlazada.getPrimero();
        while(aux != null){
            strings.append(aux.getEtiqueta()+":"+aux.getDato().getNombre()+":"+aux.getDato().getPrecio()+":"+aux.getDato().getStock()+"-");
            aux = aux.getSiguiente();
        }
        return strings.toString();
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        TElementoAB<Producto> buscar = productos.buscar(clave);
        if (buscar != null) {    // Verificamos que el producto existe.
            buscar.getDatos().agregarStock(cantidad);
            //System.out.println("Valor económico del stock agregado: " + (buscar.getDatos().getPrecio()*cantidad));
            return true;
        }
        return false;
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        int stock = 0;
        TElementoAB<Producto> buscar = productos.buscar(clave);
        if (buscar != null) {
            stock = productos.buscar(clave).getDatos().restarStock(cantidad);
            //System.out.println("Valor económico del stock reducido: " + (buscar.getDatos().getPrecio()*cantidad));
            if (stock == -1) {
                productos.eliminar(clave);
            }
        }
        return stock;
    }

    @Override
    public Producto buscarPorCodigo(Comparable clave) {
        TElementoAB<Producto> buscar = productos.buscar(clave);
        if(buscar !=null){
            return this.productos.buscar(clave).getDatos();
        }
        return null;
    }

    @Override
    public boolean eliminarProducto(Comparable clave) {
        TElementoAB<Producto> buscar = productos.buscar(clave);
        if(buscar != null){
            //System.out.println("Valor económico del stock eliminado: " + (buscar.getDatos().getPrecio()*buscar.getDatos().getStock()));
            this.productos.eliminar(clave);
            return true;
        }
        return false;
    }
    public Lista<Producto> getProductosEnLista(){
        return productos.inorden();
    }
    /**
     * Listar productos por descripción. 
     * Guardar un archivo el resultado.
     */
    public String[] listaOrdenadaDescripcion() {

        // Árbol resultado.
        TArbolBB<Producto> arbolOrdenado = new TArbolBB<>();

        // Obtener lista de productos del árbol desordenado y reordenarlos, obteniendo el árbol ordenado.
        Lista<Producto> listaProductos = this.productos.inorden();
        Nodo<Producto> nodoActual = listaProductos.getPrimero();
        while (nodoActual != null) {
            TElementoAB<Producto> unElemento = new TElementoAB<Producto>( (Comparable) nodoActual.getDato().getNombre(), nodoActual.getDato());
            arbolOrdenado.insertar(unElemento);
            nodoActual = nodoActual.getSiguiente();
        }

        // Lsita resultado.
        List<String> listaOrdenada = new ArrayList<>();

        // Listar por consola, obtener salida para archivo.
        int valorTotalStock = 0;
        Lista<Producto> listaAux = arbolOrdenado.inorden();
        Nodo<Producto> nodoAux = listaAux.getPrimero();
        while (nodoAux != null) {
            String dato = nodoAux.getDato().getNombre() + "," + nodoAux.getDato().getPrecio();
            valorTotalStock += nodoAux.getDato().getPrecio() * nodoAux.getDato().getStock();
            listaOrdenada.add(dato);
            //System.out.println(dato);
            nodoAux = nodoAux.getSiguiente();
        }
        System.out.println("Valor Total del Stock: " + valorTotalStock);

        // Salida por archivo.
        return listaOrdenada.toArray(new String[0]);

    }

}
