package xyz.theo.circle;


import xyz.theo.list.LinkList;

public class CircleQueue<E> {
	
	private E[] elements;
	private static int DEFAULT_CAPACITY = 10;
	int size;
	private int front;
	
	public CircleQueue() {
		elements = (E[])(new Object[DEFAULT_CAPACITY]);
	}
	
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * 
	 *	��  �߼������� �ڴ����� ��ӳ�� 
	 * @param index �߼�����
	 * @return   �߼�������Ӧ���ڴ�����
	 */
	private int index(int index) {
		index += front;
		return index - (index>=elements.length? elements.length : 0);
	}
	
	public void enQueue(E element) {
		ensureCapacity(size);
		elements[index(size)] = element;
		size ++;
	}
	
	/**
	 * �����������������Χ������
	 * @param size
	 */
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
	
	
	public E deQueue() {
		E oldE = elements[front];
		
		 elements[front] = null;
		
		/*����front*/
		front = index(1);
		size--;
		return oldE;
	}
	
	public E front() {
		return elements[front];
	}
	
	public void clear() {
		for(int i = 0 ; i < size; i++)
		{
			elements[index(i)] = null;
		}
		front = 0 ;
		size = 0 ;
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
