import tdas.*;
import archivos.*;
import institucion.Examen;
import metodos.*;

public class Principal {

    public static void main(String[] args) throws Exception {

        System.out.println("Comenzado...");

        Examen exa = new Examen();

        exa.main();
        
        System.out.println("Finalizado.");
    }
}
