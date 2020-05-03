package linkedList;

public class _21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	
    	while(l1 !=null && l2!=null) {
    		
    		if(l1.val >= l2.val) {
    			ListNode node = l2;
    			l2 = l2.next;
    			insertAfter(l1, node);
    		}else {
    			
    		}
    		
    		
    		l2 = l2.next;
    	}
		return l1;
    }
    /**
     * 将节点l1 unlink, 插入节点l2后面
     * 
     * @param l1
     * @param l2
     */
    protected void insertAfter(ListNode l1, ListNode l2) {
		l1.next = l2.next;
		l2.next = l1;
	}
}
