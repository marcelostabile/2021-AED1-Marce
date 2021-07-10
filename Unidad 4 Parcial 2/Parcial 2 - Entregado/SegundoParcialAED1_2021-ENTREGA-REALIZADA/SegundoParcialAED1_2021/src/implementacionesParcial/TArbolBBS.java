package implementacionesParcial;

import mutualista.*;
import tdas.*;

public class TArbolBBS extends TArbolBB<Socio> implements IArbolBBS{

    @Override
    public void armarIndicesEspecialidades(Lista<Especialidad> especialidades) {
        if (!esVacio()) {
            this.getRaiz().indizar(especialidades);
        }
    }


    @Override
    public void cambioConsulta(String cedula, String nuevaEsp, Lista<Especialidad> especialidades) {
        // TODO Auto-generated method stub
    }

    
}
