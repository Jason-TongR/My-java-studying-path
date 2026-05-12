public class FloydHeapify{
    /*
        the cost of building a heap with n element is O(nlogn). (插入+上滤)
        we can do it more efficiently with the Heapify Algorithm

        Heapify Algorithm:
            For each index i from n-1 down to 0 , apply the siftDown algorithm starting form i
            (找到最后一个叶子，从后往前，对每个节点进行SiftDown下虑)

            This complexity is O(n) in the worst case.



        Heapsort:
            Input : an array A
            Output : a sorted permutaiton of A (输出一个一个单调递增的sorted数组)

            Step 1 : Heapify (建堆 + Heapify Algorithm)

            Step 2 : 将堆顶交换到当前堆的末尾 + 对新换到堆顶的元素执行SiftDown

            最终，该数组会是单调递增的sorted array.
    */
}