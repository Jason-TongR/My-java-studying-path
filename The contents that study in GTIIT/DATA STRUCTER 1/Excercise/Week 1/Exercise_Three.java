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
        
        boolean a_is_Integer_Array = true;
        
        for(int i = 0 ; i < a.size() ; i++){
            if ( !(a.get(i) instanceof Integer) ){
                a_is_Integer_Array = false;
            }
        }
        
        assert a_is_Integer_Array == true : "a is an array of n integers";
        
        //Postcondition
        
        List<Integer> s = new ArrayList<Integer>();
        
        for( int j = 0 ; j < a.size() ; j++){
            int max = a.get(0);
            for(int i = 0 ; i < a.size() ; i++){
                if(a.get(i) > max){
                    max = a.get(i);
                }
            }
            s.add(max);
            a.remove()
        }
    }
}