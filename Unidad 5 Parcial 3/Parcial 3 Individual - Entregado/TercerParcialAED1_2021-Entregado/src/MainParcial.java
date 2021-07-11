import com.ucudal.implementacionesParcial.*;
import com.ucudal.productora.*;
import com.ucudal.tdas.*;
import com.ucudal.utils.*;

public class MainParcial {

    public static void main(String[] args){

        /* Crear el arbol de películas, el arbol inicial de actores y el arbol que sera el optimo
         */
        TArbolBB<Film> peliculas = new TArbolBB(); //arbol en donde van a estar todas las películas por id
        TArbolBB<Actor> actoresBase = new TArbolBB(); // cargamos todos los actores aca para luego calcular las frecuencias
        TArbolActores actoresOptimo = new TArbolActores(); // este va a ser el optimo

        /* Cargar las peliculas a partir del archivo "peliculas.txt”. Cada línea tiene id y titulo
         * Cargar los actores a partir  del archivo "actores.txt”. Cada línea tiene nombre de actor y id de la pelicula
         * A cada actor asociar sus películas y a cada película asociar sus actores.
         */
        cargarDatos(peliculas, actoresBase);

        /*Utilizando el archivo "busquedas", calcular las frecuencias de búsquedas exitosas y no exitosas
         */
        cargarFrecuencias(actoresBase);

        /* Crear los vectores necesarios, cargarle los datos calculados en el arbol base inicial
         * Calcular los valores de las matrices a partir de los vectores de datos
         * Armar el árbol de busqueda óptimo para los actores
         */
        armarABO(actoresBase, actoresOptimo);

        /*Obtener la lista de los actores que trabajaron con cierto actor
         * cada uno con la lista de peliculas que comparten
         */
        String elActor = "Susana";
        Lista<Actor> coactores = actoresOptimo.todosLosCoProtagonistas(elActor);
        salidaCoActores(coactores,elActor);

    }

    public static void cargarDatos(TArbolBB<Film> pelis, TArbolBB<Actor> actores) {

        String ruta = "src/";

        // peliculas
        String[] archivo = ManejadorArchivosGenerico.leerArchivo(ruta + "peliculas.txt");

        for (String linea : archivo) {
            String[] reg = linea.split(",");
            if (reg.length == 3) {
                Film film = new Film(reg[0], reg[1], reg[2]);
                IElementoAB<Film> unFilm = new TElementoAB<Film>(reg[0], film);
                pelis.insertar(unFilm);
            }
        }

        // actores
        String[] archivo2 = ManejadorArchivosGenerico.leerArchivo(ruta + "actores.txt");

        for (String linea : archivo2) {
            String[] reg = linea.split(",");
            if (reg.length == 2) {

                IElementoAB<Actor> actorEncontrado = actores.buscar(reg[0]);
                Actor unActor;
                if (actorEncontrado == null) {
                    unActor = new Actor(reg[0]);
                } else {
                    unActor = actorEncontrado.getDatos();
                }
                IElementoAB<Film> film = pelis.buscar(reg[1]);
                if (film != null) {
                    unActor.agregarFilm(film.getDatos());
                    film.getDatos().agregarActor(unActor);
                }
                IElementoAB<Actor> elActor = new TElementoAB<>(reg[0], unActor);
                actores.insertar(elActor);
            }
        }
    }

    public static void cargarFrecuencias(TArbolBB<Actor> actoresBase) {
        String[] arch = ManejadorArchivosGenerico.leerArchivo("src/busquedas.txt");
        for (String nombre : arch) {
            actoresBase.cuentaFrec(nombre);
        }
    }

    public static void armarABO(TArbolBB actoresBase, TArbolActores losActores){
        int tamano = actoresBase.obtenerTamanio() + 1;
        CalculadorMatricesOptimo calculadora = new CalculadorMatricesOptimo(tamano - 1);
        int[] frecExito = new int[tamano];
        int[] frecNoExito = new int[tamano];

        IElementoAB<Actor>[] array = new TElementoAB[tamano];

        actoresBase.completaVectores(array, frecExito, frecNoExito);
        calculadora.encontrarOptimo(tamano - 1, frecExito, frecNoExito);
        calculadora.armarArbolBinario(0, tamano - 1, array, losActores);
    }

    public static void salidaCoActores(Lista<Actor> losActores, String actor){
        String[] salida = (actor + "-" + losActores.imprimir("-")).split("-");
        ManejadorArchivosGenerico.escribirArchivo("src/salida_actor_coautores.txt", salida);
    }
}
