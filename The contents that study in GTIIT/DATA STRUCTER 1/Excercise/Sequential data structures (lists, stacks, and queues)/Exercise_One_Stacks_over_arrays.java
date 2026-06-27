
/*
    Our goal in this exercise is to design a stack with the following operations. 
    All complexities correspond to worst-case execution time:
        • Create a new stack with capacity to store N elements of type T.
          Complexity: O(N ).

        • Obtain the current capacity (maximum number of elements that can be inserted).
          Complexity: O(1).

        • Obtain the current size (number of elements that the stack currently contains).
          Complexity: O(1).

        • Push an element on top of the stack.
          Precondition: the size of the stack must be strictly less than its capacity.
          Complexity: O(1).

        • Obtain the element at the top of the stack.
          Precondition: the stack must not be empty.
          Complexity: O(1).

        • Pop the element from the top of the stack.
          Precondition: the stack must not be empty.
          Complexity: O(1).

    The stack should be represented over arrays, containing:

        • An array this.elements of elements of type T.

        • An integer this.capacity representing the maximum capacity of the stack.
        
        • An integer this.size representing the current size of the stack.

    The representation invariant should include the following conditions:
        
        1. this.size <= this.capacity所以 stack.add(element) 如果继续执行，会在超过 capacity 后继续扩容
        
        2. this.elements.size() == this.size
        
        The top of the stack should be located at this.elements[this.size - 1].
*/

import java.util.ArrayList;

public class Exercise_One_Stacks_over_arrays {

    class Stack<T> {

        ArrayList<T> stack;

        int capacity;
                

        Stack(int capacity) {

        stack = new ArrayList<>(capacity);

        this.capacity = capacity;

        }



        int capacity() {

            return this.capacity;

        }
        
        
        
        int size() {

            return stack.size();

        }
        
        
        
        void push(T element) {

            assert stack.size() < this.capacity;

            stack.add(element);

        }
        
        
        
        T top() {

            assert stack.size() > 0 ;

            return stack.get(stack.size() - 1);

        }
        
        
        
        void pop() {

            assert stack.size() > 0;

            stack.remove(stack.size() - 1);

        }
    }
}
