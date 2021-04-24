package farmacia;

import tdas.*;
import java.util.*;

import archivos.ManejadorArchivosGenerico;

public class Almacen implements IAlmacen {

    public ILista<IFarmaco> listaFarmacos;    // Lista de fármacos.
    public ILista<ISuero> listaSueros;    // Lista de sueros.
    public ILista<IPreparado> listaPreparados;    // Lista de preparados.
    public ArrayList<Integer> listaBlanca;    // Lista blanca de fármacos.
    public ArrayList<IPar<Integer, Integer>> listaNegra;    // Lista negra de combinaciones suero-fármaco.

    public Almacen() {
        this.listaFarmacos = new Lista<IFarmaco>();
        this.listaSueros = new Lista<ISuero>();
        this.listaPreparados = new Lista<IPreparado>();
        this.listaBlanca = new ArrayList<>();
        this.listaNegra = new ArrayList<>();
    }

    /**
     * Insertar un nuevo fármaco.
     * @param unFarmaco
     */
    public void insertarFarmaco(IFarmaco unFarmaco) {

        // Creamos un nodo, insertamos el fármaco si no existe en la lista.
        INodo<IFarmaco> nodoFarmaco = new Nodo<IFarmaco>(unFarmaco.getIdFarmaco(), unFarmaco);
        if ( listaFarmacos.buscar(nodoFarmaco.getEtiqueta()) == null ) { listaFarmacos.insertarUltimo(nodoFarmaco); }
    }

    /**
     * Insertar múltiples fármacos a partir de un array String[] que recibimos.
     */
    public void cargaMasivaFarmacos(String[] listaFarmacos) {

        // Recorremos el array String[] ingresando los fármacos.
        for (String registro : listaFarmacos) {
            String[] linea = registro.split(",");
            IFarmaco unFarmaco = new Farmaco(Integer.parseInt(linea[0]), linea[1]);
            INodo<IFarmaco> nodoFarmaco = new Nodo<IFarmaco>(unFarmaco.getIdFarmaco(), unFarmaco);
            this.listaFarmacos.insertarUltimo(nodoFarmaco);
        }
    }

    /**
     * Insertamos un nuevo Suero.
     * @param unSuero
     */
    public void insertarSuero(ISuero unSuero) {

        // Creamos un nodo, insertamos el suero si no existe en la lista.
        INodo<ISuero> nodoSuero = new Nodo<ISuero>( (Comparable) unSuero.getIdSuero(), unSuero);
        if (listaSueros.buscar(nodoSuero.getEtiqueta()) == null) { listaSueros.insertarNodoOrdenado(nodoSuero); }
    }

    /**
     * Insertar múltiples fármacos a partir de un array[] que recibimos.
     */
    public void cargaMasivaSueros(String[] listaSueros) {

        for (String registro : listaSueros) {
            String[] linea = registro.split(",");
            ISuero unSuero = new Suero(Integer.parseInt(linea[0]), linea[1]);
            this.insertarSuero(unSuero);
        }
    }

    /**
     * Insertar preparacion en la lista de preparados.
     */
    public void insertarPreparado(IPreparado unPreparado) {

        INodo<IPreparado> nodoPreparado = new Nodo<IPreparado>(unPreparado.getIdSuero(), unPreparado);
        if (listaPreparados.buscar(nodoPreparado.getEtiqueta()) == null) { listaPreparados.insertarNodoOrdenado(nodoPreparado); }
    }

    /**
     * Carga masiva de elemento en la lista preparados.
     * @param listaPreparados
     */
    public void cargaMasivaPreparados(String[] listaPreparados) {
        
        for (String registro : listaPreparados) {
            String[] linea = registro.split(",");    // suero,farmaco1,farmaco2...,farmacoN
            int idSuero = Integer.parseInt(linea[0]);
            // Manejo de preparados: la cantidad de elementos es variable, evaluamos por el largo de la linea obtenido.
            ArrayList<Integer> listaFarmacos = new ArrayList<Integer>();
            for (int i = 1; i < linea.length; i++) {    // Inicio en i=1 para excluir el suero, está al comienzo de la linea.
                listaFarmacos.add(Integer.parseInt(linea[i]));
            }
            IPreparado unPreparado = new Preparado(idSuero, listaFarmacos);
            this.insertarPreparado(unPreparado);
        }
    }

    /**
     * Insertar fármaco en la lista blanca.
     * @param unFarmaco
     */
    public void ingresarEnListaBlanca(int idFarmaco) {

        // Ingresamos el valor recibido en la lista, si el valor no existe previamente.
        if (listaBlanca.contains(idFarmaco) == false) {listaBlanca.add(idFarmaco); }
    }

    /**
     * Carga masiva de elementos en la lista blanca.
     */
    public void cargaMasivaListaBlanca(String[] listaBlancaFarmacos) {

        for (String registro : listaBlancaFarmacos) {
            this.ingresarEnListaBlanca(Integer.parseInt(registro));
        }
    }

