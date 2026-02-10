import java.util.HashMap;   //or import java.util.*;

public class Map_HashMap{
    private HashMap<String,String> jason_hashmap;   
    
    
    public Map_HashMap(){
        jason_hashmap = new HashMap<String,String>();
        
        
        jason_hashmap.put("jason","123456");
        jason_hashmap.put("Bob","654321");
        /*
         * in HashMap ,instead of .add() ,we use .put( , ) to add things
         * 
         * get();   get value from key
         * containsKey(i);   wether exits key i.
         * contiansValue(j); wethet exits value j.
         * size();
         * remove(key)  remove the (key,value) through key
         * remove(key,value) remove the (key,value)
         * 
         */
    }
    
    public void Print_size_of_hashmap(){
        System.out.println( jason_hashmap.size() );
    }
}