public class Minimun_spanning_tree {
    /*
        Let G be an undirected graph with weights over edge.
        
        DEF :
            A spanning tree for G is a graph G' such that :
                It conclude all edges.
                G' is a tree (connected with no cyccle)
        DEF :
            A minimum spanning tree for G is a graph G' such that :
                G' is a spnning tree for G
                The sum of the weights of the edges in G' is minimum
        
        
        Remark :
            1. the input graph must be connected
            
            2. If the input graph G is connected , then :
                It has a finite number of spanning trees.
                At least one of them must have minimum weight.

            3. The minimum spanning tree is not unique


        


        How to find the minimun spanning tree ?

        Kruskal algorithm :
            Input : a connected graph G = (V ,E).
            Output : a minimum spanning tree G' for G
        ---------------------------------------------------------------------------
        Initialize : E' := empty set
        Sort the edges of E non-decreasingly by weight.
        For each edge e in E{
            If E' union {e} have no cycle , then set E' = E' union {e}.
        }
        ---------------------------------------------------------------------------
    */
}
