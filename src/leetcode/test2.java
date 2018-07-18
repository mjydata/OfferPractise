package leetcode;

import java.util.Stack;

/**
 Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are+,-,*,/. Each operand may be an integer or another expression.

 Some examples:

 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class test2 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack();
        for (int i=0;i<tokens.length;i++){
           try{
               stack.push(Integer.parseInt(tokens[i]));
           }
           catch (Exception e){
               int b=stack.pop();
               int a=stack.pop();
               stack.push(get(a,b,tokens[i]));
           }
        }
        return stack.pop();
    }
    private int get(int a ,int b ,String str){
       switch (str){
           case "+":
               return a+b;
           case "-":
               return a-b;
           case "*":
               return a*b;
           case "/":
               return a/b;
           default:
                   return 0;
       }
    }
    public static void main(String[] args){
        String[] arg={"0","3","/"
};
        new test2().evalRPN(arg);
    }
}
