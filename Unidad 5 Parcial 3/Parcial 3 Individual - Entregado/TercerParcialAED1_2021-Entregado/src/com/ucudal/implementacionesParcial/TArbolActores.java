package com.ucudal.implementacionesParcial;

import com.ucudal.productora.*;
import com.ucudal.tdas.*;

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

        if(esVacio()){
            return null;
        }
        // lista resultado.
        Lista<Actor> coActores = new Lista<>();

        IElementoAB<Actor> elem = this.buscar(elActor);

        // verifico que existe, obtengo la lista de sus peliculas
        if(elem != null){
            Lista<Film> films = elem.getDatos().getFilms();

            // verifico si tiene peliculas y si tiene obtengo y recorro la lista
            if(films!=null ){
                INodo<Film> aux = films.getPrimero();

                // para cada pelicula analizo sus actores.
                while(aux != null){
                    Film filmAux = aux.getDato();

                    // Lista de actores de la pelicula.
                    Lista<Actor> actores = filmAux.getActores();

                    if(actores != null){
                        INodo<Actor> actor = actores.getPrimero();

                        while(actor!=null){
                            if(actor.getEtiqueta().compareTo(elActor) != 0 && coActores.buscar(actor.getEtiqueta()) == null) {
                                
                                // Insertar el coActor en la lista resultado. 
                                coActores.insertar(new Nodo<>(actor.getEtiqueta(), actor.getDato()));
                            }
                            actor = actor.getSiguiente();
                        }
                    }
                    aux = aux.getSiguiente();
                }
            }
        }
        // retornar los coActores.
        return coActores;
    }
}
