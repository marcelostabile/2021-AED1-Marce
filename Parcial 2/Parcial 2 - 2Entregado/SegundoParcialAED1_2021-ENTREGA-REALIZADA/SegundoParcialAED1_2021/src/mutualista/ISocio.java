package mutualista;

public interface ISocio {

    public String getCedula();
    public String getApellido();
    public String getConsultaEspecialidadDelDia();

    public void setCedula(String cedula);
    public void setApellido(String apellido);
    public void setConsultaEspecialidadDelDia(String unaEspecialidad);
    
}
