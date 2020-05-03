package linkedList.快慢指针;

import linkedList.ListNode;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * @author 叶伟伟
 *
 */
public class _141_环形链表 {
	/**
	 * 使用快慢指针的思想
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
