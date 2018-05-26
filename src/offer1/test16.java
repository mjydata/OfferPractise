package offer1;
/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @author mjy
 *
 */
public class test16 {
  public ListNode4 Merger(ListNode4 listNode41,ListNode4 listNode42){
      if (listNode41==null) {
		return listNode42;
	}
      if (listNode42==null) {
  		return listNode41;
  	}
      ListNode4 listNode=null;
	  if(listNode41.val<listNode42.val){
		  listNode=listNode41;
		  listNode.next=Merger(listNode41.next, listNode42);
      }else{
    	  listNode=listNode42;
    	  listNode.next=Merger(listNode41, listNode42.next);
      }
	  return listNode;
  } 
}
class ListNode4{
	int val;
	ListNode4 next;
	public ListNode4(int val) {
       this.val=val;
	}
}