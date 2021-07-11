import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import com.ucudal.tdas.*;
import com.ucudal.implementacionesParcial.*;
import com.ucudal.productora.*;

class TArbolActoresTest {
    private TArbolActores arbolVacio;
    private TArbolActores arbolLleno;


    TElementoAB<Integer> elem1;
    TElementoAB<Integer> elem2;
    TElementoAB<Integer> elem3;

    @BeforeEach
    void setUp() {
        arbolVacio = new TArbolActores();
        arbolLleno = new TArbolActores();
        Actor act2 = new Actor("bruno");
        Actor act3 = new Actor("nuevo");
        Actor act1 = new Actor("Charlie");
        Film film1 = new Film("1","2","Terror");
        film1.agregarActor(act1);
        film1.agregarActor(act2);
        Film film2 = new Film("2","pi","Documental");
        act1.agregarFilm(film1);
        act1.agregarFilm(film2);
        film2.agregarActor(act3);
        arbolLleno.insertar(new TElementoAB<Actor>(act1.getNombre(),act1));
        arbolLleno.insertar(new TElementoAB<Actor>(act2.getNombre(),act2));
        arbolLleno.insertar(new TElementoAB<Actor>(act3.getNombre(),act3));
    }

    @Test
    void todosLosCoProtagonistasVacio() {
        assertEquals(null,arbolVacio.todosLosCoProtagonistas("Charlie"));
    }

    @Test
    void todosLosCoProtagonistasNormal() {
        assertEquals("bruno-nuevo",arbolLleno.todosLosCoProtagonistas("Charlie").imprimir("-"));
    }
    @Test
    void todosLosCoProtagonistasNormalQueTenganLasMovies() {
        assertEquals("1",arbolLleno.todosLosCoProtagonistas("Charlie").buscar("bruno").getDato().getFilms().getPrimero().getEtiqueta());
    }
}