import java.util.HashSet;

public class Collection_HashSet{
    private HashSet<String> jason_set;
    
    
    public Collection_HashSet(){
        jason_set = new HashSet<String>();
        
        jason_set.add("one");
        jason_set.add("two");
        jason_set.add("three");
        
        /*
         * in set ,we also have method like:
         * 1.set.add(...)
         * 2.set.size()
         */
    }
    
    
    
    public void Printing_All_Element_In_Set(){
        for( String n : jason_set ){
            System.out.println(n);
        }
    }
}