public class Disjoint_Set_Data_Structure {
    /*
        we want to represent a family of sets {A1,A2,...,Ak} where:
            Each set Ai is finite and non-empty.
            Each set Ai has a special element called its representative.
            The sets are pairwise disjoint : i != j ==> Ai intersection Aj = empty set.
            (This is useful to work with partitions and equivalence relations)
        

        We need the following operations :
            Make a new set with a single element.
            Merge two sets , replacing them by their union.
            Find the representative of the set of an element.
            


        Merge-find data structure : 
            We store an ara p such that p[i] is the parent of i : 
                If is the representative of a set , P[i] = i.
                Otherewise , p[i] is closer to the representative.
        
                

        ----------------------------------------------------------------------------------------------
        Optimized find (with path compression)
            int find(int i) {
                if (P[i] == i){
                    return i;
                }
                else{
                    int j = find(P[i]);
                    P[i] = j;       ---this is the path compression
                    return j;    
                }
            }
        ----------------------------------------------------------------------------------------------



        Optimizing merge 
            Merging by rank :
                store a number of each element , called its rank.
                When merging , the node with largerst tank becomes the root.
                The rank is like the height of the tree , but it is not kept up to date by path compression.

                void merge_by_rank(int i  , int j){
                    int rep_i = find(i);
                    int rep_j = find(j);
                    
                    if(rep_i == rep_j){
                        return;
                    }

                    if(rank[rep_i] > rank[rep_j]){
                        P[rep_j] = rep_i;
                    }
                    else{
                        p[rep_i] = rep_j;

                        if (rank[rep_i] == rank[rep_j]){
                            rank[rep_j]++;
                        }
                    }
                }
            


            (Another possible way for merging)
            Merging by size(the number of the node of the tree)
                The node with most descendants becomes te new root.
    */
}
