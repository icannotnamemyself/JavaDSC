package xyz.theo;


public class ArrayList<E> {
	/**
	 * 接口设计:
◼ int size(); // 元素的数量
◼ boolean isEmpty(); // 是否为空
◼ boolean contains(E element); // 是否包含某个元素
◼ void add(E element); // 添加元素到最后面
◼ E get(int index); // 返回index位置对应的元素
◼ E set(int index, E element); // 设置index位置的元素
◼ void add(int index, E element); // 往index位置添加元素
◼ E remove(int index); // 删除index位置对应的元素
◼ int indexOf(E element); // 查看元素的位置
◼ void clear(); // 清除所有
	 * 
	 */
	private static final int DEFAULT_CAPACITY = 10;
	private static final int ELEMENT_NOT_FOUND = -1;
	
	private int capacity;
	private int size = 0;
	private E[] elems;
	
	int indexOf(E element) // 查看元素的位置
	{
		E elem;
		for( int i = 0 ; i < size ; i++)
		{
			if(elems[i]==element )
				return i;
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
	
	/***
	 * 在指定位置添加元素
	 * @param index
	 * @param elem
	 */
	public void add(int index, E elem) {
		checkIndex(index);
		checkForAdd(size);

		
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
		return elem;
	}
	
	/***
	 * 清除所有元素
	 */
	public void clear() {
		size = 0;
	}
	
	
	public E get(int index) {
		checkIndex(index);
		
		return elems[index];
	}

	/**
	 * 返回元素个数
	 * @return
	 */
	public int size() {
		return size ;
	}
	
	
	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	/***
	 * 查询是否包含元素
	 * @param elem
	 * @return
	 */
	public boolean contains(E elem) {

		for(int i = 0 ; i < size ; i++)
		{
			if(elem.equals(elems[i]))
				return true;
		}

		return false;
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
		if( (size + 1 ) >= capacity) {
			capacity = (int) (capacity*1.5);
			E[] newElems = (E[])new Object[capacity];
			
			for(int i = 0 ; i < size ; i++)
			{
				newElems[i]= elems[i]; 
			}
			elems = newElems;
		}
		
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
