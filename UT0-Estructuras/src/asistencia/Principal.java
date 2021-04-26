package asistencia;

import archivos.*;
import tdas.*;

public class Principal {

    public void main() {

        String ruta2 = "C:\\AED1-Marce21\\RepoMarcelo\\UT0-Estructuras\\src\\asistencia_archivos\\";
        
        // Padrón de Afiliados.
        IPadronAfiliados<IAfiliado> padron = new PadronAfiliados<>();

        // Cargar afiliados en el padrón.
        // afiliadoCedula,nombre,apellido
        String[] archPadron = ManejadorArchivosGenerico.leerArchivo(ruta2 + "padron.txt");
        for (String linea1 : archPadron) {
            String[] registro1 = linea1.split(",");
            IAfiliado afiliado = new Afiliado(Integer.parseInt(registro1[0]), registro1[1].replaceAll(" ", ""), registro1[2].replaceAll(" ", ""));
            INodo<IAfiliado> nodoAfiliado = new Nodo<IAfiliado>((Comparable) afiliado.getCedula(), afiliado);
            padron.insertarAfiliado(nodoAfiliado);
        }

        // Cargar consultas agendadas en los afiliados.
        // afiliadoCedula,fecha,especialidad,cedula,resultado
        String[] archAgendadas = ManejadorArchivosGenerico.leerArchivo(ruta2 + "agendadas.txt");
        for (String linea2 : archAgendadas) {
            String[] registro2 = linea2.split(",");
            IConsulta consulta = new Consulta(Integer.parseInt(registro2[1]), registro2[2].replaceAll(" ", ""), Integer.parseInt(registro2[3]), Integer.parseInt(registro2[4]));
            INodo<IConsulta> nodoConsultaAnotada = new Nodo<IConsulta>(consulta.getEspecialidad(), consulta);
            // Busco el afiliado en el padrón y le inserto la consulta.
            IAfiliado elAfiliado = padron.buscarAfiliado(Integer.parseInt(registro2[0])).getDato();
            elAfiliado.insertarConsultaAnotada(nodoConsultaAnotada);
        }

        // Cargar consultas históricas en los afiliados.
        // afiliadoCedula,fecha,especialidad,cedula,resultado
        String[] archHistoricas = ManejadorArchivosGenerico.leerArchivo(ruta2 + "historicas.txt");
        for (String linea3 : archHistoricas) {
            String[] registro3 = linea3.split(",");
            IConsulta consulta = new Consulta(Integer.parseInt(registro3[1]), registro3[2].replaceAll(" ", ""), Integer.parseInt(registro3[3]), Integer.parseInt(registro3[4]));
            INodo<IConsulta> nodoConsultaHistorica = new Nodo<IConsulta>(consulta.getEspecialidad(), consulta);
            // Busco el afiliado en el padrón y le inserto la consulta.
            IAfiliado elAfiliado = padron.buscarAfiliado(Integer.parseInt(registro3[0])).getDato();
            elAfiliado.insertarConsultaHistorica(nodoConsultaHistorica);
        }

        // padron actualizar consultas.
        ILista<IAfiliado> listaCobranzas = padron.actualizarConsultas();
        System.out.println(listaCobranzas.cantElementos());
        INodo<IAfiliado> actual = listaCobranzas.getPrimero();
        while (actual != null) {
            Comparable afiCedula = actual.getDato().getCedula();
            String afiNombre = actual.getDato().getNombre();
            String afiApellido = actual.getDato().getApellido();
            System.out.println(afiCedula + "," + afiNombre + "," + afiApellido);
            actual = actual.getSiguiente();
        }

    }

}