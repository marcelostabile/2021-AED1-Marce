import mutualista.*;
import archivos.*;
import tdas.*;
import implementacionesParcial.*;

public class Parcial {
    public static void main(String[] args) throws Exception {

        System.out.println("Bienvenidos al primer parcial de Algoritmos y estructuras de datos 1 - 2021");

        // Parte 2

        String ruta = "C:\\PrimerParcialAED1_2021\\src\\";

        // 2. Cargar el archivo de consultas agendadas del día. 
        Lista<IConsulta> consultasDelDia = new Lista<>();

        String[] consultaAgendadas = ManejadorArchivosGenerico.leerArchivo(ruta + "consultas.txt");

        for (String linea1 : consultaAgendadas) {
            String[] registro1 = linea1.split(";");
            IConsulta consulta = new Consulta(registro1[0].toString(), registro1[1], registro1[2], registro1[3], registro1[4]);
            INodo<IConsulta> nodoConsulta = new Nodo<IConsulta>( (Comparable) consulta.getApellidoPaciente(), consulta);
            consultasDelDia.insertar(nodoConsulta);
        }

        // 3. Instanciar y cargar los médicos de la Policlínica A y Policlínica B
        Conjunto<IMedico> medicosPoliclinicaA = new Conjunto<>();

        String[] poliA = ManejadorArchivosGenerico.leerArchivo(ruta + "policlinicaA.txt");

        for (String linea2 : poliA) {
            String[] registro2 = linea2.split(";");
            IMedico medico = new Medico(registro2[0],registro2[1],registro2[2]);
            INodo<IMedico> nodo = new Nodo<>(medico.getIDMedico(), medico);
            medicosPoliclinicaA.insertar(nodo);
        }

        Conjunto<IMedico> medicosPoliclinicaB = new Conjunto<>();

        String[] poliB = ManejadorArchivosGenerico.leerArchivo(ruta + "policlinicaB.txt");
        for (String linea2 : poliB) {
            String[] registro2 = linea2.split(";");
            IMedico medico = new Medico(registro2[0],registro2[1],registro2[2]);
            INodo<IMedico> nodo = new Nodo<>(medico.getIDMedico(), medico);
            medicosPoliclinicaB.insertar(nodo);
        }

        // 4. Obtener la lista de consultas de una especialidad, ordenada por apellido e imprimirlas en pantalla. 
        SociedadMedica unaSociedad = new SociedadMedica();
        ListaOrdenada<IConsulta> listaConsultasPorEspecialidad = unaSociedad.obtenerConsultasPorEspecialidad("", consultasDelDia);
        
        System.out.println(listaConsultasPorEspecialidad.cantElementos());
        // 5. Obtener una lista de médicos, ordenado por apellido, que trabajan en una u otra policlínica, pero no en las dos e imprimirlas en pantalla.
        
    }

}
