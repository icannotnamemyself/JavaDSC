package xyz.theo.list;


public abstract class AbstractList<E> implements List<E> {
	
 int size;
	/**
	 * ����Ԫ������
	 * @return
	 */
	public int size() {
		return size;
		
	}; 
	
	/**
	 * �Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		return size==0;
	} // �Ƿ�Ϊ��
	
	/**
	 * �Ƿ����ĳһԪ��
	 * @param element
	 * @return
	 */
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	} // �Ƿ����ĳ��Ԫ��
	public abstract void insertFront(E element);
}
