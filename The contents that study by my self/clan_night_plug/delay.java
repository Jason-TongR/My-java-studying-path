import java.awt.*;
import java.awt.event.KeyEvent;

public class delay{
    private Robot robot;
    
    public delay(){
        try{
            robot = new Robot();
        }
        catch(AWTException e){
            System.out.println("fail to creat robot");
        }
    }
    
    
    public void test_delay( int time ){
        robot.delay(time);  //delay time(ms) 
    }
    
}