public class Exercise4{
    
    
        /**
         * Consider the following program:
         * 
         * Using the loop invariant theorem, prove that it is correct with respect to the following contract:
         *   • Precondition: the input is an integer n >= 1.
         *   • Postcondition: the output fact is the factorial of n.
         */
    int factorial(int n) {
        int i = n;
        int fact = n;
        while (i > 1) {
            i = i- 1;
            fact = fact * i;
        }
        return fact;
    }
    
    /*
     * Answer:
     *      consider the following Inv := { fact * (i - 1)! = n! }
     *      
     *      
     *      Initialization:
     *          at the start of the loop, fact = n , i = n , 
     *          fact * (i-1)! = fact * (n-1)! = n *(n-1)! = n!
     *          therefore,initialization holds.
     *      
     *      Preservation:
     *          Assuming : {Inv && cond}holds <==> { fact * (i-1)! = n! && i > 1} holds
     *          
     *          then we need to prove that after the body , Inv still holds:
     *              i' = i - 1(it is well define because by the Assuming) , fact' = fact * i'
     *              now, fact' * ( i' - 1 )! = fact * (i-1) *( i-1 -1 )! 
     *                                       = fact * (i-1)!
     *                                       =n!(by Assuming)
     *          Therefore,{Inv}holds after the body
     *          
     *          
     *      Termination:
     *          this loop will Terminate because i will minors 1 once we go into the loop
     *          
     *          
     *          
     *      Therefore,by loop invariant theorm,{Inv && !cond}holds after the loop
     *      it means { fact * (i - 1)! = n! && i <= 1}
     *      since when i<=1 ,(i-1)! is 1
     *      Therefore fact = n! we proved it.
     */         
}