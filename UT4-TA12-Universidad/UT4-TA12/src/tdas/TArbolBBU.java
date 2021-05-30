package tdas;

import universidad.*;

public class TArbolBBU extends TArbolBB<Alumno>  implements IArbolBBU {

    //@Override
    public void armarIndicesCarrreras(Lista<Carrera> carreras) {
        if (!this.esVacio()) {
            this.getRaiz().indizar(carreras);
        }
    }

}
