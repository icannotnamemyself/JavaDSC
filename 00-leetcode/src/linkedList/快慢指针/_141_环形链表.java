package linkedList.����ָ��;

import linkedList.ListNode;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * @author Ҷΰΰ
 *
 */
public class _141_�������� {
	/**
	 * ʹ�ÿ���ָ���˼��
	 */
    public boolean hasCycle(ListNode head) {
    	if(head == null || head.next ==null) return false;
       ListNode slow = head;
       ListNode fast = head.next;
       while(fast !=null && fast.next != null) {
    	   slow = slow.next;
    	   fast = fast.next.next;
    	   if(slow == fast)return true; 
       }
    	return false;
    }
}
