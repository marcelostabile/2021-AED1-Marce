package mutualista;

import archivos.*;
import implementacionesParcial.*;
import mutualista.*;
import tdas.*;

/* Implementación de la clase Medico parte 2 del parcial.*/
public class Medico implements IMedico{

    private String idMedico; 
    private String nombre; 
    private String apellido; 

	public Medico(String idMedico, String nombre, String apellido) {
        this.idMedico = idMedico;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String getIDMedico() {
        return this.idMedico;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getApellido() {
        return this.apellido;
    }

    @Override
    public void setIDMedico(String idMedico) {
        this.idMedico = idMedico;        
    }

    @Override
    public void setNombre(String unNombre) {
        this.nombre = unNombre;      
    }

    @Override
    public void setApellido(String unApellido) {
        this.apellido = unApellido;      
    }
    
}
