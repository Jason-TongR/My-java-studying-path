import java.util.List;
import java.util.ArrayList;     //we should import this two beacause the example need to use this.

public class Iteration_foreach_loop{
    private List<String> Example_list;
    
    
    public Iteration_foreach_loop(){
        Example_list = new ArrayList<String>();
        
        Example_list.add("apple");
        Example_list.add("pear");
        Example_list.add("Richar");
    }
    
    
    public void Printing_by_forEach_loop(){
        for( String n : Example_list ){         //here the type of n must be equal to the type of the ArrayList
            System.out.println( n );
        }              
        /*
         * it should println:
         * apple
         * pear
         * Richar
         */
    }
 }