package offer1;
/*
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */

import java.util.Iterator;
import java.util.Stack;

public class test20 {
  Stack<Integer> stack=new Stack<>();
  public void push(int val){
	  stack.push(val);
  }
  public void pop(){
	  stack.pop();
  }
  public void top(){
	  stack.peek();
  }
  public int min(){
	 int min=stack.peek();
	  Iterator<Integer> iterator = stack.iterator();
	  while (iterator.hasNext()) {
		Integer next = iterator.next();
		if (min>next) {
			min=next;
		}
		
	}
	  return min;
  }
}
