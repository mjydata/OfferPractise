package leetcode;

public class Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = lenOfLinkedList(headA);
        int len2 = lenOfLinkedList(headB);


        // "右对齐"两条链表
        int diff = len1 - len2;
        if (diff < 0){
            diff = - diff;
            while (diff > 0){
                headB = headB.next;
                diff --;
            }
        }else{
            while (diff > 0){
                headA = headA.next;
                diff --;
            }
        }


        // 查找两条链表的公共节点
        while (headA != null && headB != null){
            if (headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;

    }

    private int lenOfLinkedList(ListNode head){
        int len = 0;
        while (head != null){
            len ++;
            head = head.next;
        }
        return len;
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
