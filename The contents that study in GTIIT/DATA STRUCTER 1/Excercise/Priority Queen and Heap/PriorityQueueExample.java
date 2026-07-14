import java.util.ArrayList;

public class PriorityQueueExample {
    public static void main(String[] args) {
    }
}

class PriorityQueue<T extends Comparable<T>> {

    /* Methods */

    PriorityQueue() {
        this.heap = new ArrayList<T>();
    }

    static int leftChild(int i) {

        return 2*i + 1;
    }

    static int rightChild(int i) {
        
        return 2*i + 2;
    }

    static int parent(int i) {
        
        return (i - 1)/2;
    }

    int size() {
        return this.heap.size();
    }

    void insert(T element) {
        this.heap.add(element);
        siftUp(this.size()-1);
    }

    T maximum() {
        assert this.size() > 0;
        
        return this.heap.get(0);
    }

    void removeMaximum() {
        assert this.size() > 0;
        
        int lastIndex = this.size() - 1;


        //用最后一个元素替代根节点
        this.heap.set(0,this.heap.get(lastIndex));
        this.heap.remove(lastIndex);

        if(this.size() > 0){
            siftDown(0);
        }
    }

    static void heapsort(ArrayList<Integer> a) {
        //1.将所有元素通过Floyd 算法构建成一个最大堆
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(a);

        // 2. 连续移出最大值，由于是最大堆，每次拿到的是当前剩余的最大数。
        // 为了实现非递减排序（从小到大），我们需要从后往前填充原数组。
        for (int i = a.size() - 1; i >= 0; i--) {
            a.set(i, pq.maximum());
            pq.removeMaximum();
        }
    }   

    /* Fields */
    private ArrayList<T> heap;



    //aux method
    private void siftUp(int i){ }

    private void siftDown(int i){}
}