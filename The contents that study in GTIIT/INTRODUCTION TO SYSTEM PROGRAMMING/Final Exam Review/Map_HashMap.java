import java.util.HashMap;   //or import java.util.*;

public class Map_HashMap{
    private HashMap<String,String> jason_hashmap;   
    
    
    public Map_HashMap(){
        jason_hashmap = new HashMap<String,String>();
        
        
        jason_hashmap.put("jason","123456");
        jason_hashmap.put("Bob","654321");
        /*
         * in HashMap ,instead of .add() ,we use .put( , ) to add things
         */
    }
    
    public void Print_size_of_hashmap(){
        System.out.println( jason_hashmap.size() );
    }
}