package universidad;

import tdas.*;

public class Carrera {

    private String NombreCarrera;
    private TArbolBB<Alumno> indiceCarrera;

    /**
     * @param unNombreCarrera
     */
    public Carrera(String unNombreCarrera) {
        NombreCarrera = unNombreCarrera;
        indiceCarrera = new TArbolBB<Alumno>();
    }

    public String getNombreCarrera() {
        return NombreCarrera;
    }

    public TArbolBB<Alumno> getIndiceCarrera(){
        return indiceCarrera;
    }

    
}
