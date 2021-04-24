import tdas.*;

public class Principal {
    public static void main(String[] args) throws Exception {

        int a = 9;
        int b = 25;

        IParOrdenado<Integer, Integer> par1 = new ParOrdenado<>(a, b);

        String d = "cadena";
        int c = 100;

        IParOrdenado<String, Integer> par2 = new ParOrdenado<String,Integer>(d, c);

        System.out.println(par1.getClave() + "," + par1.getValor());
        System.out.println(par2.getClave() + "," + par2.getValor());    
    }
}
