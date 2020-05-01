package linkedList.����ָ��;

import linkedList.ListNode;
/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/chao-jian-ji-shuang-zhi-zhen-fu-tu-jie-by-newpp/
 * @author Ҷΰΰ
 *
 */
public class _19_ɾ������ĵ�����N���ڵ� {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode fastNode= head;
    	ListNode slowNode = head;
    	while(n!=0) {
    		fastNode = fastNode.next;  // ��ǰ�ƶ�
    		n--;
    	}
    	if(fastNode == null) {
    		ListNode newHead = slowNode.next;
    		slowNode.next = null;
    		return newHead;
    	}
    	while( fastNode.next != null) {
    		fastNode = fastNode.next;
    		slowNode = slowNode.next;
    	}
    	ListNode deleteNode = slowNode.next;
    	slowNode.next = deleteNode.next;
    	deleteNode.next = null;
		return head;
    }
}
