package offer1;

import java.util.Stack;

/*
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class test15 {
  public ListNode3 ReverseList(ListNode3 listNode){
	 if (listNode==null) {
		return null;
	}
	 Stack<ListNode3> stack=new Stack<>();
	 while(listNode!=null){
		 stack.push(listNode);
		 listNode=listNode.next;
	 }
	 ListNode3 newHead=stack.pop();
	 ListNode3 resultHead=newHead;
	 
     while(!stack.isEmpty()){
    	 newHead.next=stack.pop();
    	 newHead=newHead.next;
     }
     newHead.next=null;
     return resultHead;
  }
}
class ListNode3{
	int val;
	ListNode3 next;
	public ListNode3(int val) {
		this.val=val;
	}
}