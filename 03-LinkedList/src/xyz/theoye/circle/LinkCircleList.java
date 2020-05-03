package xyz.theoye.circle;



import java.util.Comparator;


import xyz.theoye.AbstractList;
import xyz.theoye.List;
/**
 * 双向循环链表
 * @author 叶伟伟
 *
 * @param <E>
 */
public class LinkCircleList<E> extends AbstractList<E> implements List<E> {

	/*链表存储大小*/
	int size = 0;
	
	/*第一个元素头指针*/
	Node<E>first;
	
	/*最后一个节点*/
	Node<E>last; 

	/*当前指针*/
	Node<E> current;
	
	
	public LinkCircleList() {
		current = first = last = null;
		
	}
	
	public static class Node<E>{
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
				/*删除的是第一个节点*/
				first = next;
			}
			if(node == last) {
				/*删除的是最后一个节点*/
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
	/**
	 * 寻找根据index寻找节点
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
	 * 将元素插入到有序列表中, 这里的element 即插入的X
	 * @param element
	 * @param comparator
	 */
	public void insert(E element, Comparator<E> comparator) {
		
		Node<E> node = first;   //获取头节点
		
		while(node!=null &&comparator.compare(element, node.element) >= 0) 
			node = node.next;
		
		
		//如果没找到比该node大的元素就直接添加到最后面, 然后返回
		if(node == null) {
			add(element);
			return ;
		}
		
		
		//否则就使用该元素生成新节点插入到该节点之前
		insertBefore(element, node);
		size++;
	}
	
	/**
	 * 将element插入到node之前 
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
	 * 找到符合条件的第一个元素并且删除
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
		
		//没找到就抛出异常
		if(node == null) {
			throw new Exception("Element Not Found");
		}
		
		//找到则删除弹出
		E oldE = node.element;
		
		Node<E> prev = node.prev;
		
		prev.next = node.next;
		node.next = prev;
		//由java GC 来处理垃圾
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
