

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 测试类 ShoppingCartTest.
 *
 * @author  (你的名字)
 * @version (一个版本号或一个日期)
 */
public class ShoppingCartTest
{
    //Arrange
    ShoppingCart sc = new ShoppingCart();
    
    @Test
    public void getItemCount_Test(){
        //Arrange
        sc.addItem("item1" , 1);
        sc.addItem("item2" , 2);
        sc.addItem("item3" , 3);
        //Act
        int result = sc.getItemCount();
        //Assert
        assertEquals(3 , result);
    }
    
    @Test
    public void getTotalPrice_Test(){
         //Arrange
        sc.addItem("item1" , 1);
        sc.addItem("item2" , 2);
        sc.addItem("item3" , 3);
        //Act
        double result = sc.getTotalPrice();
        //Assert
        assertEquals(6 , result);
    }
    
    @Test
    public void clearCart_Test(){
        //Arrange
        sc.addItem("item1" , 1);
        sc.addItem("item2" , 2);
        sc.addItem("item3" , 3);
        sc.clearCart();
        //Act
        int result1 = sc.getItemCount();
        double result2 = sc.getTotalPrice();
        //Assert
        assertEquals(0 , result1);
        assertEquals(0 , result2);
    }
}