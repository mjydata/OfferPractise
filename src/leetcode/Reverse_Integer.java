package leetcode;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output: 321
 Example 2:

 Input: -123
 Output: -321
 Example 3:

 Input: 120
 Output: 21
 Note:
 Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class Reverse_Integer {
    class Solution {
        public int reverse(int x) {
            long result = 0;
            int tmp = Math.abs(x);
            while(tmp>0){
                result *= 10;
                result += tmp % 10;
                if(result > Integer.MAX_VALUE){
                    return 0;
                }
                tmp /= 10;
            }
            return (int)(x>=0?result:-result);
        }
    }

}
