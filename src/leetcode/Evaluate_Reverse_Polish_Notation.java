package leetcode;
import java.util.Stack;

/**
 * 150 .
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 Note:
 Division between two integers should truncate toward zero.
 The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 Example 1:

 Input: ["2", "1", "+", "3", "*"]
 Output: 9
 Explanation: ((2 + 1) * 3) = 9
 Example 2:

 Input: ["4", "13", "5", "/", "+"]
 Output: 6
 Explanation: (4 + (13 / 5)) = 6
 */
public class Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<Integer>();
        int temp=0;
        int len=tokens.length;
        for(String str:tokens){
            if(str.equals("+")){
                temp=stack.pop()+stack.pop();
                stack.push(temp);
            }else  if(str.equals("-")){
                int a=stack.pop();
                int b=stack.pop();
                temp=b-a;
                stack.push(temp);
            }else  if(str.equals("*")){
                int a=stack.pop();
                int b=stack.pop();
                temp=b*a;
                stack.push(temp);
            }else  if(str.equals("/")){
                int a=stack.pop();
                int b=stack.pop();
                temp=b/a;
                stack.push(temp);
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
