package asistencia;

public class Consulta implements IConsulta {
    
    // Constructor.

    int fecha;
    String especialidad;
    int cedula;
    int resultado;
    
    public Consulta(int fecha, String especialidad, int cedula, int resultado) {
        this.fecha = fecha;
        this.especialidad = especialidad;
        this.cedula = cedula;
        this.resultado = resultado;
    }

    // Métodos.

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

}
