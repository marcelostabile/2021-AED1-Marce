import mutualista.*;
import archivos.*;
import tdas.*;
import implementacionesParcial.*;

public class Parcial {
    public static void main(String[] args) throws Exception {

        System.out.println("Bienvenidos al primer parcial de Algoritmos y estructuras de datos 1 - 2021" + "\n");

        // Parte 2

        // 2. Cargar el archivo de consultas agendadas del día. 

        String ruta = "C:\\AED1-Marce21\\RepoMarcelo\\UT3-Parcial1-Corregido\\src\\";

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

        // Policlínica A.

        Conjunto<IMedico> medicosPoliclinicaA = new Conjunto<>();

        String[] poliA = ManejadorArchivosGenerico.leerArchivo(ruta + "policlinicaA.txt");
        for (String linea : poliA) {
            String[] reg = linea.split(";");
            IMedico medico = new Medico(reg[0], reg[1], reg[2]);
            INodo<IMedico> nodo = new Nodo<>( (Comparable) medico.getIDMedico(), medico);
            medicosPoliclinicaA.insertar(nodo);
        }
        System.out.println("Registros ingresados: " + medicosPoliclinicaA.cantElementos());

        // Policlínica B.

        Conjunto<IMedico> medicosPoliclinicaB = new Conjunto<>();

        String[] poliB = ManejadorArchivosGenerico.leerArchivo(ruta + "policlinicaB.txt");
        for (String linea : poliB) {
            String[] reg = linea.split(";");
            IMedico medico = new Medico(reg[0], reg[1], reg[2]);
            INodo<IMedico> nodo = new Nodo<>( (Comparable) medico.getIDMedico(), medico);
            medicosPoliclinicaB.insertar(nodo);
        }
        System.out.println("Registros ingresados: " + medicosPoliclinicaB.cantElementos() + "\n");

        // // 4. Obtener la lista de consultas de una especialidad, ordenada por apellido e imprimirlas en pantalla.

        SociedadMedica unaSociedad = new SociedadMedica();

        ListaOrdenada<IConsulta> listaConsultasPorEspecialidad = unaSociedad.obtenerConsultasPorEspecialidad("Dermatología", consultasDelDia);
        
        INodo<IConsulta> cons = listaConsultasPorEspecialidad.getPrimero();
        while (cons != null) {
            String paciente = cons.getDato().getApellidoPaciente();
            String diaYHora = cons.getDato().getDiaYHora();
            String policlinica = cons.getDato().getCodPoliclinica();
            String medico = cons.getDato().getIDMedicoConsulta();
            String especialidad = cons.getDato().getEspecialidadConsulta();
            System.out.println("Apellido: " + paciente + ", Fecha: " + diaYHora + ", Policlínica: " + policlinica + ", médico: " + medico + ", Especialidad: " + especialidad);
            cons = cons.getSiguiente();
        }
        System.out.println("Total de consultas encontradas: " + listaConsultasPorEspecialidad.cantElementos() +"\n");

        // // 5. Obtener una lista de médicos, ordenado por apellido, que trabajan en una u otra policlínica, pero no en las dos e imprimirlas en pantalla.
        Conjunto<IMedico> medicosPorApellido = new Conjunto<>();
        medicosPorApellido = medicosPoliclinicaA.diferenciaSimetrica(medicosPoliclinicaB);
        
        ListaOrdenada<IMedico> listaOrdenadaMedicos = new ListaOrdenada<>();

        INodo<IMedico> medicoActual = medicosPorApellido.getPrimero();

        while (medicoActual != null) {
            INodo<IMedico> drTemp = new Nodo<IMedico>( (Comparable) medicoActual.getDato().getApellido(), medicoActual.getDato());
            listaOrdenadaMedicos.insertar(drTemp);
            medicoActual = medicoActual.getSiguiente();
        }

        System.out.println("Imprimiendo lista de médicos:");
        INodo<IMedico> actual = listaOrdenadaMedicos.getPrimero();
        while (actual != null) {
            System.out.println(actual.getDato().getApellido() + ", " + actual.getDato().getNombre() + ", " + actual.getDato().getIDMedico());
            actual = actual.getSiguiente();
        }

    }

}
