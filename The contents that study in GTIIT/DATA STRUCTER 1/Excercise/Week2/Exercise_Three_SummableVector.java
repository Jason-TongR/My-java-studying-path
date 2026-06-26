/*
    Design a data type SummableVector with the following interface, respecting the indicated worst-case time complexities:
        
        • SummableVector(ArrayList<Integer> A) — creates a structure representing the received array A. Complexity: O(n), assuming |A| = n.

        • int value(int i) — returns the element at position i of array A. Precondition: it is assumed that 0 ≤ i ≤ n. Complexity: O(1).

        • int sum(int i, int j) — returns the sum of the elements of array A in the interval [i, j).1 That is, it returns A[i] + A[i + 1] + . . . + A[j − 1]. Precondition: it is assumed that 0 ≤ i ≤ j ≤ n. Complexity: O(1).
*/

import java.util.ArrayList;

public class Exercise_Three_SummableVector{
    
    ArrayList<Integer> B = new ArrayList<>();

    ArrayList<Integer> B_prefix = new ArrayList<>();

    int n;

    public Exercise_Three_SummableVector(ArrayList<Integer> A){
        
        for(int i = 0 ; i < A.size() ; i++){
            B.add(A.get(i));
            
            if(i == 0)
                B_prefix.add(A.get(i));
            else
                B_prefix.add(B_prefix.get(i-1)+A.get(i));
        }

        n = A.size();
    }

    int value(int i){
        assert 0 <= i && i < n;

        return B.get(i);
    }


    int sum(int i , int j){
        assert ( 0 <= i && i <= n ) && ( 0 <= j && j <= n ) && (i <= j);
        
        if(i == 0)
            return B_prefix.get(j-1);
        else
            return B_prefix.get(j-1) - B_prefix.get(i-1);
    }

}
