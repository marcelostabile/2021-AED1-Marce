package TA1;

public class ArithmeticDemo {

    public static void main (String[] args){
       
        int result = 1 + 2; // result is now 3
        System.out.println("Original: " + result);

        // Mejorado: escribir directo el resultado de una operación sin variables.
        int result2 = 3;
        System.out.println(result2);


        result = result - 1; // result is now 2
        System.out.println("Original: " + result);

        // Mejorado: -=
        System.out.println(result2 -= 1);


        result = result * 2; // result is now 4
        System.out.println("Original: " + result);

        // Mejorado: *=
        System.out.println(result2 *= 2);


        result = result / 2; // result is now 2
        System.out.println("Original: " + result);

        //Mejorado:
        System.out.println(result2 /= 2);


        result = result + 8; // result is now 10
        result = result % 7; // result is now 3
        System.out.println("Original: " + result);

        // Mejorado:
        System.out.println((result2 += 8) % 7);

        System.out.println("Parte 2");
        int a = 5;
        int i = 3;
        int resA = a+=++i;

        System.out.println("Primero se realiza el ++i  3 + 1 = " + i);
        System.out.println("Luego se suma a = a + " + i + " = 9");
        System.out.println(resA);

        System.out.println("Parte 3");
    
            int j = 3;
            j++;
            System.out.println(j); // "4"
            ++j;
            System.out.println(j); // "5"
            System.out.println(++j); // "6" se incrementa antes de la ejecusión
            System.out.println(j++); // "6" se incrementa luego de la ejecusión
            System.out.println(j); // "7"
    }
}