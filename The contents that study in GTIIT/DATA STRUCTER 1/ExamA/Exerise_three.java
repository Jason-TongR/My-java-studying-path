public class Exerise_three {
    /*
        [complexity analysis]
        We represent singly linked lists using the following class:

            class Node {
                int value;
                Node next;
            }

        The following algorithm receives two linked lists a and b and checks if they have an element in common.
        We assume that Node mergeSort(Node a) implements the mergesort algorithm.

            boolean commonElement(Node a  , Node b){
                // Sort a and b increasingly :
                a = mergeSort(a);
                b = mergesort(b);
                //Find if they have a common element :
                while (a != null){
                    while (b != null && a.value > b.value){
                        b = b.next;
                    }
                    if (b ! = null && a.value == b.value){
                        return true;    //Stop searching
                    }
                    a = a.next
                }
                return false;
            }
    */





    /*
        ANSWER:

            a)
                The best case is met when the minimum element of a is equal to the minimum element of b. In these case,
                the outermost while-loops does only one iteration , and the innermost while-loop does no iterations.So the 
                total cose of while-loops is O(1).The overall best-case time complexity is O(nlogn).


            b)
                The worest case is met when a and b have no elements in common , and a contains at least one element
                which is greater than all the elements of b. In this case , the outermost while-loop will have to have to traverse
                the complete list a. In the i-th iteration of the outermost while-loop(for each 1<= i <= n) the innermost 
                while loop will iterate ki times. But note that k1 + k2 +...+ kn = n because the innermost while loop will traverse
                the full lisst b only once(never going back). So the total cose of while-loops is O(n).The overall worst-case time
                complexity is O(nlogn).0
    */
}