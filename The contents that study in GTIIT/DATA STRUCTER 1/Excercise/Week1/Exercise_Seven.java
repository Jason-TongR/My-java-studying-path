/*
    Consider the searching problem:
        Precondition: the input a is an array of integers and an integer x such that x appears in a.
        Postcondition: the output i is the least index such that a[i] = x.

    1. Write code (in Java or pseudocode) that solves this problem using linear search scanning the array from left to right.
    2. Using the loop invariant theorem, prove that your algorithm is correct.
       Note. To be able to use the loop invariant theorem, your code should not use the control structures break nor continue
*/

import java.util.ArrayList;

public class Exercise_Seven {
    public void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(5);
        
        Find_element(5 , a );
    }
    
    
    int Find_element(int x , ArrayList<Integer> a){
        int i = 0;
        int n = a.size();

        while(i < n){
            if(a.get(i) == x){
                System.out.println(i);
                return i;
            }

            i++;
        }

        return -1;  //we won't reach here if we have the precondition.
    }


    /*
        Consier the following Inv := { 1 . 0 <= i <= n   2. the element before a[i-1] (0,1,2,...,i-2) are all not the x that want to search for }

        Initialization :
            before the while loop, i == 0 and cheak the Inv : 1.is true , 2.no elements before a[i-1] , so are all not the x that we want to search.

        persevation :
            Suppose the Inv and Cond are true. after the loop , cheak the Inv : 1. 0 <= i'==i+1 <= n is true    2.if a[i]==x then this Inv also true(i'==i) ,if a[i]!=x then i' then this Inv also true
                

        Termination :
            the loop will teminate because i is 1+1+1+...


        Conclusion : 
            The Inv and !Cond is true , that is the the a[i] is the least i that a[i] == x

    */
}
