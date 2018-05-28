package practise;

import java.util.Stack;

public class QueueByTwoStack {
  Stack<Integer> stack1=new Stack<>();
  Stack<Integer> stack2=new Stack<>();
  public void push(int a) {
	stack1.push(a);
  }
  public int pop() {
	int first=0;
	if(!stack2.isEmpty()){
		first=stack2.pop();
	}else{
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		if (!stack2.isEmpty()) {
			first=stack2.pop();
		}
	}
			 

	 
	 
	return first;
}
}
