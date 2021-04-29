package implementacionesParcial;

import mutualista.*;
import tdas.*;

public class SociedadMedica {

    /*
    Implementación de obtenerConsultasPorEspecialidad
     */
    public ListaOrdenada<IConsulta> obtenerConsultasPorEspecialidad(String especialidad, ILista<IConsulta> unaLista){

        System.out.println("Procesando lista de Consultas por especialidad: " + unaLista.cantElementos() + " elementos.");

        // Lista resultado.
        ListaOrdenada<IConsulta> consultasPorEspecilidad = new ListaOrdenada<>();

        // Normalizo la variable de búsqueda en mayúsculas
        String especialidadMAY = especialidad.trim().toUpperCase();

        System.out.println("Especialidad búscada: " + especialidadMAY + "\n");
        
        // Recorro la lista de consultas y verifico si el registro actual corresponde con la búsqueda.
        INodo<IConsulta> nodoConsulta = unaLista.getPrimero();
        while (nodoConsulta != null) {

            String especialidadConsultaMAY = nodoConsulta.getDato().getEspecialidadConsulta().trim().toUpperCase(); //.getEspecialidadConsulta().trim().toUpperCase();
            if (especialidadConsultaMAY.contains(especialidadMAY)) {
                System.out.println("Coincidencia encontrada: " + especialidadMAY);
                INodo<IConsulta> nodo = new Nodo<IConsulta>(nodoConsulta.getEtiqueta(), nodoConsulta.getDato());
                consultasPorEspecilidad.insertar(nodo);;
                System.out.println(consultasPorEspecilidad.cantElementos());
            }
            nodoConsulta = nodoConsulta.getSiguiente();
        }
        return consultasPorEspecilidad;
    }
    
}
