import java.util.ArrayList;
import java.io.*;

public class HashMapMain {
    public static void main(String[] args) {
        HashMapMain.measure_time(HashFunction.FirstChar);
        HashMapMain.measure_time(HashFunction.SumChars);
        HashMapMain.measure_time(HashFunction.PolynomialRolling);
    }

    // This method:
    // - Reads all the words from the words.txt file into an array.
    // - Creates a hash table.
    // - Inserts all the words into the hash table, mapping each word to a number.
    // - Checks that all the words are mapped to the correct number.
    // - Measures the total time required to do this and prints it on the screen.
    //   (The time to load the words from the file is not measured).
    static void measure_time(HashFunction hash_function) {
        System.out.println("--- Measuring time for hash function: " + hash_function + " ---");

        System.out.println("  Reading words");
        ArrayList<String> words = HashMapMain.read_words();

        double start = System.nanoTime();
        System.out.println("  Hashing words");
        int i = 0;
        HashMap hashmap = new HashMap<Integer>(hash_function);
        for (String word : words) {
            hashmap.insert(word, i);
            i++;
        }
        i = 0;
        for (String word : words) {
            if ((int)hashmap.lookup(word) != i) {
                System.out.println("ERROR");
                System.exit(1);
            }
            i++;
        }
        double end = System.nanoTime();
        double time_ms = (end - start) / 1000000;
        System.out.println("  Total time: " + String.format("%.3f ms", time_ms));
    }

    // This method reads all the words from the words.txt file into an array.
    static ArrayList<String> read_words() {
        try {
            ArrayList<String> words = new ArrayList<String>();
            BufferedReader b = new BufferedReader(new FileReader("words.txt"));
            String word;
            while ((word = b.readLine()) != null) {
                words.add(word);
            }
            return words;
        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
        return null;
    }
}

// Each element in the enumeration represent a different hash function.
enum HashFunction {
    FirstChar,
    SumChars,
    PolynomialRolling,
}

class HashMap<T> {

    /**** Representation ****/

    // Represents a key-value pair.
    private class KeyValue {
        String key;
        T value;
        KeyValue(String key, T value) {
            this.key = key;
            this.value = value;
        }
        public String toString() {
            return this.key + ": " + this.value;
        }
    }

    // HashMap.CAPACITIES is the list of all possible capacities.
    // The hash table is initialized with the first capacity in the list (53 buckets).
    // Every time the load factor becomes more than 75%, the table must
    // be resized to the next capacity in this list.
    private static final int[] CAPACITIES = {
        53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
        49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469
    };
 
    // The hash function used by this hash table.
    private HashFunction hash_function;

    // The table is an array of buckets.
    // Each bucket is an array of key-value pairs.
    private ArrayList<ArrayList<KeyValue>> table;

    // The size of the hash table is the total number of keys it contains.
    private int size;

    // The capacity of the hash table is the total number of buckets.
    //   icapacity  is an index to the CAPACITIES array above.
    //   capacity   is the corresponding capacity.
    // For example, if icapacity = 0, then capacity = 53.
    private int icapacity;
    private int capacity;

    // Representation invariant:
    // 1) 0 <= this.icapacity < CAPACITIES.length
    // 2) this.capacity == this.table.size()
    // 3) this.capacity == HashMap.CAPACITIES[this.icapacity]
    // 4) For every index i in the table,
    //    and every key-value pair kv in the bucket this.table[i]
    //      this.hash(kv.key) == i.

    /**** Implementation ****/

    // Create an empty hash table.
    HashMap(HashFunction hash_function) {
        this.hash_function = hash_function;
        this.table = new ArrayList<ArrayList<KeyValue>>();
        this.icapacity = 0;
        this.capacity = HashMap.CAPACITIES[this.icapacity];
        // Initialize the table with empty buckets.
        for (int i = 0; i < this.capacity; i++) {
            this.table.add(new ArrayList<KeyValue>());
        }
    }

