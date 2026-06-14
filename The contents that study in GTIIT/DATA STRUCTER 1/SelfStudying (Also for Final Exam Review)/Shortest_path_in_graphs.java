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
        



        Bellman-Ford algorithm :
            We have a directed graph G = (V,E) and possibly negative weight to each edge.
            Dijkstra's algorithm is no correct here.

            Input : a diagraph G with weights and a vertex v in V.
            Precondition : the graph has no negative cycles
            Output : a distance verctor dist , where dist[w] is the weight of the shortest path from v to w , or +00 if there is no such path.

            ---------------------------------------------------------------------------------------------------------------------------------------------
            Initialize the distance vector with dist[v] := 0 and dist[x] := +00 for every other vertex x != v

            Repeat n times {
                For each (x -> y) in E {
                    Let w be the weight of the edge x -> y.
                    Update the distance of y setting dist[y] = min{dist[y],dist[x] + w}
                }
            }
            -----------------------------------------------------------------------------------------------------------------------------------------------
            Worst case time complexity : O(n*m)


            Question :
                1. Can the algorithm be adapted to work with undirected graphs?                                 No , if yes , then <--> with negative weight is a negative cycle 
                2. Can the algorithm be adapted to detect if there are cycles of negative weight?               Yes
                
                


        Floyd-Warshall algorithm :
            Let G = (V,E) be a directed graph with posiibly negative weights.
            We want to find the distance between every pair of vertices. i.e. dist[x][y] is the weight of the short path from x to y.
            We could use Bellman-Ford n times , Worst case of it is O(n^4) if the graph is dense. but we can do better.



            Input : a digraph G = (V,E) with weights.
            Precondition : the graph has no negative cycles.
            Output : a distance vector dist , where dist[v][w] is the weight of the shortest path from v to w or +00 if there is no such path.

            ---------------------------------------------------------------------------------------------------------------------------------------------------------
            Initialize the distance vector with dist[x][x] := 0 and for every x != y :
                dist[x][y] := w (if there is an edge x -> y of weight w) , (+00 otherwise)

            For each z in V {
                For each x in V{
                    for each y in V{
                        Update the distance from x to y , setting dist[x][y] := min{dist[x][y] , dist[x][z]+dist[z][y]}
                    }
                }
            }
            ----------------------------------------------------------------------------------------------------------------------------------------------------------
            Worst-case time complexity : O(n^3)

            Note : the nesting (z,x,y) is improtant . E.g. x,y,z does not work.
    */
}
