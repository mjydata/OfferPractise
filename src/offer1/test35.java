package offer1;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class test35 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
          ListNode node1=pHead1;
          ListNode node2=pHead2;
          int count1 =0;
          int count2 =0;
          while(node1!=null){
              node1=node1.next;
              count1++;
          }
          while(node2!=null){
            node2=node2.next;
            count2++;
          }
          if (count1>count2){
              for (int i=0;i<count1-count2;i++){
                  pHead1=pHead1.next;
              }
          }else{
              for (int i=0;i<count2-count1;i++){
                  pHead2=pHead2.next;
              }
          }
          while(pHead1!=null){
              if (pHead1==pHead2){
                  return pHead1;
              }
              pHead1= pHead1.next;
              pHead2= pHead2.next;
          }
           return  null;

    }
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

