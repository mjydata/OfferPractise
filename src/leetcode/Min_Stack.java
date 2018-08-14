package leetcode;

import java.util.LinkedList;

/** 155
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 Example:
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.
 */
public class Min_Stack {
    private LinkedList<Integer> dataStack = null;
    private LinkedList<Integer> minStack = null;

    public Min_Stack() {
        dataStack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty()) minStack.push(x);
        else    minStack.push(Math.min(minStack.peek(), x));//按照排序深度，添加重复的当前最小值
    }

    public void pop() {
        if(!minStack.isEmpty()) minStack.pop();
        if(!dataStack.isEmpty()) dataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
    public  static  void  main(String[] args){
        Min_Stack stack=new Min_Stack();
        stack.push(-1);
        stack.push(1);
        stack.push(-2);
        stack.pop();
       System.out.println(stack.getMin());
    }
}