    // This static method applies the hash function to the key.
    //
    // - The "FirstChar" hash function is already implemented.
    //   It returns the value of the first character.
    // - You should implement the "SumChars" and "PolynomialRolling" functions:
    //   - The SumChars function sums all the characters in the key.
    //   - The PolynomialRolling function computes
    //       k_0 + p k_1 + p^2 k_2 + ... + p^(n-1) k_(n-1)
    //     where k_i represents the i-th character of the key
    //     and p is a prime bigger than 256.
    static int apply_hash_function(HashFunction hash_function, String key) {
        switch (hash_function) {
        case FirstChar:

            return (int)key.charAt(0);

        case SumChars:

            int sum = 0;
            for(int i = 0 ; i < key.length() ; i++){
                sum += key.charAt(i);
            }
            return 0;

        case PolynomialRolling:

            // k0 + p*k1 + p^2*k2 + ...
            int p =257; //is a pime that bigger than 255
            int hash = 0;
            int power = 1;
            for(int i = 1 ; i < key.length() ; i++){
                hash += key.charAt(i)*power;
                power *= p;
            }
            return 0;

        } 
        return 0; // This line is unreachable.
    }

    // This method computes the hash of the key.
    // - First it applies the hash function.
    // - Then it takes the remainder in the division by the capacity.
    int hash(String key) {
        int h = HashMap.apply_hash_function(this.hash_function, key);
        return Math.floorMod(h, HashMap.CAPACITIES[this.icapacity]);
    }

    // Insert a key associating it to a value.
    // - You should insert a key by calculating its hash, using this.hash(key),
    //   and adding it to the corresponding bucket.
    // - Remember to increase the size of the table if the key was not
    //   present in the table before.
    // - If the load factor is higher than 0.75, we grow the table.
    void insert(String key, T value) {
        int idx = hash(key);
        ArrayList<KeyValue> bucket = this.table.get(idx);

        //1.检查 Key 是否已经存在， 存在则更新
        for(KeyValue kv : bucket){
            if(kv.key.equals(key)){
                kv.value = value;
                return;
            }
        }


        //2. 不存在则创建新节点插入
        KeyValue kv = new KeyValue(key , value);
        bucket.add(kv);
        this.size++;

        
        // If the load factor is higher than 0.75, grow the table.
        double load_factor = (double)this.size / (double)this.capacity;
        if (load_factor > 0.75) {
            grow();
        }
    }

    // Implement the mechanism to grow the table.
    // - You should find the next capacity in the CAPACITIES table.
    // - Create a new auxiliary table with the new capacity,
    //   and rehash all the previous keys.
    // - Remember to update this.table, this.capacity and this.icapacity.
    void grow() {
        if (this.icapacity == HashMap.CAPACITIES.length) {
            // Maximum size reached, cannot grow.
            return;
        }
        // 1. 更新容量参数
        this.icapacity++;
        this.capacity = CAPACITIES[this.icapacity];
    
        // 保存对旧表的引用
        ArrayList<ArrayList<KeyValue>> oldTable = this.table;
        
        // 2. 初始化新表
        this.table = new ArrayList<>(this.capacity);
        for (int i = 0; i < this.capacity; i++) {
            this.table.add(new ArrayList<>());
        }
        
        // 将 size 清零，因为重新调用 insert 时 size 会自行累加
        this.size = 0;
        
        // 3. 遍历旧表，重哈希（Rehash）所有数据
        for (ArrayList<KeyValue> bucket : oldTable) {
            for (KeyValue kv : bucket) {
                this.insert(kv.key, kv.value);
            }
        }
    }

    // Implement the lookup method.
    // If the key is not present, return null.
    T lookup(String key) {
        int idx = hash(key);
        ArrayList<KeyValue> bucket = this.table.get(idx);
    
        // 线性遍历该桶
        for (KeyValue kv : bucket) {
            if (kv.key.equals(key)) {
                return kv.value;
            }
        }
    
        // 未找到
        return null;
    }

    public String toString() {
        return this.table.toString();
    }

}
