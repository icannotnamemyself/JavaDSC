package xyz.theo;

import com.sun.org.apache.bcel.internal.generic.StackConsumer;

public class Main {

	// 0  1 1 2 3 5 8 13
	// fib(n) = fib(n - 1) + fib(n - 2)
	
	/**
	 * 递归版本
	 * 时间复杂度: 2^n
	 * 1. 存在性能问题
	 * 
	 * @param n
	 * @return
	 */
	public  static int  fib1(int n) {
		if(n <= 1) return n;   // 传0 返回0 , 传1 返回1
		return fib1(n - 1) + fib1(n - 2);
	}
	/**
	 * 迭代版本
	 * 时间复杂度: n
	 * 
	 * @param args
	 */
	public static int fib2(int n) {
		if (n == 0 ) {
			return 0;
		}
		int first = 0;
		int second = 1;
		int sum = 0; // 中间值
		for(int i=0; i<n-1;i++) {
			sum = second + first;
			first = second;
			second = sum;
		}
		
		
		return second;
	}
	
	
	
	public static void main(String[] args) {
		
		
		System.out.println(fib2(30));

	}

}
