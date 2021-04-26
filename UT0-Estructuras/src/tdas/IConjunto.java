package tdas;

import java.util.*;

public interface IConjunto<T> extends ILista<T> {


    public void insertarUltimo(INodo<T> nodo);







    /**
     * Obtener el primer elemento.
     */
    public INodo<T> getPrimero();

    /**
     * Obtener la lista Conjunto.
     */
    public ILista<T> getLista();

    /**
     * Insertar un elemento a partir de un nodo.
     * @param nodo
     */
    public void insertarElemento(INodo<T> nodo);

    /**
     * Insertar muchos elementos en el conjunto a partir de un array.
     * @param unArray
     */
    public void insertarElementos(ArrayList<T> unArrayElementos);

    /**
     * Cantidad de elementos en el conjunto.
     */
    public int cantElementos();

    /**
     * UNION
     * El conjunto UNION contiene todos los elementos del conjunto A y del conjunto B.
    */
    public IConjunto<T> union(IConjunto<T> otroConjunto);

    /**
     * El conjunto INTERSECCIÓN contiene todos los elementos comunes de ambos conjuntos.
    */
    public IConjunto<T> interseccion(IConjunto<T> otroConjunto);

    /**
     * El conjunto DIFERENCIA contiene elementos de A que no pertenecen al conjunto B.
    */
    public IConjunto<T> diferencia(IConjunto<T> otroConjunto);

    /**
     * El conjunto DIFERENCIA SIMÉTRICA contiene los elementos de A y B que no son comunes.
    */
    public IConjunto<T> diferenciaSimetrica(IConjunto<T> otroConjunto);

    /**
     * El conjunto COMPLEMENTO son todos los elementos que no pertenecen al conjunto A.
    */
    public IConjunto<T> complemento(IConjunto<T> otroConjunto);

    /**
     * Imprimir TConjunto.
    */
    public void imprimirConjunto(IConjunto<T> conjunto);

}
