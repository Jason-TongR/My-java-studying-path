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
}