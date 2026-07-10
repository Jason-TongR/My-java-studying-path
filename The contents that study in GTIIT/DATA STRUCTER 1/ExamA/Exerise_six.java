public class Exerise_six {
    /*
        [Graphs]
        a) Propose an algotithm to determine if an undirected graph is connected . using the merge-find data structure for
        disjoint sets. Assume that the graph is represented using an adjacency list. The worst-case time complexity of
        the algorithm must be at most O(n+mlogn) , where n is the number of verices and m is the number of edges.
        Your algorithm must be iterative.


        b) For each loop in your algorithm (every while or for loop) : explain why the loop terminates and explain infformally
        what is the loop invariant. You do not need to formally prove that your algoithm is correct , but the
        loop invariant should clarify why your algotithm works.
    */








    /*
        ANSWER :
            a)
                Let G = (V,E) be an undirected graph.Assume that |V| = n and |E| = m . Let us write N(v) for the list of neighbors of a vertex v in V. 
                The graph is assumed to be represented using adjacency lists, so N(v) can be known in O(1) time.

                We propose the following algotithm to check if G is connected :
                    1. If m < n - 1 return false (the graph is disconnected)
                    2. Initialize a disjoint set data structure D
                    3. For each vertex v in V , make a new set calling D.make()
                    4. For each vertex v in V , and for each nerghbor w in N(v):
                            Merge the vertices , calling D.merge(v,w)
                    5. Let v0 in V be some vertex and let V0^* := D.find(v) be its representative
                    6. Let isConnected := true
                    7. For each vertex v in V\{v0} :
                            If D.find(v) != v0^* , set isConnected := false
                    8. Return connected


                To justify that this algorithm has the expeted time complexity , note that the three outermose for-loops 
                iterate n times each , and the innermost for-loop iterates m times in total. The number of operations used
                for the merge-find data structure includes n calls to make , m calls to merge , and n calls to find , which adds
                up to 2n + m operations. The intersting case is n <= m , for otherwise the algorithm immediately terminates,
                so the total complexity is O(n + m + (n+m)alpa(n)) in O(n + mlogn)





            b)
                Termination is immediate because we only use for-loops iterating over finite sequences/sets.

                The interesting invariant is that of the second outermost for-loop : after the i-th ieration , let E' subset of E be the
                set of edges that have already been visited. Then for any two vertices v,w we have that FIND(v) = FIND(w)
                holds iff there exists a path from v to w that only if there exists a path connecting them. So , at the end ,
                we have that the graph is connected iff all vertices have the same representative.

                The invariant of the first for-loop is that after verices v1,...,vi have been visited we have created one set per each of them.
                The invariant of the last for-loop is that after vertices v1 ,..., vi have benn visited isConnected is true iff they all have the same representative as v0. 
    */
}