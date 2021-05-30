package asistencia;
import tdas.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bernardo Rychtenberg
 */
public class TArbolPadronAfiliados extends TArbolBB<Afiliado> implements IArbolPadronAfiliados {

    /**
     * Devuelve un arbol BB a partir de una lista dada.
     * @param
     * @return
     */
    public TArbolBB<Afiliado> cargarDesdeLista(Lista<Afiliado> listaAfiliados) {
        
        TArbolBB<Afiliado> afiliadosArbol = new TArbolBB<>();

        Nodo<Afiliado> nodoAfiliado = listaAfiliados.getPrimero();
        while (nodoAfiliado != null) {
            TElementoAB<Afiliado> unElemento = new TElementoAB<Afiliado>( (Comparable) nodoAfiliado.getDato().getCedula(), nodoAfiliado.getDato());
            afiliadosArbol.insertar(unElemento);
            nodoAfiliado = nodoAfiliado.getSiguiente();
        }
        return afiliadosArbol;
    }
    
    /**
     * Devuelve un árbol BB con las consultas para la fecha ingresada.
     * @param 
     * @return
     */
    public TArbolBB<Afiliado> obtenerConsultasDelDia(String fecha) { 

        // árbol resultado.
        TArbolBB<Afiliado> consultasDelDia = new TArbolBB<>();

        // Obtengo la lista de afiliados.
        Lista<Afiliado> listaAfiliado = this.inorden();

        // Recorro los afiliados.
        Nodo<Afiliado> nodoAfiliado = listaAfiliado.getPrimero();
        while (nodoAfiliado != null) {
            // Verifico que tenga consultas agendadas.
            if (!nodoAfiliado.getDato().pendientes.esVacia()) {   
                // Recorro las consultas pendientes evaluando por fecha.
                Nodo<Consulta> nodoConsulta = nodoAfiliado.getDato().pendientes.getPrimero();
                while (nodoConsulta != null) {
                    // La consulta debe coincidir en fecha y resultado buscado.
                    if (nodoConsulta.getDato().getFecha().compareTo(fecha) == 0) {
                        if (nodoConsulta.getDato().getResultado() == 0) {
                            String unaEtiqueta = nodoAfiliado.getDato().getCedula() + "," + nodoConsulta.getDato().getFecha() + "," + nodoConsulta.getDato().getEspecialidad().trim();
                            TElementoAB<Afiliado> consultaDelDia = new TElementoAB<Afiliado>( (Comparable) unaEtiqueta, nodoAfiliado.getDato());
                            consultasDelDia.insertar(consultaDelDia);
                        }
                    }
                    nodoConsulta = nodoConsulta.getSiguiente();
                }
            }
            nodoAfiliado = nodoAfiliado.getSiguiente();
        }
        return consultasDelDia;
    }
    
    @Override
    public Integer cantidadConsultasdelDia(){
        // Obtengo la cantidad de consultas del día.
        // la fecha debería tomarse por sistema, no una varible fija.
        TArbolBB<Afiliado> consultasDelDia = this.obtenerConsultasDelDia("20190905");
        return consultasDelDia.obtenerTamanio();
    }

} 
    

