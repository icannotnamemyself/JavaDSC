package linkedList;


public class _206_反转链表 {
//	  public class ListNode {
//	      int val;
//	      ListNode next;
//	      ListNode(int x) { val = x; }
//	 }
	/**
	 * 递归版本
	 * @param head
	 * @return
	 */
    public ListNode reverseList1(ListNode head) {
    	if(head==null || head.next ==null) return head;
    	ListNode newHead = reverseList(head.next);
    	head.next.next = head;
    	head.next = null;
		return newHead;
    }
    
    /**
     * 迭代版本
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
    	if(head==null || head.next ==null) return head;
    	ListNode newHead = null;
    	ListNode tmp;
    	while(head!=null) {
    		tmp = head.next;
    		head.next = newHead;
    		newHead = head;
    		head = tmp;
    	}
    	return newHead;
    }
}
