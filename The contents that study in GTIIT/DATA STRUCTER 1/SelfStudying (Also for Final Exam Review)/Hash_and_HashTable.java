public class Hash_and_HashTable {
    /*
        why we don't use array[n] to achieve Hash Table?
            The key in the array must be an integer, but in the real world, the key can be a string, a float ,...,or any type of data,
            so we need a way to convert the key into an integer, and this is what Hash Function does.
        
        Idea : Hash Function
            We want to implement a dictionary mapping keys to values
            Let K be the set of all keys
            Find a function H : K -> {0, 1, ..., m-1} that maps each key to an integer in the range [0, m-1]
            and we can store all the values in an array of size m
            
        Tautology : 
            This function H is called a hash function , if H is injective , then we say H is a perfect hash function.
            Each of the m positions in the array is called a bucket.



        Collisions :  It is usually difficult or impossible to find a perfect hash function , collisions are extremely common.
                      Because we don't kown how many keys we will have in the future.





        How to resolve collisions?
            1. Closed addressing :
                Each bucket contains a list of key-value pairs

                Operations:
                    To insert (k,v) , insert it in the bucket H(k).
                    TO search for k , search for it in the bucket H(k).
                    TO delete k , delete it from the bucket H(k).
                
                Time complexity: (n = number of keys , m = number of buckets)
                    Worst case : O(n)       <--- all keys hash to the same bucket 
                    Average case : O(n/m)   <--- all the keys are in different buckets 

                Rehashing : The load factor := n/m

                            load factor 小 → 桶大部分是空的，查找快，但浪费内存。

                            load factor 大 → 表很拥挤，链表可能很长，查找会变慢。

                            当负载因子超过某个阈值（比如 0.75），冲突会变得很严重，链表变长，查找性能从 O(1) 往 O(n) 退化。
                            这时候就必须增大数组长度，让元素重新分散，把负载因子降下来。

                            常见做法是加倍 : 
                                1. 创建一个新的数组，长度是原来的两倍。
                                2. 将原来数组中的所有元素重新哈希到新的数组中。
                                3. 更新哈希表的引用，指向新的数组。
                                This is called Rehashing.

                            To rehash the table , we need to change the hash function to accommodate the new size of the table.
                            Complexity of rehashing:
                                Rehashing takes O(n+m) worest-case time
                                But the amortized cost is O(1).
                                The analysis is similar to the geometric growth method for arrays.
                            
                            低了就缩，高了就扩, 以保持负载因子在一个合理的范围内。
            
            2. Open addressing :
                Each bucket may be empty or contain a single key-value pair.
                    Operations:
                        To insert a key k , try to insert it in the bucket H(k).
                            If the bucket H(k) is full , try the bucket H(k) + 1 , then H(k) + 2 , and so on until we find an empty bucket.
                        To search for a key k , follow a similar procedure :
                            Search the key in the bucket H(k) + i mod m , until it is found or an empty bucket is found.
                        To delete a key k , we can mark the bucket as deleted, but we can't simply set it to empty, because it may cause problems for searching.



                        In linear probing , keys tend to cluster in long runs.
                        An alternative is quadratic probing , another alternative is double hashing.
                        Both methods can reduce clustering by using different probing sequences.
                        


        Designing hash functions :

            An ideal hash function to implement a hash table:
                Should be fast to compute.

                Should distribute input uniformly.

                Intuitively, it should look like a “random” assignment.

            Avalanche effect:

                small changes in the input significantly change the output.
                It should not preserve other properties of the input.

    */

}
