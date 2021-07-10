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
public interface IArbolPadronAfiliados {

    public TArbolBB<Afiliado> cargarDesdeLista(Lista<Afiliado> listaAfiliados);
    
    public TArbolBB<Afiliado> obtenerConsultasDelDia(String fecha);
    
    public Integer cantidadConsultasdelDia();    
}
