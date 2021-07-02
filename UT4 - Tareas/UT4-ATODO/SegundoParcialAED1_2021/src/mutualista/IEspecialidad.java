package mutualista;

import implementacionesParcial.*;

public interface IEspecialidad {

    public String getNombreEspecialidad();
    public void setNombreEspecialidad(String nombreEspecialidad);
    public TArbolBB<Socio> getIndiceSociosEspecialidad();
    
}
