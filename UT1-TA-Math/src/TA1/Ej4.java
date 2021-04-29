package TA1;

public class Ej4 {

    public static void Ejercicio4 () {
        
        int aNumber = -1;

        // Código original 

        /*
        if (aNumber >= 0)
        if (aNumber == 0)
        System.out.println("first string");
        else System.out.println("second string");
        System.out.println("third string");
        */

        // En la primera sentencia se ejecutar el if, que contiene el otro if.

        // Si aNumbre es 0, se imprime: first y third thing.
        // Si aNumbre es mayor de cero: se imprime second y third
        // si aNumbre es menor a cero se oprime third.

        // siempre se imprime third

        if (aNumber >= 0)
            if (aNumber == 0)
                System.out.println("first string");
            else System.out.println("second string");
        
        System.out.println("third string");
    }
}