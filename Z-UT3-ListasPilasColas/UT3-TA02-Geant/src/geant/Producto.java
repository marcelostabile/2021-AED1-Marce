package geant;

public class Producto implements IProducto {

    private Comparable etiqueta;
    private Integer precio;
    private Integer stock;
    private String nombre;

    /**
     *  El constructor producto es de Orden constante : O(1)
     */
    public Producto(Comparable etiqueta, Integer precio, Integer stock, String nombre)
    {
        this.etiqueta = etiqueta;
        this.precio = precio;
        this.stock = stock;
        this.nombre = nombre;
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    @Override
    public Integer getPrecio() {
        return precio;
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    @Override
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    @Override
    public Integer getStock() {
        return stock;
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    @Override
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    @Override
    public String getNombre() {
        return nombre;
    }

    /**
     *  Este metodo es de Orden constante : O(1)
     */
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}