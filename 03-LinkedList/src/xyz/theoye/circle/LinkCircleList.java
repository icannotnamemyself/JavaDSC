package xyz.theoye.circle;



import java.util.Comparator;


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


	public void insert(int element) {
		
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
	/**
	 * Ѱ�Ҹ���indexѰ�ҽڵ�
	 * @param index
	 * @return
	 */
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
	 * ��Ԫ�ز��뵽�����б���, �����element �������X
	 * @param element
	 * @param comparator
	 */
	public void insert(E element, Comparator<E> comparator) {
		
		Node<E> node = first;   //��ȡͷ�ڵ�
		
		while(node!=null &&comparator.compare(element, node.element) >= 0) 
			node = node.next;
		
		
		//���û�ҵ��ȸ�node���Ԫ�ؾ�ֱ����ӵ������, Ȼ�󷵻�
		if(node == null) {
			add(element);
			return ;
		}
		
		
		//�����ʹ�ø�Ԫ�������½ڵ���뵽�ýڵ�֮ǰ
		insertBefore(element, node);
		size++;
	}
	
	/**
	 * ��element���뵽node֮ǰ 
	 * @param element
	 * @param node
	 */
	private void insertBefore(E element, Node<E> node) {
		Node<E> newNode = new Node<>(node.prev, element, node); 
		
		Node<E>prev = node.prev;
		
		prev.next = newNode;
		node.prev = newNode;

	}
	
	/**
	 * �ҵ����������ĵ�һ��Ԫ�ز���ɾ��
	 * @param element
	 * @throws Exception
	 */
	public void findAndDelete(E element) throws Exception {
		Node<E> node = first;
		
		while(node !=null) {
			if(element.equals(node.element))
				break;
			node = node.next;
		}
		
		//û�ҵ����׳��쳣
		if(node == null) {
			throw new Exception("Element Not Found");
		}
		
		//�ҵ���ɾ������
		E oldE = node.element;
		
		Node<E> prev = node.prev;
		
		prev.next = node.next;
		node.next = prev;
		//��java GC ����������
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
