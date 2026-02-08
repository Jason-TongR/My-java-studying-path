

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class StringUtilsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StringUtilsTest
{
    private StringUtils test_object;
    
    public StringUtilsTest(){
        test_object = new StringUtils();
    }
    
    
    @Test
    public void reverse_Test(){
        //Act
        String result1 = test_object.reverse("hello");
        String result2 = test_object.reverse(null);
        String result3 = test_object.reverse("");
        //Assert
        assertEquals( result1 , "olleh");
        assertEquals( result2 , null );
        assertEquals( result3 , "" );
    }
    
    
    @Test
    public void isPalindrome_Test(){
        //Act
        boolean result1 = test_object.isPalindrome("racecar");
        //assert
        assertTrue(result1);
    }
    
    
    @Test
    public void countVowels_Test(){
        //Act
        int result1 = test_object.countVowels("jason");
        //assert
        assertEquals( result1 , 2 );
    }
}