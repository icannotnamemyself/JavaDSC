package xyz.theoye.circle;



import xyz.theoye.AbstractList;
import xyz.theoye.List;
/**
 * ˫��ѭ������
 * @author Ҷΰΰ
 *
 * @param <E>
 */
public class LinkCircleList<E> extends AbstractList<E> implements List<E> {

	/*����洢��С*/
	int size = 0;
	
	/*��һ��Ԫ��ͷָ��*/
	Node<E>first;
	
	/*���һ���ڵ�*/
	Node<E>last; 

	/*��ǰָ��*/
	Node<E> current;
	
	
	public LinkCircleList() {
		current = first = last = null;
		
	}
	
	public static class Node<E>{
		/*ָ��ǰһ���ڵ�*/
		Node<E> prev;
		
		/*ָ����һ���ڵ�*/
		Node<E> next; 
		E element ; 
		
		protected  Node(Node<E> prev,E element, Node<E>next ) {
			this.prev = prev;
			this.element = element;
			this.next = next;
		}
		
		public E getElement() {
			return element;
		}
	}

	public void reset() {
		current = first;
	}
	public Node next() {
		current = current.next;
		return current;
	}

	public Node<E> getCurrent() {
		if(current == null)
			current = first;
		return current;
	}
	@Override
	public void add(E element) {
		Node<E> newNode = new Node<E>(last,element, first);
		if(size == 0 ) {
			this.first = this.last = newNode;
			newNode.prev = newNode.next = newNode;
			
		}else {
			last.next = newNode;
			newNode.prev = last;
			last = newNode;
			
			newNode.next = first;
			first.prev = newNode;
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




	@Override
	public E remove(int index) {
		
		rangeCheck(index);
		E old = null;

		
		if(size == 1) {
			old = first.element;
			first = null;
			last = null;
		}else {
			
			Node<E> node =findNode(index);
			old = node.element;
			Node<E> prev = node.prev;
			Node<E> next = node.next; 
			prev.next = next;
			next.prev = prev;
			
			if(node == first) {
				/*ɾ�����ǵ�һ���ڵ�*/
				first = next;
			}
			if(node == last) {
				/*ɾ���������һ���ڵ�*/
				last = prev;
			}
			
			
		}
		size--;
		return old;
	}




	@Override
	public int indexOf(E element) {
		Node<E> node = first; 
		
		/*�������վ��ҿ�*/
		if(element == null) {   //
			for(int i = 0;  i < size; i++)
			{
				node = node.next;
				if(element == null) {
					return i;
				}
			}
		}
		/*�������ǿվ��Ҹ�Ԫ��*/
		else {
			for(int i = 0;  i < size; i++)
			{
				node = node.next;
				if(element.equals(node.element)) {
					return i;
				}
			}
		}
		
		/*�Ҳ�������ELEMENT_NOT_FOUND*/
		return ELEMENT_NOT_FOUND;
	}




	@Override
	public void clear() {
		
		size = 0 ;
		/*
		 * ��Ȼ��ѭ������, ���ǲ���gcroot����
		 * gcroot
		 * 
		 * ��: ��ջָ��ָ��Ķ���
		 */
		
		/*��һ�������һ��û��, �����Զ�û��*/
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
	 * toString����
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
