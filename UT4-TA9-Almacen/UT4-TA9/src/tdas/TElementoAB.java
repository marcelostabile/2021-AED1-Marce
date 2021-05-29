package tdas;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T datos;

    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    /**
     * Insertar un elemento en el árbol.
     * @param unElemento
     * @return
     */
    public boolean insertar(TElementoAB<T> unElemento) {

        if (unElemento.getEtiqueta().compareTo(this.etiqueta) < 0) {   // Etiqueta de menor valor.
            if (hijoIzq == null) {   // Se inserta como hijo izquierdo, si ya tiene se inserta recursivamente.
                hijoIzq = unElemento;
                return true;
            } else {
                return hijoIzq.insertar(unElemento);
            }
        } else if (unElemento.getEtiqueta().compareTo(this.etiqueta) > 0) {   // Etiqueta de mayor valor.
            if (hijoDer == null) {   // Se inserta como hijo derecho, si ya tiene se inserta recursivamente.
                hijoDer = unElemento;
                return true;
            } else {
                return hijoDer.insertar(unElemento);
            }
        } else {   // Etiqueta repetida, no se inserta.
            return false;
        }
    }

    /**
     * Buscar un elemento en el árbol y devolverlo.
     * @param unaEtiqueta
     * @return
     */
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.compareTo(this.getEtiqueta()) == 0) {   // La etiqueta de este elemento coincide con la búsqueda.
            return this;

        } else if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
                if (hijoIzq == null) {
                    return null;
                } else {
                    return hijoIzq.buscar(unaEtiqueta);
                }

        } else if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
                if (hijoDer == null) {
                    return null;
                } else {
                    return hijoDer.buscar(unaEtiqueta);
                }

        } else {
            return null;
        }
    }

    /**
     * Imprime en inorden el arbol separado por guiones.
     * 
     * HijoIzquierdo, Elemento, HijoDerecho.
     * @return String conteniendo el InOrden
     */
    public String inOrden() {

        String cadena = "";
        String separa = "-";

        // Hijo izquierdo.
        if (hijoIzq != null) {
            cadena += hijoIzq.inOrden();
            cadena += separa;
        }
        // Elemento.
        cadena += this.etiqueta.toString();
        // Hijo derecho.
        if (hijoDer != null) {
            cadena += separa;
            cadena += hijoDer.inOrden();
        }
        return cadena;
    }

     /**
     * pone las etiquetas del recorrido en inorden en una TLista.
     *
     * @param unaLista
     */
    public void inOrden(Lista<T> unaLista) {

        // Hijo izquierdo.
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);
        }

        // Elemento.
        Nodo<T> unNodo = new Nodo<T>( (Comparable) this.getEtiqueta(), this.datos);
        unaLista.insertar(unNodo);

        // Hijo derecho.
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    /**
     * Método para determinar la altura del árbol.
     * 
     * @return entero.
     */
    public int obtenerAltura() {
        int A1 = -1;
        int A2 = -1;
        if (this.hijoIzq != null) {
            A1 = this.hijoIzq.obtenerAltura();
        }
        if (this.hijoDer != null) {
            A2 = this.hijoDer.obtenerAltura();
        }

        if (A1 > A2) {
            return A1 + 1;
        } else {
            return A2 + 1;
        }
    }

    /**
     * Calcular tamaño.
     * 
     * Recorro recursivamente el árbol, por cada nodo sumo uno, retorno el
     * resultado.
     * @return entero
     */
    public int obtenerTamanio() {
        int T1 = 0;
        int T2 = 0;

        // Hijo izquierdo.
        if (hijoIzq != null) {
            T1 += hijoIzq.obtenerTamanio();
        }
        // Hijo derecho.
        if (hijoDer != null) {
            T2 += hijoDer.obtenerTamanio();
        }
        // Retornar tamaño.
        return T1 + T2 + 1;
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	/**
	 * Retorna la cantidad de hojas del arbol cuya raiz es la del nodo actual.
	 * @return Cantidad de hojas del subarbol.
	 */
	public int obtenerCantidadHojas() {
        // Hoja.
        if (hijoIzq == null && hijoDer == null)
            return 1;

        // Cantidad de Hojas.
        int H1 = 0;
        int H2 = 0;

        // Hijo izquierdo.
        if (hijoIzq != null) {
            H1 += hijoIzq.obtenerCantidadHojas();
        }
        // Hijo derecho.
        if (hijoDer != null) {
            H2 += hijoDer.obtenerCantidadHojas();
        }

        // Retornar valor.
        return H1 + H2;
    }
    
     @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
 private TElementoAB quitaElNodo() {
               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   

   	
}
