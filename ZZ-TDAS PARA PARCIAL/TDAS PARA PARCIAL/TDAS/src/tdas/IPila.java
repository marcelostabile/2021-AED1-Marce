package tdas;

public interface IPila<T> {

    public boolean esVacia();

    public void push(INodo<T> nodo);

    public INodo<T> pop();
    
    public INodo<T> top();

}
