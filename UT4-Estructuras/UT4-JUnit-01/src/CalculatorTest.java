
public class CalculatorTest {
    
    private Calculator calc;

    @BeforeEach
    public void setUp() throws Exception {
        calc = new Calculator();
    }

    @Test 
    @DisplayName ("Simple Test")
    public void testMultiply() {
        assertEquals(20, calc.multiply(4,5), "Mensaje error");
    }

    @RepeatedTest(5)
    @DisplayName("Zero Handling")
    public void testMultiplyWithZero() {
        assertEquals(0, calc.multiply(0, 5), "Mensaje error 0-5");
        assertEquals(0, calc.multiply(5, 0), "Mensaje error 5-0");
    }
}
