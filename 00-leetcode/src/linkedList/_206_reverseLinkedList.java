package linkedList;


public class _206_reverseLinkedList {
//	  public class ListNode {
//	      int val;
//	      ListNode next;
//	      ListNode(int x) { val = x; }
//	 }

    public ListNode reverseList1(ListNode head) {
    	if(head==null || head.next ==null) return head;
    	ListNode newHead = reverseList(head.next);
    	head.next.next = head;
    	head.next = null;
		return newHead;
    }
    
    /**
     * 锟斤拷锟斤拷锟芥本
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
