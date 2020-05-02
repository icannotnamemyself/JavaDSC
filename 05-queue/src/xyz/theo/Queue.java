package xyz.theo;

import java.util.LinkedList;

import xyz.theo.list.LinkList;

public class Queue<E> {
	private LinkList<E> linkList= new LinkList<E>();
	
	public Queue() {
	}
	
	
	public int size() {
		return linkList.size();
	}
	
	public boolean isEmpty() {
		return linkList.isEmpty();
	}
	
	
	public void enQueue(E element) {
		linkList.add(element);
	}
	
	
	public E deQueue() {
		return linkList.remove(0);
	}
	
	E front() {
		return linkList.getFirst();
	}
	
	void clear() {
		linkList.clear();
	}
	
	@Override
	public String toString() {
		return linkList.toString();
	}
}
