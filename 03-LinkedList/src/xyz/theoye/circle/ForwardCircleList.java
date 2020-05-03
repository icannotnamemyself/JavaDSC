package xyz.theoye.circle;



import xyz.theoye.AbstractList;
import xyz.theoye.List;

public class ForwardCircleList<E> extends AbstractList<E> implements List<E> {

	/*链表存储大小*/
	protected int size = 0;
	
	/*第一个元素头指针*/
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
	 * 单向循环链表 
	 * @return
	 */
	public E pop_back() {
		Node<E>last =  findNode(size -1);  //找到最后一个节点
		Node<E> prev = findNode(size - 2); // 找到倒数第二个节点
		E oldE = last.element;  //保存数据   
		
		prev.next = last.next;  // 倒数第二个节点指向第一个节点
		
		
		size--;  
		return oldE;
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
		
		/*第一个没了, 其他自动没了*/
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
