import org.junit.*;
import static org.junit.Assert.*;

//EXERCISE - 04
public class LoanCalculatorTest {

    private LoanCalculator calculator;

    // Arrange
    @Before
    public void setUp() {
        calculator = new LoanCalculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testCalculateEMI() {
        // Act
        double emi = calculator.calculateEMI(100000, 10, 1);
        // Assert
        assertEquals(8791.59, emi, 0.1);
    }

    @Test
    public void testCalculateTotalPayment() {
        double total = calculator.calculateTotalPayment(8791.59, 1);
        assertEquals(105499.08, total, 0.1);
    }
}
