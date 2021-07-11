package com.ucudal.implementacionesParcial;

import com.ucudal.tdas.*;
import com.ucudal.productora.*;

public class TArbolActores extends TArbolBB<Actor> implements IArbolActores {

    /**
     * Devuelve una lista de Actor todos los actores que participaron en alguna pelicula con elActor
     * en esta lista, cada actor tiene como lista de peliculas aquellas en la que participo con elActor
     * @param elActor
     * @return
     */
    @Override
    public Lista<Actor> todosLosCoProtagonistas(String elActor) {
        // TODO: Completar en el parcial
        Lista<Actor> coact = new Lista<>();
        IElementoAB<Actor> buscado = this.buscar(elActor);
        if(buscado != null){
            INodo<Film> filmActual = buscado.getDatos().getFilms().getPrimero();
            while (filmActual != null){
                INodo<Actor> actorActual = filmActual.getDato().getActores().getPrimero();
                while(actorActual != null){
                    if(actorActual.getEtiqueta().compareTo(elActor) != 0){
                        INodo<Actor> yaEsta = coact.buscar(actorActual.getEtiqueta());
                        if(yaEsta == null){
                            Actor temp = new Actor(actorActual.getEtiqueta().toString());
                            temp.agregarFilm(filmActual.getDato());
                            coact.insertar(new Nodo<Actor>(temp.getNombre(),temp));
                        }else{
                            yaEsta.getDato().agregarFilm(filmActual.getDato());
                        }
                    }
                    actorActual = actorActual.getSiguiente();
                }
                filmActual = filmActual.getSiguiente();
            }
            return  coact;
        }
        return null;
    }
}
