package offer1;
/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author mjy
 *定义两个指针，指针之间隔k-1的距离
 *
 *难点 如何定义指针
 */
public class test14 {
  public ListedNode FindKthToTail(ListedNode head,int k){
	 if(head==null){
		 return null;
	 }
	  ListedNode first=head;
	  ListedNode second=head;
	 for(int i=0;i<k;i++){
		 //如果k大于链表的长度
		 if(second==null){ 
             return null;
         }else{
             second=second.next;
         }
	 }
	 while(second!=null){
		 first=first.next;
		 second=second.next;
	 }
	  return first;
  }
}
class ListedNode{
	int val;
	ListedNode next;
	public ListedNode(int val) {
		this.val=val;
	}
}