public class Exerise_seven {
    /*
        [Amortized analysis]
        A robot starts at positon (0,0). At each step it can move one step to the right, from (i,j) to(i+1,j),or one step up, from (i,j) to (i,j+1).
        If the robot is at position (i,j) it can also return to the origin (0,0). The actual costs of the operations are:
            1. Move to the right : c(right) = 1.
            2. Move up : c(up) = 1.
            3. Return from (i,j) to the orighin : c(return) = i + j.
        Propose a potential function fi(i,j) such that the amortized costs of all operations become O(1).
    */




    
    /*
        ANSWER : 
            Let fi(i,j) = i + j. Then :
                1. Note that fi(i,j) = i + j >= 0 = fi(0,0) for every i , j in natural number , so the potential function is "good"
                2. The amortized cost for moving to the right is c(right)hat = c(right) + fi(i+1 , j) - fi(i,j) = c(right) + 1 = 2 in O(1)
                3. Similarly , the amoritzed cost for moving up is c(up)hat = c(up) + fi(i,j+1) - fi(i,j) = c(up) + 1 = 2 in O(1)
                4. The amortized cost for returning to the origin is c(return)hat = c(return) + fi(0,0) - fi(i,j) = c(return) - i - j = i +j - i - j = 0  in O(1)
    */
}