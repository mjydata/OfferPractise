package practise;

import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

import offer1.StackByTwoQueue;

public class stackByTwoQueue {
   Queue<Integer> queue1=new LinkedList<>();
   Queue<Integer> queue2=new LinkedList<>();
   public void push(Integer a){
	   if(queue1.isEmpty()){
		   queue2.add(a);
	   }
	   if(queue2.isEmpty()){
		   queue1.add(a);
	   }
   }
   public int pop(){
	   if(queue1.isEmpty()&&queue2.isEmpty()){
			try {
				throw new Exception("stack is empty");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	   if (!queue1.isEmpty()) {
		while (queue1.size()>1) {
			queue2.add(queue1.poll());
		}
		return queue1.poll();
	   }else{
		   while (queue2.size()>1) {
				queue1.add(queue2.poll());
			}
			return queue2.poll();
	   }
   }
   public static void main(String[] args){
	   stackByTwoQueue s1=new stackByTwoQueue();
   	s1.push(1);
   	s1.push(2);
   	s1.push(3);
   	System.out.println(s1.pop());
   	System.out.println(s1.pop());
   	System.out.println(s1.pop());
   }
}
