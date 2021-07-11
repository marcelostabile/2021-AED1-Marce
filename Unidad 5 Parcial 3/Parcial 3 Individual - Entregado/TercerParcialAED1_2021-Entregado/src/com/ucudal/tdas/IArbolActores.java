package com.ucudal.tdas;

import com.ucudal.productora.*;

public interface IArbolActores {

    /**
     * Devuelve una lista de de tipo Actor todos los actores que participaron en alguna película con elActor
     * en esta lista, cada actor tiene como lista de películas aquellas en las que participó con elActor
     * @param elActor
     * @return
     */
    public Lista<Actor> todosLosCoProtagonistas(String elActor);
}
