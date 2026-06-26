/*
    Exercise 1. Provide algorithms to solve the following problems and determine their worst-case time and space complexity:
        a) Find the maximum of an array of n integers.

        b) Find the k largest numbers in an array of n integers.

        c) Given two integer arrays A and B, determine which one is longer.

        d) Given two integer arrays A and B, determine how many elements of A also appear in B.

        e) Given an integer array A, produce an integer array B such that B[i] contains the square of A[i].
        f) Given an integer array A, produce an integer array B that results from deleting all the negative elements.
        g) Given an integer array A whose values are between 0 and k − 1, produce an array B of size k such that B[i]
           contains the number of times the integer i appears in A.
        h) Given a character string S of length n, determine if S is a palindrome, i.e., if the reverse of S is equal to S. For
           example, the string “abcbbcba” is a palindrome.
        i) Given a character string S of length n and a character string T of length m, determine if T appears as a substring
           of S. For example, the string “abc” appears as a substring of “ababc” but not of “abacb”.
        j) Given a character string S of length n, determine how many of its substrings are palindromes. For example, the
           string “abcb” has 5 palindromic substrings: “a”, “b”, “c”, “b” and “bcb”.
*/
import java.util.ArrayList;

public class Exercise_One {
    public void main(String[] args) {
    
    }

    /*
        Exercise a

        The worst time complexity of this algorithm is O(n).

    */
    int Find_maximum(ArrayList<Integer> a){
        assert a.size() > 0;

        int max = a.get(0);

        for( int i = 0 ; i < a.size() ; i++ ){
            if( a.get(i) > max ){
                max = a.get(i);
            }
        }

        return max;
    }


    /*
        Exercise b

        The worst time complexity is O(k*n)
    */
    void Find_k_largest( int k , ArrayList<Integer> a ){
        assert a.size() > 0 && k <= a.size();


        for(int i = 0 ; i < k ; i++){
            int max = Find_maximum(a);
            
            System.out.println(max);

            a.remove(Integer.valueOf(max));
        }
    }




    /*
        Exercise c

        The worst time complexit is O(1)
    */
    ArrayList<Integer> Determine_longer(ArrayList<Integer> a , ArrayList<Integer> b){
        if(a.size() > b.size())
            return a;
        else
            return b;
    }




    /*
        Exercise d
        
        The worst time copmplexity is O(n*m)
    */
    int appear_times(ArrayList<Integer> a , ArrayList<Integer> b){
        
        int appear_time = 0;

        for(int i = 0 ; i < a.size() ; i++){
            
            boolean found = false;
            for(int j = 0 ; j < b.size() ; j++){

                if(a.get(i).equals(b.get(j)) && !found){
                    found = true;
                    appear_time++;
                }

            }
        }

        return appear_time;
    }


}
