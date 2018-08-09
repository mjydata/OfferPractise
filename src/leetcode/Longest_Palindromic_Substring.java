package leetcode;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example 1:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: "cbbd"
 Output: "bb"

 *
 */
public class Longest_Palindromic_Substring {
    public static String longestPalindrome(String s) {
            if(s.length()<=1){
                return s;
            }
            int len=s.length();
            int maxlen=0;
            int start=0;int end=0;
            boolean[][] hp=new boolean[len][len];
            for(int i=len-1;i>0;i--){
                for(int j=i;j<len;j++){
                    if(((j-i)<=2||hp[i+1][j-1]) && s.charAt(i)==s.charAt(j) )  {//(j-i)<=2||hp[i+1][j-1]) hp[i+1][j-1]一定要放后面，否则会溢出
                        hp[i][j] =true;
                        if(maxlen<j-i){
                            maxlen=j-i+1;
                            start=i;
                            end=j;

                        }
                    }
                }
            }
            return s.substring(start,end+1);
        }
        public static void main(String[] args){
            String s="babad";
            longestPalindrome(s);
        }

}
