public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        

        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/palabras.txt");
        int cantElementos = lineas.length;

        CalculadorMatricesOptimo calculadorABO = new CalculadorMatricesOptimo(cantElementos);
        
        // cargar CLAVES y FRECUENCIAS DE BUSQUEDAS EXITOSAS
        
        
        String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("src/nopalabras.txt");
        
        // cargar FRECUENCIAS DE BUSQUEDAS NO EXITOSAS
        
        calculadorABO.encontrarOptimo(cantElementos, frecExito, frecNoExito);

        // IMPRIMIR RAIZ A PARTIR DE MATRIZ R
        
        //
        // MOSTRAR MATRIZ R
        System.out.println("Matriz R: ");
       Util.imprimirMatriz(abo.R);
         // MOSTRAR MATRIZ P
       System.out.println("Matriz P: ");
        Util.imprimirMatriz(abo.P);
         // MOSTRAR MATRIZ W
        System.out.println("Matriz W: ");
       Util.imprimirMatriz(abo.W);

       // IMPRIMIR COSTO DEL ARBOL OPTIMO A PARTIR DE VALOR DE LA MATRIZ P
        //
        
        // AHORA ARMAR EL ARBOL BINARIO DE BUSQUEDA CORRESPONDIENTE
        TArbolBB elABO = new TArbolBB();

        calculadorABO.armarArbolBinario(0, cantElementos, claves, elABO);
       
        
        // MOSTRAR PREORDEN DEL ARBOL BB RESULTANTE
        
        // COMPROBAR EL COSTO HALLADO EN LA MATRIZ P CON LA EJECUCION DEL METODO DE CALCULAR COSTO DEL ARBOL

        System.out.println("costo del arbol iterando: " + elABO.calcularCosto(frecExito, frecNoExito));


    }
    }


