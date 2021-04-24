package tdas;

public interface ITConjunto<T> {
    
    public INodo<T> getPrimero();

    /**
     * El conjunto UNION contiene todos los elementos del conjunto A y del conjunto B.
    */
    public TConjunto<T> union(TConjunto<T> otroConjunto);

    /**
     * El conjunto INTERSECCIÓN contiene todos los elementos comunes de ambos conjuntos.
     */
    public TConjunto<T> interseccion(TConjunto<T> otroConjunto);

    /**
     * El conjunto DIFERENCIA contiene elementos de A que no pertenecen al conjunto B.
     */
    public TConjunto<T> diferencia(TConjunto<T> otroConjunto);

    /**
     * El conjunto DIFERENCIA SIMÉTRICA contiene los elementos de A y B que no son comunes.
    */
    public TConjunto<T> diferenciaSimetrica(TConjunto<T> otroConjunto);

    /**
     * El conjunto COMPLEMENTO son todos los elementos que no pertenecen al conjunto A.
     */
    public TConjunto<T> complemento(TConjunto<T> otroConjunto);
}
