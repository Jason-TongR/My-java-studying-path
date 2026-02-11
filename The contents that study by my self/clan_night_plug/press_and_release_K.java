import java.awt.*;
import java.awt.event.KeyEvent;
public class press_and_release_K{
    private Robot robot;
    
    public press_and_release_K(){
        try{
            robot = new Robot();
        }
        catch(AWTException e){
            System.out.println("fail to create an robot object");
        }
    }
    
    
    public void test_press_and_release_k(){
        robot.keyPress(KeyEvent.VK_K);  //press K
        robot.keyRelease(KeyEvent.VK_K);    //release K
    }
}