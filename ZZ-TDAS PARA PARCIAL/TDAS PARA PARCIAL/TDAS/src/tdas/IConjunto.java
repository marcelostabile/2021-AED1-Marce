package tdas;

public interface IConjunto<T>{

    public INodo<T> buscar(Comparable clave);

    public INodo<T> getPrimero();

    public boolean esVacia();

    public IConjunto<T> union( IConjunto<T> conjunto);

    public IConjunto<T> interseccion ( IConjunto<T> conjunto);

    public IConjunto<T> diferenciaSimetrica (IConjunto<T> conjunto);

    public IConjunto<T> diferencia ( IConjunto<T> conjunto);

    //public IConjunto<T> productoCartesiano(IConjunto<T> conjunto);

}
