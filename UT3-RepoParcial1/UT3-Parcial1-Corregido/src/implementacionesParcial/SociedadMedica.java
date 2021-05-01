package implementacionesParcial;

import mutualista.*;
import tdas.*;

public class SociedadMedica {

    /*
    Implementación de obtenerConsultasPorEspecialidad
     */
    public ListaOrdenada<IConsulta> obtenerConsultasPorEspecialidad(String especialidad, ILista<IConsulta> unaLista){

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
                INodo<IConsulta> nodo = new Nodo<IConsulta>(nodoConsulta.getDato().getApellidoPaciente(), nodoConsulta.getDato());
                consultasPorEspecilidad.insertar(nodo);;
            }
            nodoConsulta = nodoConsulta.getSiguiente();
        }
        return consultasPorEspecilidad;
    }
    
}
