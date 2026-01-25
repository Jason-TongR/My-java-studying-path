

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class StudentGradeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentGradeTest
{
    StudentGrade list = new StudentGrade();
    @Test
    public void isPassing_Test(){
        //Act
        for( int i = 0 ; i <= 100 ; i++ ){
            boolean result = list.isPassing(i);
            //Assert
            if( i >= 0 && i < 60 ){
                assertFalse(result);
            }
            else{
                assertTrue(result);
            }
      }
    }
    
    
    @Test
    public void getGrade_Test(){
        //Act
        String result1 = list.getGrade(95);
        String result2 = list.getGrade(85);
        String result3 = list.getGrade(75);
        String result4 = list.getGrade(65);
        String result5 = list.getGrade(55);
    }
}