package offer1;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */
public class test31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        StringBuffer sb=new StringBuffer();
        for(int i=1;i<=n;i++){
            sb.append(String.valueOf(i));
        }
        int count=0;
        char[] str=sb.toString().toCharArray();
        for (int i=0;i<str.length;i++){
            if(str[i]=='1'){
                count ++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        test31 test27=new test31();
        System.out.print(test27.NumberOf1Between1AndN_Solution(2));
    }
}
