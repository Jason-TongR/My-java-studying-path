public class Exerise_four {
    /*
        [Balance binary trees]
        Suppose that n is an odd number , Recall that the median of a set of elements
        {x0,x1,..,xn-1} is the element in the middle if we sort the elements increstingly.
        That is if x0 < x1 < ... < xn-1 = x2k . The median is the element at position x(n-1)/2 = xk
        For example ,the median of 10 , 11 , 17 , 20 ,22 is 17
        
        Propose an algorithm that receives an AVL tress of n nodes and returns the median in worst-case time
        O(logn) , you can assume that each node of the AVL stores the size of the corresponding subtree.
    */





    /*
        We write size(t) for the size of a given AVL tress t, which can be know in O(1) by hypothesis.
        We write t.key for the value contained in the AVl tree and t.left and t.right for the left and right children respecively.
        We first propose the following algorithm to find the i-the element i an AVl:

        FINDTHEELEMENT(t,i):

        Input : an AVL tree containing n elements x0 < x1 < ... < xn-1 and an index 0 <= i < n.

        Output : the element xi

            if(size(t.left) = i-1){
                return t.key
            }
            else{

                if(size(t.left) > i-1){
                    return FINDTHEELEMENT(t.left , i)
                }

                else{
                    return FINDTHEELEMENT(t.right , i-1-size(t.left))
                }

            }

        Since each branch has at most one recursive call over one of the children , the worst-case time complexity
        of this algorithm is given bu the height of the input tree . Since the tree is assumed to be an AVl tree , the complexit
        is O(logn). In particular , to find the median of an AVl tree t , we can use FINDTHEELEMETN(t,i) where i = (size(n)-1)/2.
    */
}