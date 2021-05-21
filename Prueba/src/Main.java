package src;
import src.tdas.*;
import src.archivos.*;
import java.util.Scanner;

public class Main {

    /**
     * @param args
        */
    public static void main(String[] args) {

        /* Almacen almacen = new Almacen("Geant");

        // cargar los productos desde el archivo "altasprueba.txt"
        String[] contenidoArchivo = ManejadorArchivosGenerico.leerArchivo("UT4-TA9\\src\\archivos\\altasPrueba.txt");
        for (String linea : contenidoArchivo) {
            String[] prod = linea.split(",");
            Producto producto = new Producto(prod[0], prod[1]);
            producto.setPrecio(Integer.parseInt(prod[2]));
            producto.setStock(Integer.parseInt(prod[3]));
            almacen.insertarProducto(producto);
        }

        // simular las ventas a partir del archivo "ventaspruebas.txt"
        String[] ventas = ManejadorArchivosGenerico.leerArchivo("UT4-TA9\\src\\archivos\\ventasPrueba.txt");
        for (String linea : ventas) {
            String[] venta = linea.split(",");
            almacen.restarStock( (Comparable) venta[0],Integer.parseInt(venta[1]));
        }

        // simular la eliminación de productos a partir del archivo "elimPrueba.txt"
        String[] elim = ManejadorArchivosGenerico.leerArchivo("UT4-TA9\\src\\archivos\\elimPrueba.txt");
        for (String linea: elim) {
            almacen.eliminarProducto( (Comparable) linea);
        } */


        Almacen almacen = new Almacen("Geant");

        // cargar los productos desde el archivo "altas.txt"
        int contadorNuevoStock = 0;
        String[] contenidoArchivo = ManejadorArchivosGenerico.leerArchivo("src\\archivos\\altasPrueba.txt");
        for (String linea : contenidoArchivo) {
            String[] prod = linea.split(",");
            Producto producto = new Producto(prod[0], prod[1]);
            producto.setPrecio(Integer.parseInt(prod[2]));
            producto.setStock(Integer.parseInt(prod[3]));
            almacen.insertarProducto(producto);
            contadorNuevoStock += producto.getPrecio()*producto.getStock();
        }
        System.out.println("Valor economico del stock agregado: " + contadorNuevoStock);
        System.out.println("Cantidad de productos: " +almacen.cantidadProductos());
        
        // simular las ventas a partir del archivo "ventas.txt"
        int ventasTotales = 0;
        contenidoArchivo = ManejadorArchivosGenerico.leerArchivo("src\\archivos\\ventas.txt");
        for (String linea : contenidoArchivo) {
            String[] venta = linea.split(",");
            Producto producto = almacen.buscarPorCodigo(venta[0]);
            if(producto != null){
                int stockViejo = producto.getStock();
                almacen.restarStock((Comparable)venta[0],Integer.parseInt(venta[1]));
                int stock =Integer.parseInt(venta[1]);
                if(stockViejo < stock){
                    ventasTotales += producto.getPrecio()*stockViejo;
                }else{
                    ventasTotales += producto.getPrecio()*stock;
                }
            }
        }
        System.out.println("Valor economico del stock reducido: " + ventasTotales);
        System.out.println("Cantidad de productos: " +almacen.cantidadProductos());

        // la eliminación de productos vencidos a partir del archivo "elim.txt"
        int productosEliminados = 0;
        contenidoArchivo = ManejadorArchivosGenerico.leerArchivo("src\\archivos\\elim.txt");
        for (String linea: contenidoArchivo) {
            Producto producto = almacen.buscarPorCodigo(linea);
            if(almacen.eliminarProducto( (Comparable) linea)){
                productosEliminados += producto.getPrecio()*producto.getStock();
            }
        }
        System.out.println("Valor economico del stock eliminado: " + productosEliminados);
        System.out.println("Cantidad de productos: " +almacen.cantidadProductos());

        /*  // listar los productos ordenados por codigo, junto con su cantidad existente
        System.out.println(almacen.imprimirProductos());
        //emitir el valor del stock

        // Listar producto por código.
        String listaProductos = almacen.imprimirProductos();
        String [] listado = listaProductos.split("-");
        for (String linea : listado) {
            System.out.println(linea);
        }
        // guardar salida "productos.txt"

        ManejadorArchivosGenerico.escribirArchivo("productos.txt", listado);
        */

        // Lista de productos por descripción, salida por consola y por archivo "Productos.txt".
        String[] listaOrdenada = almacen.listaOrdenadaDescripcion();
        ManejadorArchivosGenerico.escribirArchivo("src\\productos.txt", listaOrdenada);
        

        // Dado un codigo de Producto, indicar si existe y en que cantidad.
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Codigo de producto a buscar: ");

        String codigo = myObj.nextLine();  // Read user input
        Producto p = almacen.buscarPorCodigo(codigo);
        if(p==null){
            System.out.println("No existe este producto en el stock");
        }else{
            System.out.println("Existe el producto y su stock es: "+ p.getStock());
        }

        // Dado una descripcion de un Producto, listar todos los similares.
        myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Descripcion de producto a buscar: ");
        String descripcion = myObj.nextLine();  // Read user input
        INodo<Producto> nodo = almacen.getProductosEnLista().getPrimero();
        while(nodo != null){
            if(nodo.getDato().getNombre().contains(descripcion.toUpperCase())){
                System.out.println(nodo.getDato().getNombre()+ ";" + nodo.getEtiqueta()+ ";" + nodo.getDato().getStock()+ ";" + nodo.getDato().getPrecio());
            }
            nodo = nodo.getSiguiente();
        }
    }

}

