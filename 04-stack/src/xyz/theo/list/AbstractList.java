package xyz.theo.list;


public abstract class AbstractList<E> implements List<E> {
	
 int size = 0;
	/**
	 * 返回元素数量
	 * @return
	 */
	public int size() {
		return size;
		
	}; 
	
	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size==0;
	} // 是否为空
	
	/**
	 * 是否包含某一元素
	 * @param element
	 * @return
	 */
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	} // 是否包含某个元素

}
