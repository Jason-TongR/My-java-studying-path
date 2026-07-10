public class Exerise_five {
    /*
        [Designing data structures]
        Design a data sturcutre which provides the following operations with
        the given worst-case time complexity , where we write |w| for the length of a string w :
            1. Initiialize an empty set of strings in O(1)
            2. Add a string w to the set , in O(|w|) time
            3 Given a string w , determine the number of strings in the set that end with w, 
              in O(|w|)time. For example if the set is {"acrobat" , "cat" , "dog" , "great"}
              there are 3 stirngs that end with "at"
    */



    /*
        ANSWER :
            We propose to represent the set of stirngs using a trie with the following characterisics:
                1. The trie stores the reverse of each string in the set
                2. Each node in the trie stores a number called count representing the number of words 
                   that end with a given prefix.

            The operations can be implemented as follows:
                1. To initialize an empty set of strings , create an empty trie. This takes O(1) worst-case time.
                
                2. To add a string w , first reverse the stirng w obtaining a reversed stirng w^r . For example , 
                   if w = "hello" then w^r = "ohheh" . Then insert w^r in the trie.Increment the count value of each visited node in
                   the path from the root to the node for w^r.

                   Reversing the stirng takes O(|w|) worst-case time . Inserting the reversed string in the trie takes O(|w|) worst-case time


                3. To check if a string w is in the set , first reverse it obtaining w^r , and then lookup w^r in the trie .
                   Return true iff the word has been inserted before.

                   Both reversal and lookup take O(|w|) worst-case time.

                4. To determine how many strings end with a given suffix w , first reverse it obtaining w^r and then lookup w^r in the
                trie . Return the count value of the node.

                    Both reversal and lookup take O(|w|) worst-case time.
    */
}