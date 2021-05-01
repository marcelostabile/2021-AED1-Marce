package geant;

import java.util.*;

import tdas.*;

public class Almacen implements IAlmacen {

    private String direccion;
    private String telefono;
    private String nombre;
    private ILista<IProducto> productos = new Lista<IProducto>();
    private ILista<IProducto> listaOrdenadosNombre = new Lista<IProducto>();

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    public ILista<IProducto> getListaProductos() {
        return productos;
    }

    /**
     *  El metodo getValorActualAlmacen es de Orden lineal : O(N)
     */
    public Integer getValorActualAlmacen() {
        Integer valor = 0;
        INodo<IProducto> actual = productos.getPrimero();
        while (actual != null) {
            valor += actual.getDato().getPrecio() * actual.getDato().getStock(); 
            actual = actual.getSiguiente();
        }
        return valor;
    }

    /**
     *  El metodo insertarProducto es de Orden lineal: O(N)
     */
    public void insertarProducto(IProducto unProducto) {
        if (productos.buscar(unProducto.getEtiqueta()) == null) {    // Verificamos que el producto no existe. El metodo buscar es de orden O(N) por lo tanto esta linea tambien lo es.
            this.productos.insertarUltimo(new Nodo<IProducto>(unProducto.getEtiqueta(), unProducto));     // Creamos un nodo de tipo producto y lo insertamos al final.El metodo insertarUltimo es de orden O(N) por lo tanto esta linea tambien lo es.
        } else {
            this.agregarStock(unProducto.getEtiqueta(), unProducto.getStock()); // agregarStock es de orden O(N)
        }
    }

    /**
     *  El metodo eliminarProducto es de Orden lineal: O(N)
     */
    public boolean eliminarProducto(Comparable clave) {
        if (this.productos.buscar(clave) != null) {    // Verificamos que exista. El metodo buscar es de orden O(N) por lo tanto esta linea tambien lo es.
            this.productos.eliminar(clave);    // Eliminamos el producto.El metodo eliminar es de orden O(N) por lo tanto esta linea tambien lo es.
            return true;
        }
        return false;
    }

    /**
     * Imprimir los productos de la lista.
     */
    public String imprimirProductos() {
        String cadena = "";
        if (!this.productos.esVacia()) {
            INodo<IProducto> nodoActual = this.productos.getPrimero();
            while (nodoActual != null) {
                String cod = nodoActual.getDato().getEtiqueta().toString();
                String nom = nodoActual.getDato().getNombre();
                String pre = nodoActual.getDato().getPrecio().toString();
                String stk = nodoActual.getDato().getStock().toString();
                cadena += ("Cód." + cod + ", Nombre: " + nom + ", Precio: " + pre + ", Stock: " + stk + "\n"); 
                nodoActual = nodoActual.getSiguiente();
            }
            System.out.println(cadena);
        }
        return cadena;
    }

    /**
     * Imprimir los productos de la lista.
     */
    public String imprimirSeparador(String separador) {
        String cadena = "";
        if (!this.productos.esVacia()) {
            INodo<IProducto> nodoActual = this.productos.getPrimero();
            while (nodoActual != null) {
                String cod = nodoActual.getDato().getEtiqueta().toString();
                String nom = nodoActual.getDato().getNombre();
                String pre = nodoActual.getDato().getPrecio().toString();
                String stk = nodoActual.getDato().getStock().toString();
                cadena += (cod + "," + nom + "," + pre + "," + stk); 
                if (nodoActual.getSiguiente() != null) { cadena += separador; }
                nodoActual = nodoActual.getSiguiente();
            }
            System.out.println(cadena);
        }
        return cadena;
    }

