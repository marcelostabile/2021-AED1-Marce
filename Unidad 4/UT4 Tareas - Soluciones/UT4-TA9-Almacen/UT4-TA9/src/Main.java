import archivos.*;
import tdas.*;

import java.util.Arrays;

import almacen.*;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

      String ruta = "src//almacen//";

      // árbol del almacen.
      Almacen almacen = new Almacen("GEANT");

      // cargar los productos desde el archivo "altasprueba.txt"
      // 1000001,ADES� DURAZNO�,140,75
      String[] altas = ManejadorArchivosGenerico.leerArchivo(ruta + "altas.txt");
      for (String linea : altas) {
        String[] reg = linea.split(",");
        // Si no existe el producto lo ingresa como nuevo, sino agregamos stock.
        Producto elProducto = almacen.buscarPorCodigo( (Comparable) Integer.parseInt(reg[0]));
        if (elProducto == null) {
          Producto unProducto = new Producto(Integer.parseInt(reg[0]), reg[1].trim());
          unProducto.setPrecio(Integer.parseInt(reg[2]));
          unProducto.setStock(Integer.parseInt(reg[3]));
          almacen.insertarProducto(unProducto);
        } else {
          elProducto.agregarStock(Integer.parseInt(reg[3]));
        }
      }

      //emitir el valor del stock
      System.out.println("Valor del Stock: " + almacen.valorStock());

      // listar los productos ordenados por codigo, junto con su cantidad existente
      Lista<Producto> listaProductos = almacen.listaProductosXCodigo();
      Nodo<Producto> nodoProducto = listaProductos.getPrimero();
      while (nodoProducto != null) {
        String linea =  nodoProducto.getDato().getEtiqueta() 
                + "," + nodoProducto.getDato().getNombre() 
                + "," + nodoProducto.getDato().getStock();
        System.out.println(linea);
        nodoProducto = nodoProducto.getSiguiente();
      }

      //emitir el valor del stock
      System.out.println("Valor del Stock: " + almacen.valorStock());

      // simular las ventas a partir del archivo "ventaspruebas.txt"
      // 1000073,550
      String[] ventas = ManejadorArchivosGenerico.leerArchivo(ruta + "ventas.txt");
      for (String linea : ventas) {
        String[] reg = linea.split(",");
        almacen.restarStock( (Comparable) Integer.parseInt(reg[0]), Integer.parseInt(reg[1]));
      }

      //emitir el valor del stock
      System.out.println("Valor del Stock: " + almacen.valorStock());
      
      // simular la eliminación de productos a partir del archivo "elimPrueba.txt"
      // 1000073
      String[] elim = ManejadorArchivosGenerico.leerArchivo(ruta + "elimPrueba.txt");
      for (String linea : elim) {
        String[] reg = linea.split(",");
        almacen.eliminarProducto( (Comparable) Integer.parseInt(reg[0]));
      }

      //emitir el valor del stock
      System.out.println("Valor del Stock: " + almacen.valorStock());
 
      // Generar archivo de salida.
      ManejadorArchivosGenerico.escribirArchivo(ruta + "productos.txt", almacen.listaOrdenadaDescripcion());

      // Para imprimir el string[]
      String[] resultado2 = almacen.listaOrdenadaDescripcion();
      String str = Arrays.toString(resultado2);
      System.out.println(str);

      // Dado un código de producto, indicar si existe y el stock disponible.
      System.out.println("Consulta 1000008: " + almacen.consultaCodigo(1000008)); 
      System.out.println("Consulta 9595: " + almacen.consultaCodigo(9595));

    }
}

