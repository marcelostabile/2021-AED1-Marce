public class Factorial {

    public static int iterativo(int n) {
        // O(N), N es n
        if(n == 0){
            return 1;
        }
        int fact = n; // O(1)
        while (n > 1) { // O(N)
            n = n - 1; // O(1)
            fact = fact * n; // O(1)
        }
        return fact; // O(1)
    }

    public static int recursiva(int n) {
        if (n == 0) {
            return 1; // caso base --- O(1)
        } else {
            return n * recursiva(n - 1); // caso recursivo --- O(N)
        }
        // Seria de Orden N, siendo N el numero a calcular su factoria
    }

}
