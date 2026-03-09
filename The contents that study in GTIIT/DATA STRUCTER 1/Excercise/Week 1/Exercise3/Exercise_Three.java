import java.util.List;
import java.util.ArrayList;
/**
 * still need to do.
 */
public class Exercise_Three{
    
    
    
    /**
     * write a program:
     * ArrayList<Integer> insertionSort(ArrayList<Integer> a){...}
     * which must be correct with respect to the following contract:
     *      1.Precondition: a is an array of n integers.
     *      2.Postcondition: the output is an array s of n integers , which is a sorted permutation of a.
     *      
     * Use the following algorithm:
     *      1.Start with an empty array s.
     *      2.For each index 0 <= i < n , insert a[i] in the right position in s , so that s is always sorted.
     */
    public ArrayList<Integer> insertionSort(ArrayList<Integer> a){
        //preconditon
        assert a != null : "a can't be empty";
        
        assert distinguish_integer_array( a ) == true : "a is an array of n integers";
        
        //Postcondition
        
        return sort_array( a );
    }
    
    /**
     * this method is to distinguish wethear the given array is an integer array
     */
    private boolean distinguish_integer_array(ArrayList<Integer> a){
        for(int i = 0 ; i < a.size() ; i++){
            if ( !(a.get(i) instanceof Integer) ){
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * this method is to sort the given Integer Array a .
     */
    private ArrayList<Integer> sort_array(ArrayList<Integer> a){
        assert distinguish_integer_array( a ) == true : "a must be the Integer array";
        
        ArrayList<Integer> result_array = new ArrayList<Integer>();
        
        for( int j = 0 ; j < a.size() ; j++){
            int max_number_index_of_a = max_number_index( a );
            
            result_array.add( a.get(max_number_index_of_a) );
            
            a.remove( max_number_index_of_a );
            
        }
        
        return result_array;
    }
    
    /**
     * this method is to find (one) the maximum number index in the given Integer array a
     */
    private int max_number_index(ArrayList<Integer> a){
        assert distinguish_integer_array( a ) == true : "a must be the Integer array";
        
        int index = 0;
        
        for( int i = 0 ; i < a.size() ; i++ ){
            if( a.get(i) > a.get(index) ){
                index = i;
            }
        }
        
        return index;
    }
}