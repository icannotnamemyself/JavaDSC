package linkedList;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @author Ҷΰΰ
 *
 */
public class _237_ɾ�������еĽڵ� {
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }
    public void deleteNode(ListNode node) {
    	node.val = node.next.val;
    	node.next = node.next.next;
    }
}
