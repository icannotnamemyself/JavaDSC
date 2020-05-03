package xyz.theoye;

import java.util.Comparator;


public class LinkedList<E> extends AbstractList<E> implements List<E> {

	
	/*第一个元素头指针*/
	Node<E>first;
	
	/*最后一个节点*/
	Node<E>last; 

	
	public LinkedList() {
		first = last = null;
	}
	private static class Node<E>{
		/*指向前一个节点*/
		Node<E> prev;
		
		/*指向下一个节点*/
		Node<E> next; 
		E element ; 
		
		protected  Node(Node<E> prev,E element, Node<E>next ) {
			this.prev = prev;
			this.element = element;
			this.next = next;
		}
	}



	@Override
	public void add(E element) {
		Node<E> newNode = new Node<E>(last,element, null);
		if(size == 0 ) {
			this.first = this.last = newNode;
			
		}else {
			last.next = newNode;
			newNode.prev = last;
			last = newNode;
		}
		
		size++;
	}




	@Override
	public E get(int index) {
		Node<E>node  = findNode(index);
		return node.element;
	}

	


	@Override
	public E set(int index, E element) {
		Node<E>node  = findNode(index);
		E old = node.element;
		node.element = element;
		
		return old;
	}




	@Override
	public void add(int index, E element) {
		
		Node<E>node  = findNode(index);
		
		Node<E>newNode = new Node<E>(node,element, node.next);
		newNode.element = element;
		node.next.prev = newNode;
		node.next = newNode;
		size++;
	}


	public void insertFront(E element) {
		Node<E> newNode = new Node<>(null, element, first);
		Node nextNode = first.next;
		
		nextNode.prev = newNode;
		newNode.next = first;
		
		first= newNode;
		size++;
	}

	@Override
	public E remove(int index) {
		
		
		Node<E>node =  findNode(index);
		E old = node.element;
		final Node<E>next = node.next;
		final Node<E> prev = node.prev; 
		
		if(prev == null) {
			first = next;
		}else {
			prev.next = next;
			node.prev = null;
		}
		if(next == null) {
			last = prev;
		}else {
			next.prev = prev;
			node.next = null;
		}
		size--;
		return old;
	}




	@Override
	public int indexOf(E element) {
		Node<E> node = first; 
		
		/*如果输入空就找空*/
		if(element == null) {   //
			for(int i = 0;  i < size; i++)
			{
				node = node.next;
				if(element == null) {
					return i;
				}
			}
		}
		/*如果输入非空就找改元素*/
		else {
			for(int i = 0;  i < size; i++)
			{
				node = node.next;
				if(element.equals(node.element)) {
					return i;
				}
			}
		}
		
		/*找不到返回ELEMENT_NOT_FOUND*/
		return ELEMENT_NOT_FOUND;
	}




	@Override
	public void clear() {
		
		size = 0 ;
		/*
		 * 虽然有循环引用, 但是不是gcroot对象
		 * gcroot
		 * 
		 * 如: 被栈指针指向的对象
		 */
		
		/*第一个和最后一个没了, 其他自动没了*/
		first = null;  
		last = null;
		
	}
	
	private Node<E> findNode(int index) {
		rangeCheck(index);
		Node<E>node = null; 
		
		if(index<(size >> 1)) {
			
			node = first; 
			for(int i = 0 ; i<index;i++) {
				node = node.next;
			}
			
		}else {
			node = last; 
			for(int i = 0 ; i>size-index-1;i++) {
				node = node.prev;
		}
		
		
		
	}
		return node;
	
	}
	private void rangeCheck(int index) {
		if(index<0 || index>=size) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	
	
	
	/**
	 * toString方法
	 */
	@Override
	public String toString() {
		
		
		StringBuilder string = new StringBuilder("size="+size+",");
		string.append("[");
		
		Node<E>node = first;
		
		for(int i = 0 ; i< size; i++)
		{
			if(i!=0) {
				string.append(",").append(node.element.toString());
			}
			else {
				string.append(node.element.toString());
			}
			
			
			node = node.next;
		}
		string.append("]");	
		
		return string.toString();
	}
	
}
