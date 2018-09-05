package leetcode;

import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


 */
public class Longest_Substring_Without_Repeating_Characters {

        public int lengthOfLongestSubstring(String s) {
            int left=0;    int right=0; int res=0;
            HashSet set=new HashSet();
            while(right<s.length()){
                if(!set.contains(s.charAt(right))){
                    set.add(s.charAt(right++));
                    res=Math.max(res,set.size());
                }else{
                    set.remove(s.charAt(left++));

                }
            }
            return res;

        }

}
