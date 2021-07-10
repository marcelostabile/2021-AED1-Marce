package tdas;

import javax.swing.text.Caret;

import universidad.*;

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

    @Override
    public void inOrden(Lista<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);

        }
        Nodo<T> unNodo = new Nodo<>(this.getEtiqueta(), this.getDatos());
        unaLista.insertar(unNodo);
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
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void indizar(Lista<Carrera> carreras) {

        /**
         * PREORDEN
         * Verifico si existe la carrera en la lista, si no existe, agrego un nodo con la carrera nueva.
         * En todos los casos, agrego el alumno a la carrera.
         */
        Alumno alumno = (Alumno) this.datos;
        TElementoAB<Alumno> unAlumno = new TElementoAB<Alumno>(alumno.getCodigo(), alumno);
        Nodo<Carrera> nodoCarrera = carreras.buscar(alumno.getCarrera());
        if (nodoCarrera == null) { 
            Carrera unaCarrera = new Carrera(alumno.getCarrera());
            Nodo<Carrera> nodo = new Nodo<>(unaCarrera.getNombreCarrera().trim(), unaCarrera);
            nodo.getDato().getIndiceCarrera().insertar(unAlumno);
            carreras.insertar(nodo);
        } else {
            nodoCarrera.getDato().getIndiceCarrera().insertar(unAlumno);
        }

        /**
         * Recursivamente verifico los hijos del elemento.
         */
        if (hijoIzq != null) {
            hijoIzq.indizar(carreras);
        }

        if (hijoDer != null) {
            hijoDer.indizar(carreras);
        }
        
    }

    public void listadoOrdenDescendente(String listaResultado) {

        if (this.hijoDer != null) {
            this.hijoDer.listadoOrdenDescendente(listaResultado);
        }

        Alumno alumno = (Alumno) this.datos;
        listaResultado += alumno.getApellido() + "," + alumno.getCodigo() + "\n";
        System.out.println(listaResultado);

        if (this.hijoIzq != null) {
            this.hijoIzq.listadoOrdenDescendente(listaResultado);
        }
    }
    
}
