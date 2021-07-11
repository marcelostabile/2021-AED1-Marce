package com.ucudal.implementacionesParcial;

import com.ucudal.tdas.*;

public class TElementoAB<T> implements IElementoAB<T> {

    private final Comparable etiqueta;
    private IElementoAB hijoIzq;
    private IElementoAB hijoDer;
    private final T datos;
    private int frecExito;
    private int frecNoExitoIzq;
    private int frecNoExitoDer;

    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
        frecExito = 0;
        frecNoExitoIzq = 0;
        frecNoExitoDer = 0;
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public IElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public IElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    @Override
    public void setHijoIzq(IElementoAB<T> elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(IElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public IElementoAB<T> buscar(Comparable unaEtiqueta) {
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

    @Override
    public boolean insertar(IElementoAB<T> elemento) {
        if (elemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(elemento);
            } else {
                hijoIzq = elemento;
                return true;
            }
        } else if (elemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(elemento);
            } else {
                hijoDer = elemento;
                return true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    @Override
    public String inOrden() {
        String tempStr = "";        // O(1)
        String separa = "-";        // O(1)

        if (hijoIzq != null) {      // O(1)
            tempStr += hijoIzq.inOrden();
            tempStr += separa;      // O(1)
        }

        tempStr += this.etiqueta.toString();        // O(1)

        if (hijoDer != null) {      // O(1)
            tempStr += separa;      // O(1)
            tempStr += hijoDer.inOrden();
        }
        return tempStr;     // O(1)
    }


    @Override
    public String preOrden() {
        String tempStr = "";        // O(1)
        String separa = "-";        // O(1)

        // Elemento
        tempStr += this.etiqueta.toString();        // O(1)

        // Izquierdo
        if (hijoIzq != null) {      // O(1)
            tempStr += separa;      // O(1)
            tempStr += hijoIzq.preOrden();
        }

        // Derecho
        if (hijoDer != null) {      // O(1)
            tempStr += separa;      // O(1)
            tempStr += hijoDer.preOrden();
        }

        return tempStr;     // O(1)
    }

    @Override
    public String postOrden() {
        String tempStr = "";        // O(1)
        String separa = "-";        // O(1)

        if (hijoIzq != null) {      // O(1)
            tempStr += hijoIzq.postOrden();
            tempStr += separa;      // O(1)
        }

        if (hijoDer != null) {      // O(1)
            tempStr += hijoDer.postOrden();
            tempStr += separa;      // O(1)
        }

        tempStr += this.etiqueta.toString();        // O(1)

        return tempStr;     // O(1)
    }

    @Override
    public void inOrden(Lista<T> unaLista) {

        // Hijo izquierdo.
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);
        }

        // Elemento.
        INodo<T> unNodo = new Nodo<>( (Comparable) this.getEtiqueta(), this.getDatos());
        unaLista.insertar(unNodo);
        
        // Hijo derecho.
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }
    }

    @Override
    public void preOrden(Lista<T> unaLista) {

        // Elemento.
        INodo<T> unNodo = new Nodo<>( (Comparable) this.getEtiqueta(), this.getDatos());
        unaLista.insertar(unNodo);

        // Hijo izquierdo.
        if (hijoIzq != null) {
            hijoIzq.preOrden(unaLista);
        }

        // Hijo derecho.
        if (hijoDer != null) {
            hijoDer.preOrden(unaLista);
        }
    }

    @Override
    public void postOrden(Lista<T> unaLista) {

        // Hijo izquierdo.
        if (hijoIzq != null) {
            hijoIzq.postOrden(unaLista);
        }

        // Hijo derecho.
        if (hijoDer != null) {
            hijoDer.postOrden(unaLista);
        }

        // Elemento.
        INodo<T> unNodo = new Nodo<>( (Comparable) this.getEtiqueta(), this.getDatos());
        unaLista.insertar(unNodo);
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public int obtenerTamanio() {
        int elTam = 1;
        if (hijoIzq != null) {
            elTam = elTam + hijoIzq.obtenerTamanio();

        }
        if (hijoDer != null) {
            elTam = elTam + hijoDer.obtenerTamanio();
        }
        return elTam;
    }

    @Override
    public int obtenerAltura() {
        int subArbolIzquierdo = -1;     // O(1)
        int subArbolDerecho = -1;       // O(1)

        if(hijoIzq != null){        // O(1)
            subArbolIzquierdo = hijoIzq.obtenerAltura();
        }
        if(hijoDer != null){        // O(1)
            subArbolDerecho = hijoDer.obtenerAltura();
        }

        if (subArbolIzquierdo > subArbolDerecho ){      // O(1)
            return 1 + subArbolIzquierdo;       // O(1)
        }
        return 1 + subArbolDerecho;     // O(1)
    }

    @Override
    public IElementoAB eliminar(Comparable unaEtiqueta) {
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

    private IElementoAB quitaElNodo() {
        if (hijoIzq == null) {
            return hijoDer;
        }

        if (hijoDer == null) {
            return hijoIzq;
        }

        IElementoAB elHijo = hijoIzq;
        IElementoAB elPadre = this;

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
    public IElementoAB clonar() {
        return new TElementoAB<>(this.etiqueta, this.datos);
    }

    @Override
    public String imprimir() {
        return (etiqueta.toString());
    }

    @Override
    public int calcularCosto(int[] FrecExito, int[] FrecNoExito, int[] indiceFE, int[] indiceFNE, int nivel) {
        int Costo = 0;
        int CostoIzq = 0;
        int CostoDer = 0;
        if (this.hijoIzq != null) {
            CostoIzq = hijoIzq.calcularCosto(FrecExito, FrecNoExito, indiceFE, indiceFNE, nivel + 1);
        } else {
            CostoIzq = FrecNoExito[indiceFNE[0]] * (nivel + 1);
            indiceFNE[0]++;
        }

        Costo = FrecExito[indiceFE[0]] * nivel;
        indiceFE[0]++;

        if (this.hijoDer != null) {
            CostoDer = hijoDer.calcularCosto(FrecExito, FrecNoExito, indiceFE, indiceFNE, nivel + 1);
        } else {
            CostoDer = FrecNoExito[indiceFNE[0]] * (nivel + 1);
            indiceFNE[0]++;
        }
        return Costo + CostoIzq + CostoDer;
    }


    @Override
    public void completaVectores(IElementoAB[] elementos, int[] FrecExito, int[] FrecNoExito, int[] indiceFE, int[] indiceFNE) {
        if (hijoIzq != null) {
            hijoIzq.completaVectores(elementos, FrecExito, FrecNoExito, indiceFE, indiceFNE);
        } else {
            FrecNoExito[indiceFNE[0]] = this.frecNoExitoIzq;
            indiceFNE[0]++;
        }
        
        elementos[indiceFE[0]] = this.clonar();
        FrecExito[indiceFE[0]] = this.frecExito;
        indiceFE[0]++; 

        if (hijoDer != null) {
            hijoDer.completaVectores(elementos, FrecExito, FrecNoExito, indiceFE, indiceFNE);
        } else {
            FrecNoExito[indiceFNE[0]] = this.frecNoExitoDer;
            indiceFNE[0]++;
        }
    }

    @Override
    public void cuentaFrec(Comparable unaClave) {
        if (unaClave.equals(this.etiqueta)) {
            this.frecExito++;
            return;
        }
        if (unaClave.compareTo(this.etiqueta) < 0) {
            if (hijoIzq != null) {
                hijoIzq.cuentaFrec(unaClave);
            } else {
                this.frecNoExitoIzq++;
            }
            return;
        }
        if (hijoDer != null) {
            hijoDer.cuentaFrec(unaClave);
        } else {
            this.frecNoExitoDer++;
        }
    }
}
