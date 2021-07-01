package TA2;

public class SumarParImpar {

    /*
    Evaluamos si el número es primo.
    Si es primo, sumar los nros pares comprendidos entre 0 y el nro dado.
    Si no es primo, sumar los nros impares.

    Lo que haremos es evaluar la condición e inicializar el resultado de acuerdo a la condición cumplida.
    Si es primo, resultado inicializa en 0 y se suma de dos en dos.
    Si no es primo, a resultado le sumo 1 y luego sumo de dos en dos.
    */
    public static int sumarNumeros (int nro) {

        int resultado = 0;
        int contador = 0;

        if ( !UtilMath.isPrime(nro)) {
            contador++;
            System.out.println("El nro " + nro + " no es primo.");
        } else {
            System.out.println("El nro " + nro + " es primo.");
        }

        while (contador <= nro) {
            resultado += contador;
            contador += 2;
        }
        return resultado;
    }
}
