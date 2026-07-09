public class Exercise_one{
    /*
        [Loop invariant theorem]
        Let A be an array of n integers.Consider the following loop in which each iteration adds the next two elements:


        int sum = 0;
        int i = 0 ;
        while (i < n){
            sum = sum + A[i] + A[i + 1];
            i = i + 2;
        }
        
        Mr.X is trying to use the loop invariant thm to prove that, at the end of the loop, sum will contain the sum
        of all the elements in the array. He has proposed the following invariant:

                Inv := {0 <= i <= n && sum = sigma (j from 0 to i - 1) A[j] }

        Explain why Mr.X will fail , describing exactly what is the problem when using the loop invariant thm.



        
        ANSWER :
            The problem is that the body of the loop does not preserve the invariant .
            For example , suppose that at the start of an iteration we have i = 0 and n = 1 and A = [10] and sum = 0 ,
            These values verify the invariant .
            Then at the end of the iteration we will have that i = 2 and n = 1 . This does not verify the condition 0 <= i <= n.
    */
}