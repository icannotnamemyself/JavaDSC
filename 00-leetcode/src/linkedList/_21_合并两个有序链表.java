package linkedList;

public class _21_�ϲ������������� {
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
     * ���ڵ�l1 unlink, ����ڵ�l2����
     * 
     * @param l1
     * @param l2
     */
    protected void insertAfter(ListNode l1, ListNode l2) {
		l1.next = l2.next;
		l2.next = l1;
	}
}
