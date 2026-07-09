public class Exercise_two{

    /*
        ["O" notation]
        Prove or disprove the following statement : for every f : N natural -> R >=1 such that
        f(n) in O(n) . we have that f(n^3) + 1 in O(n^3).
    */





    /*
        ANSWER :
            sice f(n) is in O(n) , 
            then by the definition , exist c > 0 and N such that for all n > N ==> f(n) < cn

            To prove f(n^3) + 1 in O(n^3) , we just need to prove that f(n^3) in O(n^3).

            by the hypothesis , we know that exits c > 0 and N such that for all n > N  ==> f(n^3) < c*n^3
            That is f(n^3) is in O(n^3)

            Q.E.D.
    
    */
    
}