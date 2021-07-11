package tdas;

public interface ICola<T>  {
    
    public void encolar(INodo<T> nodo);

    public INodo<T> desencolar();

    public boolean esVacia();

    public INodo<T> getPrimero();
}   
