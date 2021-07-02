package mutualista;

public class Socio implements ISocio {

    private String cedula;
    private String apellido; 
    private String unaEspecialidad;

    public Socio(String cedula, String apellido, String especialidad){
        this.cedula = cedula; 
        this.apellido = apellido;
        this.unaEspecialidad = especialidad;
    }

    @Override
    public String getCedula() {
        return this.cedula;
    }


    @Override
    public String getApellido() {
        return this.apellido;
    }

    @Override
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }


    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getConsultaEspecialidadDelDia() {
       return this.unaEspecialidad;
    }

    @Override
    public void setConsultaEspecialidadDelDia(String unaEspecialidad) {
        this.unaEspecialidad = unaEspecialidad;
        
    }
    
    
}
