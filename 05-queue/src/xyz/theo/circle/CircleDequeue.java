package xyz.theo.circle;

import xyz.theo.list.LinkList;

/**
 * 使用动态数组实现 circleDequeue
 * @author 叶伟伟
 *
 */
public class CircleDequeue<E> {
	
	
	private E[] elements;
	private static int DEFAULT_CAPACITY = 10;
	int size;
	private int front;
	
	public CircleDequeue() {
		elements = (E[])(new Object[DEFAULT_CAPACITY]);
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		
		for(int i = 0 ; i < size; i++)
		{
			elements[index(i)] = null;
		}
		
		front = 0 ;
		size = 0 ;
		
	}
	
	/**
	 * 添加到队尾
	 * @param element
	 */
	public void enQueueRear(E element) {
		ensureCapacity(size);
		elements[index(size)] = element;
		size ++;
	}
	
	/**
	 * 索引映射
	 * @param index
	 * @return 真实索引
	 */
	private int index(int index) {
		index += front; 
		if(index <0) {
			return (index + elements.length);
		}
		return index - (index>=elements.length? elements.length : 0);
	}
	
	/**
	 * 弹出队头元素
	 * @return
	 */
	public E deQueueFront() {
		E frontE = elements[index(0)];
		/*front 向前移动*/
		 elements[index(0)] = null;
		front = index(1); 
		size--;
		return frontE;
	}
	
	/**
	 * 弹出队尾元素
	 * @return
	 */
	public E deQueueRear() {
		E rearE = elements[index(size - 1)];
		 elements[index(size - 1)] = null;
		size--;
		return rearE;
	}
	
	/**
	 * 添加队头元素
	 * @param element
	 */
	public void enQueueFront(E element) {
		ensureCapacity(size);
		elements[index(-1)] = element;
		front = index(-1);
		size ++;
	}
	
	public E front() {
		return elements[index(0)];
	}
	
	public E rear() {
		return elements[index(size - 1)];
	}
	
	private void ensureCapacity(int size) {
		
		if((size + 1) > elements.length ) {
			int oldCapacity = elements.length;
			int newCapacity = oldCapacity + (oldCapacity >>1) ;
			E[] newElements = (E[]) new Object[newCapacity];
			
			for(int i = 0 ; i < size; i ++) {
				newElements[i] = elements[index(i)];  
			}
			elements = newElements;
			front = 0;
		}
	}
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder("size="+size+",");
		
		string.append("capacity="+elements.length+",")
		.append("front="+front+",");
		
		string.append("[");
		
		for(int i = 0 ; i< elements.length ; i++)
		{
			if(i!=0) {
				string.append(",").append(elements[i]);
			}
			else {
				string.append(elements[i]);
			}
		}
		string.append("]");	
		
		return string.toString();
	}

	
}
