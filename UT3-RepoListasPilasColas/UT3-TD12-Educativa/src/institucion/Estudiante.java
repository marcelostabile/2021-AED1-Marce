package institucion;

public class Estudiante implements IEstudiante {
    
    int codigoEstudiante;
    String nombreEstudiante;

    public Estudiante(int codigoEstudiante, String nombreEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
        this.nombreEstudiante = nombreEstudiante;
    }
    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }
    public void setCodigoEstudiante(int codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }
    public String getNombreEstudiante() {
        return nombreEstudiante;
    }
    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

}
