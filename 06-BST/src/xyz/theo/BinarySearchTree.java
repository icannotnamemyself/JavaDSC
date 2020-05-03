package xyz.theo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import com.mj.printer.BinaryTreeInfo;


public class BinarySearchTree<E> implements BinaryTreeInfo {

	/*size*/
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
	
	/**
	 * 
	 * @author 叶伟伟
	 *
	 * @param <E>
	 */
	public static abstract class Visitor<E> {
		
		/*interface 不可定义属性, 因此设置为abstract class*/
		boolean stop;
		
		
		/**
		 * 
		 * @param element
		 * @return 如果返回true则停止遍历
		 */
		public abstract boolean visit(E element);
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
		// �п�
		
		
		//如果没有root则创建root
		if(root == null) {
			root = new Node<E>(element, null);
			return ;
		}
		
		// �Ҹ��ڵ�, �Լ�����, ���ұ���
		Node<E> parent = null;
		int cmp = 0;
		Node<E> node = root;
		
		
		/*�Ҹ��ڵ�*/
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
		
		/*�������Ҳ���ڵ�*/
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
	
	/**
	 * calculate the height of this BinarySearchTree
	 * @return
	 */
	public int height() {
		return height(root);
	}
	
	/**
	 * calculate the height of specific node
	 * @param node
	 * @return
	 */
	private int height(Node<E>node ) {
		int nodeHeight = 0;
		
		//利用队列实现, LinkedList其实就是就是一个队列, 实现了队列接口
		Queue<Node<E>> queue =new LinkedList<Node<E>>();
		// 1. 根节点入队
		queue.offer(node);
		
		//只要队列有值就循环
		int levelSize = 1;
		// 1. 取出第一个元素 并且访问
		
		// 2. 如果该元素有子左右节点就入队
		while(queue.size() != 0) {
			//从队列中取出第一个元素
			Node<E> nextNode = queue.poll();
			levelSize--;  
			//把所有子节点入队
			if(nextNode.left !=null) {
				queue.offer(nextNode.left);
			}
			
			if(nextNode.right!=null) {
				queue.offer(nextNode.right);
			}
			
			if(levelSize == 0 ) {
				/*0 说明即将访问完该层*/
				levelSize = queue.size(); //此时队列大小为下一层的数量
				nodeHeight ++;
			}
			
		}
		
		return nodeHeight;
	}
	

	/**
	 * 开放接口, 前序遍历
	 * @param visitor
	 */
	public void preorderTraversal(Visitor<E>visitor ) {
		preorderTraversal(root, visitor);
	}
	
	private void preorderTraversal(Node<E>node, Visitor<E>visitor  ) {
		if(node == null || visitor.stop == true) return ;
		
		visitor.stop = visitor.visit(node.element);//然后访问当前节点
		preorderTraversal(node.left, visitor);
		preorderTraversal(node.right, visitor);
	}
	
	/**
	 * 开放接口, 层级遍历
	 * @param visitor
	 */
	public void levelOrderTraversal(Visitor<E>visitor ) {
		levelOrderTraversal(root, visitor);
	}
	
	private void levelOrderTraversal(Node<E>node, Visitor<E>visitor) 	{
		
		Queue<Node<E>> queue =new LinkedList<Node<E>>();
		// 1. 根节点入队
		queue.offer(node);
		
		//只要队列有值就循环
		// 1. 取出第一个元素 并且访问
		
		// 2. 如果该元素有子左右节点就入队
		while(queue.size() != 0) {
			//从队列中取出第一个元素
			Node<E> nextNode = queue.poll();
			
			if(visitor.stop == true) return; //如果达成停止条件就停止循环
			
			visitor.stop = visitor.visit(nextNode.element);
			
			//把所有子节点入队
			if(nextNode.left !=null) {
				queue.offer(nextNode.left);
			}
			
			if(nextNode.right!=null) {
				queue.offer(nextNode.right);
			}
		}
		
	}
	
	
	
	/**
	 * 开放接口, 中序遍历
	 * @param visitor
	 */
	public void inorderTraversal(Visitor<E>visitor ) {
		inorderTraversal(root, visitor);
	}
	
	private void inorderTraversal(Node<E>node, Visitor<E>visitor  ) {
		if(node == null || visitor.stop == true) return ;
		
		inorderTraversal(node.left, visitor); //先访问左子树
		visitor.stop = visitor.visit(node.element);//然后访问当前节点
		inorderTraversal(node.right, visitor); //再访问右子树
	}
	
	
	/**
	 * 开放接口, 后序遍历
	 * @param visitor
	 */
	public void postorderTraversal(Visitor<E>visitor ) {
		postorderTraversal(root, visitor);
	}
	
	private void postorderTraversal(Node<E>node, Visitor<E>visitor  ) 	{
		if(node == null || visitor.stop == true) return ;
		postorderTraversal(node.left, visitor); //先访问左子树
		postorderTraversal(node.right, visitor); //再访问右子树
		
		if(visitor.stop == true) return;
		visitor.stop = visitor.visit(node.element);
	}
	
	
	
	
	
	/**
	 * 根据元素内容获取元素节点
	 * @param element
	 * @return 寻找到的节点, 找不到返回null 
	 */
	private Node<E> node(E element){
		
		Node<E> node = root;
		int cmp = 0;
		
		while(node !=null) {
			cmp = compare(element, node.element);
			if(cmp > 0) {
				node = node.right;
			}else if(cmp < 0){
				node = node.left;
			}else{
				return node;
			}
		}
		return node;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new  StringBuilder();
		toString(root,sb,"");  //根节点prefix为空
		return sb.toString();
	}
	/**
		0
		 L -6
		 L  R -4
		 L  R  R -2
		 R 3
		 R  L 2
		 R  R 6
		 R  R  L 4
		 R  R  R 9
		 R  R  R  L 8
		 R  R  R  R 12
		 R  R  R  R  R 15
	 * (前序)遍历递归打印
	 * @param node
	 * @param sb
	 * @param prefix
	 */
	private void toString(Node<E>node, StringBuilder sb, String prefix  ) {
		// preorder traverse print
		if(node == null) return;
		
		sb.append(prefix).append(node.element).append("\n");
		
		toString(node.left, sb,prefix+ " L ");  //也可以把这句移上去先打左子树,如下
		/**
		 *   L -6
			 L  R -4
			 L  R  R -2
			 0
			 R  L 2
			 R 3
			 R  R  L 4
			 R  R 6
			 R  R  R  L 8
			 R  R  R 9
			 R  R  R  R 12
			 R  R  R  R  R 15
		 * 
		 */
		toString(node.right, sb, prefix+" R ");
	}
	
	
	

	@Override
	public Object root() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public Object left(Object node) {
		return ((Node<E>)node).left;
	}

	@Override
	public Object right(Object node) {
		return ((Node<E>)node).right;
	}

	@Override
	public Object string(Object node) {
		return ((Node<E>)node).element;
	}

}
