package implementacionesParcial;

import mutualista.IConsulta;
import tdas.ILista;
import tdas.INodo;

public class SociedadMedica {
    
    /*
    Implementación de obtenerConsultasPorEspecialidad
     */
    public  ListaOrdenada<IConsulta> obtenerConsultasPorEspecialidad(String especialidad, ILista<IConsulta> unaLista){

        // Normalizo la variable de búsqueda en mayúsculas
        String especialidadMAY = especialidad.trim().toUpperCase();
        
        // Lista resultado.
        ListaOrdenada<IConsulta> consultasResultado = new ListaOrdenada<>();

        // Recorro la lista de consultas.
        INodo<IConsulta> nodoConsulta = unaLista.getPrimero();
        while (nodoConsulta != null) {

            // Verifico si la consulta es la buscada.
            if (nodoConsulta.getDato().getEspecialidadConsulta().trim().toUpperCase().contains(especialidadMAY)) {
                consultasResultado.insertar(nodoConsulta);;
            }
            nodoConsulta = nodoConsulta.getSiguiente();
        }
        return consultasResultado;
    }
    
}
