package institucion;

import java.util.*;
import archivos.*;
import tdas.*;

public class Examen {

    public void main () {

        String ruta = "C:\\AED1-Marce21\\RepoMarcelo\\UT3-TD12-Educativa\\src\\archivos\\";

        IConjunto<IEstudiante> BasicoIng1 = new TConjunto<IEstudiante>();
        IConjunto<IEstudiante> BasicoEmp1 = new TConjunto<IEstudiante>();

        // Cargar datos de archivo "basico-ing1.txt"
        String Basico_Ing_1[] = ManejadorArchivosGenerico.leerArchivo(ruta + "basico-ing1.txt");
        ArrayList<IEstudiante> arrayBasicoIng1 = new ArrayList<>();
        for (String linea : Basico_Ing_1) {
            String[] registro = linea.split(",");
            IEstudiante estudiante = new Estudiante(Integer.parseInt(registro[0]), registro[1]);
            arrayBasicoIng1.add(estudiante);
        }

        // Cargar datos de archivo "basico-emp1.txt"
        String Basico_Emp_1[] = ManejadorArchivosGenerico.leerArchivo(ruta + "basico-emp1.txt");
        ArrayList<IEstudiante> arrayBasicoEmp1 = new ArrayList<>();
        for (String linea : Basico_Emp_1) {
            String[] registro = linea.split(",");
            IEstudiante estudiante = new Estudiante(Integer.parseInt(registro[0]), registro[1]);
            arrayBasicoEmp1.add(estudiante);
        }

        // Inserto los estudiantes en los conjuntos.
        BasicoIng1.insertarElementos(arrayBasicoIng1);
        BasicoEmp1.insertarElementos(arrayBasicoEmp1);

        // Asignar los estudiantes que cursaron BasicoIng1 y/o BasicoEmp1.
        // Conjunto Unión.
        // Guardar este conjunto en el archivo Integrador101.txt        
        IConjunto<IEstudiante> Integrador101 = new TConjunto<IEstudiante>();
        System.out.println("imprimiendo1");
        Integrador101.getLista().imprimir("-");
        Integrador101 = BasicoIng1.union(BasicoEmp1);

        List<String> lista1 = new ArrayList<String>();
        INodo<IEstudiante> actual1 = Integrador101.getPrimero();
        while (actual1 != null) {
            lista1.add(actual1.getDato().getCodigoEstudiante() + "," + actual1.getDato().getNombreEstudiante());
            actual1 = actual1.getSiguiente();
        }
        String[] listaIntegrador = lista1.toArray(new String[0]);
        ManejadorArchivosGenerico.escribirArchivo(ruta + "Integrador101.txt", listaIntegrador);

        // Asignar los estudiantes que cursaron BasicoIng1 y BasicoEmp1.
        // Conjunto Intersección.
        // Guardar este conjunto en el archivo Exigente102.txt
        IConjunto<IEstudiante> Exigente102 = new TConjunto<IEstudiante>();
        System.out.println("imprimiendo2");
        Exigente102.getLista().imprimir("-");
        Exigente102 = BasicoIng1.interseccion(BasicoEmp1);

        List<String> lista2 = new ArrayList<String>();
        INodo<IEstudiante> actual2 = Exigente102.getPrimero();
        while (actual2 != null) {
            lista2.add(actual2.getDato().getCodigoEstudiante() + "," + actual2.getDato().getNombreEstudiante());
            actual2 = actual2.getSiguiente();
        }
        String[] listaExigente = lista2.toArray(new String[0]);
        ManejadorArchivosGenerico.escribirArchivo(ruta + "Exigente102.txt", listaExigente);

    }

}