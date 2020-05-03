package xyz.theo;

import java.util.Comparator;

import com.mj.printer.BinaryTrees;

public class Main {

	public static void main(String[] args) {
		
		BinarySearchTree<Integer>bst = new BinarySearchTree<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		}); 

		
		System.out.println("test");
		for(int i = 0 ; i <17; i+=3) {
			bst.add(i);
		}
		
		for(int i = -6 ; i < 10; i+=2) {
			bst.add(i);
		}
		
		bst.levelOrderTraversal(new BinarySearchTree.Visitor<Integer>() {
			@Override
			public boolean visit(Integer element) {
				System.out.println(element);
				return element.equals(9)?true:false; 
			}
		});
		BinaryTrees.println(bst);
		
		System.out.println(bst.height());
	}

}
