public class App {
    public static void main(String[] args) throws Exception {

        Fibonacci f = new Fibonacci();
        Factorial f1 = new Factorial();

        System.out.println("Factorial Iterativo!");
        System.out.println("resultado 9: "+ f1.iterativo(9));

        System.out.println("Factorial Recursivo!");
        System.out.println("resultado 9: "+ f1.recursiva(9));

        System.out.println("Fibonacci Binario!");
        System.out.println(f.binario(6));
        System.out.println("contador de fibonacci binario de 6: "+ f.contadorBinario);

        System.out.println("Fibonacci Lineal!");
        System.out.println(f.lineal(6)[0]);
        System.out.println("contador de fibonacci lineal de 6: "+ f.contadorLineal);
    }
    
}
