import com.ucudal.implementacionesParcial.CalculadorMatricesOptimo;
import com.ucudal.implementacionesParcial.TArbolActores;
import com.ucudal.implementacionesParcial.TArbolBB;
import com.ucudal.implementacionesParcial.TElementoAB;
import com.ucudal.productora.Actor;
import com.ucudal.productora.Film;
import com.ucudal.tdas.IElementoAB;
import com.ucudal.tdas.INodo;
import com.ucudal.tdas.Lista;
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
        // TODO: Completar en el parcial
        String[] archivo1 = ManejadorArchivosGenerico.leerArchivo("src/peliculas.txt");
        for (String linea : archivo1) {
            String[] reg = linea.split(",");
            if(reg.length == 3){
                pelis.insertar(new TElementoAB<>(reg[0],new Film(reg[0],reg[1],reg[2])));
            }
        }

        String[] archivo2 = ManejadorArchivosGenerico.leerArchivo("src/actores.txt");
        for (String linea : archivo2) {
            String[] reg = linea.split(",");
            if(reg.length == 2){
                IElementoAB<Actor> actor = actores.buscar(reg[0]);
                IElementoAB<Film> film = pelis.buscar(reg[1]);
                if(actor == null) {
                    actor  = new TElementoAB<>(reg[0],new Actor(reg[0]));
                }
                if(film != null){
                    actor.getDatos().agregarFilm(film.getDatos());
                    actores.insertar(new TElementoAB<>(actor.getEtiqueta(),actor.getDatos()));
                    film.getDatos().agregarActor(actor.getDatos());
                }
                actores.insertar(new TElementoAB<>(actor.getEtiqueta(),actor.getDatos()));
            }
        }
    }

    public static void cargarFrecuencias(TArbolBB<Actor> actoresBase) {
        // TODO: Completar en el parcial
        String[] lines = ManejadorArchivosGenerico.leerArchivo("src/busquedas.txt");
        for (String line : lines) {
            actoresBase.cuentaFrec(line);
        }
    }

    public static void armarABO(TArbolBB actoresBase, TArbolActores losActores){
        // TODO: Completar en el parcial
        int tamanio = actoresBase.obtenerTamanio() + 1;
        CalculadorMatricesOptimo calculadora = new CalculadorMatricesOptimo(tamanio - 1);
        int[] frecExito = new int[tamanio];
        int[] frecNoExito = new int[tamanio];

        IElementoAB<Integer>[] elementos = new TElementoAB[tamanio];

        actoresBase.completaVectores(elementos, frecExito, frecNoExito);
        calculadora.encontrarOptimo(tamanio - 1, frecExito, frecNoExito);
        calculadora.armarArbolBinario(0, tamanio - 1, elementos, losActores);
    }

    public static void salidaCoActores(Lista<Actor> losActores, String actor){
        // TODO: Completar en el parcial
        //String[] salida = (actor + "-" + losActores.imprimir("-")).split("-");
        String[] salida = new String[(losActores.cantElementos())*2+1];
        salida[0] = "Los actores que trabajaron con " + actor + " son:";
        int contador = 1;
        INodo<Actor> actual = losActores.getPrimero();
        while(actual != null) {
            salida[contador] = "\t"+actual.getDato().getNombre()+" en la(s) película(s):";
            contador++;
            INodo<Film> filmActual = actual.getDato().getFilms().getPrimero();
            String filmes = "\t\t";
            while(filmActual!=null){
                if(filmActual.getSiguiente()!=null){
                    filmes += filmActual.getDato().getTitulo()+";";
                }else{
                    filmes += filmActual.getDato().getTitulo();
                }
                filmActual = filmActual.getSiguiente();
            }
            salida[contador] = filmes;
            contador++;
            actual = actual.getSiguiente();
        }

        ManejadorArchivosGenerico.escribirArchivo("salida_coactores.txt", salida);
    }
}
