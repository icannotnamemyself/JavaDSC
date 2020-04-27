package xyz.theo;

import com.sun.org.apache.bcel.internal.generic.StackConsumer;

public class Main {

	// 0  1 1 2 3 5 8 13
	// fib(n) = fib(n - 1) + fib(n - 2)
	
	/**
	 * �ݹ�汾
	 * ʱ�临�Ӷ�: 2^n
	 * 1. ������������
	 * 
	 * @param n
	 * @return
	 */
	public  static int  fib1(int n) {
		if(n <= 1) return n;   // ��0 ����0 , ��1 ����1
		return fib1(n - 1) + fib1(n - 2);
	}
	/**
	 * �����汾
	 * ʱ�临�Ӷ�: n
	 * 
	 * @param args
	 */
	public static int fib2(int n) {
		if (n == 0 ) {
			return 0;
		}
		int first = 0;
		int second = 1;
		int sum = 0; // �м�ֵ
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
