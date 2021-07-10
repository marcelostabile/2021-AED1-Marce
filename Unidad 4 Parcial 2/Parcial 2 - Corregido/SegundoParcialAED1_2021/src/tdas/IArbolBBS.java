package tdas;

import mutualista.*;

public interface IArbolBBS {

    void armarIndicesEspecialidades (Lista<Especialidad> especialidades);
    void cambioConsulta (String cedula, String nuevaEsp, Lista<Especialidad> especialidades);
    
}
