package tdas;

import java.time.temporal.Temporal;

public class ElementoAB<T> implements IElementoAB<T> {
    
    private Comparable etiqueta;
    private ElementoAB<T> hijoIzquierdo;
    private ElementoAB<T> hijoDerecho;
    private T datos;

    /**
     * Constructor ElementoAB.
     * @param etiqueta (Comparable)
     * @param datos (T)
     */
    public ElementoAB(Comparable etiqueta, T datos) {
        this.etiqueta = etiqueta;
        this.datos = datos;
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public ElementoAB<T> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public ElementoAB<T> getHijoDerecho() {
        return hijoDerecho;
    }

    public T getDatos() {
        return datos;
    }

    /**
     * Método para insertar un elemento (descendiente).
     * 
     * Verificamos si la etiqueta del elementoAB es mayor o menor respecto a la etiqueta de nuestro elemento.
     * Si es menor se inserta recursavimente en el hijo izquierdo, de lo contrario en el hijo derecho.
     * No es pre, post o In-Orden porque no hacemos cambios en el elemento raiz. 
     * @param elementoAB (T)
     */
    public boolean insertar(ElementoAB<T> elementoAB) {

        if (elementoAB.getEtiqueta().compareTo(this.etiqueta) < 0) {   // Etiqueta de menor valor.
            if (hijoIzquierdo == null) {   // Se inserta como hijo izquierdo, si ya tiene se inserta recursivamente.
                hijoIzquierdo = elementoAB;
                return true;
            } else {
                return hijoIzquierdo.insertar(elementoAB);
            }

        } else if (elementoAB.getEtiqueta().compareTo(this.etiqueta) > 0) {   // Etiqueta de mayor valor.
            if (hijoDerecho == null) {   // Se inserta como hijo derecho, si ya tiene se inserta recursivamente.
                hijoDerecho = elementoAB;
                return true;
            } else {
                return hijoDerecho.insertar(elementoAB);
            }

        } else {   // Etiqueta repetida, no se inserta.
            return false;
        }
    }

    /**
    * Método para buscar un elemento.
    * 
    * Verificamos si la etiqueta ingresada coincide con este elemento, si coincide retornamos el elemento.
    * Si no coincide recorremos recursivamente los hijos. Si no se encuentra retornamos null.
    * Pre-Orden.
    * @param etiqueta (T)
    */
   public ElementoAB<T> buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.compareTo(this.getEtiqueta()) == 0) {   // La etiqueta de este elemento coincide con la búsqueda.
            return this;

        } else if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
                if (hijoIzquierdo == null) {
                    return null;
                } else {
                    return hijoIzquierdo.buscar(unaEtiqueta);
                }
                
        } else if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
                if (hijoDerecho == null) {
                    return null;
                } else {
                    return hijoDerecho.buscar(unaEtiqueta);
                }
        
        } else {
            return null;
        }
    }





    
    /**
     * Recorrido Pre-Orden.
     * 
     * Elemento, HijoIzquierdo, HijoDerecho.
     * @return cadena de etiquetas.
     */
    public String preOrden() {

        StringBuilder tempStr = new StringBuilder();
        String separador = ",";

        // Elemento.
        tempStr.append(this.etiqueta);
        // Hijo izquierdo.
        if (hijoIzquierdo != null) {
            tempStr.append(separador);
            tempStr.append(hijoIzquierdo.preOrden());
        }
        // Hijo derecho.
        if (hijoDerecho != null) {
            tempStr.append(separador);
            tempStr.append(hijoDerecho.preOrden());
        }
        return tempStr.toString();
    }

    /**
     * Recorrido Post-Orden.
     * 
     * HijoIzquierdo, HijoDerecho, Elemento
     * @return cadena de etiquetas.
     */
    public String postOrden() {

        StringBuilder tempStr = new StringBuilder();
        String separador = ",";

        // Hijo izquierdo.
        if (hijoIzquierdo != null) {
            tempStr.append(hijoIzquierdo.postOrden());
            tempStr.append(separador);
        }
        // Hijo derecho.
        if (hijoDerecho != null) {
            tempStr.append(hijoDerecho.postOrden());
            tempStr.append(separador);
        }
        // Elemento.
        tempStr.append(this.etiqueta);

        return tempStr.toString();
    }

    /**
     * Recorrido In-Orden.
     * 
     * HijoIzquierdo, Elemento, HijoDerecho.
     * @return cadena de etiquetas.
     */
    public String inOrden() {

        StringBuilder tempStr = new StringBuilder();
        String separador = ",";

        // Hijo izquierdo.
        if (hijoIzquierdo != null) {
            tempStr.append(hijoIzquierdo.inOrden());
            tempStr.append(separador);
        }
        // Elemento.
        tempStr.append(this.etiqueta);
        // Hijo derecho.
        if (hijoDerecho != null) {
            tempStr.append(separador);
            tempStr.append(hijoDerecho.inOrden());
        }
        return tempStr.toString();
    }

    /**
     * Método para determinar la altura del árbol.
     * @return entero.
     */
    public int calcularAltura() {

        int A1 = -1;
        int A2 = -1;
        if (this.hijoIzquierdo != null) {
            A1 = this.hijoIzquierdo.calcularAltura();
        }
        if (this.hijoDerecho != null) {
            A2 = this.hijoDerecho.calcularAltura();
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
     * Recorro recursivamente el árbol, por cada nodo sumo uno, retorno el resultado.
     * @return entero
     */
    public int calcularTamano() {

        int T1 = 0;
        int T2 = 0; 

        // Hijo izquierdo.
        if (hijoIzquierdo != null) {
            T1 += hijoIzquierdo.calcularTamano();
        }
        // Hijo derecho.
        if (hijoDerecho != null) {
            T2 += hijoDerecho.calcularTamano();
        }
        // Retornar tamaño.
        return T1 + T2 + 1;
    }

    /**
     * Calcular hojas.
     * 
     * Recorro recursivamente el árbol, por cada hoja sumo uno, retorno el resultado.
     * @return entero
     */
    public int calcularHojas() {

        // Hoja.
        if (hijoIzquierdo == null && hijoDerecho == null) 
            return 1;

        // Cantidad de Hojas.
        int H1 = 0;
        int H2 = 0;

        // Hijo izquierdo.
        if (hijoIzquierdo != null) {
            H1 += hijoIzquierdo.calcularHojas();
        }
        // Hijo derecho.
        if (hijoDerecho != null) {
            H2 += hijoDerecho.calcularHojas();
        }

        // Retornar valor.
        return H1 + H2;
    }

    /**
     * Calcular elementos internos.
     * 
     * Recorro recursivamente el árbol, por cada elemento que no es hoja sumo uno, retorno el resultado.
     * @return entero
     */
    public int calcularInternos() {

        int I1 = 0;
        int I2 = 0; 

        // Si es hoja retorna cero.
        if (hijoIzquierdo == null && hijoDerecho == null) {
            return 0;
        } else {
            // Hijo izquierdo.
            if (hijoIzquierdo != null) {
                I1 += hijoIzquierdo.calcularInternos();
            }
            // Hijo derecho.
            if (hijoDerecho != null) {
                I2 += hijoDerecho.calcularInternos();
            }
            // Retornar valor.
            return I1 + I2 + 1;
        }
    }

    /**
     * Calcular elementos internos completos.
     * 
     * Recorro recursivamente el árbol, por cada elemento interno completo sumo uno, retorno el resultado.
     * @return entero
     */
    public int calcularInternosCompletos() {

        int C1 = 0;
        int C2 = 0; 

        // Si es hoja retorna cero.
        if (hijoIzquierdo == null && hijoDerecho == null) {
            return 0;
        } else {
            // Hijo izquierdo.
            if (hijoIzquierdo != null) {
                C1 += hijoIzquierdo.calcularInternos();
            }
            // Hijo derecho.
            if (hijoDerecho != null) {
                C2 += hijoDerecho.calcularInternos();
            }
            if (hijoIzquierdo != null && hijoDerecho != null) {
                return C1 + C2 + 1;
            } else {
                return C1 + C2;
            }
        }
    }



}
