package xyz.theo;
import xyz.theo.list.LinkList;

public class Main {
	
	public static void main(String[] args) {
//		testQueue();
		DeQueue<Integer> deQueue = new DeQueue<>();
		deQueue.enQueueRear(3);
		deQueue.enQueueRear(4);

		deQueue.enQueueRear(5);
		
		deQueue.enQueueFront(1);
		System.out.println(deQueue.front());
		System.out.println(deQueue.rear());
	}

	
	
	
	
	
	
	
	
	private static void testQueue() {
		Queue<Integer> queue = new Queue<Integer>();
		
		queue.enQueue(3);

		queue.enQueue(4);

		queue.enQueue(5);

		queue.enQueue(6);
		
		
		System.out.println(queue.isEmpty());
	}
}