    /**
     * Insertar combinación suero-fármaco en la lista negra.
     */
    public void ingresarEnListaNegra(int idSuero, int idFarmaco) {

        IPar<Integer, Integer> parIncompatible = new Par<>(idSuero, idFarmaco);
        if (listaNegra.contains(parIncompatible) == false) { listaNegra.add(parIncompatible); }    // Insertar en la lista.
    }

    /**
     * Carga masiva de elementos en la lista negra.
     */
    public void cargaMasivaListaNegra(String[] listaNegraSueroFarmaco) {

        for (String registro : listaNegraSueroFarmaco) {
            String[] linea = registro.split(",");
            this.ingresarEnListaNegra(Integer.parseInt(linea[0]), Integer.parseInt(linea[1]));
        }
    }

    /**
     * Listar un preparado.
     */
    public void imprimirPreparado(INodo<IPreparado> nodoPrepActual, String ruta) {
    
        // Reporte para imprimir y guardar en pantalla.
        List<String> reporteArch = new ArrayList<>();

        // Preparación:
        String lineaPrep = "Preparación Nro. " + nodoPrepActual.getEtiqueta().toString();
        reporteArch.add(lineaPrep);

        // Suero:
        int sueroId = nodoPrepActual.getDato().getIdSuero();
        String sueroDesc = "";
        if (this.listaSueros.buscar(sueroId) != null) {
            sueroDesc = this.listaSueros.buscar(sueroId).getDato().getDescSuero();
        } else {
            sueroDesc = "Suero no encontrado.";
        }
        String lineaSuero = "Suero Id." + sueroId + " - " + sueroDesc;
        reporteArch.add(lineaSuero);

        // Fármacos:
        ArrayList<Integer> farmacosLista = nodoPrepActual.getDato().getListaFarmacos();
        String lineaFarmacos = "Fármacos contenidos:" + "\n";
        String farmacoDesc = "";
        for (int farmacoId : farmacosLista) {    // Busco el nombre del fármaco, si no existe indico que no fue encontrado.
            if (this.listaFarmacos.buscar(farmacoId) != null) {
                farmacoDesc = this.listaFarmacos.buscar(farmacoId).getDato().getDescFarmaco();
            } else {
                farmacoDesc = "Fármaco no encontrado.";
            }
            lineaFarmacos += "Fármaco Id." + farmacoId + " - " + farmacoDesc + "\n";
        }
        reporteArch.add(lineaFarmacos);

        String lineaViabilidad = "Viabilidad: ";
        boolean viabilidad = this.preparadoViable(nodoPrepActual.getDato().getIdSuero(), nodoPrepActual.getDato().getListaFarmacos());
        if (viabilidad == true) {
            lineaViabilidad += "Viable.";
        } else {
            lineaViabilidad += "El preparado no es viable.";
        }
        reporteArch.add(lineaViabilidad + "\n");

        // Imprimir resultados.
        System.out.println(lineaPrep + "\n" + lineaSuero + "\n" + lineaFarmacos + "\n" + lineaViabilidad + "\n");

        String[] lineasArchivo = reporteArch.toArray(new String[0]);
        ManejadorArchivosGenerico.escribirArchivo(ruta + "Consultas.txt", lineasArchivo);
    }

    /**
     * Lista todos los preparados de la lista.
     */
    public void listarPreparados(String ruta) {

        INodo<IPreparado> nodoPrepActual = listaPreparados.getPrimero();
        while (nodoPrepActual != null) {
            this.imprimirPreparado(nodoPrepActual, ruta);
            nodoPrepActual = nodoPrepActual.getSiguiente();
        }
    }

    public boolean preparadoViable(int idSuero, ArrayList<Integer> listaFarmacos) {

        // Si no se ingresó el suero o no hay fármacos, no se puede preparar, retorno false.
        if (idSuero == 0) { return false; }
        if (listaFarmacos.isEmpty() == true) { return false; }

        // Recorro la lista de fármacos de la preparación.
        for (int idFarmaco : listaFarmacos) {
            
            // Caso: si el fármaco no está en la lista de fármacos, nos se puede preparar, retorno false.
            if (this.listaFarmacos.buscar(idFarmaco) == null) { return false; }

            // Caso: el fármaco está en la lista blanca, es compatible con todos los sueros.
            // Si no está en la lista blanca, debo revisar la compatibilidad con el suero.
            IPar<Integer, Integer> posibleParIncomp = new Par<>(idSuero, idFarmaco);
            if (this.listaBlanca.contains(idFarmaco) == false)
                for (IPar<Integer, Integer>  par : this.listaNegra) {
                    if (par.getValor1() == posibleParIncomp.getValor1() && par.getValor2() == posibleParIncomp.getValor2()) { 
                        System.out.println(par.getValor1() + "-" + par.getValor2());
                        return false; 
                    }
                }
        }
        return true;
    }

}