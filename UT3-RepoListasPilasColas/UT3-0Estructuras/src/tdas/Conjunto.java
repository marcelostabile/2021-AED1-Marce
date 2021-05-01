package tdas;

public class Conjunto<T> extends Lista<T> implements IConjunto<T> {

    /**
     * UNION
     * El conjunto UNION contiene todos los elementos del conjunto A y del conjunto B.
     *
     * Creo una nueva lista resultado, recorro el conjunto A y agrego todos los elementos en mi lista.
     * Recorro el conjunto B, verifico si cada elemento no existe previamente, si no existe lo agrego.
     * Retorno el conjunto resultado conteniendo la union de ambos conjuntos.
     *
     * Este método es de orden cuadratico : O(N^2), siendo N el largo del conjunto.
    */
    public IConjunto<T> union(IConjunto<T> otroConjunto) {

        IConjunto<T> conjuntoResultado = new Conjunto<T>();

        // Conjunto A
        INodo<T> actual = this.getPrimero();    
        while (actual != null) {
            conjuntoResultado.insertarUltimo(actual.clonar());
            actual = actual.getSiguiente();
        }

        // Conjunto B
        actual = otroConjunto.getPrimero();
        while (actual != null) {
            if (conjuntoResultado.buscar(actual.getEtiqueta()) == null) {
                conjuntoResultado.insertarPrimero(actual.clonar());
            }
            actual = actual.getSiguiente();
        }
        return conjuntoResultado;
    }   

    /**
     * El conjunto INTERSECCIÓN contiene todos los elementos comunes de ambos conjuntos.
     * 
     * Creo una nueva lista resultado, verifico cúal de mis conjuntos contiene menos elementos.
     * Utilizaremos el conjunto más pequeño como referencia, buscando en el más largo si existe el elemento.
     * Esto es más eficiente que recorrer el conjunto más largo como referencia.
     * Para cada coincidencia, copiamos el elemento al conjunto resultado, que finalmente retornamos.
     * 
     * Este método es de orden cuadratico : O(N^2), siendo N el largo del conjunto.    
     */
    public IConjunto<T> interseccion(IConjunto<T> otroConjunto) {
        
        IConjunto<T> conjuntoResultado = new Conjunto<T>();

        IConjunto<T> listaPrincipal = new Conjunto<T>();
        IConjunto<T> listaReferencia = new Conjunto<T>();

        // Verificar el conjunto más pequeño.
        if (this.cantElementos() <= otroConjunto.cantElementos()) {
            listaPrincipal = this;
            listaReferencia = otroConjunto;
        } else {
            listaPrincipal = otroConjunto;
            listaReferencia = this;
        }

        INodo<T> actual = listaPrincipal.getPrimero();
        while (actual != null) {
            if (listaReferencia.buscar(actual.getEtiqueta()) != null) {
                conjuntoResultado.insertarPrimero(actual.clonar());
            }
            actual = actual.getSiguiente();
        }
        return conjuntoResultado;
    }

    /**
     * El conjunto DIFERENCIA contiene elementos de A que no pertenecen al conjunto B.
     * 
     * Creo una nueva lista para el conjunto resultado.
     * Recorro el conjunto A y para cada elemento verifico si existe en el conjunto B.
     * Si no existe agrego el elemento al conjunto resultado, al final devuelvo estos resultados.
     */
    public IConjunto<T> diferencia(IConjunto<T> otroConjunto) {

        IConjunto<T> conjuntoResultado = new Conjunto<T>();

        INodo<T> actual = this.getPrimero();
        while (actual != null) {
            if (otroConjunto.buscar(actual.getEtiqueta()) == null) { 
                conjuntoResultado.insertarPrimero(actual.clonar());
            }
            actual = actual.getSiguiente();
        }
        return conjuntoResultado;
    }

    /**
     * El conjunto DIFERENCIA SIMÉTRICA contiene los elementos de A y B que no son comunes.
     *
     * Recorro el primer conjunto, para cada elemento verifico si existe en el conjunto B, 
     * si no existe lo agrego al conjunto resultado.
     * Luego recorreo el segundo conjunto, para cada elemento verifico si existe en el conjunto A 
     * y en el conjunto resultado. Si no existe en ambos lo agrego al conjunto resultado.
    */
    public IConjunto<T> diferenciaSimetrica(IConjunto<T> otroConjunto) {

        IConjunto<T> conjuntoResultado = new Conjunto<T>();

        // Conjunto A
        INodo<T> actual = this.getPrimero();
        while (actual != null) {
            if (otroConjunto.buscar(actual.getEtiqueta()) == null) {
                conjuntoResultado.insertarPrimero(actual.clonar());
            }
            actual = actual.getSiguiente();
        }

        // Conjunto B
        actual = otroConjunto.getPrimero();
        while (actual != null) {
            if ( (this.buscar(actual.getEtiqueta()) == null) && (conjuntoResultado.buscar(actual.getEtiqueta()) == null) ) {
                conjuntoResultado.insertarPrimero(actual.clonar());
            }
            actual = actual.getSiguiente();
        }
        return conjuntoResultado;
    }

    /**
     * El conjunto COMPLEMENTO son todos los elementos que no pertenecen al conjunto A.
     * 
     * Recibimos un conjunto B que define el universo de números ha evaluar.
     * Para cada elemento del conjunto B, verifico si exite en el conjunto A.
     * Los números que no existen los agrego al conjunto resultado, que luego devuelvo.
     */
    public IConjunto<T> complemento(IConjunto<T> otroConjunto) {

        IConjunto<T> conjuntoResultado = new Conjunto<>();

        INodo<T> actual = otroConjunto.getPrimero();
        while (actual != null) {
            if (this.buscar(actual.getEtiqueta()) == null) {
                conjuntoResultado.insertarPrimero(actual.clonar());
            }
            actual = actual.getSiguiente();
        }
        return conjuntoResultado;
    }

    /**
     * Imprimir Conjunto.
     */
    public void imprimirConjunto(IConjunto<T> conjunto) {

        INodo<T> actual = conjunto.getPrimero();
        String cadena = "";
        while (actual != null) {
            cadena += actual.getEtiqueta();
            if (actual.getSiguiente() != null) { cadena += ","; }
            actual = actual.getSiguiente();
        }
        System.out.println(cadena);
    }

}
