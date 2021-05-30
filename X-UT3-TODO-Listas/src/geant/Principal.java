package geant;

import archivos.*;
import tdas.*;

public class Principal {
    
    public void main () {
        
        String ruta = "C:\\AED1-Marce21\\RepoMarcelo\\UT0-Estructuras\\src\\geant_archivos\\";
        String[] archivoAltas = ManejadorArchivosGenerico.leerArchivo(ruta + "altas.txt");
        String[] archivoVentas = ManejadorArchivosGenerico.leerArchivo(ruta + "ventas.txt");
        String[] archivoElim = ManejadorArchivosGenerico.leerArchivo(ruta + "elim.txt");

        // Creamos el almacen.
        Almacen alm = new Almacen();

        // Alta de productos.
        alm.altaProducto(archivoAltas);
        System.out.println(alm.getValorActualAlmacen());
        System.out.println(alm.cantidadProductos());

        // Venta de productos.
        alm.ventaProductos(archivoVentas);
        System.out.println(alm.getValorActualAlmacen());
        System.out.println(alm.cantidadProductos());

        // Eliminar productos.
        alm.eliminarProductos(archivoElim);
        System.out.println(alm.getValorActualAlmacen());
        System.out.println(alm.cantidadProductos());

        // Listar productos ordenados por nombre.
        alm.listarOrdenadoPorNombre();

        // UT3-TA13 Búsqueda por nombre parcial.
        System.out.println("Buscar1");
        String resultado1 = alm.buscarPorNombreParcial("Tang");
        System.out.println(resultado1);

        System.out.println("Buscar2");
        String resultado2 = alm.buscarPorNombreParcial("Royal");
        System.out.println(resultado2);

    }
}
