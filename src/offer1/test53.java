package offer1;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class test53 {
    public ListNode5 EntryNodeOfLoop(ListNode5 pHead)
    {
        if(pHead==null||pHead.next==null){
            return null;
        }
        ListNode5 p1=pHead;
        ListNode5 p2=pHead;
        int count =1;
        p1=p1.next;
        p2=p2.next.next;
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next.next;
            count++;
        }
        p2=pHead;
        while(p2!=p1){
            p2=p2.next;
            p1=p1.next;
        }
        return p1;

    }
}
class ListNode5{
    int val;
    ListNode5 next = null;

    ListNode5(int val) {
        this.val = val;
    }
}