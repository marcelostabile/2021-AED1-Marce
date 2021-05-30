import universidad.*;
import tdas.*;
import archivos.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        // crear un nuevo TArbolBBU de nombre "ucu" 
        TArbolBBU ucu = new TArbolBBU();

        // cargar los alumnos en el árbol "ucu" desde el archivo de datos "datos.txt"
        // 123,Abadie,Psicología
        String ruta = "src//";
        String[] archivo1 = ManejadorArchivosGenerico.leerArchivo(ruta + "Datos.txt");
        for (String linea : archivo1) {
            String[] reg = linea.split(",");
            Alumno unAlumno = new Alumno(Integer.parseInt(reg[0]), reg[1], reg[2]);
            TElementoAB<Alumno> unElemento = new TElementoAB<Alumno>(unAlumno.getCodigo(), unAlumno);
            ucu.insertar(unElemento);
        }

        // crear una nueva lista de carreras.
        // lo hago en un arbol para evitar revisar por cada registro si existe, elimino los repetidos.
        TArbolBB<Carrera> arbolCarreras = new TArbolBB<>();

        Lista<Alumno> alumnos = ucu.inorden();
        Nodo<Alumno> alum = alumnos.getPrimero();
        while (alum != null) {
            Carrera carrera = new Carrera(alum.getDato().getCarrera());
            TElementoAB<Carrera> unElemento = new TElementoAB<>(carrera.getNombreCarrera(), carrera);
            arbolCarreras.insertar(unElemento);
            alum = alum.getSiguiente();
        }
        System.out.println(arbolCarreras.obtenerTamanio());
        System.out.println(arbolCarreras.inorden().imprimir());

        // invocar el método armarIndicesCarreras
        Lista<Carrera> carreras = new Lista<>();
        ucu.armarIndicesCarreras(carreras);

        // escribir el archivo "unaCarrera.txt" con el nombre de la carrera indicada
        String carreraIngresada = "Psicología";

        List<String> salida = new ArrayList<>();
        salida.add(carreraIngresada + ":");

        TArbolBB<Alumno> arbolAlumnosOrdenados = new TArbolBB<>();
        Nodo<Carrera> carrera = carreras.buscar(carreraIngresada.trim());
        if (carrera != null) {   // verifico que la carrera existe.
                        
            Lista<Alumno> listaAlumnos = carrera.getDato().getIndiceCarrera().inorden();
            Nodo<Alumno> alumno = listaAlumnos.getPrimero();
            while (alumno != null) {
                arbolAlumnosOrdenados.insertar(new TElementoAB<Alumno>(alumno.getDato().getApellido(), alumno.getDato()));
                alumno = alumno.getSiguiente();
            }
        }
        Lista<Alumno> listaAlumnosOrdenados = arbolAlumnosOrdenados.inorden();
        Nodo<Alumno> nodoAlumno = listaAlumnosOrdenados.getPrimero();
        while (nodoAlumno != null) {
            salida.add(nodoAlumno.getDato().getCodigo() + "," + nodoAlumno.getDato().getApellido() + "," + nodoAlumno.getDato().getCarrera());
            nodoAlumno = nodoAlumno.getSiguiente();
        }
        ManejadorArchivosGenerico.escribirArchivo(carreraIngresada + ".txt", salida.toArray(new String[0]));


        // escribir el archivo "todasCarreras.txt"
        List<String> todaslasCarreras = new ArrayList<>();
        TArbolBB<Alumno> arbolTodosOrdenados = new TArbolBB<>();
        // Recorro la lista de carreras.
        Nodo<Carrera> nodoCarrera = carreras.getPrimero();
        while (nodoCarrera != null) {
            todaslasCarreras.add(nodoCarrera.getDato().getNombreCarrera() + ":");
            // Para cada carrera, ordeno los alumnos alfabeticamente y los agrego a la salida.
            Lista<Alumno> listaAlumnos = nodoCarrera.getDato().getIndiceCarrera().inorden();
            nodoAlumno = listaAlumnos.getPrimero();
            while (nodoAlumno != null) { 
                arbolTodosOrdenados.insertar(new TElementoAB<Alumno>(nodoAlumno.getDato().getApellido(), nodoAlumno.getDato()));
                nodoAlumno = nodoAlumno.getSiguiente();                
            }
            // Salida ordenada.
            Lista<Alumno> listaAlumOrdenada = arbolTodosOrdenados.inorden();
            Nodo<Alumno> alumno = listaAlumOrdenada.getPrimero();
            while (alumno != null) {
                todaslasCarreras.add(alumno.getDato().getApellido() + "," + alumno.getDato().getCodigo() + "," + alumno.getDato().getCarrera());
                alumno = alumno.getSiguiente();
            }
            nodoCarrera = nodoCarrera.getSiguiente();
        }
        ManejadorArchivosGenerico.escribirArchivo("TodasCarreras.txt", todaslasCarreras.toArray(new String[0]));
    }

}

