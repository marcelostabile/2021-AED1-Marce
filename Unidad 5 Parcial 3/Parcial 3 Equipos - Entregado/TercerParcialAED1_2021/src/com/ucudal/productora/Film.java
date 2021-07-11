package com.ucudal.productora;

import com.ucudal.tdas.Lista;
import com.ucudal.tdas.Nodo;

public class Film {
    private String idFilm;
    private String titulo;
    private String genero;
    private Lista<Actor> actores;

    public Film (String elId, String elNombre, String unGenero) {
        this.idFilm = elId;
        this.titulo = elNombre;
        this.actores  = new Lista<>();
        this.genero = unGenero;
    }

    public String getIdFilm() {
        return idFilm;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public  Lista<Actor> getActores(){
        return actores;
    }

    public void agregarActor(Actor elActor) {
        actores.insertar(new Nodo<Actor>(elActor.getNombre(), elActor));
    }


    public String imprimir(){
        return (idFilm  + " - "+ this.titulo);
    }

}
