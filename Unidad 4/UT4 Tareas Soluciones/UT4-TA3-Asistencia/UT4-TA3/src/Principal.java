/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import tdas.*;
import archivos.*;
import asistencia.*;

/**
 *
 * @author Bernardo Rychtenberg
 */
public class Principal {
    
    public static void main(String[] args){

        String ruta = "src//archivos//";
        
        
        // 1) Instanciar y cargar los afiliados a un árbol de afiliados desde padron.txt. 
        TArbolPadronAfiliados afiliadosArbol = new TArbolPadronAfiliados();

        String[] afiliadosArchivo = ManejadorArchivosGenerico.leerArchivo(ruta + "padron.txt");
        for (String linea : afiliadosArchivo) {
            String[] reg = linea.split(",");   // 296878,Juan ,Gonzalez
            Afiliado afiliado = new Afiliado(Integer.parseInt(reg[0]), reg[1].trim(), reg[2].trim());
            TElementoAB<Afiliado> unElemento = new TElementoAB<Afiliado>( (Comparable) afiliado.getCedula(), afiliado);
            afiliadosArbol.insertar(unElemento);
        }


        // 2) Instanciar y cargar las consultas a partir de los archivos historicos.txt y agendadas.txt
        // agendadas 226926,20190903,Cardiologia ,15194571,2 (cedula,fecha,especialidad,medico,estado)
        // historicas 830741,20190901,Medicina general ,38917611,1 (cedula,fecha,especialidad,medico,estado)
        String[] agendadas = ManejadorArchivosGenerico.leerArchivo(ruta + "agendadas.txt");
        for (String linea : agendadas) {
            String[] reg = linea.split(",");        // consulta agendada
            Consulta unaConsulta = new Consulta(
                reg[1],                             // unaFecha, 
                reg[2].trim(),                      // unaEspecialidad, 
                Integer.parseInt(reg[3]),           // cedula medico, 
                Integer.parseInt(reg[4])            // unResultado
            );
            // busco afiliado e inserto la consulta en su lista
            afiliadosArbol.buscar( (Comparable) Integer.parseInt(reg[0]) ).getDatos().cargarConsultaPendiente(unaConsulta);
        }

        String[] historicas = ManejadorArchivosGenerico.leerArchivo(ruta + "historicas.txt");
        for (String linea : historicas) {
            String[] reg = linea.split(",");        // consulta historica
            Consulta unaConsulta2 = new Consulta(
                reg[1],                             // unaFecha, 
                reg[2].trim(),                      // unaEspecialidad, 
                Integer.parseInt(reg[3]),           // cedula medico, 
                Integer.parseInt(reg[4])            // unResultado
            );
            // busco afiliado e inserto la consulta en su lista
            afiliadosArbol.buscar( (Comparable) Integer.parseInt(reg[0]) ).getDatos().cargarConsultaHistorica(unaConsulta2);
        }


        // 3) Aplicar el método de carga de afiliados a partir de una lista (invocando el método cargarDesdeLista)
        TArbolPadronAfiliados afiliadosArbol2 = new TArbolPadronAfiliados();
        Lista<Afiliado> afiliadosLista = new Lista<>();

        String[] afiliadosArchivo2 = ManejadorArchivosGenerico.leerArchivo(ruta + "padron.txt");
        for (String linea : afiliadosArchivo2) {
            String[] reg = linea.split(",");   // 296878,Juan ,Gonzalez
            Afiliado afiliado = new Afiliado(Integer.parseInt(reg[0]), reg[1].trim(), reg[2].trim());
            Nodo<Afiliado> nodoAfiliado = new Nodo<>( (Comparable) afiliado.getCedula(), afiliado);
            afiliadosLista.insertar(nodoAfiliado);
        }
        TArbolBB<Afiliado> arbolResultado = afiliadosArbol2.cargarDesdeLista(afiliadosLista);


        // 4) Aplicar el método obtenerConsultasDelDia para obtener las consultas del día de la fecha. 
        TArbolBB<Afiliado> consultasDelDia = afiliadosArbol.obtenerConsultasDelDia("20190905");

        System.out.println("Árbol consultasDelDía en Inorden: " + consultasDelDia.inOrden());

        // Imprimir salida
        String[] registroSalida = consultasDelDia.inOrden().split("-");
        ManejadorArchivosGenerico.escribirArchivo("src//consultasDelDia.txt", registroSalida);

        // 5) Obtener la cantidad de consultas en el día.
        System.out.println("Cantidad de consultas del día: " + afiliadosArbol.cantidadConsultasdelDia());
        
    }
    
}
