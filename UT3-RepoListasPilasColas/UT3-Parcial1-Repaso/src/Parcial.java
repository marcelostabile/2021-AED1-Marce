import javax.swing.Icon;

import archivos.*;
import implementacionesParcial.*;
import mutualista.*;
import tdas.*;

public class Parcial {
    public static void main(String[] args) throws Exception {

        System.out.println("Bienvenidos al primer parcial de Algoritmos y estructuras de datos 1 - 2021");

        // Parte 2

        String ruta = "C:\\AED1-Marce21\\RepoMarcelo\\UT3-RepoListasPilasColas\\UT3-Parcial1-Repaso\\src\\";

        // 2. Cargar el archivo de consultas agendadas del día. 
        // idMedico;apellidoPaciente;diaYHora;codPoliclinica;especialidadConsulta

        Lista<IConsulta> consultasDelDia = new Lista<>();

        String[] archivo = ManejadorArchivosGenerico.leerArchivo(ruta + "consultas.txt");
        for (String linea : archivo) {
            System.out.println(linea);
            String[] reg = linea.split(";");
                // Instanciar elemento, instanciar nodo, agregar a lista.
                IConsulta registro = new Consulta(reg[0].trim(), reg[1].trim(), reg[2].trim(), 
                                                    reg[3].trim(), reg[4].trim());
                INodo<IConsulta> nodo = new Nodo<IConsulta>((Comparable) registro.getEspecialidadConsulta(), registro);
                consultasDelDia.insertar(nodo);
        }

        // 3. Instanciar y cargar los médicos de la Policlínica A y Policlínica B
        // idMedico;nombre;apellido

        Conjunto<IMedico> medicosPoliclinicaA = new Conjunto<>();

        String[] archivo2 = ManejadorArchivosGenerico.leerArchivo(ruta + "policlinicaA.txt");

        for (String linea : archivo2) {
            String[] aux = linea.split(";");
            IMedico registro = new Medico(aux[0],aux[1],aux[2]);
            INodo<IMedico> nodo = new Nodo<IMedico>((Comparable) registro.getApellido(), registro);
            medicosPoliclinicaA.insertar(nodo);
        }

        Conjunto<IMedico> medicosPoliclinicaB = new Conjunto<>();

        String[] archivo3 = ManejadorArchivosGenerico.leerArchivo(ruta + "policlinicaB.txt");

        for (String linea : archivo3) {
            String[] aux = linea.split(";");
            IMedico registro = new Medico(aux[0],aux[1],aux[2]);
            INodo<IMedico> nodo = new Nodo<IMedico>((Comparable) registro.getApellido(), registro);
            medicosPoliclinicaA.insertar(nodo);
        }

        // 4. Obtener la lista de consultas de una especialidad, ordenada por apellido e imprimirlas en pantalla. 
        SociedadMedica unaSociedad = new SociedadMedica();
        ListaOrdenada<IConsulta> listaConsultasPorEspecialidad = unaSociedad.obtenerConsultasPorEspecialidad("", consultasDelDia);
        
        // 5. Obtener una lista de médicos, ordenado por apellido, que trabajan en una u otra policlínica, pero no en las dos e imprimirlas en pantalla.
        
    }

}
