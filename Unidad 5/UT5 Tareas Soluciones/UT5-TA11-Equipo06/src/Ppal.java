import clases.*;
import tdas.*;
import archivo.*;
public class Ppal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /* Crear el arbol de libros, el arbol inicial de autores y el arbol que sera el optimo
        */
        TArbolLibros libreria = new TArbolLibros(); //arbol en donde van a estar todos los libros por isbn
        TArbolBB<Autor> autoresBase = new TArbolBB(); // cargamos todos los autores aca para luego calcular las frecuencias
        TArbolAutores autoresOptimo = new TArbolAutores(); // este va a ser el optimo
        
        /* Cargar los libros en la libreria a partir del archivo "libros.txt” Cada línea tiene ISBN y titulo
         * Cargar los autores a partir  del archivo "autoresLibreria-Libros.txt” 
         * Cada línea tiene nombre de autor e ISBN de libro. 
         * A cada autor asociar sus libros. A cada libro asociar sus autores.
        */
        cargarDatos(libreria, autoresBase); //que hace esto!!!
        
        /*Utilizando el archivo "busquedasGlobalesAutores", calcular las frecuencias de búsquedas exitosas y no exitosas 
        */
        cargarFrecuencias(autoresBase);
        
        /* Crear los vectores necesarios, cargarle los datos calculados en el arbol base inicial
         * Calcular los valores de las matrices a partir de los vestores de datos
         * Armar el árbol de busqueda óptimo para los autores
        */
        armarABO(autoresBase, autoresOptimo);
        
        /* dado un autor, emitir una lista con los títulos de sus libros 
         * y generar un archivo de salida "autor-libros.txt"
        */
        String elAutor = "Edward P. Jones";
        Lista<Libro> librosDelAutor = autoresOptimo.listarTitulos(elAutor);
        salidaLibrosDelAutor(librosDelAutor, elAutor);
        
        /* dado un ISBN de libro, emitir una lista con los nombres de sus autores 
         * y generar un archivo de salida "libros-autor.txt"
         */
        String idLibro = "097669400X";
        Lista<Autor> autoresLibro = libreria.autoresDelLibro(idLibro);
        salidaAutoresDelLibro(autoresLibro, idLibro);
        
        /* listar todos libros ordenados por ISBN, con t[itulo y todos los coautores de cada libro 
         * y generar un archivo de salida "salida-todosLosLibros.txt"
         */
        String[] todosLosLibros = libreria.librosConAutores();
        ManejadorArchivosGenerico.escribirArchivo("UT5-TA11/src/salida-todosLosLibros.txt",todosLosLibros); 

        System.out.println(autoresOptimo.altura());
        System.out.println(autoresOptimo.obtenerTamanio());
        System.out.println(autoresOptimo.preOrden());

    } // Fin del metodo "main"

    // comienzan los metodos estaticos auxiliars del main
    
    public static void cargarDatos(TArbolLibros libreria, TArbolBB<Autor> autores) {
        /*
         * Crear los libros  y cargarlos en la libreria a partir
         * del archivo "libros.txt” Cada línea tiene ISBN y titulo
         */
        String[] archivo1 = ManejadorArchivosGenerico.leerArchivo("UT5-TA11/src/libros.txt");
        for (String linea : archivo1) {
            String[] reg = linea.split(",");
            try{
                Libro librito = new Libro(reg[0], reg[1]);
                TElementoAB<Libro> unLibro = new TElementoAB<>(reg[0], librito);
                libreria.insertar(unLibro);
            }catch(IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
            
        }

        /*
         * Crear los autores y cargarlos en la lista de autores a partir
         * del archivo "autores.txt” Cada línea tiene nombre de autor e ISBN de libro
         */
        String[] archivo2 = ManejadorArchivosGenerico.leerArchivo("UT5-TA11/src/autoresLibreria-Libros.txt");
        for (String linea : archivo2) {
            String[] reg = linea.split(",");
            try{
                TElementoAB<Autor> autorEncontrado = autores.buscar(reg[0]);
                Autor unAutor;
                if (autorEncontrado==null){
                    unAutor = new Autor(reg[0]);
                }else{
                    unAutor = autorEncontrado.getDatos();
                }
                TElementoAB<Libro> librito = libreria.buscar(reg[1]);
                if (librito != null)
                {
                    unAutor.agregarLibro(librito.getDatos());
                    librito.getDatos().agregarAutor(unAutor);
                }
                TElementoAB<Autor> elAutor = new TElementoAB<>(reg[0], unAutor);
                autores.insertar(elAutor);
            }catch(IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        }

    } // Fin del metodo cargarDatos

    public static void cargarFrecuencias(TArbolBB<Autor> autoresBase) {
        
        //aca usas el txt busquedasGlobalesAutores
        String[] arch = ManejadorArchivosGenerico.leerArchivo("UT5-TA11/src/busquedasGlobalesAutores.txt");
        for (String nombre : arch) {
            autoresBase.cuentaFrec(nombre);
        }
    } //Fin del metodo cargarFrecuencias
    
    public static void armarABO(TArbolBB autoresBase, TArbolAutores losAutores){
        int tamano  = autoresBase.obtenerTamanio() + 1;
        CalculadorMatricesOptimo calculadora = new CalculadorMatricesOptimo(tamano-1);
        int[] frecExito = new int[tamano];
        int[] frecNoExito = new int[tamano];

        TElementoAB<Autor>[] array = new TElementoAB[tamano];

        autoresBase.completaVectores(array, frecExito, frecNoExito);
        calculadora.encontrarOptimo(tamano-1, frecExito, frecNoExito);
        calculadora.armarArbolBinario(0, tamano-1 , array , losAutores);
        System.out.println(losAutores.calcularCosto(frecExito, frecNoExito));
    }//fin del metodo armarABO
    
    public static void salidaLibrosDelAutor(Lista<Libro> librosDelAutor, String elAutor) {
        String[] salida = (elAutor+"-"+librosDelAutor.imprimir("-")).split("-");
        ManejadorArchivosGenerico.escribirArchivo("autor-libros.txt", salida);
    }// fin del metodo de generar la salida de los libros por autor
    
    public static void salidaAutoresDelLibro(Lista<Autor> losAutores, String idLibro){
        String[] salida =(idLibro+"-"+losAutores.imprimir("-")).split("-");
        ManejadorArchivosGenerico.escribirArchivo("libro-autores.txt", salida);
    }// fin del metodo de generar la salida de los autores de un libro

} //fin de la clase main
