package TA3;

public class Principal {

    /* TA3-EJ2*/
    public static void pruebaContadorPalabras () {

        ContadorPalabras cp = new ContadorPalabras();

        String frase1 = "Una imagen vale mil palabras.";
        System.out.println(frase1);
        System.out.println(cp.contarPalabras(frase1));

        String frase2 = "Si piensas que tu profesor es malo, espera a conocer a tu jefe.";
        System.out.println(frase2);
        System.out.println(cp.contarPalabras(frase2));
    }

    /* TA3-EJ3 */
    public static void pruebaObtenerLineas (String[] args) {

        ContadorPalabras cp = new ContadorPalabras();

        if (args.length >= 1) {    // Controlamos que nos pasaron los argumentos en el main.
            
            String[] lineasArchivo = cp.obtenerLineas(args[0]);
            int cantPalabrasTotal = cp.cantPalabras(lineasArchivo);
            System.out.println("Cantidad de palabras del archivo: " + cantPalabrasTotal);
        }
    }
}
