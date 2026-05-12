import java.util.ArrayList;

public class DigitalTree{
    /*
        Let A be an alphabet (finite set of symbols)

        A trie is a tree where each node has |A| children , one of each symbol of the alphabet. (每个节点有|A|个孩子，每个孩子对应一个字母)

        1.The path from the root to a node is a key (路径是key)
        2.The value stored in a node corresponds to a value associated with the key (节点存储的值是key对应的value)

        Example : A = {a , b, c} , the following is trie :
                          root
                        /  |  \
                     'a' 'b' 'c'
                     /     |     \
                    □      1      □         （空框可以表示为null)
                    /            / \
                  'b'          'a'  'b'
                  / \           |    |
                 2  'a'         5    6
                     |
                     3

        The trie is a data structure that can be used to implement a dictionary (trie可以用来实现字典)


        □ 的含义：
        - 表示该节点不是任何有效 key 的终点，value 为 null（空）
        - 也可能是某个字符分支不存在（空子节点）
        - 中间节点可以是 □，它只是路径的一部分，用来构成更长的 key

        空间浪费问题：
        - 如果一个节点变成了叶子（没有子节点），但它的 value 是 □（空）
        - 这个节点就白白占用了空间，没有任何实际作用

        Invariant（不变量 / 必须始终成立的规则）：
        - 叶子节点（没有子节点的节点）必须有 value，不能是 □
        - 唯一的例外是根节点（root）
        - 当树为空时，根节点没有子节点也没有 value，这是允许的
    */




    private void InsertionAlgorithm(){
        /*
            To insert a key a0,...,am-1 with value v into a trie :
            
            1. Start at the root of the trie (从根节点开始)

            2. For each i from 0 to m-1 :
                Go down to the child corresponding to ai (根据当前字符 ai 选择对应的子节点)
                (if the child does not exist, create a new node) (如果子节点不存在，创建一个新节点)

            3. Mark the node to indicate that the key is present. (标记该节点表示这个 key 存在)
               Store the value v in the node. (在该节点存储 value v)
        */
    }


}


class TrieNode<V>{
    boolean hasKey; // 是否是一个有效 key 的终点
    V value; // 存储与 key 相关联的值
    ArrayList<TrieNode<V>> children; // 孩子节点数组，大小为 |A|

    public TrieNode(){
        this.hasKey = false; // 默认不是一个有效 key 的终点
        this.value = null; // 默认没有关联的值
        this.children = new ArrayList<>(); // 初始化孩子节点数组
    }
}