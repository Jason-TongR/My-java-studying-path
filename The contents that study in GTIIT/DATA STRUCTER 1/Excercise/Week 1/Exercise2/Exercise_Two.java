package Exercise2;

public class Exercise_Two{
    
    
    /**
     * write a program:
     * boolean isPrime(int n){...}
     * which must be correct with repect to the following contract:
     *      1.Precondition: n is an integer.(Note : it might be negative)
     *      2.Postcondition: the output is true if and only if n is prime.
     */
    public boolean isPrime(int n){
        //precondition is hold because of the parmameter type
        
        //Postcondition
                
        return distinguish_prime( n );
    }
    
    
    /**
     * this method is to distinguish wethear the int n is prime number.
     */
    private boolean distinguish_prime( int n ){
        for(int i = 2 ; i < n ; i++){
            if( n % i == 0 ){
                return false;
            }
        }
        
        return true;
    }
}
