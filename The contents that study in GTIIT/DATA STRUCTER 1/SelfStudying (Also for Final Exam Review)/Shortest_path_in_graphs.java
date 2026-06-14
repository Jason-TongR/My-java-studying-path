public class Shortest_path_in_graphs {
    /*
        Problem description :
            We have an undirected graph G = (V,E) and every edges have a weight ,
            given two vertices v,w in V , we want to find to shortest path (i.e. the one minimum weight) connecting v and w.
        



        Dijkstra's algorithm :
            Input : a graph G with weights and a vertex v in V
            Precondition : edge weights must be positive
            Output : a distance verctor dist , where dist[w] is the weight of the shortest path from v to w , or +00 if there is no such path.

            --------------------------------------------------------------------------------------------------------------------------------------------
            Initialize the distance vector with dist[v] := 0 and dist[x] := +00 for every other vertex x != v.

            Initialize the set of visited vertices as W := empty set 

            while there are vertices that have not been visited {
                Select a vertex x that has not been visited and such that dist[x] is minimum.
                Mark x as visited.
                For each neighbor y of x {
                    Let w be the weight of the edge x---y.
                    Update the distance of y setting dist[y] := min{dist[y],dist[x]+w}
                }
            }
            ---------------------------------------------------------------------------------------------------------------------------------------------
    */
}
