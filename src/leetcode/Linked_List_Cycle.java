package leetcode;

public class Linked_List_Cycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode  quick=head;
        ListNode  solw =head ;
        while (quick!=null && solw !=null){
            if(quick.next!=null){
                quick=quick.next.next;
            }else{
                return false ;
            }
            solw =solw.next;
            if(quick==solw ) return true;
        }
        return  false;
    }
}
