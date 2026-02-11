import java.awt.*;
import java.awt.event.InputEvent;

public class mouse{
    public Robot robot;
    
    public mouse(){
        try{
            robot = new Robot();
        }
        catch(AWTException e){
            System.out.println("fail to creat robot");
        }
    }
    
    
    public void move_mouse(int x , int y){
        robot.mouseMove(x,y);
    }
    
    public void mouse_press(){
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);     //press the left key of the mouse.
    }
    
    public void mouse_release(){
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}