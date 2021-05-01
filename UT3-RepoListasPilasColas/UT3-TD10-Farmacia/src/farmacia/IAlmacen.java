package farmacia;

import java.util.ArrayList;
import tdas.*;

public interface IAlmacen {
    
    /**
     * Insertar un nuevo fármaco.
     * @param unFarmaco
     */
    public void insertarFarmaco(IFarmaco unFarmaco);

    /**
     * Insertar múltiples fármacos a partir de un array String[] que recibimos.
     */
    public void cargaMasivaFarmacos(String[] listaFarmacos);

    /**
     * Insertamos un nuevo Suero.
     * @param unSuero
     */
    public void insertarSuero(ISuero unSuero);

    /**
     * Insertar múltiples fármacos a partir de un array[] que recibimos.
     */
    public void cargaMasivaSueros(String[] listaSueros);

    /**
     * Insertar fármaco en la lista blanca.
     * @param unFarmaco
     */
    public void ingresarEnListaBlanca(int idFarmaco);

    /**
     * Carga masiva de elementos en la lista blanca.
     */
    public void cargaMasivaListaBlanca(String[] listaBlancaFarmacos);

    /**
     * Insertar combinación suero-fármaco en la lista negra.
     */
    public void ingresarEnListaNegra(int idSuero, int idFarmaco);

    /**
     * Carga masiva de elementos en la lista negra.
     */
    public void cargaMasivaListaNegra(String[] listaNegraSueroFarmaco);

    /**
     * Insertar preparacion en la lista de preparados.
     */
    public void insertarPreparado(IPreparado unPreparado);

    /**
     * Carga masiva de elemento en la lista preparados.
     * @param listaPreparados
     */
    public void cargaMasivaPreparados(String[] listaPreparados);

    /**
     * Listar un preparado.
     */
    public void imprimirPreparado(INodo<IPreparado> nodoPrepActual, String ruta);

    /**
     * Lista todos los preparados de la lista.
     */
    public void listarPreparados(String ruta);

    /**
     * Dado un preparado, retorna si es viable o no.
     * 
    */
    public boolean preparadoViable(int idSuero, ArrayList<Integer> listaFarmacos);



}
