import tdas.*;
import almacen.Almacen;
import almacen.Producto;
import almacen_archivos.*;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
      
      // Crear almacen.

      Almacen almacen = new Almacen("GEANT");

      // 1. cargar los productos desde el archivo "altas.txt" o "altasPrueba.txt".
      // 2. agregar stock a un producto existente.

      String[] altas = ManejadorArchivosGenerico.leerArchivo("src\\almacen_archivos\\altasPrueba.txt");
      //String[] altas = ManejadorArchivosGenerico.leerArchivo("src\\almacen_archivos\\altas.txt");
      for (String linea : altas) {
        String[] registro = linea.split(",");
        Producto unProducto = new Producto( (Comparable) registro[0], registro[1]);
        unProducto.setPrecio(Integer.parseInt(registro[2]));
        unProducto.setStock(Integer.parseInt(registro[3]));
        almacen.insertarProducto(unProducto);        
      }

      // emitir el valor del stock

      System.out.println("Altas - Cantidad de productos: " + almacen.cantidadProductos());
      System.out.println("Altas - Valor del Stock del Almacen: " + almacen.valorStock());

      // 3. simular las ventas a partir del archivo "ventas.txt" o "ventaspruebas.txt"

      String[] ventas = ManejadorArchivosGenerico.leerArchivo("src\\almacen_archivos\\ventasPrueba.txt");
      //String[] ventas = ManejadorArchivosGenerico.leerArchivo("src\\almacen_archivos\\ventas.txt");
      for (String linea : ventas) {
        String[] registro = linea.split(",");
        almacen.restarStock( (Comparable) registro[0], Integer.parseInt(registro[1]));
      }

      System.out.println("Ventas - Cantidad de productos: " + almacen.cantidadProductos());
      System.out.println("Ventas - Valor del Stock del Almacen: " + almacen.valorStock());

      // 4. simular la eliminación de productos a partir del archivo "elim.txt" o "elimPrueba.txt"

      String[] elim = ManejadorArchivosGenerico.leerArchivo("src\\almacen_archivos\\elimPrueba.txt");
      //String[] elim = ManejadorArchivosGenerico.leerArchivo("src\\almacen_archivos\\elim.txt");
      for (String registro : elim) {
        almacen.eliminarProducto(registro);
      }

      System.out.println("Eliminados - Cantidad de productos: " + almacen.cantidadProductos());
      System.out.println("Eliminados - Valor del Stock del Almacen: " + almacen.valorStock());

      // 5. Dado un codigo de producto, indicar las existencias del mismo en el almacén.

      Producto producto = almacen.buscarPorCodigo("1000097");
      if (producto != null) System.out.println("Cantidad del producto 1000097: " + producto.getStock());

      // 6. Listar los productos por códigos incluyendo su stock.
      almacen.listarProductoCodigo();

      // Paso 1. Punto 2. Compra de más unidades de un producto o incorporación de uno nuevo.
      // Punto 3. ¿cúal es el valor económico agregado al stock?
      System.out.println("Valor anterior del stock: " + almacen.valorStock());

      Producto producto1 = almacen.buscarPorCodigo("1000097");
      producto1.agregarStock(1000);

      System.out.println("Valor agregado del stock: " + almacen.valorStock());

      Producto producto2 = new Producto( (Comparable) "3000099", "CHOCOLATE MILKA");
      producto2.setPrecio(Integer.parseInt("100"));
      producto2.setStock(Integer.parseInt("1000"));
      almacen.insertarProducto(producto2);

      System.out.println("Valor agregado del stock: " + almacen.valorStock());

      // Paso 2. Punto 1. Buscar un producto y simular una venta reduciendo su stock.
      // Punto 2. ¿cúal es el valor económico agregado al stock?

      int cantidadVenta = 1000;
      System.out.println("Valor reducido del stock: " + almacen.buscarPorCodigo("3000099").getPrecio() * cantidadVenta);
      almacen.restarStock("3000099", 1000);

      // Eliminar un producto del almacen.
      System.out.println(almacen.eliminarProducto("1000097"));
      System.out.println(almacen.eliminarProducto("3000099"));

      System.out.println("Valor del stock: " + almacen.valorStock());

      // Listar productos por descripción alfabeticamente y generar salida "productos.txt".
      System.out.println("Listar Alfabeticamente");
      System.out.println("Cantidad: " + almacen.cantidadProductos());
      String[] listaResultado = almacen.listaOrdenadaDescripcion();
      for (String linea : listaResultado) {
        String[] reg = linea.split(",");
        System.out.println(reg[0] +","+ reg[1]);        
      }
    }
}

