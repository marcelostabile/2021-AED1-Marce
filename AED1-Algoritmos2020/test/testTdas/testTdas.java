/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testTdas;

import tdas.*;

import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.event.InternalFrameAdapter;

/**
 * Tests
 */
public class testTdas {
    
    public NodoTest() {
    }

    @Test
    public void testNodos() {
        Nodo<Integer> nodo1 = new Nodo<>("1", 100);
        Nodo<Integer> nodo2 = new Nodo<>("2", 200);
        Nodo<Integer> nodo3 = new Nodo<>("3", 300);
        Integer resultado = nodo1.getDato() + nodo2.getDato() + nodo3.getDato();
        // Test.
        assertEquals(600, resultado);
    }

    @Test
    public void testNombraNodos() {
        Nodo<Integer> nodo1 = new Nodo<>("1", 100);
        Nodo<Integer> nodo2 = new Nodo<>("2", 200);
        Nodo<Integer> nodo3 = new Nodo<>("3", 300);
        String nombresConcatenados = nodo1.getEtiqueta().toString() + nodo2.getEtiqueta().toString() + nodo3.getEtiqueta().toString();
        // Test.
        assertEquals("123", resultado);
    }

}
