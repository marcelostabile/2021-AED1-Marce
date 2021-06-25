public class Fibonacci {

    public static int contadorLineal = 0;
    public static int contadorBinario = 0;

    // función recursiva -- O(N)
    public static Integer[] lineal(int k) {
        if(k == 0 ){
            Integer result[] = { 0, 0 };
            return result;
        }
        // O(N), siendo N k
        if (k == 1) { // O(1)
            Integer result[] = { k, 0 }; // O(1)
            return result; // O(1)
        } else {
            contadorLineal++; // O(1)
            Integer result[] = lineal(k - 1);
            Integer aux = result[0] + result[1]; // O(1)
            result[1] = result[0]; // O(1)
            result[0] = aux; // O(1)
            return result; // O(1)
        }

    }

    // función recursiva -- O(2^N)
    public static int binario(int n) {
        // N siendo el numero n
        if (n > 1) {
            contadorBinario += 2;
            return binario(n - 1) + binario(n - 2); 
        } else if (n == 1) { // caso base -- O(1)
            return 1; // O(1)
        } else if (n == 0) { // caso base -- O(1)
            return 0; // O(1)
        } else {
            return -1; // O(1)
        }
    }

}