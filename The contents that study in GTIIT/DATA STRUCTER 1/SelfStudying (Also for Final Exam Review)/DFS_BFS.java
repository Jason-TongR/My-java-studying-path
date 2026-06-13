public class DFS_BFS {
    /*
        Reachability problem : indicating if there is a path from v to w ?



        DFS :
            DFS is a method to solve the reachability problem.

            The input is a gragh G = (V,E) and two vertices v,w in V . n := |V|  m := |E|

            ----------------------------------------------------------------------------------------------------------

            Initialize the pending stack as S = [v] (the vertice that need to be ...)               O(n)
            while pending stack has verices :{                                                      O(m) iterations
                Pop a vertex x from the top of the stack.                                           O(1)
                If x has been visited before , skip it.                                             O(1)
                Mark x as already visited.                                                          O(1)
                If we found the target (x= w) , return true.(there is a path form v to w)           O(1)
                Push all the neighbors of x onto the stack.                                         O(m)
            }
            If we reach here , return false.(there is no path form v to w)                          O(1)

            ----------------------------------------------------------------------------------------------------------

            Total complexity : O(n+m)

            Note : the algorithm also uses a visited set W of vertices.

======================================================================================================================================================

        BFS :
            BFS is a related method for reachability.

            The input is G = (V,E) and v,w in V

            ------------------------------------------------------------------------------------------------------------

            Initialize the pending queue as Q = [v].
            While the pending queue has vertices : {
                Remove the next vertex x from the queue
                If x has been visited before , skip it
                Mark x as already visted.
                If we have found the target (x=w) ,return true.(There is a path from v to w)
                Add all the neighbors of x to the queue.
            }
            If we reach here , return false.(There is no path from v to w)

            ---------------------------------------------------------------------------------------------------------------

            The time complexity is also O(n+m)
    */
}
