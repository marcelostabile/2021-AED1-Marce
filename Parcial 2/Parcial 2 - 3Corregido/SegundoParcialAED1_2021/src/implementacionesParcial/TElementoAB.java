package implementacionesParcial;

import mutualista.*;
import tdas.*;
import tdas.*;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private IElementoAB<T> hijoIzq;
    private IElementoAB<T> hijoDer;
    private T datos;

    public TElementoAB(Comparable etiqueta, T datos) {
        this.etiqueta = etiqueta;
        this.datos = datos;
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Comparable etiqueta) {
        this.etiqueta = etiqueta;
    }

    public IElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(IElementoAB<T> hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public IElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(IElementoAB<T> hijoDer) {
        this.hijoDer = hijoDer;
    }

    public void setDatos(T datos) {
        this.datos = datos;
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

    @Override
    public void inOrden(Lista<T> unaLista) {
        // Hijo izquierdo.
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);
        }

        // Elemento.
        Nodo<T> unNodo = new Nodo<T>( (Comparable) this.getEtiqueta(), this.getDatos());
        unaLista.insertar(unNodo);

        // Hijo derecho.
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }
    }

    @Override
    public T getDatos() {
        return this.datos;
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

    @Override
    public String imprimir() {
        return this.getEtiqueta().toString();
    }



    private IElementoAB quitaElNodo() {
        if (hijoIzq == null) { // solo tiene un hijo o es hoja
            return hijoDer;
        }
        if (hijoDer == null) { // solo tiene un hijo o es hoja
            return hijoIzq;
        }
        // tiene los dos hijos, buscamos el lexicograficamente anterior
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
        // Caso en el que el nodo a eliminar tiene como hijos a dos hojas
        elHijo.setHijoDer(hijoDer);
        setHijoIzq(null); // para que no queden referencias y ayudar al collector
        setHijoDer(null);
        // Devuelve el hijo izquierdo
        return elHijo;
    }

    @Override
    
    public void indizar(Lista<Especialidad> especialidades) {

        // Socio
        Socio socio = (Socio) this.datos;
        IElementoAB<Socio> nuevoSocio = new TElementoAB<>(socio.getApellido(), socio);

        // Especialidad a partir del socio
        INodo<Especialidad> nodoEspecialidad = especialidades.buscar(socio.getConsultaEspecialidadDelDia());
        
        // Si la especialidad no existe, creamos una nueva
        if (nodoEspecialidad == null) {
            Especialidad nuevaEsp = new Especialidad(socio.getConsultaEspecialidadDelDia());
            INodo<Especialidad> nodoNuevaEsp = new Nodo<>(nuevaEsp.getNombreEspecialidad(), nuevaEsp);
            nodoNuevaEsp.getDato().getIndiceSociosEspecialidad().insertar(nuevoSocio);
            especialidades.insertar(nodoNuevaEsp);
        } else {
            nodoEspecialidad.getDato().getIndiceSociosEspecialidad().insertar(nuevoSocio);
        }

        if (hijoIzq != null) {
            hijoIzq.indizar(especialidades);
        }

        if (hijoDer != null) {
            hijoDer.indizar(especialidades);
        }
        
    }

}
