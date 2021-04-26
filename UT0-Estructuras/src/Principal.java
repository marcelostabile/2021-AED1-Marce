import almacen.*;
import archivos.*;
import tdas.*;
import asistencia.*;
import conjuntos.*;

import java.util.*;

public class Principal {
    public static void main(String[] args) throws Exception { 

        System.out.println("Iniciando procesamiento..." + "\n");

        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        System.out.println("* * Almacen * * ");

        almacen.Principal almacenPrincipal = new almacen.Principal();
        almacenPrincipal.main();
        System.out.println("\n");

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        System.out.println("* * Asistencia Médica * * ");

        asistencia.Principal asistenciaPrincipal = new asistencia.Principal();
        asistenciaPrincipal.main();
        System.out.println("\n");

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        System.out.println("* * Pilas - Colas * * ");

        pilas_colas.Principal pilacolaPrincipal = new pilas_colas.Principal();
        pilacolaPrincipal.main();
        System.out.println("\n");
        
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        System.out.println("* * Conjuntos * * ");

        conjuntos.Principal conjuntosPrincipal = new conjuntos.Principal();
        conjuntosPrincipal.main();
        System.out.println("\n");
        
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        System.out.println("* * Geant * * ");

        geant.Principal geantPrincipal = new geant.Principal();
        geantPrincipal.main();
        System.out.println("\n");
        
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        System.out.println("Finalizado.");

    }

}
