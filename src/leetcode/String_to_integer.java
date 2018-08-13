package leetcode;
/**
 * String-to-Integer
 *
 */
public class String_to_integer {
    public int myAtoi(String str) {
        str = str.trim();
        if ("".equals(str)) return 0;
        int sign = 1, index = 0;
        double result = 0;
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            index++;
            sign = -1;
        }
        for (int i = index; i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'; i++) {
            result = result * 10 + str.charAt(i) - 48;
            if (result > Integer.MAX_VALUE) {
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
        }
        return (int)(sign * result);
    }

    public static void main(String[] args){
       String str="2147483648" ;
       System.out.print(new String_to_integer().myAtoi(str));
    }
}
