package xyz.theoye;


import xyz.theoye.circle.ForwardCircleList;
import xyz.theoye.circle.LinkCircleList;

public class Main {

	public static void main(String[] args) {
//		testArrayListTrim();
//		testLinkList();
//		testForwadList();
//		testForwardCircleList();
//		testLinkCircleList();
		
		
	}

	private static void testLinkCircleList() {
		LinkCircleList<Integer> list = new LinkCircleList<Integer>();
		
		
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		
		list.remove(0);
		list.remove(3);
		list.getCurrent();
		for(int i =0 ; i < 8; i++)
		{
			if(i == 0)
				System.out.println(list.getCurrent().getElement());
			else {
				System.out.println(list.next().getElement());
			}
		}

		System.out.println(list);
	}

	private static void testForwardCircleList() {
		List<Integer>list= new ForwardCircleList<Integer>();
		
		list.add(3);
		list.add(4);
		list.add(5);

		list.add(6);
		list.add(7);
		list.remove(0);
		list.remove(3);
		
		ForwardCircleList.Node<Integer> firstNode = ((ForwardCircleList<Integer>) list).getFirst();
		
		for(int i =0 ; i < 8; i++)
		{
			System.out.println(firstNode.getElement());
			firstNode = firstNode.getNext();
			System.out.println(list);
		}
	}

	private static void testForwadList() {
		List<Integer>list = new ForwardList<Integer>(); 
		list.add(3);
		list.add(4);
		list.add(5);
		list.remove(0);
		list.remove(1);
		
		System.out.println(list);
	}

	private static void testLinkList() {
		List<Integer> list =new LinkList<Integer>();
		
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.remove(0);	
		list.remove(3);
		list.clear();
		list.add(7);
		list.add(7);
		list.add(7);
		System.out.println(list);
	}

	private static void testArrayListTrim() {
		
		
		List<Integer>list2  = new ArrayList<Integer>();
		
		for(int i = 0 ; i < 50; i ++) {
			list2.add(i);
		}
		for(int i = 0 ; i < 50; i++) {
			list2.remove(0);
		}
	}

}
