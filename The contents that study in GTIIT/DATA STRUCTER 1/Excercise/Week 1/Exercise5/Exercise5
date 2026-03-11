



/**
 *  Consider the following program:
 *      Using the loop invariant theorem, prove that it is correct with respect to the following contract:
            • Precondition: the input a is an array of integers.
            • Postcondition: the output sorted is true if and only if the array a is sorted non-decreasingly. More precisely,
                for every 0 <= i < n and every 0 <= j < n such that i <= j we have that a[i] <= a[j] holds.
 */
public class Exercise5{


    boolean isSorted(ArrayList<Integer> a) {
        int n = a.size();
        int i = 0;
        boolean sorted = true;
        while (i < n - 1) {
            if (a[i] > a[i + 1]) {
            sorted = false;
            }
            i = i + 1;
        }
        return sorted;
    }
    /*
    *   Answer:
            consider the following Inv :={  }

            Initialization:

            Preservation:

            Termination:

    */
}