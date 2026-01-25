

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SimpleCalculatorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SimpleCalculatorTest
{
    //Arrange
    SimpleCalculator sc = new SimpleCalculator();
    @Test
    public void add_Test(){
        //Act
        int result1 = sc.add(5 , 3);
        int result2 = sc.add(1 , 2);
        int result3 = sc.add(4 , 6);
        //Assert
        assertEquals(8 , result1);
        assertEquals(3 , result2);
        assertEquals(10 , result3);
        
    }
    
    @Test
    public void subtract_Test(){
        //Act
        int result1 = sc.subtract(5 , 3);
        int result2 = sc.subtract(1 , 2);
        int result3 = sc.subtract(4 , 6);
        //Assert
        assertEquals(2 , result1);
        assertEquals(-1 , result2);
        assertEquals(-2 , result3);
    }
    
    @Test
    public void multiply_Test(){
        //Act
        int result1 = sc.multiply(5 , 3);
        int result2 = sc.multiply(1 , 2);
        int result3 = sc.multiply(4 , 6);
        //Assert
        assertEquals(15 , result1);
        assertEquals(2 , result2);
        assertEquals(24 , result3);
    }
}
