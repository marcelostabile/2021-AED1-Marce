package conjuntos;

import java.util.ArrayList;

public class Conjuntos {
    
    /**
    * UNION
    * El conjunto UNION contiene todos los elementos del conjunto A y del conjunto B.
    * 
    * Lenguaje Natural:
    * Recibimos dos listas conteniendo los conjuntos (listaConjuntoA y listaConjuntoB).
    * Creamos una lista (listaConjuntoUnion).
    * Recorremos la lista del conjunto A y los agregamos a la lista resultado (listaConjuntoUnion).
    * Recorremos la lista del conjunto B, para cada elemento revisamos si ya existe en la lista resultado.
    * Si existe pasamos al siguiente elemento, si no existe agregamos el elemento a la lista resultado.
    * Devolvemos la lista de resultado (listaConjuntoUnion).
    */
    public static ArrayList<Integer> union(ArrayList<Integer> listaConjuntoA, ArrayList<Integer> listaConjuntoB) {

        ArrayList<Integer> listaConjuntoUnion = new ArrayList<>();    // Esta es lista resultado.

        for (int elemA : listaConjuntoA) {    // Recorremos lista A y la agregamos a la lista resultado.
            listaConjuntoUnion.add(elemA);
        }
        for (int elemB : listaConjuntoB) {    // Recorremos lista B, verificamos si existe en la lista resultado, si no existe lo agregamos.
            if (! listaConjuntoUnion.contains(elemB)) { listaConjuntoUnion.add(elemB); }
        }
        return listaConjuntoUnion;    // Retornamos la lista resultado.
    }

    /**
    * INTERSECCIÓN
    * El conjunto INTERSECCIÓN contiene todos los elementos comunes de ambos conjuntos.
    * 
    * Lenguaje Natural:
    * Recibimos dos listas conteniendo los conjuntos (listaConjuntoA y listaConjuntoB).
    * Creamos tres listas: listaConjuntoInterseccion, listaAuxiliar1 y listaAuxiliar2.
    * Verificamos el largo de ambas listas, referenciamos la lista más corta a la listaAuxiliar1 y la lista más larga a la listaAuxiliar2.
    * Si son iguales, no importa el orden, hacemos conjunto A en listaAuxiliar1, conjunto B en listaAuxiliar2.
    * Esto nos permite recorrer la lista más corta, para cada elemento verificamos si existe en la lista más larga, 
    * si existe lo agregamos a la lista resultado. Una vez finalizamos de recorrer la lista mas corta devolvemos la lista resultado.
    * Evaluar a partir de la lista más corta nos permite recorrer menos veces que al reves. 
     */
    public static ArrayList<Integer> interseccion(ArrayList<Integer> listaConjuntoA, ArrayList<Integer> listaConjuntoB) {

        ArrayList<Integer> listaConjuntoInterseccion = new ArrayList<>();    // Esta es lista resultado.
        ArrayList<Integer> listaAuxiliar1 = new ArrayList<>();
        ArrayList<Integer> listaAuxiliar2 = new ArrayList<>();

        if (listaConjuntoA.size() <= listaConjuntoB.size()) {    // Listas iguales o la lista más corta en listaAuxiliar1, la otra en listaAuxiliar2.
            listaAuxiliar1 = listaConjuntoA;
            listaAuxiliar2 = listaConjuntoB;
        } else {
            listaAuxiliar1 = listaConjuntoB;
            listaAuxiliar2 = listaConjuntoA;            
        }

        for (int elem : listaAuxiliar1) {    // Para cada elemento que existe en ambas lista, lo agregamos a la lista resultado.
            if (listaAuxiliar2.contains(elem)) { listaConjuntoInterseccion.add(elem); }
        }
        return listaConjuntoInterseccion;    // Retornamos la lista resultado.
    }

    /**
    * DIFERENCIA
    * El conjunto DIFERENCIA contiene elementos de A que no pertenecen al conjunto B.
    * 
    * Lenguaje Natural:
    * Recibimos dos listas conteniendo los conjuntos (listaConjuntoA y listaConjuntoB).
    * Creamos una lista (listaConjuntoDiferencia).
    * Recorremos la lista del conjunto A, para cada elemento verificamos si existe en la lista del conjunto B,
    * si no existe agregamos el elemento a la lista resultado, si existe pasamos al siguiente elemento.
    * Cuando terminamos de recorrer, devolvemos la lista resultado.
     */
    public static ArrayList<Integer> diferencia(ArrayList<Integer> listaConjuntoA, ArrayList<Integer> listaConjuntoB) {

        ArrayList<Integer> listaConjuntoDiferencia = new ArrayList<>();    // Esta es lista resultado.

        for (int elem : listaConjuntoA) {    // Para cada elemento de lista conjunto A, verificamos que no exista en el conjunto B y lo agregamos.
            if (! listaConjuntoB.contains(elem)) { listaConjuntoDiferencia.add(elem); }
        }
        return listaConjuntoDiferencia;    // Retornamos la lista resultado.
    }

