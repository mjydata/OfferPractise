package offer1;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 输入描述:
 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。

 */
public class test27 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<String>();//根据返回类型需要
        if(str==null||str.length()==0){
            return result;
        }
        char[] chars = str.toCharArray();
        TreeSet<String> res = new TreeSet<String>(); //用于排序输出
        getResult(chars,0,str.length()-1,res);
        result.addAll(res) ;//添加到ArrayList
        return result ;
    }

    public void getResult(char[] chars,int start,int end,TreeSet<String> res){

        if(start==end){
            res.add(String.valueOf(chars));
        }else{
            //循环一次，
            for(int i=start;i<=end;i++){
                swap(chars,start,i);//换一位
                getResult(chars,start+1,end,res);//递归
                swap(chars,start,i);//换回来，保证下次换位是正确的
            }
        }
    }
    public void swap(char[] chars,int a,int b){
        if(a==b){//因为会出现原位置与原位置交换，直接空即可

        }else{
            char temp = chars[a];
            chars[a]=chars[b];
            chars[b]=temp;
        }
    }
    public static void main(String[] args){
        test27 test27=new test27();
        System.out.print(test27.Permutation("abc"));
    }
}
