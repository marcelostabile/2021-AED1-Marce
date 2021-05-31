package tdas;

import universidad.*;

public class TArbolBBU extends TArbolBB<Alumno>  implements IArbolBBU {

    //@Override
    public void armarIndicesCarreras(Lista<Carrera> carreras) {
        if (!this.esVacio()) {
            this.getRaiz().indizar(carreras);
        }
    }

    public String listadoApellidoDescendente() {

        String listaResultado = "";

        if (!esVacio()) {
            this.getRaiz().listadoOrdenDescendente(listaResultado);
        }

        return listaResultado;
    }

}
