import java.util.List;
import java.util.ArrayList;

public class Sorting{



    // 1. Heapsort (堆排序). Time complexity : O(nlogn) in the worst case.
    private ArrayList<Integer> Heapsort(){
        /*
            Heapsort:
                Input : an array A
                Output : a sorted permutaiton of A (输出一个一个单调递增的sorted数组)

                Step 1 : Heapify (建堆 + Heapify Algorithm)

                Step 2 : 将堆顶交换到当前堆的末尾 + 对新换到堆顶的元素执行SiftDown

                最终，该数组会是单调递增的sorted array.
        */
        return null;   
    }





    // 2. Mergesort (归并排序). Time complexity : O(nlogn) in the worst case.
    private ArrayList<Integer> Mergesort(){
        /*
            Mergesort:
                Input : an array A
                Output : a sorted permutaiton of A (输出一个一个单调递增的sorted数组)

                Step 1 : Divide (将数组分成两半)

                Step 2 : Conquer (递归地对每一半进行排序)

                Step 3 : Merge (将两个已排序的子数组合并成一个已排序的数组)
        
                最终，该数组会是单调递增的sorted array.


            细节 ：
                1. Divide : 将数组分成两半，直到每个子数组只有一个元素（或者没有元素）。单个元素的数组是有序的。

                2. Conquer : 递归地对每一半进行排序。对于每个子数组，重复步骤1和步骤2，直到所有子数组都被排序。

                3. Merge : 将两个已排序的子数组合并成一个已排序的数组。比较两个子数组的第一个元素，将较小的元素添加到结果数组中，并将指针移动到下一个元素。重复这个过程，直到所有元素都被合并。

        */
        return null;
    }




    // 3. Quicksort (快速排序). Time complexity : O(nlogn) in the average case, O(n^2) in the worst case.
    private ArrayList<Integer> Quicksort(){
        /*
            Quicksort:
                Input : an array A
                Output : a sorted permutaiton of A (输出一个一个单调递增的sorted数组)

                Step 1 : Choose a pivot element from the array（选择一个枢轴元素）for example, A[0]

                Step 2 : Partition the array into two sub-arrays according to the pivot（根据枢轴元素将数组分成两个子数组）

                Step 3 : Recursively sort the sub-arrays（递归地对两个子数组进行排序）

                最终，该数组会是单调递增的sorted array.

            思路；
                把第一个元素作为枢轴元素，然后扫描[low+1, high] ，我们有 i 和 j 两个指针 ，i 从左向右扫描，j 从右向左扫描，直到 i 和 j 相遇为止。
                    - 如果 A[i] < pivot , 则i++，继续扫描
                    - 如果 A[j] > pivot , 则调换 A[i] 和 A[j-1] 的位置，j--，继续扫描 
                循环结束后 ，A[i] 是小于等于 pivot 的最后一个元素，A[j] 是大于等于 pivot 的第一个元素。交换 A[low] 和 A[i] 的位置，这样 pivot 就被放在了正确的位置上。
                然后递归地对 pivot 左边和右边的子数组进行排序
        */
        return null;
    }




    // 4. Insertion Sort (插入排序). Time complexity : O(n^2) in the worst case.   O(n) in the best case (when the array is already sorted).
    private ArrayList<Integer> InsertionSort(){
        /*
            Insertion Sort:
                Input : an array A
                Output : a sorted permutaiton of A (输出一个一个单调递增的sorted数组)

                思路：

                For each element, compare it with the elements before it and insert it into the correct position in the sorted subarray to its left.
                (对于每个元素，将其与它之前的元素进行比较，并将其插入到它左边的已排序子数组中的正确位置)


                最终，该数组会是单调递增的sorted array.
        */
        return null;


    }
    






    // 5. Selection Sort (选择排序). Time complexity : O(n^2) in the worst case.   O(n^2) in the best case (when the array is already sorted).
    private ArrayList<Integer> SelectionSort(){
        /*
            Selection Sort:
                Input : an array A
                Output : a sorted permutaiton of A (输出一个一个单调递增的sorted数组)

                思路：

                Repeatedly select the smallest unsorted element and swap it with the first unsorted element until the entire array is sorted.
                (重复地选择最小的未排序元素，并将其与第一个未排序元素交换，直到整个数组被排序)

                最终，该数组会是单调递增的sorted array.
        */
        return null;

    }

    







    /*
        Lower bound for sorting time complexity (排序时间复杂度的下界) :

        We know algotihms to sort lists in:
            - O(nlogn) time (Heapsort, Mergesort, Quicksort)
            - O(n) time (quicksort in worst case , insertion sort , selection sort)

        Can we do better than O(nlogn) time for sorting?

            The answer is NO. We can prove that any comparison-based sorting algorithm must have a worst-case time complexity of O(nlogn) by using a decision tree.
            （任何基于比较的排序算法在最坏情况下的时间复杂度必须是O(nlogn)，我们可以通过使用决策树来证明这一点）
    */




        




    // 6. Counting Sort (计数排序). Time complexity : O(n + k) where n is the number of elements in the input array and k is the range of the input values.
    private ArrayList<Integer> CountingSort(){
        /*
            Counting Sort:
                Input : an array A of n integers where each integer is in the range [0, k-1]
                Output : a sorted permutaiton of A (输出一个一个单调递增的sorted数组)

                思路：

                1. Create a count array C of size k and initialize all elements to 0. 
                (创建一个大小为k的计数数组C，并将所有元素初始化为0)

                2. For each element x in A :
                    Increment C[x] by one
                    at this point , C[x] is the number of occurrences of x in A 
                    (对于A中的每个元素x，将C[x]加1，此时C[x]是A中x的出现次数)


                3.For each x from 0 to k-1,generate in the output x as many times as indicated by C[x] 
                    (对于每个x从0到k-1，根据C[x]的值在输出中生成x的相应次数)
        */
        return null;
    }

}