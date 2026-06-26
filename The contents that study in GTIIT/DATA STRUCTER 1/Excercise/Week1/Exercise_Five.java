import java.util.ArrayList;
/**
 *  Consider the following program:
 *      Using the loop invariant theorem, prove that it is correct with respect to the following contract:
            • Precondition: the input a is an array of integers.
            • Postcondition: the output sorted is true if and only if the array a is sorted non-decreasingly. More precisely,
                for every 0 <= i < n and every 0 <= j < n such that i <= j we have that a[i] <= a[j] holds.
 */
public class Exercise_Five{


    boolean isSorted(ArrayList<Integer> a) {
        int n = a.size();
        int i = 0;
        boolean sorted = true;
        while (i < n - 1) {
            if (a.get(i) > a.get(i+1)) {            //(a[i] > a[i+1])
            sorted = false;
            }
            i = i + 1;
        }
        return sorted;
    }
    /*
    *   Answer:
            consider the following Inv :={ 1. 0 <= i <= n-1   2. sorted == true  iff  the terms before i are all sorted with non-decreasing }

            Initialization:

                before the while loop , 1. i = 0    2. sorted == true iff the terms before i are sorted(no term before i)
                So the Invariant holds.

            Preservation:

                now going inside the while loop.
                Suppose old i and old sorted are call "i" and "sorted" , new i and new sored are called "i'" and "sorted'"
                Suppose the condition "i < n - 1" is true , and the Inv true

                if (a[i] > a[i+1]) , then sorted = false . then i' = i + 1 .now cheak the Inv : 
                                                                                1.since i < n-1 then i' = i+1 <= n-1 which means the Inv 1 is holds
                                                                                2.sorted' == false  iff  there exist some term there are not sorted    is also true.
                Therefore , the Inv is also true after once loop.

            Termination:

                By i is 1+1+1+1... then the while loop will teminate at some moment.



            Conclusion:
                The Inv and !cond holds .
                That is i >= n-1 and 0 <= i <= n-1   and   sorted == true  iff  the terms before i are sorted
                That is i == n-1   and   the array is sorted.
                Q.E.D
    */
}