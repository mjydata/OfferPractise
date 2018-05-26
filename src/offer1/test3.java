package offer1;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class test3 {
    public static void main(String[] args){
    	
    }
    public static ArrayList<Integer> print(ListNode listNode){
    	Stack<Integer> stack=new Stack<>(); 
    	List<Integer> lists=new ArrayList<>();
    	while(listNode!=null){
    		stack.push(listNode.value);
    		listNode =listNode.next;
    	}
    	while(stack.isEmpty()!=true){
    		lists.add(	stack.pop());
    	}
    		return (ArrayList<Integer>) lists;
    	
    }
  
}
class ListNode{
	int value;
	ListNode next=null;
	public ListNode(int val) {
		this.value=val;
	}
	
}