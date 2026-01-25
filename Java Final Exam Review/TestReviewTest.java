

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class TestReviewTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestReviewTest
{
    /**
     * this test is to test the SumCalculator method.
     */
    @Test
    public void SumCalculatorTest(){
        /*
         * Arrange.     create an object and int a int b
         */
        TestReview jason_test = new TestReview();
        int a = 100;                                                                                     
        int b = 12;
        /*
         * Act
         */
        int result = jason_test.SumCalculator(a , b);
        /*
         * Assert
         */
        assertEquals(112,result);
    }
    
    /*
     * we have:
     *      *assertEquals(.. ,result)
     *      *assertNotEquals(.. , result)
     *      *assertTrue( conditon )
     *      *assertFalse( condition )
     */
}
