package TD1;

public class Ejercicio1 {

    public static void Eje1 () {
        System.out.print ("No, yo ");
        zoop ();
        System.out.print ("Yo ");
        baffle ();
    }
    
    public static void zoop () {
        baffle ();
        System.out.print ("Vos zacata ");
        baffle ();
    }

    public static void baffle () {
        System.out.print ("pac");
        ping ();
    }

    public static void ping () {
        System.out.println (".");
    }    
}
