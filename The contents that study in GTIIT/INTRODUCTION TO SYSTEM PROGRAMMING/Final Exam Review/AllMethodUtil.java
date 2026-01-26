import java.util.*;
public class AllMethodUtil{
    public void randomGenerator_of_one_hundred_number(){
        Random rand = new Random();
        for( int i = 0 ; i < 100 ; i++ ){
            int number = rand.nextInt();
            System.out.println(number);
        }
    }
}