/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Atención: clase desarrollada exclusivamente para UT4_TA11 que funciona adecuadamente
 * si recibe un array ordenado y de tamaño potencia de 2
 * @author aruib_000
 */

import tdas.*;

public class ArmarLleno {

     public ArmarLleno() {

     }

     public void armarArbolLleno(int i, int j, String[] Claves, TArbolBB elArbolBB) {

          int medio = (i + j) / 2;
          TElementoAB<Comparable> unNodo;
          unNodo = new TElementoAB(Claves[medio], Claves[medio]);
          elArbolBB.insertar(unNodo);
          if (i <= medio - 1) {
               armarArbolLleno(i, medio - 1, Claves, elArbolBB);
          }
          if (medio + 1 <= j) {
               armarArbolLleno(medio + 1, j, Claves, elArbolBB);
          }
     }
}
