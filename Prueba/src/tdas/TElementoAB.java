package src.tdas;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos 
     */
    @SuppressWarnings("unchecked")
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
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    /**
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
     */
    @Override
    public String inOrden() {
        String tempStr = "";
        String separa = "-";

        if (hijoIzq != null) {
            tempStr += hijoIzq.inOrden();
            tempStr += separa;
        }

        tempStr += this.etiqueta.toString();

        if (hijoDer != null) {
            tempStr += separa;
            tempStr += hijoDer.inOrden();
        }
        return tempStr;
    }

    @Override
    public void inOrden(Lista<T> unaLista) {

        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);
        }
        Nodo<T> nodo = new Nodo<>(etiqueta, datos);
        unaLista.insertar(nodo);

        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

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

    @Override
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

    @Override
    public int obtenerTamanio() {
        int T1 = 0;
        int T2 = 0;

        // Hijo izquierdo.
        if (hijoIzq != null) {
            T1 = hijoIzq.obtenerTamanio();
        }
        // Hijo derecho.
        if (hijoDer != null) {
            T2 = hijoDer.obtenerTamanio();
        }
        // Retornar tamaño.
        return T1 + T2 + 1;
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        int resultado = -1; // Default, no encontrado.

        // Verificamos si el elemento actual coincide con la busqueda, retornamos cero.
        // En caso contrario, si no tiene hijos, no se encontró, retornamos -1.
        if (unaEtiqueta.compareTo(this.etiqueta) == 0) { // Encontrado.
            return 1;
        } else {
            if ((hijoIzq == null) && (hijoDer == null)) { // No Encontrado.
                return -1;
            }
        }

        // Si tiene hijos, continuamos la búsqueda recursivamente.
        if ((unaEtiqueta.compareTo(this.etiqueta) < 0) && (hijoIzq != null)) {
            resultado = hijoIzq.obtenerNivel(unaEtiqueta);
        }

        if ((unaEtiqueta.compareTo(this.etiqueta) > 0) && (hijoDer != null)) {
            resultado = hijoDer.obtenerNivel(unaEtiqueta);
        }

        // Evaluamos el resultado de la búsqueda, si lo encontramos retornamos el nivel
        // + 1, sino retornamos -1.
        if (resultado >= 0) {
            return resultado += 1;
        } else {
            return resultado;
        }
    }

    @Override
    public int obtenerCantidadHojas() {
        // Hoja.
        if (hijoIzq == null && hijoDer == null){
            return 1;
        }
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
        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }

        if (unaEtiqueta.compareTo(this.getEtiqueta()) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }

        return quitaElNodo();
    }

    private TElementoAB quitaElNodo() {
        if (hijoIzq == null) { // solo tiene un hijo o es hoja
            return hijoDer;
        }

        if (hijoDer == null) { // solo tiene un hijo o es hoja
            return hijoIzq;
        }

        // tiene los dos hijos, buscamos el lexicograficamente anterior
        TElementoAB elHijo = hijoIzq;
        TElementoAB elPadre = this;

        while (elHijo.hijoDer != null) {
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }

        if (elPadre != this) {
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(hijoIzq);
        }

        // Caso en el que el nodo a eliminar tiene como hijos a dos hojas
        elHijo.setHijoDer(hijoDer);
        setHijoIzq(null); // para que no queden referencias y ayudar al collector
        setHijoDer(null);
        // Devuelve el hijo izquierdo
        return elHijo;
    }
}
