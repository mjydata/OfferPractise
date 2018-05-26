package offer1;

import java.lang.Thread.State;
import java.util.Stack;

public class test5 {
  Stack<Integer> stack1=new Stack<>();
  Stack<Integer> stack2=new Stack<>();
	public void push(int val){
	  stack1.push(val);
  } 
	public int pop(){
		int first = 0;
		if(!stack2.isEmpty()){
			first= (int) stack2.pop();
		}else{
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());	
			}
			if(!stack2.isEmpty()){
				first= (int) stack2.pop();		
			}
		}
			
		return first;
	}
}
