import java.awt.*;
import java.awt.event.KeyEvent;
public class test_press_and_release_K{
    private Robot robot;
    
    public test_press_and_release_K(){
        try{
            robot = new Robot();
        }
        catch(AWTException e){
            System.out.println("fail to create an robot object");
        }
    }
    
    
    public void press_and_release_k(){
        robot.keyPress(KeyEvent.VK_K);
    }
}