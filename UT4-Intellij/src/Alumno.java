import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class Alumno {

    public int cedula;
    public String apellido;
    public Carrera carrera;

    public Alumno(int cedula, String apellido, Carrera carrera) {
        this.cedula = cedula;
        this.apellido = apellido;
        this.carrera = carrera;
    }

    public int getCedula() {
        return cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

}
