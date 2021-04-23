import procesador.*;

public class Principal {

    public static void main(String[] args) throws Exception {

        System.out.println("* * * Comenzando ejecución...");

        String directorioBase = "C:\\AED1-Marce21\\WIS-ErrorFile\\src\\";
        String archivoReporte = "Reporte de Errores.txt";

        procesadorArchivos.procesarArchivos(directorioBase, archivoReporte);

        System.out.println("* * * Ejecución finalizada. * * *");
    }
}
