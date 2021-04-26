import TA2.*;
import TD1.Ejercicio1;
import TD1.Ejercicio2;
import TD1.Multsuma;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Factorial - Resultado: " + UtilMath.factorial(3));

        System.out.println("Resultado: " + SumarParImpar.sumarNumeros(10));

        System.out.println("Resultado: " + SumarParImpar.sumarNumeros(11));

        TA3.Principal.pruebaContadorPalabras();

        /* 
        UT1-TA3-Ejercicio 3 
        */

        /*
        Parte 1: descripción con lenguaje natural.

        Firma: public String[] obtenerLineas (String archivo)

        El método recibe un string indicando la ruta y nombre del archivo.
        Inicializamos un ArrayList "lineasArchivo" donde almacenaremos las líneas leídas del archivo.
        Decido utilizar un ArrayList porque desconozco el largo del archivo.
        Para la lectura del archivo empleamos las clases de Java: FileReader y BufferedReader del paquete java.io.*
        FileReader nos permite acceder al archivo para su lectura y BufferedReader lo utilizamos para leer línea a línea.
        Empleamos un bucle while para recorrer todo el archivo línea a línea hasta el final.
        Para cada línea leída, agregamos a nuestro ArrayList un registro.
        Dentro del while también empleamos un contador incremental "posicion" que nos permitirá devolver en pantalla la cantidad de líneas leídas.
        Una vez finalizada la lectura, imprimimos en pantalla la cantidad de líneas del archivo.
        Necesitamos instanciar un vector String "lineas" y volcar nuestro ArrayList en este, para luego retornar el vector, cumpliendo con los requerimientos solicitados.
        */        

        /* El siguiente datos se debe recibir por consola, en este caso usamos una variable ha efectos de prueba: */
        String[] argumentos = {"C:\\AED1\\UT1\\src\\TA3\\ARCHIVO_EJEMPLO.TXT"}; 

        TA3.Principal.pruebaObtenerLineas(argumentos);

        UT_ManejadorArchivos.Principal.pruebaManejador();

        Ejercicio1.Eje1();

        Ejercicio2.Eje2();
        
        Multsuma.multsuma(1.0, 2.0, 3.0);
    }
}
