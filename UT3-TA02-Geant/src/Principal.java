import archivos.*;
import tdas.*;
import geant.*;

public class Principal {

    public static void main(String[] args) throws Exception {

        System.out.println("Comenzando ejecución UT3_TA2");

        /*
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();String[] contenidoArchivo = manejadorArchivos.leerArchivo("C:\\Users\\santi\\Documents\\GitHub\\Algoritmos\\aed1-ut3-ta2-equipo-6-2021\\src\\altas.txt");
        String[] contenidoArchivo1 = manejadorArchivos.leerArchivo("C:\\Users\\santi\\Documents\\GitHub\\Algoritmos\\aed1-ut3-ta2-equipo-6-2021\\src\\ventas.txt");
        String[] contenidoArchivo2 = manejadorArchivos.leerArchivo("C:\\Users\\santi\\Documents\\GitHub\\Algoritmos\\aed1-ut3-ta2-equipo-6-2021\\src\\elim.txt");
        */

        String ruta = "C:\\AED1-Marce21\\RepoMarcelo\\UT3-TA02-Geant\\src\\archivos\\";
        String[] archivoAltas = ManejadorArchivosGenerico.leerArchivo(ruta + "altas.txt");
        String[] archivoVentas = ManejadorArchivosGenerico.leerArchivo(ruta + "ventas.txt");
        String[] archivoElim = ManejadorArchivosGenerico.leerArchivo(ruta + "elim.txt");

        // Alta de productos.
        Almacen alm = new Almacen();
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
        System.out.println("Bucar1");
        String resultado1 = alm.buscarPorNombreParcial("Tang");
        System.out.println(resultado1);

        System.out.println("Bucar2");
        String resultado2 = alm.buscarPorNombreParcial("Royal");
        System.out.println(resultado2);
    }

}