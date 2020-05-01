package Stack;

import java.util.Stack;

public class _150_�沨�����ʽ��ֵ {
    public int evalRPN(String[] tokens) {
    	
    	Stack<Integer> numStack = new Stack<Integer>();
    	
    	for(String string : tokens) {
			int num ;
			switch (string) {
			case "+":
				numStack.push(numStack.pop() + numStack.pop());
				break;
			case "-":
				num = numStack.pop();
				numStack.push(numStack.pop() - num);
				break;
			case "*":
				num = numStack.pop();
				numStack.push(numStack.pop() * num);
				break;
			case "/":
				num = numStack.pop();
				numStack.push(numStack.pop() / num);
				break;
			default:
    			int numIn = Integer.valueOf(string);
				numStack.push(numIn);
			}
    		
    	}
    	
		return numStack.pop();
    }
}
