import almacen.*;
import archivos.*;
import tdas.*;
import asistencia.*;

import java.util.*;

public class Principal {
    public static void main(String[] args) throws Exception { 

        System.out.println("Iniciando procesamiento...");

        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        almacen.Principal almacenPrincipal = new almacen.Principal();
        almacenPrincipal.main();

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        asistencia.Principal asistenciaPrincipal = new asistencia.Principal();
        asistenciaPrincipal.main();

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        pilas_colas.Principal pilacolaPrincipal = new pilas_colas.Principal();
        pilacolaPrincipal.main();
        
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        geant.Principal geantPrincipal = new geant.Principal();
        geantPrincipal.main();
        
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        System.out.println("Finalizado.");
    }

}
