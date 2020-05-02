package ջ;

import java.util.Stack;
/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/submissions/
 * @author Ҷΰΰ
 *
 */
public class _232_��ջʵ�ֶ��� {
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(3);
		queue.push(4);
		queue.push(3);
		queue.push(4);
		queue.push(3);
		queue.push(4);
		queue.pop();
		System.out.println(queue.peek());
		
	}

}

class MyQueue {
	Stack<Integer> inStack;
	Stack<Integer> outStack;
	
    /** Initialize your data structure here. */
    public MyQueue() {
    	inStack = new Stack<Integer>();
    	outStack = new Stack<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
    	inStack.push(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	if(outStack.isEmpty()) {
    		while(!inStack.isEmpty()) {
    			outStack.push(inStack.pop());
    		}
    	}
    	return outStack.pop();
    }
    
    /** Get the peek element. */
    public int peek() {
    	if(outStack.isEmpty()) {
    		while(!inStack.isEmpty()) {
    			outStack.push(inStack.pop());
    		}
    	}
    	return outStack.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
    	return inStack.isEmpty() && outStack.isEmpty();
    }
}