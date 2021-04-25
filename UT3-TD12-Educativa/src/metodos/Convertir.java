package metodos;

import java.util.*;

public class Convertir {

    public static List<String> convertir_ArraytoList (String[] unArray) {
        // String[] unArray = new String[] { valor1, valor2, valor3 };
        List<String> miLista = Arrays.asList(unArray);
        return miLista;
    }

    public static ArrayList<String> convertir_ArraytoArrayList(String[] unArray) {
        // String[] unArray = new String[] { valor1, valor2, valor3 };
        ArrayList<String> miArrayList = new ArrayList<>();
        for (String registro : unArray) {
            miArrayList.add(registro);
        }
        return miArrayList;
    }

}