    /**
     *  El metodo agregarStock es de Orden lineal: O(N)
     */
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        INodo<IProducto> producto = this.productos.buscar(clave); // El metodo buscar es de orden O(N)
        if (producto != null) {    // Verificamos que el producto existe.
            Integer stock = producto.getDato().getStock() + cantidad;    // A la cantidad existente le sumamos lo que agregamos.
            producto.getDato().setStock(stock);     // Modificamos el stock en el producto. 
            return true;
        }
        return false;
    }

    /**
     *  El metodo restarStock es de Orden lineal: O(N)
     */
    public Integer restarStock(Comparable clave, Integer cantidad) {
        INodo<IProducto> producto = this.productos.buscar(clave); // El metodo buscar es de orden O(N)
        if (producto != null) {    // Verificamos que el producto existe. 
            Integer stock = producto.getDato().getStock() - cantidad;    // A la cantidad existente le restamos la cantidad.
            if(stock <= 0){
                this.eliminarProducto(clave); // Si luego del cálculo, el stock es menor a cero, eliminamos el producto y retornamos 0.
            }else{
                producto.getDato().setStock(stock);  // Modificamos el stock en el producto.
                return stock;
            }  
        }
        return 0;
    }

    /**
     *  El metodo buscarPorCodigo es de Orden lineal: O(N)
     */
    public IProducto buscarPorCodigo(Comparable clave) {
        INodo<IProducto> producto = this.productos.buscar(clave);  // El metodo buscar es de orden O(N)
        if(producto != null){
            return producto.getDato();
        }
        return null;
    }

    /**
     *  El metodo listarOrdenadoPorNombre es de Orden cuadratico: O(N^2)
     */
    public void listarOrdenadoPorNombre() {
      
        // Recorrer la lista.
        INodo<IProducto> actual = productos.getPrimero();
        while(actual != null) {

            // Para cada elemento, referenciamos el nodo auxiliar el elemento de la lista.
            // La etiqueta del nodo auxiliar es el nombre del elemento, el dato sigue siendo el dato del elemento.
            INodo<IProducto> nodoAuxiliar = new Nodo<IProducto>((Comparable) actual.getDato().getNombre(), actual.getDato());

            // guardamos el nodo auxiliar con el metodo de insertar ordenado.
            listaOrdenadosNombre.insertarNodoOrdenado(nodoAuxiliar);

            actual = actual.getSiguiente();
        }
        // imprimimos esta lista ordenada por nombre.
        String lista = "";
        INodo<IProducto> actual1 = listaOrdenadosNombre.getPrimero();
        while(actual1 != null){
            lista += actual1.getDato().getNombre() + " " + actual1.getDato().getEtiqueta() + " " + actual1.getDato().getPrecio() + " " + actual1.getDato().getStock() + "\n" ;
            actual1 = actual1.getSiguiente();
        }
        System.out.println(lista);
        
    }

    /**
     *  El metodo buscarPorDescripcion es de Orden lineal: O(N)
     */
    public IProducto buscarPorDescripcion(String descripcion) {
        INodo<IProducto> actual;
        actual = productos.getPrimero();
        while(actual != null){                  // Recorre toda la lista en el peor de los casos entonces es de orden O(N)
            if(actual.getDato().getNombre().equals(descripcion)){
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    /**
     *  El metodo cantidadProductos es de Orden lineal: O(N)
     */
    public int cantidadProductos() {
        return productos.cantElementos();  // CantElementos es de orden O(N)
    }

    /**
     *  El metodo altaProducto es de Orden cuadratico : O(N^2)
     */
    public void altaProducto(String[] lineas) {

        int montoTotal = 0;    // Inicializamos el monto total del stock.

        for (String string : lineas) {    // Leemos el archivo, creamos un producto nuevo, lo insertamos en la lista. // Recorremos todas las lineas es de orden O(N)
            String[] linea = string.split(",");
            Producto productoNuevo = new Producto((Comparable)linea[0], Integer.parseInt(linea[2]), Integer.parseInt(linea[3]), linea[1]);
            this.insertarProducto(productoNuevo);   // insertarProducto es de orden lineal O(N)
            montoTotal += (Integer.parseInt(linea[3]) * Integer.parseInt(linea[2]));    // Incrementamos el montoTotal luego de insertar cada producto (cantidad * precio).
        }
        System.out.println("Monto Total luego del alta: " + montoTotal);
        System.out.println("Valor actual del almacen :" + this.getValorActualAlmacen());
    }

    /**
     *  El metodo ventaProductos es de Orden cuadratico : O(N^2)
     */
    public void ventaProductos(String[] ventas) {

        Integer montoTotalVendido = 0;    // Inicializamos el monto total del stock.

        // Recorremos toda la lista por lo tanto el for es O(N)
        for (String string : ventas) {    // Leemos el archivo, obtenemos el código del producto y cantidad vendida, calculamos el monto total vendido, lo reducimos en el stock.
            String[] linea = string.split(",");
            Comparable codigo = (Comparable)linea[0];
            Integer numVenta = Integer.parseInt(linea[1]);
            montoTotalVendido += (productos.buscar(codigo).getDato().getPrecio()) * numVenta; // buscar es O(N)
            this.restarStock(codigo, numVenta); // restarStock es O(N)
        }
        System.out.println("Monto Total Vendido: " + montoTotalVendido);
        System.out.println("Valor actual del almacen: " + this.getValorActualAlmacen());
    }

    /**
     *  El metodo eliminaroProductos es de Orden cuadratico : O(N^2)
     */
    public void eliminarProductos(String[] eliminados) {
        for (String codigo : eliminados) {
                this.productos.eliminar((Comparable)codigo.trim());    // Eliminamos el producto.El metodo eliminar es de orden O(N) por lo tanto esta linea tambien lo es.
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
