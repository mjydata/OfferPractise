package offer1;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * 用两个队列实现一个栈:思想就是维持一个队列是空的
 * @author mjy
 *
 */
public class StackByTwoQueue {
	private Queue<String> queue1 = new LinkedList<String>();
    private Queue<String> queue2 = new LinkedList<String>();
    public void push(String e) {
		if (queue1.isEmpty()) {
			queue2.add(e);
		} 
		if (queue2.isEmpty()) {
			queue1.add(e);
		}
	}
    public String pop() {
		if(queue1.isEmpty()&&queue2.isEmpty()){
			try {
				throw new Exception("stack is empty");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (queue1.isEmpty()) {
			while(queue2.size()>1){
				
				queue1.add(queue2.poll());
			}
			  return queue2.poll();
		}
		if (queue2.isEmpty()) {
			while(queue1.size()>1){
				
				queue2.add(queue1.poll());
			}
			  return queue1.poll();
		}
		return null;
	}
    public static void main(String[] args){
    	StackByTwoQueue s1=new StackByTwoQueue();
    	s1.push("1");
    	s1.push("2");
    	s1.push("3");
    	System.out.println(s1.pop());
    }
}
