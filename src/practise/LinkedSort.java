package practise;

public class LinkedSort {
   public LinkedNode	linkSort(LinkedNode node){
	   if (node==null||node.next==null) {
		return node;
	}
	   LinkedNode cur=node;
	   LinkedNode tail=null;
	   while(cur!=tail){
		   while(cur.next!=tail){
			   if (cur.val>cur.next.val) {
				int temp=cur.val;
				cur.val=cur.next.val;
				cur.next.val=temp;
			}
			   cur=cur.next;
		   }
		   tail=cur;
		   cur=node;
	   }
	   return node;
   }
}
class LinkedNode{
	int val ;
	LinkedNode next;
	public LinkedNode(){
		
	}
}
