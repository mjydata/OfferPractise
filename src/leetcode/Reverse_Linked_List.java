package leetcode;

public class Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nodeA=head;
        ListNode nodeB=head.next;
        ListNode resNode=nodeA;
        while(nodeB!=null){
            nodeA.next=nodeB.next;
            nodeB.next=resNode;
            resNode=nodeB;
            nodeB=nodeA.next;
        }
        return resNode;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
