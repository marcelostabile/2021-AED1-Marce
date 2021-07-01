package mutualista;

import archivos.*;
import implementacionesParcial.*;
import mutualista.*;
import tdas.*;

public interface IMedico {

    public String getIDMedico();
    public String getNombre();
    public String getApellido();

    public void setIDMedico(String idMedico);
    public void setNombre(String unNombre);
    public void setApellido(String unApellido);

}
