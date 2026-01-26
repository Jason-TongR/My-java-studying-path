import java.util.ArrayList;

public class Collection_ArrayList{
    
    private ArrayList<String> jason_list;           //in field
    
    public Collection_ArrayList(){
        jason_list = new ArrayList<String>();       //in constructor
    }
    
    
    
    /**
     * in ArrayList we have method:
     * jason_list.add(name);            add a new element in the ArrayList
     * jason_list.size();               Return the number of elements
     * jason_list.get(index);           get the element that has index 'index'
     * 
     */
    
    public void test_method_in_ArrayList(){
        jason_list.add("age");
        jason_list.add("GTIIT");
        
        System.out.println( jason_list.size() );    //it should be 2
        
        System.out.println( jason_list.get(0) );    //it should print "age"
        
        System.out.println( jason_list.get(1) );    //it should print "GTIIT"
        
    }
}