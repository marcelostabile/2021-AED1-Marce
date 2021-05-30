import aplicacion.*;
import habitacion.*;

public class App {

    public static void main(String[] args) throws Exception {

        System.out.println("Comenzando.");

        /**
         * Creación de las habitaciones.
         */
        Habitacion escritorio = new Habitacion("Escritorio");
        // Techo
        escritorio.agregarTecho("Techo", 2, 2);
        // Pared
        escritorio.agregarPared("Pared Norte", 2, 2);
        escritorio.agregarPared("Pared Sur", 2, 2);
        escritorio.agregarPared("Pared Este", 2, 2);
        escritorio.agregarPared("Pared Oeste", 2, 2);
        // Piso
        escritorio.agregarPiso("Piso", 2, 2);
        // Aberturas
        escritorio.agregarAbertura("Ventana", 2, 2);
        escritorio.agregarAbertura("Puerta", 2, 2);


        // /**
        //  * Carga de medidas.
        //  * Habitación(str), Nombre(str), Largo(dou), Ancho(dou)
        //  */
        // String[] datosEscritorio = ManejadorArchivosGenerico.leerArchivo("datosEscritorio.txt");
        // String[] datosDormPrincipal = ManejadorArchivosGenerico.leerArchivo("datosDormPrincipal.txt");
        // String[] datosDormSecundario = ManejadorArchivosGenerico.leerArchivo("datosDormSecundario.txt");

        System.out.println("Finalizado.");
    }
}
