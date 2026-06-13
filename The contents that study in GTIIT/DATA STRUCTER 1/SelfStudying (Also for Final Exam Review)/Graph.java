public class Graph{
    /*
        Graph is the same "Graph" in Combinatorics course.


        Graph representation :

            1. Adjacency matrix :
                Storage space                                           O(n^2)
                Complexity to determine if v,w are neighbors            O(1)
                Complexity to compute deg(v)                            O(n)

            


            2. Incidence matrix :
                The graph is represented with a boolean matrix I of size n*m where n := |V| , m := |E|
                satisfies vi belong to ej  iff  I[i][j] = true .

                e.g                        |  e0   e1   e2 ... em-1
                                I =  ------------------------
                                       v0  |  1     0    1
                                       v1  |  1     0    0
                                       v2  |...
                                       ...
                                       vn-1


                Storage space                                           O(nm)
                Complexity to determine if v,w are neighbors            O(m)
                Complexity to compute deg(v)                            O(m)


            

            3. Adjacency list :
                The graph is represented with an array A fo n sets ,
                such that A[i] is the set of neighbors of vi.

                e.g.
                            
                        v0    |   {v1,v3}
                        v1    |   {v0}
                        v2    |   {v3}
                        v3    |   {v0,v2}

                
                Storage space                                           O(n+m)
                Complexity to determine if v,w are neighbors            O(logn) (depends on the set representation)
                Complexity to compute deg(v)                            O(1)
    */                                   
}