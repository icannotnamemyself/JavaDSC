package xyz.theo;

import xyz.theo.list.ArrayList;
import xyz.theo.list.List;

public class Stack<E> {

	List<E> list = new ArrayList<E>();
	
	public void push(E element) {
		list.add(element);
	}
	
	public E top() {
		return list.get(list.size() - 1);
	}
	
	public E pop() {
		return list.remove(list.size() -1);
	}
	
	public boolean isEmpty() {
		
		return list.isEmpty();
	}
	
	public int size() {
		return list.size();
	}
	
	@Override
	public String toString() {
		return list.toString();
	}
	
}
