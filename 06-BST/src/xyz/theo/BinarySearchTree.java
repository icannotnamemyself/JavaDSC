package xyz.theo;

import java.util.Comparator;

import com.mj.printer.BinaryTreeInfo;


public class BinarySearchTree<E> implements BinaryTreeInfo {

	/*二叉树节点数*/
	int size;
	
	/*根节点*/
	Node<E> root; 
	
	Comparator<E> comparator; 
	
	class Node<E> {
		E element;
		Node<E> left, right, parent; 
		
		
		public Node(E element, Node parent){
			this.element = element;
			this.parent = parent;
		}
	}
	
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
		
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size ==0 ;
	}

	
	public void add(E element) {
		// 判空
		
		
		//如果还没有节点则初始化根节点
		if(root == null) {
			root = new Node<E>(element, null);
		}
		
		// 找父节点, 以及方向, 并且保存
		Node<E> parent = null;
		int cmp = 0;
		Node<E> node = root;
		
		
		/*找父节点*/
		while(node !=null) {
			parent = node;
			cmp = compare(element, node.element);
			if(cmp > 0) {
				node = node.right;
				
			}else if(cmp < 0) {
				node = node.left;
			}else {
				return ;
			}
		}
		
		/*创建并且插入节点*/
		Node<E> newNode = new Node<E>(element, parent); 
		if(cmp > 0 ) {
			parent.right = newNode;
		}else {
			parent.left = newNode;
		}
		
		size++;
	}
	
	
	
	
	
	
	
	void clear() {}
	
	/**
	 * 
	 * @param e1
	 * @param e2
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private int compare(E e1, E e2) {
		if(comparator != null) {
			return comparator.compare(e1, e2);
		}
		
		return ((Comparable<E>)e1).compareTo(e2) ;
	}
	
	
	
	private void elementNotNullCheck(E element) {
		if(element == null) {
			throw new IllegalArgumentException("element can't be null");
		}
	}

	@Override
	public Object root() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public Object left(Object node) {
		// TODO Auto-generated method stub
		return ((Node<E>)node).left;
	}

	@Override
	public Object right(Object node) {
		// TODO Auto-generated method stub
		return ((Node<E>)node).right;
	}

	@Override
	public Object string(Object node) {
		// TODO Auto-generated method stub
		return ((Node<E>)node).element;
	}

}
