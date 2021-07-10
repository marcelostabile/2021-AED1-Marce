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
                Especialidad esp = new Especialidad(reg[2]);
                INodo<Especialidad> especialidad = new Nodo<Especialidad>(reg[2], esp);
                listaEspecialidades.insertar(especialidad);
            }
        }
        arbolSocios.armarIndicesEspecialidades(listaEspecialidades);

        //System.out.println(arbolSocios.esVacio());
        //System.out.println(listaEspecialidades.cantElementos());

        String especialidadDestino = "Traumatología";
        String cedulaSocio = "11"; 

        

        // 3. A partir de una nueva especialidad que se indicará:
        //   a. Generar un archivo de salida de nombre “nuevaAntes.txt” en donde se listen los socios inscriptos 
        //      en la especialidad destino (ordenados por nombre, solamente el nombre, un nombre por línea). 
        
        
        //   b. Invocar el método cambioConsulta (con los parámetros de cedulaSocio y especialidadDestino definidos arriba).

        //   c. Generar un archivo de salida de nombre “nuevaDespues.txt” en donde se listen los socios 
        //      inscriptos en la especialidad destino (ordenados por nombre, solamente el nombre, un nombre por línea). 

    }
}
