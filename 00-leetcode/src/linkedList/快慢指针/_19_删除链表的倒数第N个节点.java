package linkedList.快慢指针;

import linkedList.ListNode;
/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/chao-jian-ji-shuang-zhi-zhen-fu-tu-jie-by-newpp/
 * @author 叶伟伟
 *
 */
public class _19_删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode fastNode= head;
    	ListNode slowNode = head;
    	while(n!=0) {
    		fastNode = fastNode.next;  // 向前移动
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
