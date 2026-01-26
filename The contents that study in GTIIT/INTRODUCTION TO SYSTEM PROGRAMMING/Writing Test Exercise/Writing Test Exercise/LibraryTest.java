

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 测试类 LibraryTest.
 *
 * @author  (你的名字)
 * @version (一个版本号或一个日期)
 */
public class LibraryTest
{
    //Arrange
    Library gt = new Library(5);
    @Test
    public void getAvailableBooks_Test(){
        for( int i = 0 ; i < 3 ; i++ ){
            //Arrange
            gt.borrowBook();
            //Act
            int result1 = gt.getAvailableBooks();
            //Assert
            assertEquals( 5 - i - 1 , result1 );
        }
        
        //Arrange
        gt.returnBook();
        //Act
        int result2 = gt.getAvailableBooks();
        //Assert
        assertEquals( 3 , result2 );
    }
}