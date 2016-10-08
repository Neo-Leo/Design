/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/min-stack/
 */ 

public class MinStack {
    Stack<Integer> stack, minStack;  
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(x);
            minStack.push(x);
        } else {
             stack.push(x);
             if(x <= minStack.peek()){
                 minStack.push(x);
             }
        }
    }
    
    public void pop() {
        int x = stack.pop();
        if(x == minStack.peek())
            minStack.pop(); 
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
