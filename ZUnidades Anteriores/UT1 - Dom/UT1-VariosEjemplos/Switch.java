public class OperadorSwitch {
    
    public void operadorSwitchLetrasAleatorias() {

        char c = (char)(Math.random()*26+'a'); // Generación aleatoria de letras minúsculas
        
        System.out.println("La letra " + c );
    
		switch (c) {
        case 'a': // Se compara con la letra a
        case 'e': // Se compara con la letra e
        case 'i': // Se compara con la letra i
        case 'o': // Se compara con la letra o
        case 'u': // Se compara con la letra u        
			System.out.println(" Es una vocal "); break;
 
        default:
            System.out.println(" Es una consonante ");
		}
    }
}
