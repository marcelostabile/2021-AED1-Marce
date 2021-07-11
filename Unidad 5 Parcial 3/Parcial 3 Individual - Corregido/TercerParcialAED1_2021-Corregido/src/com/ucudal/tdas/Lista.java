package com.ucudal.tdas;

public class Lista<T> implements ILista<T> {

    private INodo<T> primero;

    public Lista() {
        primero = null;
    }


    @Override
    public void insertar(INodo<T> unNodo) {
        if (esVacia()) {
            primero = unNodo;
        } else {
            INodo<T> aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(unNodo);
        }
    }

    @Override
    public INodo<T> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            INodo<T> aux = primero;
            while (aux != null) {
                if (aux.getEtiqueta().compareTo(clave) == 0) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    @Override
    public INodo<T> eliminar(Comparable clave) {
        if (esVacia()) {
            return null;
        }

        INodo<T>  resultado = primero;
        if (resultado.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            primero = resultado.getSiguiente();

            return resultado;
        }
        
        INodo<T> aux = primero;
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().compareTo(clave) == 0) {
                resultado  = aux.getSiguiente();
                aux.setSiguiente(resultado.getSiguiente());
                return resultado;

            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    @Override
    public void imprimir() {
        if (!esVacia()) {
            INodo<T> temp = primero;
            while (temp != null) {
                temp.imprimirEtiqueta();
                temp = temp.getSiguiente();
            }
        }
    }

    public String imprimir(String separador) {
        String aux = "";
        if (esVacia()) {
            return "";
        } else {
            INodo<T> temp = primero;
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;
    }

    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            INodo aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public INodo<T> getPrimero() {
        return primero;
    }

    @Override
    public void setPrimero(INodo<T> unNodo) {
        this.primero = unNodo;
    }
}