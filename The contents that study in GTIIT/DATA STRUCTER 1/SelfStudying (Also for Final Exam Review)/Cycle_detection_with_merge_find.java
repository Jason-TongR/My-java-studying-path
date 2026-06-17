public class Cycle_detection_with_merge_find {
    /*
        Let G be an undirected graph
        
        Algorithm to detect cycles :
            Create a merge find data structure.
            Call make() once per vertex
            For each edge v--w {
                If find(v) = find(w) , report a cycle.
                Otherwise , call merge(v,w)
            }

        Time complexity : O( (n+m)afa(n) )



        in the edge v--w , if v and w have the same representative , then it is a cyccle in this graph.
    */
}
