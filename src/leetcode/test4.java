package leetcode;
/**
 * String-to-Integer
 *
 */
public class test4 {
    public int atoi(String str) {
       if (str==null||str.trim().length()<1){
           return 0;
       }
       char[] chars=str.trim().toCharArray();
       int sign=1;int index=0;
       if (chars[0]=='+'){
           index++;
       }
        if (chars[0]=='-'){
           sign=-1;
           index++;
        }
        int num=0;
       for (int i=index;i<chars.length;i++){
           if (chars[i]-'0'>=0&&chars[i]-'9'<=0){
               if (num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && chars[i] - '7' > 0) {
                   if (sign > 0)
                       return Integer.MAX_VALUE;
                   else
                       return Integer.MIN_VALUE;
               }
                num=10*num+chars[i]-'0';
           }else {
               break;
           }
       }
       return  num*sign;
    }
    public static void main(String[] args){
       String str="2147483648" ;
       System.out.print(new test4().atoi(str));
    }
}
