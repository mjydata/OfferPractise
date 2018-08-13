package leetcode;

import java.util.Stack;

public class Valid_Parentheses {
    public boolean isValid(String s) {
        if(s.length()==1) return false;
        if(s.length()==0) return true;
        Stack<Character> charStack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
            {
                charStack.push(s.charAt(i));
            }
            else{
                if(charStack.size()==0){
                    return false;
                }
                char top=charStack.pop();
                if(s.charAt(i)==')'){
                    if(top!='(') return false;
                }
                else if(s.charAt(i)==']'){
                    if(top!='[') return false;
                }
                if(s.charAt(i)=='}'){
                    if(top!='{') return false;
                }
            }
        }
        return charStack.size()==0;
    }

    public static void main(String[] arfs){

        String s="()";
        Character a='s';
        System.out.println(a.equals('s'));
//        System.out.println(new Valid_Parentheses().isValid(s));
    }
}
