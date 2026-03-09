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
        
        assert distinguish_exist( n ) == true : " exists an integer r such that r * r = n ";
        
        //Postcondition

        assert distinguish_uniquness( n ) == true : "the r is unique";
        
        return find_one_root( n );
    }
    
    /**
     * this meathod is to distinguish for int n , whether there exist a root for it.
     */
    private boolean distinguish_exist( int n ){
        assert n >= 0 : "this n must >= 0 "; 
        
        for( int r = 0 ; r < n ; r++ ){
            if( r * r == n ){
                return true;
            }
        }
        
        return false;   //If we cannot find the root , then we return false.
    }
    
    /**
     * this method is to distinguish the uniquenss of the root.
     */
    private boolean distinguish_uniquness( int n ){
        assert distinguish_exist( n ) == true : "at first , this n must exist root";
        
        for( int r = 0 ; r < n ; r++ ){
            if( r * r == n ){
                for( int i = r + 1 ; i < n ; i++ ){     //if found one root , then check whether there exit another root
                    if( i * i == n){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    /**
     * this method is to find one root of the int n.
     */
    private int find_one_root( int n ){
        assert distinguish_exist( n ) == true : "at first , this n must exist root";
        
        for( int r = 0 ; r < n ; r++ ){
            if( r * r == n ){
                return r;    
            }
        }
        
        return -1;  //actually code cannot reach here
    }
}