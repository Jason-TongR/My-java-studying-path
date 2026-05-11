public class Heaps{
    /*
        DEF:
        A heap(堆) is a binary tree with the following invariant:
        
        1.The tree is leftist
        
        2.In all subtrees , the element at the root is maximum (more precisely , it has maximum priority)



        （前几层全满，最后一层全部靠左 + 任意子树的节点是最大的）




        A heap can be representated as an array
    */







    
    /*
        将节点 X 插入到Heap里面的方法
    */
    private void Insertion_in_Heap(Note X){
        /*  
            step 1 : Place X in the next free position of the leftist tree. That is , at the last level on the right.

            step 2 : Apply the following Sift-Up procedure !!!!
                     while the element has higher priority than its parent , we Swap the element with its parent.

            
            (将新元素放到leftist的下一个空闲位置 + 当插入元素的优先级高于其父节点时，将插入节点和父节点交换，再继续向上比较，直到堆序恢复或者到达根节点)



            Remark :

            Worst-case time complexity : O(log n)
        */
    
    }







    /*
        从堆中删除最大元素（堆顶）的算法
    */
    private void Remove_maximum_from_heap(heap H){
        /*
            1. Replace the root with the element in the last position

            2.Apply the following SiftDown procedure!!!!!!
              while the element is smaller than any of its children , Swap it with the child of higer priority.


            (把堆的最后一个节点（最底层最右边的元素）取出来 ， 覆盖到根上 + 下滤 ， 从根开始，比较当前当前节点和它两个子节点，如果当前节点比它两个孩子中较大的那个小，就和那个孩子交换，重复这个过程直到当前节点不再小于任何一个孩子，或者已经达到叶子节点)  
        */
    }

}













/*
    没有用，只是为了不报错
*/
public class Note{

}
public class heap{

}