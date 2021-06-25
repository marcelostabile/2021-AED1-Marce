package almacen;

public interface IProducto {

    public int getCodigoProd();
    
    public void setCodigoProd(int codigoProd);

    public String getNombreProd();

    public void setNombreProd(String nombreProd);

    public double getPrecioProd();

    public void setPrecioProd(double precioProd);

    public int getStockProd();

    public void setStockProd(int stockProd);

}
