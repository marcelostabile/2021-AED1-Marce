package tdas;

public interface IConjunto<T> {

    /**
     * Obtener el primer elemento de la lista.
     */
    public INodo<T> getPrimero();

    /**
     * Insertar primero.
     * @param nodo
     */
    public void insertarPrimero(INodo<T> nodo);

    /**
     * Metodo encargado de agregar un nodo al final de la lista.
     * @param nodo - Nodo a agregar
     */
    public void insertarUltimo(INodo<T> nodo);

    /**
     * Metodo encargado de buscar un nodo cuya clave es la indicada.
     * @param clave - Clave del nodo a buscar.
     * @return El nodo encontrado. En caso de no encontrarlo, retornar null.
     */
    public INodo<T> buscar(Comparable clave);

    /**
     * Retorna la cantidad de elementos de la lista. En caso de que la lista
     * este vacía, retornar 0.
     * @return Cantidad de elementos de la lista.
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
     * Imprimir Conjunto.
     */
    public void imprimirConjunto(IConjunto<T> conjunto);
    
}
