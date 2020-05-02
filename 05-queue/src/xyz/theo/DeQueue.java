package xyz.theo;

import xyz.theo.list.LinkList;
public class DeQueue<E> {
	
	LinkList<E> linkList = new LinkList<>();
	
	
	public DeQueue() {
	}
	
	public int size() {
		return linkList.size();
	}
	
	boolean isEmpty() {
		return linkList.isEmpty();
	}
	
	void clear() {
		linkList.clear();
	}
	
	public void enQueueRear(E element) {
		linkList.add(element);
	}
	
	E deQueueFront() {
		return linkList.remove(0);
	}
	
	E deQueueRear() {
		return linkList.remove(size() - 1);
	}
	
	void enQueueFront(E element) {
		linkList.insertFront(element);
	}
	
	E front() {
		return linkList.get(0);
	}
	
	E rear() {
		return linkList.get(size() - 1);
	}
	
	
	@Override
	public String toString() {
		return linkList.toString();
	}

}
