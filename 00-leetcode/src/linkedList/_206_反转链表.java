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
//    	if(head == null) return null;// 如果反转完毕则返回null
//    	if(head.next == null) return head;  //如果只有一个节点则直接把这个节点返回
    	
    	
    	// 1->2<-3<-4<-5
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
