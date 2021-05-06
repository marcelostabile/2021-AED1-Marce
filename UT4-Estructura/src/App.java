import tdas.*;

public class App {

    public static void main(String[] args) throws Exception {

        System.out.println("Comenzando...");

        ArbolBB<Integer> arbolEnteros = new ArbolBB<>();

        int[] elementos = { 15,7,20,3,9,18,24,1,4,12,17 };

        for (int i : elementos) {
            ElementoAB<Integer> unElemento = new ElementoAB<Integer>(i, i);
            arbolEnteros.insertar(unElemento);
        }

        System.out.println("\nEnteros\n");

        String resPreOrden = arbolEnteros.preOrden();
        String resPostOrden = arbolEnteros.postOrden();
        String resInOrden = arbolEnteros.inOrden();

        System.out.println("PreOrden: " + resPreOrden);
        System.out.println("PostOrden: " + resPostOrden);
        System.out.println("InOrden: " + resInOrden);

        System.out.println("Altura: " + arbolEnteros.obtenerAltura());
        System.out.println("Tamaño: " + arbolEnteros.obtenerTamano());
        System.out.println("Hojas: " + arbolEnteros.obtenerHojas());

        System.out.println("Internos: " + arbolEnteros.obtenerInternos());
        System.out.println("Internos Completos: " + arbolEnteros.obtenerInternosCompletos());

        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        ArbolBB<String> arbolLetras = new ArbolBB<>();

        String[] elem2 = { "T", "Y", "U", "P", "L", "K", "J", "S", "A", "Z", "X", "C", "V", "N" };

        for (String i : elem2) {
            ElementoAB<String> unElemento = new ElementoAB<String>(i, i);
            arbolLetras.insertar(unElemento);
        }

        String resPreOrden2 = arbolLetras.preOrden();
        String resPostOrden2 = arbolLetras.postOrden();
        String resInOrden2 = arbolLetras.inOrden();

        System.out.println("\nLetras\n");

        System.out.println("PreOrden: " + resPreOrden2);
        System.out.println("PostOrden: " + resPostOrden2);
        System.out.println("InOrden: " + resInOrden2);

        System.out.println("Altura: " + arbolLetras.obtenerAltura());
        System.out.println("Tamaño: " + arbolLetras.obtenerTamano());
        System.out.println("Hojas: " + arbolLetras.obtenerHojas());

        System.out.println("Internos: " + arbolLetras.obtenerInternos());
        System.out.println("Internos Completos: " + arbolLetras.obtenerInternosCompletos());

        System.out.println("Finalizado.");

    }
}
