
/*
    Design a data type VectorWithUndo with the following interface , respecting the indicated worst case time complexityes:

        • VectorWithUndo(int n) — creates a vector of integers of size n, whose elements are all 0.
            Precondition: it is assumed that n ≥ 0. Complexity: O(n).

        • int read(int i) — returns the value at position i.
            Precondition: it is assumed that 0 ≤ i < n. Complexity: O(1).

        • void write(int i, int x) — overwrites the element at position i with the value x.
            Precondition: it is assumed that 0 ≤ i < n. Complexity: O(1).

        • void ctrlZ() — undoes the last write operation. If there were no writes, this operation has no effect.
            Complexity: O(1).
*/

import java.util.ArrayList;

public class Exercise_Four_VectorWithUndo {

    ArrayList<Integer> vector = new ArrayList<Integer>();

    int Write_times = 0;

    int old_write_position;

    int old_write_positon_integer;

    public Exercise_Four_VectorWithUndo(int n){
        
        assert n >= 0;

        for(int i = 0 ; i < n ; i++){
            vector.add(0);
        }

    }



    int read(int i){
        
        assert 0 <= i && i < vector.size();

        return vector.get(i);

    }


    void write(int i , int x){

        assert 0 <= i && i < vector.size();

        old_write_position = i;
        
        old_write_positon_integer = vector.get(i);

        vector.set(i,x);

        Write_times++;

    }


    void ctrlZ(){
        
        assert Write_times > 0;

        vector.set(old_write_position , old_write_positon_integer);
    }

}
