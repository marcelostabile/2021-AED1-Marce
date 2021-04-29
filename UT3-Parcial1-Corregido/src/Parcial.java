import mutualista.*;
import archivos.*;
import tdas.*;
import implementacionesParcial.*;

public class Parcial {
    public static void main(String[] args) throws Exception {

        System.out.println("Bienvenidos al primer parcial de Algoritmos y estructuras de datos 1 - 2021" + "\n");

        // Parte 2

        String ruta = "C:\\AED1-Marce21\\RepoMarcelo\\UT3-Parcial1\\src\\";

        // 2. Cargar el archivo de consultas agendadas del día. 

        Lista<IConsulta> consultasDelDia = new Lista<>();

        String[] consultaAgendadas = ManejadorArchivosGenerico.leerArchivo(ruta + "consultas.txt");
        for (String linea : consultaAgendadas) {
            String[] reg = linea.split(";");
            IConsulta consulta = new Consulta(reg[0], reg[1], reg[2], reg[3], reg[4]);
            INodo<IConsulta> nodo = new Nodo<IConsulta>( (Comparable) consulta.getEspecialidadConsulta(), consulta);
            consultasDelDia.insertar(nodo);
        }
        System.out.println("Registros ingresados: " + consultasDelDia.cantElementos());

        // 3. Instanciar y cargar los médicos de la Policlínica A y Policlínica B

        Conjunto<IMedico> medicosPoliclinicaA = new Conjunto<>();

        String[] poliA = ManejadorArchivosGenerico.leerArchivo(ruta + "policlinicaA.txt");
        for (String linea : poliA) {
            String[] reg = linea.split(";");
            IMedico medico = new Medico(reg[0], reg[1], reg[2]);
            INodo<IMedico> nodo = new Nodo<>( (Comparable) medico.getIDMedico(), medico);
            medicosPoliclinicaA.insertar(nodo);
        }
        System.out.println("Registros ingresados: " + medicosPoliclinicaA.cantElementos());

        Conjunto<IMedico> medicosPoliclinicaB = new Conjunto<>();

        String[] poliB = ManejadorArchivosGenerico.leerArchivo(ruta + "policlinicaB.txt");
        for (String linea : poliB) {
            String[] reg = linea.split(";");
            IMedico medico = new Medico(reg[0], reg[1], reg[2]);
            INodo<IMedico> nodo = new Nodo<>( (Comparable) medico.getIDMedico(), medico);
            medicosPoliclinicaB.insertar(nodo);
        }
        System.out.println("Registros ingresados: " + medicosPoliclinicaB.cantElementos());

        // // 4. Obtener la lista de consultas de una especialidad, ordenada por apellido e imprimirlas en pantalla. 
        SociedadMedica unaSociedad = new SociedadMedica();
        ListaOrdenada<IConsulta> listaConsultasPorEspecialidad = unaSociedad.obtenerConsultasPorEspecialidad("Dermatología", consultasDelDia);
        
        System.out.println("Total de consultas encontradas: " + listaConsultasPorEspecialidad.cantElementos());

        unaSociedad.obtenerConsultasPorEspecialidad("Traumatología", consultasDelDia);
        
        // System.out.println(listaConsultasPorEspecialidad.cantElementos());
        // // 5. Obtener una lista de médicos, ordenado por apellido, que trabajan en una u otra policlínica, pero no en las dos e imprimirlas en pantalla.
        
    }

}
