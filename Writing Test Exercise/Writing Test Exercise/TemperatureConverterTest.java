

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class TemperatureConverterTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TemperatureConverterTest
{
   @Test
   public void celsiusToFahrenheit_Test(){
       //Arrange
       TemperatureConverter tc = new TemperatureConverter();
       //Act
       double result1 = tc.celsiusToFahrenheit(0);
       double result2 = tc.celsiusToFahrenheit(100);
       double result3 = tc.celsiusToFahrenheit(37);
       //Assert
       assertEquals(32.0 , result1);
       assertEquals(212.0 , result2);
       assertEquals(98.6 , result3);
   }
}
