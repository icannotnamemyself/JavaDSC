package xyz.theo.list;

import java.util.Arrays;

public class ArrayList<E> extends AbstractList<E> implements List<E>{
	private static final int DEFAULT_CAPACITY = 10;

	
	private int capacity;

	private E[] elems;
	
	public int indexOf(E element) // 查看元素的位置
	{
		if(element == null) {
			// 找null
			for ( int i = 0 ; i< size; i++) {
				if(elems[i]== null)
					return i;
			}
		}else {
			// null不能调用equals
			for( int i = 0 ; i < size ; i++)
			{
				if(element.equals(elems[i]))
					return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	public ArrayList(int capacity) {
		this.capacity = (capacity < DEFAULT_CAPACITY)?DEFAULT_CAPACITY:capacity;

		elems =  (E[]) new Object[this.capacity];
	}
	
	

	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	/**
	 * 添加元素
	 * @param elem
	 */
	public void add(E elem) {
		checkForAdd(size);

		elems[size++]= elem;
	}
	
	
	/**
	 * 设置元素
	 * @param index
	 * @param elem
	 * @return
	 */
	public E set(int index, E elem) {
		checkIndex(index);
		
		elems[index] = elem;
		return elem;
	}
	
	/**
	 * 扩容
	 */
	public void ensureCapacity() {
		if(size == capacity) {
			int newCapacity = capacity<<1;
			System.out.println(capacity + "扩容为" + newCapacity);
			
			// 复制数组
			E[] newElems = (E[])(new Object[newCapacity]);
			for(int i= 0; i < size ; i++) {
				System.out.println(size);
				newElems[i] = elems[i];
			}
			elems = newElems;
			capacity = newCapacity;
		}
	}
	
	/***
	 * 在指定位置添加元素
	 * @param index
	 * @param elem
	 */
	public void add(int index, E elem) {
		checkIndex(index);
		checkForAdd(size);

//		ensureCapacity();
		
		for(int i = size; i >index; i--)
		{
			elems[i] = elems[i-1];
		}

		elems[index] = elem; 
		size++;
	}
	
	/**
	 * 删除指定位置元素
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		
		//检查范围
		checkIndex(index);
		//存
		E elem = elems[index];
		//全部前移 
		for(int i = index;i<size-1;i++) {
			elems[i]=elems[i+1]; 
		}
		
		size--;
		elems[size]=null;   //最后一个元素与倒数第二个元素都指向 一个对象, 因此将最后一个对象置空 
		
		
		trim();
		return elem;
	}
	
	/***
	 * 清除所有元素
	 * 由于是对象数组, 光size=0是不行的, 会导致内存无法被GC释放
	 */
	public void clear() {
		
		/*对象全部置空*/
		for(int i = 0 ; i < size; i++)
		{
			elems[i]= null; 
		}
		size = 0;
	}
	
	
	public E get(int index) {
		checkIndex(index);
		
		return elems[index];
	}

	
	
	/***
	 * 查询是否包含元素
	 * @param elem
	 * @return
	 */
	public boolean contains(E elem) {
		return indexOf(elem)!=ELEMENT_NOT_FOUND; 
	}
	
	

	
	void checkIndex(int i ) {
		if(i<0 || i>=size) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * 检查添加
	 * @param size
	 */
	void checkForAdd(int size) {
		
		if( size  >= capacity) {
			int newCapacity = (int) (capacity*1.5);
			E[] newElems = (E[])new Object[newCapacity];
			
			for(int i = 0 ; i < size ; i++)
			{
				newElems[i]= elems[i]; 
			}
			
			System.out.println(capacity + "扩容为" + newCapacity);
			elems = newElems;
			capacity = newCapacity;
		}
		
	}
	
	/***
	 * 缩容
	 */
	private void trim() {
		if(size >= capacity>>1 || size <=DEFAULT_CAPACITY)
			return;
		
		int newCapacity = capacity>>1;
		E[] newElems = (E[])(new Object[newCapacity]);
		for(int i= 0; i < size ; i++) {
			newElems[i] = elems[i];
		}
		elems = newElems;
		System.out.println(capacity+"缩容为"+newCapacity);
		capacity = newCapacity;
	}

	

	/**
	 * toString方法
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder("size="+size+",");
		string.append("[");
		
		for(int i = 0 ; i< size ; i++)
		{
			if(i!=0) {
				string.append(",").append(elems[i]);
			}
			else {
				string.append(elems[i]);
			}
		}
		string.append("]");	
		
		return string.toString();
	}
}
