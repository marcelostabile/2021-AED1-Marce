import java.util.*;
import archivos.ManejadorArchivosGenerico;
import implementacionesParcial.*;
import mutualista.*;
import tdas.*;

public class Parcial {
    public static void main(String[] args) throws Exception {

        System.out.println("Bienvenidos al segundo parcial de Algoritmos y estructuras de datos 1 - 2021");

        String ruta = "src//";

        // Parte 3
        // 1. Instanciar un árbol TArbolBBS y cargar los socios a partir del archivo “entrada.txt”.
        // 2. Obtener la lista de especialidades.
        
        TArbolBBS arbolSocios = new TArbolBBS();
        Lista<Especialidad> listaEspecialidades = new Lista<>();

        String[] archivo = ManejadorArchivosGenerico.leerArchivo(ruta + "Consultas.txt");
        for (String linea : archivo) {
            // socio
            String[] reg = linea.split(",");
            Socio socio = new Socio(reg[0], reg[1], reg[2]);   // 1,Rodriguez,Traumatologia
            IElementoAB<Socio> unElemento = new TElementoAB<Socio>(socio.getCedula(), socio);      
            arbolSocios.insertar(unElemento);
            // especialidad
            if (listaEspecialidades.buscar(reg[2]) == null) {
                Especialidad especialidad = new Especialidad(reg[2]);
                INodo<Especialidad> nodoEspecialidad = new Nodo<Especialidad>(reg[2], especialidad);
                listaEspecialidades.insertar(nodoEspecialidad);
            }
        }

        // árbol de socios: arbolSocios.
        //System.out.println(arbolSocios.esVacio());

        // lista de especialidades: listaEspecialidades.
        //System.out.println(listaEspecialidades.cantElementos());

        // le paso la lista de especialidades al metodo armarIndicesEspecialidadese .
        arbolSocios.armarIndicesEspecialidades(listaEspecialidades);

        String cedulaSocio = "11"; 

        // 3. A partir de una nueva especialidad que se indicará:
        String especialidadDestino = "Traumatologia";
        //String especialidadDestino = "Traumatología";

        //   a. Generar un archivo de salida de nombre “nuevaAntes.txt” en donde se listen los socios inscriptos 
        //      en la especialidad destino (ordenados por nombre, solamente el nombre, un nombre por línea). 
        List<String> sociosInscriptos = new ArrayList<>();

        INodo<Especialidad> nodoEsp = listaEspecialidades.getPrimero();
        while (nodoEsp != null) {
            if (nodoEsp.getDato().getNombreEspecialidad().compareTo(especialidadDestino) == 0) {
                // agregar a la lista el nombre de la especialidad
                sociosInscriptos.add(nodoEsp.getDato().getNombreEspecialidad() + ":");
                // Lista de socios
                Lista<Socio> listaSocios = nodoEsp.getDato().getIndiceSociosEspecialidad().inorden();
                // agregar a la lista los socios ordenados por apellido
                INodo<Socio> nodoSocio = listaSocios.getPrimero();
                while (nodoSocio != null) {
                    sociosInscriptos.add(nodoSocio.getDato().getApellido());
                    nodoSocio = nodoSocio.getSiguiente();
                }
            }
            nodoEsp = nodoEsp.getSiguiente();
        }
        ManejadorArchivosGenerico.escribirArchivo(ruta + "nuevaAntes.txt", sociosInscriptos.toArray(new String[0]));

        //   b. Invocar el método cambioConsulta (con los parámetros de cedulaSocio y especialidadDestino definidos arriba).

        //   c. Generar un archivo de salida de nombre “nuevaDespues.txt” en donde se listen los socios 
        //      inscriptos en la especialidad destino (ordenados por nombre, solamente el nombre, un nombre por línea). 

    }
}
