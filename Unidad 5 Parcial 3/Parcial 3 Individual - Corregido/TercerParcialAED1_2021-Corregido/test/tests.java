import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import com.ucudal.implementacionesParcial.*;
import com.ucudal.productora.*;
import com.ucudal.tdas.*;

public class tests {

    // arboles
    TArbolActores arbolvacio;
    TArbolActores arbolito;

    // actores
    Actor actor_1;
    TElementoAB<Actor> actor1;
    Actor actor_2;
    TElementoAB<Actor> actor2;
    Actor actor_3;
    TElementoAB<Actor> actor3;

    @BeforeEach
    public void setUp() throws Exception {

        arbolito = new TArbolActores();
        arbolvacio = new TArbolActores();

        // instanciamos los actores.
        actor_1 = new Actor("Pedro");
        actor_2 = new Actor("Gustavo");
        actor_3 = new Actor("Alberto");

        // instancia de pelis
        Film film1 = new film("12345","Lo que el viento se llevo");
        film1.agregarActor(actor_1);
        film1.agregarActor(actor_2);
        film1.agregarActor(actor_3);
        actor_1.agregarFilm(film1);
        actor_1.agregarFilm(film2);

        Film film2 = new film("345","Matrix");
        film2.agregarActor(actor_1);
        film2.agregarActor(actor_2);
        film2.agregarActor(new Actor("Juan"));

        // insertar los actores en el arbolito
        actor01 = new TElementoAB<>(actor_1.getNombre(), actor_1);
        actor02 = new TElementoAB<>(actor_2.getNombre(), actor_2);
        actor03 = new TElementoAB<>(actor_3.getNombre(), actor_3);
        arbolito.insertar(actor01);
        arbolito.insertar(actor02);
        arbolito.insertar(actor03);

        // coactores
        coactores = new Lista<>();
        coactores.insertar(new Nodo(actor_2.getNombre(), actor_2));
        coactores.insertar(new Nodo(actor_3.getNombre(), actor_3));
        coactores.insertar(new Nodo("Juan", ""));
    }

    @Test
    public void testActores() {
        assertEquals(coactores.imprimir(" "), arbolito.todosLosCoactores("Pedro").imprimir(" "));
    }

    @Test
    public void testVacio() {
        assertEquals(null, vacio.todosLosCoactores("elActor"));
    }

}