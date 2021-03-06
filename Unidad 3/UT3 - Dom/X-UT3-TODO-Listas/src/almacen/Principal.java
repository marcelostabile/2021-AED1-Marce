package almacen;

import tdas.*;
import archivos.*;
import java.util.*;

public class Principal {
    
    public void main() {

        // Creamos el almacen, se crea la lista de productos.
        IAlmacen almacen = new Almacen();

        System.out.println("Almacen - Cantidad inicial de productos: " + almacen.getListaProductos().cantElementos());

        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        // Crear los datos manualmente.
        IProducto producto1 = new Producto(101, "Prod1", 12.00, 1000);    // Código, Nombre, Precio, Stock.
        IProducto producto2 = new Producto(102, "Prod2", 16.25, 500);
        IProducto producto3 = new Producto(103, "Prod3", 23.50, 1500);
        IProducto producto4 = new Producto(104, "Prod4", 32.75, 400);

        // Creamos una lista auxiliar con los productos.
        List<IProducto> lisProductos = new ArrayList<IProducto>();
        lisProductos.add(producto1);
        lisProductos.add(producto2);
        lisProductos.add(producto3);
        lisProductos.add(producto4);

        // Con la lista de productos, crear nodos y cargarlos a la lista del almacen.
        for (IProducto prod : lisProductos) {
            // creamos el nodo a partir del producto.
            INodo<IProducto> nodoProd = new Nodo<IProducto>(prod.getCodigoProd(), prod);
            // lo insertamos en la lista del almacen.
            almacen.insertarProducto(nodoProd);
        }

        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        // Ruta y nombres de los archivos.
        String ruta = "C:\\AED1-Marce21\\RepoMarcelo\\UT0-Estructuras\\src\\almacen_archivos\\";
        String nombreArchivo = "productos.txt";

        // Crear los datos desde un archivo.
        String[] lineasArchivo = ManejadorArchivosGenerico.leerArchivo(ruta + nombreArchivo);
        for (String linea : lineasArchivo) {

            String[] datos = linea.split(",");
            // creamos el producto.
            IProducto unProd = new Producto(Integer.parseInt(datos[0]), datos[1], Double.parseDouble(datos[2]), Integer.parseInt(datos[3]));
            // Insertamos en la lista a partir del producto.
            almacen.insertarProducto(unProd);
        }

        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    }
}
