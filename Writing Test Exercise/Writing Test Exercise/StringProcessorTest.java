

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 测试类 StringProcessorTest.
 *
 * @author  (你的名字)
 * @version (一个版本号或一个日期)
 */
public class StringProcessorTest
{
    //Arrange
    StringProcessor sp = new StringProcessor();
    @Test
    public void reverse_Test(){
        //Act
        String result1 = sp.reverse("hello");
        String result2 = sp.reverse("Java");
        //Assert
        assertEquals("olleh" , result1);
        assertEquals("avaJ" , result2);
    }
    
    @Test
    public void countWords_Test(){
        //Act
        int result1 = sp.countWords("Hello World");
        int result2 = sp.countWords("I love Java programming");
        //Assert
        assertEquals(2 , result1);
        assertEquals(4 , result2);
    }

}