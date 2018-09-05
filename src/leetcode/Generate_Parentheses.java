package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]1、开头不是能“）”
 2、左括号个数大于右括号个数时，接下来的括号随意。
 3、当左右括号数目相等时，接下来的必须要是左括号。
 4、又括号的个数不能大于左括号个数，当左右括号都用完时，返回。
 */
public class Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParentheses(n,n,"",list);
        return list;
    }

    public void generateParentheses(int left,int right,String curStr,List<String> list){
        //左右括号用完了，返回
        if(left == 0 && right == 0){
            list.add(curStr);
            return;
        }
        //只要还有左括号，就能使用
        if(left > 0){
            generateParentheses(left-1,right,curStr+"(",list);
        }
        //还有右括号且剩下的右括号必须多余剩下的左括号
        if(right > 0 && left < right){
            generateParentheses(left,right-1,curStr+")",list);
        }
    }
    public List<String> genratePar(int n){
        List<String> lists=new ArrayList<>();
        generate(n,n,"",lists);
        System.out.print(lists);
        return lists;
    }
    public void generate(int l,int r,String curStr,List<String> lists){
        if (l==0 && r==0) {lists.add(curStr) ;
            return;}
        if (l>0){
            generate(l-1,r,curStr+"(",lists);
        }
        if (r>0 && l<r){
            generate(l,r-1,curStr+")",lists);
        }
    }
    public static void main(String[] args){
        new Generate_Parentheses().genratePar(2);
    }
}
