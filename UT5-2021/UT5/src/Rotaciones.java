import tdas.*;

public class Rotaciones {

    /**
     * Rotar un nodo que tiene un hijo izquierdo.
     * Rotación simple, caso 1.
     */
    public static TElementoAB rotacionSimple_Con_HijoIzquierdo(TElementoAB padre) {

        TElementoAB hijo = padre.getHijoIzq();
        TElementoAB nieto = hijo.getHijoDer();
        padre.setHijoIzq(nieto);
        hijo.setHijoDer(padre); 
        return hijo;
    }

    /**
     * Rotar un nodo que tiene un hijo derecho.
     * Rotación simple, caso 4.
     */
    public static TElementoAB rotacionSimple_Con_HijoDerecho(TElementoAB padre) {

        TElementoAB hijo = padre.getHijoDer();
        TElementoAB nieto = hijo.getHijoIzq();
        padre.setHijoDer(nieto);
        hijo.setHijoIzq(padre); 
        return hijo;
    }

    /**
     * Rotación de un nodo, primero hijo izquierdo con su hijo derecho.
     * Luego nodo k3 con su nuevo hijo izquierdo.
     * Rotación doble, caso 2.
     */
    public static TElementoAB rotacionDoble_HijoIzquierdo(TElementoAB hijoIzquierdo) {

        hijoIzquierdo.setHijoIzq(rotacionSimple_Con_HijoDerecho(hijoIzquierdo.getHijoIzq()));
        return rotacionSimple_Con_HijoIzquierdo(hijoIzquierdo);
    }

    /**
     * Rotación de un nodo, primero hijo derecho con su hijo izquierdo.
     * Luego nodo k1 con su nuevo hijo derecho.
     * Rotación doble, caso 3.
     */
    public static TElementoAB rotacionDoble_HijoDerecho(TElementoAB hijoDerecho) {

        hijoDerecho.setHijoDer(rotacionSimple_Con_HijoIzquierdo(hijoDerecho.getHijoDer()));
        return rotacionSimple_Con_HijoDerecho(hijoDerecho);
    }

}
