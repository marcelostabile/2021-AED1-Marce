package almacen;

public class Producto implements IProducto {
    
    private int codigoProd;
    private String nombreProd;
    private double precioProd;
    private int stockProd;

    public Producto(int codigoProd, String nombreProd, double precioProd, int stockProd) {
        this.codigoProd = codigoProd;
        this.nombreProd = nombreProd;
        this.precioProd = precioProd;
        this.stockProd = stockProd;
    }

    public int getCodigoProd() {
        return codigoProd;
    }

    public void setCodigoProd(int codigoProd) {
        this.codigoProd = codigoProd;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public double getPrecioProd() {
        return precioProd;
    }

    public void setPrecioProd(double precioProd) {
        this.precioProd = precioProd;
    }

    public int getStockProd() {
        return stockProd;
    }

    public void setStockProd(int stockProd) {
        this.stockProd = stockProd;
    }

    /**
     * Reducir el stock del producto restando la cantidad ingresada.
     * @param cantidad
     */
    public void restarStock(int cantidad) {
        if (this.stockProd - cantidad < 0) {    // Si la cantidad final es menor a cero, stock final debe ser cero.
            this.setStockProd(0);
        } else {
            this.setStockProd(stockProd - cantidad);
        }
    }

}
