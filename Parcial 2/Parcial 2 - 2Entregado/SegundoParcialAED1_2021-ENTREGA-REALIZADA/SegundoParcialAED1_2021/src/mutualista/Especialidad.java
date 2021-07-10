package mutualista;

import implementacionesParcial.*;

public class Especialidad implements IEspecialidad{

    private String nombreEspecialidad; 
    private TArbolBB<Socio> indiceSocios = new TArbolBB<>(); // .

    public Especialidad(String nombreEspecialidad){
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public String getNombreEspecialidad(){
        return this.nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad){
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public TArbolBB<Socio> getIndiceSociosEspecialidad(){
        return this.indiceSocios;
    }
    
}
