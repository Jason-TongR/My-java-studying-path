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
        
        String s1 = "";
        String s2 = "a";
        String s3 = "ab";
        String s4 = "aaa";
        String s5 = "abcb";

        System.out.println(how_many_pali_substring(s1));
        System.out.println(how_many_pali_substring(s2));
        System.out.println(how_many_pali_substring(s3));
        System.out.println(how_many_pali_substring(s4));
        System.out.println(how_many_pali_substring(s5));
    }

    /*null
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


    /*
        Exercise e

        The worst time complexity is O(n)
    */
    ArrayList<Integer> Process_square(ArrayList<Integer> a){
        
        ArrayList<Integer> b = new ArrayList<>();
        
        for(int i = 0 ; i < a.size() ; i++){
            b.add(a.get(i)*a.get(i));
        }

        return b;
    }


    

    /*
        Exercise f

        The time complexiy is O(n)
    */
    ArrayList<Integer> delete_negative_element(ArrayList<Integer> a){
        ArrayList<Integer> b = new ArrayList<Integer>();

        for(int i = 0 ; i < a.size() ; i++){
            
            if(a.get(i) >= 0)
                b.add(a.get(i));

        }

        return b;
    }






    /*
        Exercise g

        The worst time complexity is O(k*n)
    */
    ArrayList<Integer> compute_appear_time(ArrayList<Integer> a , int k){
        
        ArrayList<Integer> b = new ArrayList<Integer>();

        for(int i = 0 ; i < k ; i++){
            
            int appear_times_i = 0;
            
            for(int j = 0 ; j < a.size() ; j++){
                
                if(a.get(j) == i)
                    appear_times_i++;

            }

            b.add(appear_times_i);
        }

        return b;

    }




    /*
        Exercise h

        The worst time complexity is O(k)
    */
    boolean determine_pali(String s){
        int k = s.length();
        
        boolean is_pali = true;

        for(int i = 0 ; i < k ; i++){
            
            if(s.charAt(i) != s.charAt(k-1-i))
                is_pali = false;

        }

        return is_pali;
    }




    /*
        Exercise i

        The worst time complexity is O(n*m)
    */
    boolean determine_substring_wether_a_is_sub_of_b(String a , String b){
        
        int n = a.length();
        int m = b.length();

        assert n <= m;

        for(int i = 0 ; i <= m-n ; i++){
            
            if (b.charAt(i) == a.charAt(0)){        //找b中出现a的第一个元素
                
                for(int j = 0 ; j < n ; j++){
                    
                    if( a.charAt(j) != b.charAt(i+j) ){
                        break;
                    }

                    if(j == n-1)
                        return true;
                }

            }

        }

        return false;

    }


    /*
        Exercise j

        The worst time complexity is O(n^3)
    */
    int how_many_pali_substring(String a){
        
        int quantity = 0;

        for( int i = 0 ; i < a.length() ; i++ ){
            for( int j = i + 1 ; j <= a.length() ; j++ ){
                if(determine_pali( a.substring(i,j) ))
                    quantity++;
            }            
        }

        return quantity;
    }
    
}
