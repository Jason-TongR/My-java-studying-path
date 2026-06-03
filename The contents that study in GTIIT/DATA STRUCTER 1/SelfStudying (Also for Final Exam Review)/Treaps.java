public class Treaps {
    /*
        Binary search trees have bad worst case complexity.
        In a skewed binary search tree , insertion , search , and deletion can all take O(n) time in the worst case (在一个倾斜的二叉搜索树中，插入、搜索和删除在最坏情况下都可能需要 O(n) 时间)
    
        but they have good average case complexity.
        In a balanced binary search tree , insertion , search , and deletion can all take O(log n) time in the average case (但它们在平均情况下具有良好的复杂度，在一个平衡的二叉搜索树中，插入、搜索和删除在平均情况下都可能需要 O(log n) 时间)
        

        Treaps are a type of binary search tree that is designed to be balanced (Treaps 是一种旨在保持平衡的二叉搜索树)

        DEF :
            A treap is a binary tree in which nodes store a pair K : P , where :
                K is a key 
                P is a randomly chosen priority (P 是一个随机选择的优先级)

            A binary search tree with keys and priorities is a treap if :
                1. looking at the keys , it is a binary search tree (从键的角度来看，它是一个二叉搜索树)
                2. looking at the priorities , it is a max heap (从优先级的角度来看，它是一个最大堆)          
    */






    private void InsertionAlgorithm(){
        /*
            To insert a key K :
                1.Randomly choose a priority P for K (为 K 随机选择一个优先级 P)
                2.Insert K : P as in a binary search tree.(The result may not have the heap invariant for priorities) (像在二叉搜索树中一样插入 K : P（结果可能不满足优先级的堆不变式）)
                3
        
        
        
        */
    }





}
