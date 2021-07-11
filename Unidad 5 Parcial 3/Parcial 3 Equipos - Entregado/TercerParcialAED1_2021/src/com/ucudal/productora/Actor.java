package com.ucudal.productora;

import com.ucudal.tdas.Lista;
import com.ucudal.tdas.Nodo;

public class Actor {

    private String nombre;
    private Lista<Film> films;

    public Actor(String nombre){
        this.nombre = nombre;
        this.films = new Lista<Film>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public Lista<Film> getFilms(){
        return this.films;
    }

    public void agregarFilm(Film unaPeli){
        this.films.insertar(new Nodo<Film>(unaPeli.getIdFilm(), unaPeli));
    }
}
