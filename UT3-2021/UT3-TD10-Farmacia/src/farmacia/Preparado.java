package farmacia;

import java.util.*;

public class Preparado implements IPreparado {

    private int suero;
    private ArrayList<Integer> listaFarmacos;
    
    public Preparado(int suero, ArrayList<Integer> listaFarmacos) {
        this.suero = suero;
        this.listaFarmacos = listaFarmacos;
    }

    public int getIdSuero() {
        return suero;
    }

    public void setIdSuero(int suero) {
        this.suero = suero;
    }

    public ArrayList<Integer> getListaFarmacos() {
        return listaFarmacos;
    }

    public void setListaFarmacos(ArrayList<Integer> listaFarmacos) {
        this.listaFarmacos = listaFarmacos;
    }

}