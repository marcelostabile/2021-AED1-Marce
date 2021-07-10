public class opeWhileLetras {

    public void ContadorLetra() {

        String cadena = "banana";
        char letraBuscada = 'a';

        int largo = cadena.length();
        int contador = 0;

        int indice = 0;
        while (indice<largo) {
            if (cadena.charAt(indice) == letraBuscada) {
                contador++;
            }
            indice++;
        }
        System.out.print(contador);
    }
}
