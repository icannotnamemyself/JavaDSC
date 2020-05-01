package xyz.theo.list;


/**
 * ◼ int size(); // 元素的数量
	◼ boolean isEmpty(); // 是否为空
	◼ boolean contains(E element); // 是否包含某个元素
	◼ void add(E element); // 添加元素到最后面
	◼ E get(int index); // 返回index位置对应的元素
	◼ E set(int index, E element); // 设置index位置的元素
	◼ void add(int index, E element); // 往index位置添加元素
	◼ E remove(int index); // 删除index位置对应的元素
	◼ int indexOf(E element); // 查看元素的位置
	◼ void clear(); // 清除所有
 * @author 叶伟伟
 *
 * @param <E>
 */
public interface List<E> {
	static final int ELEMENT_NOT_FOUND = -1;
	
	
	
	/**
	 * 返回元素数量
	 * @return
	 */
	int size(); // 元素的数量
	
	/**
	 * 是否为空
	 * @return
	 */
	boolean isEmpty(); // 是否为空
	
	/**
	 * 是否包含某一元素
	 * @param element
	 * @return
	 */
	boolean contains(E element); // 是否包含某个元素
	
	/**
	 * 添加元素到最末尾
	 * @param element
	 */
	void add(E element); // 添加元素到最后面
	
	
	/**
	 * 获取元素
	 * @param index
	 * @return
	 */
	E get(int index); // 返回index位置对应的元素
	
	/**
	 * 设置index位置的元素为element
	 * @param index
	 * @param element
	 * @return
	 */
	E set(int index, E element); // 设置index位置的元素
	
	/**
	 * 添加元素到index位置
	 * @param index
	 * @param element
	 */
	void add(int index, E element); // 往index位置添加元素
	
	/**
	 * 删除元素
	 * @param index
	 * @return
	 */
	E remove(int index); // 删除index位置对应的元素
	
	/**
	 * 查找某一元素的第一次出现的位置
	 * @param element
	 * @return
	 */
	int indexOf(E element); // 查看元素的位置
	
	
	/**
	 * 清除所有元素
	 */
	void clear(); // 清除所有

}
