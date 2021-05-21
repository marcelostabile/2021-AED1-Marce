package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import src.*;
import src.tdas.*;

public class AlmacenTest {

    private Almacen almacenNormal;
    private Almacen vacio;
    private Almacen unicoItem;

    @BeforeEach
    public void setUp() throws Exception {

        unicoItem = new Almacen("devoto");
        vacio = new Almacen("Geant");
        almacenNormal = new Almacen("Tienda Inglesa");

        almacenNormal.insertarProducto(new Producto(12345, "ades"));
        almacenNormal.insertarProducto(new Producto(54656, "galletas"));
        almacenNormal.insertarProducto(new Producto(75689, "agua"));
        almacenNormal.insertarProducto(new Producto(35146, "fernet"));
        almacenNormal.insertarProducto(new Producto(79865, "coquita"));
        almacenNormal.insertarProducto(new Producto(98731, "jamon"));
        almacenNormal.insertarProducto(new Producto(78954, "fafita"));

        unicoItem.insertarProducto(new Producto(12345, "papita"));
    }

    //insertar producto almacen vacio
    @Test
    @DisplayName("Test para validar que se inserta bien un producto cuando el almacen esta vacio")
    public void testInsertarProductoAlmacenVacio() {
        vacio.insertarProducto(new Producto(45654, "cosas"));
        assertEquals(1, vacio.cantidadProductos(), "Deberia de haber 1 solo producto");
    }
    //insertar producto almacen con productos
    @Test
    @DisplayName("Test para validar que se inserta bien un producto cuando el almacen no esta vacio")
    public void testInsertarProductoAlmacenNoVacio() {
        Integer cantidadProd = almacenNormal.cantidadProductos() + 1;
        almacenNormal.insertarProducto(new Producto(45654, "cosas"));
        assertEquals(cantidadProd, almacenNormal.cantidadProductos(), "Deberia de ");
    }
    //cantidadProductos
    @Test
    @DisplayName("Test para validar la cantidad de productos del almacen")
    public void testCantidadProductos() {
        assertEquals(1, unicoItem.cantidadProductos());
        assertEquals(7, almacenNormal.cantidadProductos());
        assertEquals(0, vacio.cantidadProductos());
    }
    //imprimirProductos
    @Test
    @DisplayName("Test para validar que imprime los productos")
    public void testImprimirPrductos() {
        assertEquals("", vacio.imprimirProductos(),"Deberia de dar un string vacio");
        assertTrue(!"".equals(almacenNormal.imprimirProductos()),"Deberia de dar un string diferente de vacio");
    }
    //agregarStock
    @Test
    @DisplayName("Test para validar que no agrega stock")
    public void testAgregarStockAlmacenVacio() {
        assertEquals(false, vacio.agregarStock(12132, 564654), "Deberian de no poder agregar el stock");
    }

    @Test
    @DisplayName("Test para validar que agrega stock")
    public void testAgregarStockAlmacenNormal() {
        assertEquals(true, almacenNormal.agregarStock(12345, 654546654), "Deberia de agregar el stock");
    }
    //restarStock
    @Test
    @DisplayName("Test para validar que no resta stock")
    public void testRestarStockAlmacenVacio() {
        assertEquals(0, vacio.restarStock(12132, 564654), "Deberia de no poder restar el stock");
    }
    @Test
    @DisplayName("Test para validar que resta stock y elimina el producto")
    public void testRestarStockAlmacenConUnProducto() {
        unicoItem.restarStock(12345, 12313544);
        assertEquals(0, vacio.cantidadProductos(), "Deberia de dar 0 los productos");
    }
    @Test
    @DisplayName("Test para validar que resta stock")
    public void testRestarStockAlmacenNormal() {
        almacenNormal.agregarStock(12345, 1000000);
        assertEquals(1000000-564654, almacenNormal.restarStock(12345, 564654), "Deberia restar el stock");
    }
    //buscarPorCodigo
    @Test
    @DisplayName("Test para validar que no encuentra el producto")
    public void testBuscarPorCodigoEnAlmacenVacio() {
        assertEquals(null, vacio.buscarPorCodigo(123456), "Deberia de dar vacio");
    }
    @Test
    @DisplayName("Test para validar que encuentra el producto")
    public void testBuscarPorCodigoEnAlmacenNormal() {
        assertTrue(null != almacenNormal.buscarPorCodigo(12345), "Deberia de no dar vacio");
    }
    //eliminarProducto
    @Test
    @DisplayName("Test para verificar que al eliminar un producto que no existe, devuelve false")
    public void testEliminarProdNoExiste() {
        Integer cantidadProductos = almacenNormal.cantidadProductos();
        assertTrue(!almacenNormal.eliminarProducto(11111111), "Deberia devolver falso porque el almacen esta vacio");
        assertEquals(cantidadProductos, almacenNormal.cantidadProductos());
    }
    @Test
    @DisplayName("Test para verificar que al eliminar un producto que existe, devuelve true")
    public void testEliminarProdExiste() {
        Integer cantidadProd = almacenNormal.cantidadProductos();
        almacenNormal.eliminarProducto(12345);
        assertEquals(cantidadProd -1, almacenNormal.cantidadProductos(), "Deberia devolver true porque al eliminar un item la cantidad de productos baja 1");
    }
    @Test
    @DisplayName("Test para verificar que al eliminar el unico producto del almacen")
    public void testEliminarUnicoProducto() {
        unicoItem.eliminarProducto(12345);
        assertEquals(0, unicoItem.cantidadProductos(), "Deberia devolver true porque eliminamos el unico item del almacen");
    }
    @Test
    @DisplayName("Test para verificar que al eliminar producto del almacen vacio")
    public void testEliminarProductoAlmacenVacio() {
        assertEquals(false, vacio.eliminarProducto(12345), "Deberia devolver true porque el almacen no tiene productos");
    }
    //getProductosEnLista
    @Test
    @DisplayName("Test para validar que te devuelve una Lista<T> ")
    public void testGetProductosEnLista() {
        assertTrue(almacenNormal.getProductosEnLista() instanceof Lista<?> , "Deberia devolver true");
    }
    //listaOrdenadaDescripcion
    @Test
    @DisplayName("Test para validar que la lista este ordenada")
    public void testListaOrdenadaDescripcion() {
        String[] lista = almacenNormal.listaOrdenadaDescripcion();
        int contador = 0;
        for (int i=0 ; i < lista.length ; i++) {
            if(i<lista.length-1 && lista[i].compareTo(lista[i+1])<0){
                contador++;
            }
        }
        assertEquals(lista.length-1, contador,"Deberia de dar la misma cantidad que la lista, ya que siempre seria verdadera la condicion");
    }
}