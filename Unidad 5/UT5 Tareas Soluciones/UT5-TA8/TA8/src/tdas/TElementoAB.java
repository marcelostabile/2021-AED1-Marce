package tdas;

public class TElementoAB<T> implements IElementoAB<T> {

    private final Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private final T datos;
    private int frecExito;
    private int frecNoExitoIzq;
    private int frecNoExitoDer;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    public TElementoAB getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB getHijoDer() {
        return hijoDer;
    }

    public int getFrecExito() {
        return frecExito;
    }

    public int getFrecNoExitoIzq() {
        return frecNoExitoIzq;
    }

    public int getFrecNoExitoDer() {
        return frecNoExitoDer;
    }

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(TElementoAB unElemento) {
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
     * altura: O(N) , N siendo la cantidad de elementos del arbol
     */
    public int altura() {

        int subArbolIzquierdo = -1; // O(1)
        int subArbolDerecho = -1; // O(1)

        if (hijoIzq != null) { // O(1)
            subArbolIzquierdo = hijoIzq.altura();
        }
        if (hijoDer != null) { // O(1)
            subArbolDerecho = hijoDer.altura();
        }

        if (subArbolIzquierdo > subArbolDerecho) { // O(1)
            return 1 + subArbolIzquierdo; // O(1)
        }
        return 1 + subArbolDerecho; // O(1)

    }

    /**
     * tamano: O(N) , N siendo la cantidad de elementos del arbol
     */
    public int tamano() {

        int subArbolIzquierdo = 0; // O(1)
        int subArbolDerecho = 0; // O(1)

        if (hijoIzq != null) { // O(1)
            subArbolIzquierdo = hijoIzq.tamano();
        }
        if (hijoDer != null) { // O(1)
            subArbolDerecho = hijoDer.tamano();
        }

        return subArbolIzquierdo + subArbolDerecho + 1; // O(1)

    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    public TElementoAB buscar(Comparable unaEtiqueta) {

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
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().inOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().inOrden());
        }

        return tempStr.toString();
    }

    /**
     * @return recorrida en preOrden del subArbol que cuelga del elemento actual
     */
    public String preOrden() {
        StringBuilder tempStr = new StringBuilder();
        tempStr.append(imprimir());
        if (hijoIzq != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoIzq().preOrden());
        }
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().preOrden());
        }
        return tempStr.toString();
    }

    /**
     * @return recorrida en postOrden del subArbol que cuelga del elemento actual
     */
    @Override
    public String postOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().postOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        if (hijoDer != null) {
            tempStr.append(getHijoDer().postOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        return tempStr.toString();
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    public T getDatos() {
        return datos;
    }

    public void setHijoIzq(TElementoAB elemento) {
        this.hijoIzq = elemento;

    }

    public void setHijoDer(TElementoAB elemento) {
        this.hijoDer = elemento;
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
        if (hijoIzq == null) {
            return hijoDer;
        }

        if (hijoDer == null) {
            return hijoIzq;
        }

        TElementoAB elHijo = hijoIzq;
        TElementoAB elPadre = this;

        while (elHijo.getHijoDer() != null) {
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }

        if (elPadre != this) {
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(hijoIzq);
        }

        elHijo.setHijoDer(hijoDer);
        return elHijo;
    }

    @Override
    public void inOrden(Lista<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);

        }
        unaLista.insertar(new Nodo<T>(this.etiqueta, this.getDatos()));
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }

    }

    @Override
    public void preOrden(Lista<T> unaLista) {
        unaLista.insertar(new Nodo<T>(this.etiqueta, this.getDatos()));
        if (hijoIzq != null) {
            hijoIzq.preOrden(unaLista);
        }

        if (hijoDer != null) {
            hijoDer.preOrden(unaLista);
        }

    }

    @Override
    public void postOrden(Lista<T> unaLista) {

        if (hijoIzq != null) {
            hijoIzq.postOrden(unaLista);
        }

        if (hijoDer != null) {
            hijoDer.postOrden(unaLista);
        }
        unaLista.insertar(new Nodo<T>(this.etiqueta, this.getDatos()));
    }

    @Override
    public int calcularCosto(int[] frecExito, int[] frecNoExito, int[] indiceFE, int[] indiceFNE, int nivel) {
        Integer costo = 0;
        if (hijoIzq != null) {
            costo += hijoIzq.calcularCosto(frecExito, frecNoExito, indiceFE, indiceFNE, nivel + 1);
        } else {
            costo += frecNoExito[indiceFNE[0]] * (nivel + 1);
            indiceFNE[0] = indiceFNE[0] + 1;
        }

        costo += nivel * frecExito[indiceFE[0]];
        indiceFE[0] = indiceFE[0] + 1;

        if (hijoDer != null) {
            costo += hijoDer.calcularCosto(frecExito, frecNoExito, indiceFE, indiceFNE, nivel + 1);
        } else {
            costo += frecNoExito[indiceFNE[0]] * (nivel + 1);
            indiceFNE[0] = indiceFNE[0] + 1;
        }
        return costo;
    }

    public void cuentaFrec(Comparable unArgumento) {
        if (unArgumento.compareTo(etiqueta) == 0) {
            this.frecExito++;
        } else if (unArgumento.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                hijoIzq.cuentaFrec(unArgumento);
            } else {
                this.frecNoExitoIzq++;
            }
        } else {
            if (hijoDer != null) {
                hijoDer.cuentaFrec(unArgumento);
            } else {
                this.frecNoExitoDer++;
            }
        }

    }

    public void completaVectores(Comparable[] claves, int[] frecExito, int[] frecNoExito, int[] indiceFE,
            int[] indiceFNE) {
        if (hijoIzq != null) {
            hijoIzq.completaVectores(claves, frecExito, frecNoExito, indiceFE, indiceFNE);
        } else {
            frecNoExito[indiceFNE[0]] = frecNoExitoIzq;
            indiceFNE[0] = indiceFNE[0] + 1;
        }
        claves[indiceFE[0]] = this.etiqueta;
        frecExito[indiceFE[0]] = this.frecExito;
        indiceFE[0] = indiceFE[0] + 1;

        if (hijoDer != null) {
            hijoDer.completaVectores(claves, frecExito, frecNoExito, indiceFE, indiceFNE);
        } else {
            frecNoExito[indiceFNE[0]] = frecNoExitoDer;
            indiceFNE[0] = indiceFNE[0] + 1;
        }
    }

    public int cumpleAVL(boolean[] cumple) {
        int subArbolIzq = -1;
        int subArbolDer = -1;

        if (hijoIzq != null) {
            subArbolIzq = hijoIzq.cumpleAVL(cumple);
        }
        if (hijoDer != null && cumple[0]) {
            subArbolDer = hijoDer.cumpleAVL(cumple);
        }
        if (Math.abs(subArbolIzq - subArbolDer) > 1) {
            cumple[0] = false;
        }
        if (subArbolIzq > subArbolDer) {
            return 1 + subArbolIzq;
        }
        return 1 + subArbolDer;
    }
}
