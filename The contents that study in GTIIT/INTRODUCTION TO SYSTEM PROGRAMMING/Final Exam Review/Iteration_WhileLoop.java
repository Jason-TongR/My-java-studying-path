import java.util.List;

import java.util.ArrayList;

public class Iteration_WhileLoop{
    private List<String> Example_list;
    
    public Iteration_WhileLoop(){
        Example_list = new ArrayList<String>();
        
        Example_list.add("apple");
        Example_list.add("banana");
        Example_list.add("Paulo");
    }
    
    
    public void Printing_using_WhileLoop(){
        int index = 0;
        
        while( index < Example_list.size() ){
            System.out.println( Example_list.get(index) );
            
            index++;
        }
        
    }
}