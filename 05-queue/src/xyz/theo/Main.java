package xyz.theo;
import xyz.theo.circle.CircleDequeue;
import xyz.theo.circle.CircleQueue;
import xyz.theo.list.LinkList;

public class Main {
	
	public static void main(String[] args) {
//		testQueue();
//		testDequeue();
		
//		testCircleQueue();
		
		
		testCircleDequeue();
	}

	private static void testCircleDequeue() {
		CircleDequeue<Integer> circleDequeue = new CircleDequeue<Integer>();
		
		for(int i =0 ; i  < 10; i++) {
			circleDequeue.enQueueRear(i);
		}
		System.out.println(circleDequeue);
		for(int i =0 ; i  <2; i++) {
			circleDequeue.deQueueFront();
		}
		System.out.println(circleDequeue);
		for(int i =0 ; i  <8; i++) {
			circleDequeue.enQueueRear(i);
		}
		System.out.println(circleDequeue);
		
		circleDequeue.clear();
		System.out.println(circleDequeue);
	}

	private static void testCircleQueue() {
		CircleQueue<Integer> circleQueue = new CircleQueue<Integer>();
		
		for(int i =0 ; i  < 10; i++) {
			circleQueue.enQueue(i);
		}
		System.out.println(circleQueue);
		for(int i =0 ; i  < 3; i++) {
			circleQueue.deQueue();
		}
		System.out.println(circleQueue);
		for(int i =0 ; i  <7; i++) {
			circleQueue.enQueue(i);
		}
		System.out.println(circleQueue);
	}
	private static void testDequeue() {
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
