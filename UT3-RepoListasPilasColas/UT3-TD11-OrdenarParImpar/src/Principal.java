import almacen.*;
import tdas.*;

public class Principal {
    public static void main(String[] args) throws Exception {

        System.out.println("Comenzando procesamiento...");

        // Origen de datos.
        int[] listaDesordenada = {4,71,3,6,12,8,35,11,22,17};

        // Lista Resultado.
        ILista<Integer> listaResultado  = new Lista<>();

        // Instanciamos la clase Almacen.
        IAlmacen almacen = new Almacen();

        // Carga de datos en la lista desordenada del almacen.
        for (int elem : listaDesordenada) {
            INodo<Integer> nodo = new Nodo<Integer>(elem, elem);
            almacen.insertarArticuloUltimo(nodo);
        }

        // Obtener resultados.
        listaResultado = almacen.ordenaParesImpares();

        // Imprimir anterior y resultado.
        System.out.println("Imprimiendo Etiquetas (Original / Común / Incl. separadores)");
        almacen.getListaDesordenada().imprimir();
        listaResultado.imprimir();
        listaResultado.imprimir(",");

        System.out.println("Finalizado.");
    }
}
