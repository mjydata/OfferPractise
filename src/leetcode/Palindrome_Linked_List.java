package leetcode;

/**
 * Example 1:

 Input: 1->2
 Output: false
 Example 2:

 Input: 1->2->2->1
 Output: true
 */
public class Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;

        ListNode slow =head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow =slow.next;
            fast=fast.next.next;
        }
        ListNode head2=reverseList(slow );
        while (head2!=null){
            if(head.val!=head2.val){
                return false;
            }else{
                head=head.next;
                head2=head2.next;
            }
        }
        return true;
    }
    public ListNode reverseList(ListNode slow ){
        ListNode previous=null;
        ListNode current=slow;
        while(current!=null){
            ListNode nextNode=current.next;
            current.next=previous;
            previous=current;
            current=nextNode;
        }
        return previous;
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
