import java.util.ArrayList;
/*
    Consider the following program :

    Using the loop invariant theorem, prove that it is correct with respect to the following contract:
        Precondition : the input "a" is an array of integers.
        Postcondition : the output r contains the elments of "a" but reversed
                        More precisely , for every 0 <= i < n we have that a[i] = r[n-i-1]

*/
public class Exercise_Six {
    ArrayList<Integer> reverse(ArrayList<Integer> a) {
        int n = a.size();
        int i = 0;
        ArrayList<Integer> r = new ArrayList<>(a);  //（a） 表示复制 一份a数组

        while (i < n / 2) {
            int temp = r.get(i);
            r.set(i, r.get(n - 1 - i));
            r.set(n - 1 - i, temp);
            i = i + 1;
        }

    return r;
    }
}


/*
    proof :
            Consider the following Inv := { 1. 0 <= i <= n/2 - 1        2. the terms before i are all commuted}
            Suppose the old i called "i" , the new i called "i'" 

            Initialization :

                before the while loop , i == 0 . cheak the Inv : 1. i is in this range.  2.the no terms before i , so this inv is also true

            Preservation :

                suppose Inv and Cond are true.
                    "
                        {int temp = r.get(i);
                        r.set(i, r.get(n - 1 - i));
                        r.set(n - 1 - i, temp);
                                                    "
                these three are change the postion r[i] and the positon r[n-1-i]

                i' = i + 1 

                Now cheak the Inv : 1. is true 2. the terms before i 


            Termination :
*/
