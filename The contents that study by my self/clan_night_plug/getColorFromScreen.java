import java.awt.*;

public class getColorFromScreen{
    private Robot robot;
    
    public getColorFromScreen(){
        try{
            robot = new Robot();
        }
        catch(AWTException e){
            System.out.println("fail to creat robot");
        }
    }
    
    
    public void getColorformCoordinate(int x , int y){
        //.getPixelColor(x,y) will return a Color object.
        Color pixelColor = robot.getPixelColor(x,y);
        System.out.println(pixelColor.getRed());
        System.out.println(pixelColor.getGreen());
        System.out.println(pixelColor.getBlue());
    }
}