    /**
    * DIFERENCIA SIMÉTRICA
    * El conjunto DIFERENCIA SIMÉTRICA contiene los elementos de A y B que no son comunes.
    * 
    * Lenguaje Natural:
    * Recibimos dos listas conteniendo los conjuntos (listaConjuntoA y listaConjuntoB).
    * Creamos una lista (listaConjuntoDifSimetrica).
    * Recorremos la lista del conjunto A, para cada elemento verificamos si existe en la lista del conjunto B,
    * si no existe agregamos el elemento a la lista resultado, si existe pasamos al siguiente elemento.
    * Recorremos la lista del conjunto B, para cada elemento verificamos que no exista en el conjunto A o en la lista resultado (no duplicados).
    * si elemento no existe, agregamos el elemento a la lista resultado.
    * Cuando terminamos de recorrer, devolvemos la lista resultado.
     */
    public static ArrayList<Integer> diferenciaSimetrica(ArrayList<Integer> listaConjuntoA, ArrayList<Integer> listaConjuntoB) {

        ArrayList<Integer> listaConjuntoDifSimetrica = new ArrayList<>();    // Esta es lista resultado.

        for (int elem1 : listaConjuntoA) {    // Para cada elemento de lista conjunto A, verificamos que no exista en el conjunto B y lo agregamos.
            if (! listaConjuntoB.contains(elem1)) { listaConjuntoDifSimetrica.add(elem1); }
        }
        for (int elem2 : listaConjuntoB) {    // Recorremos el conjunto B, si elemento no está en el conjunto A o el elemento no está en la lista resultado, lo agrego.
            if (! listaConjuntoA.contains(elem2) && ! listaConjuntoDifSimetrica.contains(elem2)) { listaConjuntoDifSimetrica.add(elem2); }
        }
        return listaConjuntoDifSimetrica;    // Retornamos la lista resultado.
    }

    /** 
    * COMPLEMENTO
    * El conjunto COMPLEMENTO son todos los elementos que no pertenecen al conjunto A.
    * 
    * Lenguaje Natural:
    * Recibimos una lista contenido el conjunto A (listaConjuntoA).
    * Recibimos un valor "desde" y un valor "hasta" para definir un rango "universo".
    * Creamos una lista (listaConjuntoComplemento).
    * Recorremos el rango ingresado, para cada elemento verificamos si existe en el conjunto A, 
    * si no existe, agregamos el elemento a la lista resultado.
    * Cuando terminamos devolvemos la lista resultado.
     */
    public static ArrayList<Integer> complementoConjuntoA(ArrayList<Integer> listaConjuntoA, int rangoDesde, int rangoHasta) {

        ArrayList<Integer> listaConjuntoComplemento = new ArrayList<>();    // Esta es lista resultado.

        for (int nro = rangoDesde; nro <= rangoHasta; nro++) {
            if (! listaConjuntoA.contains(nro)) { listaConjuntoComplemento.add(nro); }
        }
        return listaConjuntoComplemento;    // Retornamos la lista resultado.
    }

    /**
    * PRODUCTO CARTESIANO
    * El conjunto PRODUCTO CARTESIANO A x B contiene todos los pares ordenados (a,b) cuyo primer elemento 
    * pertenece a A y su segundo elemento pertenece a B.
    * Ejem. A={1,2,3,4} B={a,b} Resultado AxB={(1,a),(1,b),(2,a),(2,b),(3,a),(3,b),(4,a),(4,b)}
    * 
    * Recibimos dos listas conteniendo los conjuntos (listaConjuntoA y listaConjuntoB).
    * Creamos una lista (listaProductoCartesiano).
    * Recorremos la lista del conjunto A, para cada elemento recorremos el conjunto B y por cada valor guardamos un par ordenado (a, b)
    * que luego guardamos en la lista resultado. 
    * Cuando terminamos devolvemos la lista resultado.
     */
    public static ArrayList<int[]> productoCartesiano(ArrayList<Integer> listaConjuntoA, ArrayList<Integer> listaConjuntoB) {

        ArrayList<int[]> listaProductoCartesiano = new ArrayList<>();    // Esta es lista resultado.

        int[] parOrdenado = new int[2];    // Par ordenado.

        for (int elemA : listaConjuntoA) {
            for (int elemB : listaConjuntoB) {
                parOrdenado[0] = elemA;
                parOrdenado[1] = elemB;
                listaProductoCartesiano.add(parOrdenado);
            }
        }
        return listaProductoCartesiano;    // Retornamos la lista resultado.
    }

    /**
     * Imprimir los valores de un ArrayList por consola.
     */
    public static void imprimir(ArrayList<Integer> listaRecibida) {

        for (Integer elem : listaRecibida) {
            System.out.println(elem);
        }
    }

    /**
     * Imprimir los valores de un ArrayList por consola.
     */
    public static void imprimirProductoCartesiano(ArrayList<int[]> listaRecibida) {

        System.out.println("Cant. elementos: " + listaRecibida.size());

        for (int i=0; i<10; i++) {
            System.out.println("E1: " + elem[0]);
            System.out.println("E2: " + elem[1]);

            System.out.println("(" + elem[0] + "," + elem[1] + ")");
        }
    }
}