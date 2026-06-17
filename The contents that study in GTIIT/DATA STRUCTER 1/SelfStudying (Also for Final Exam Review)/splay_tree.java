public class splay_tree {
    /*
        Locality of reference :
            Usually , information is not accessed completely randomly.
            Recently accessed information is more likely to be accedssed again.

            Locality of reference : in a short interval of time , programs tend to repeatedly access a small number of memory locations.



        


        Splay tree :
            Splay trees are a data structure to impletement sets and maps.
                They take advantage of locality of reference.
                Recently accessed elements are faster to access.

                Invariant and operations:
                    A splay tree is a binary tree.
                        The tree must have the binary search tree(BST) invariant.
                        Insertion , lookup and deletion are implemented like in a BST.
                        No balancing invariant is imposed.
                        Whenever an element is accessed, it is splayed.
                        Splaying moves the element to the root of the tree.




            


            Splaying algorithm 
            Begin on the node x and tranverse the path to the root.
            There are three cases : (当x是parent的左孩子的时候用zig ， 当x是parent的右孩子的时候用zag)
                1. Zig : If the parent is the root , rotate it with the parent

                        y                          x
                       / \                        / \
                      x   c     ----->           a   y
                     /  \                           / \
                     a   b                         b   c

                
                If the node has a parent and a grandparent , there are two subcases.
                2. Zig-zig : the node and the parent are in the same direction.
                             That is , both are left children or both are right children.


                        z
                       / \
                      y   ...
                     /
                    x
                
                
                3. Zig-Zag:

                        z
                       / \
                    ...    y
                         /
                        x

            伸展树（Splay Tree）上单个操作（查找、插入、删除）的均摊时间复杂度。
            The time complexity can be annalyzed using the potential method.
            The potential function is defined as the sum of the logarithm of the sizes of the subtrees rooted at each node.
            (势能 Φ = 整棵树中，每一个节点各自子树大小的对数，再全部加起来。)

            Based on this analysis , the amortized complexity of operations can be seen to be 
            amortized O(log n) for a splay tree for n nodes.
    */
}
