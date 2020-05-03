package xyz.theoye.circle;



import xyz.theoye.AbstractList;
import xyz.theoye.List;

public class ForwardCircleList<E> extends AbstractList<E> implements List<E> {

	/*����洢��С*/
	protected int size = 0;
	
	/*��һ��Ԫ��ͷָ��*/
	Node<E>first;
	
	public static class Node<E>{
		
		Node<E> next; 
		E element ; 
		
		public Node(E element, Node<E>next ) {
			this.element = element;
			this.next = next;
		}
		
		
		public Node getNext() {
			return next;
		}
		
		public E getElement() {
			return element;
		}
	}


	public Node getFirst() {
		return first;
	}
	
	@Override
	public void add(E element) {
		Node<E> newNode = new Node<E>(element, null);
		
		if(size == 0 ) {
			this.first = newNode;
			first.next = first;
		}else {
			Node<E>lastNode=  findNode(size - 1);
			lastNode.next = newNode;
			newNode.next = first;
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
		Node<E>newNode = new Node<E>(element, node.next); 
		node.next = newNode;
		size++;
	}




	@Override
	public E remove(int index) {
		Node<E>node =  findNode(index);
		E oldE = node.element;
		
		if(index ==0 ) {
			Node<E>lastNode = findNode(size - 1);
			node = first;
			first = first.next;
			node.next = null;
			lastNode.next = first;
		}
		else {
			Node<E> preNode = findNode(index - 1);
			preNode.next = node.next;
			node.next = null;
			node = null;
		}

		size--;
		return oldE;
	}

	/**
	 * ����ѭ������ 
	 * @return
	 */
	public E pop_back() {
		Node<E>last =  findNode(size -1);  //�ҵ����һ���ڵ�
		Node<E> prev = findNode(size - 2); // �ҵ������ڶ����ڵ�
		E oldE = last.element;  //��������   
		
		prev.next = last.next;  // �����ڶ����ڵ�ָ���һ���ڵ�
		
		
		size--;  
		return oldE;
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
		
		/*��һ��û��, �����Զ�û��*/
		first = null;  
	}
	
	private Node<E> findNode(int index) {
		rangeCheck(index);
		
		Node<E>node = first; 
		for(int i = 0 ; i<index;i++) {
			node = node.next;
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
