public class Exercise_One{
    //field omitted
    
    //constructor omitted
    
    
    /**
     * Write a program:
     * int square Root(int n){...}
     * which must be correct with respect to the following contract:
     *      1.Precondition  : n >= 0 and there exists an integer r such that  r * r = n
     *      2.Postcondition : the output is the (unique) integer r such that r * r = n
     */
    public int squareRoot(int n){
        //precondition
        assert n >= 0 : " n is greater or equal than zero ";
        
        boolean exist_r = false;
        
        for( int r = 0 ; r < n ; r++ ){
            if( r * r == n ){
                exist_r = true;
                break;
            }
        }
        
        assert exist_r == true : " exists an integer r such that r * r = n ";
        
        //Postcondit 
        boolean unique = true;
        
        int candidate_r = -1 ;
        
        for( int r = 0 ; r < n ; r++ ){
            if( r * r == n ){
                for( int i = r + 1 ; i < n ; i++ ){
                    if( i * i == n){
                        unique = false;
                    }
                }
                
                candidate_r = r;
            }
        }
        
        assert unique == true : "the r is unique";
        
        return candidate_r;
    }
}