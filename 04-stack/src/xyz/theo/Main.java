package xyz.theo;

public class Main {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		
		stack.pop();
		
		System.out.println(stack);
		System.out.println(stack.top());
		System.out.println(stack.isEmpty());
	}
}





