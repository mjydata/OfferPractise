package designPatterns;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n+1][m+1];
        dp[0][0]=grid[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0){
                    if(j==0){
                        dp[i][j]=grid[0][0];
                    }else{
                        dp[i][j]=dp[i][j-1]+grid[i][j];
                    }
                }else{
                    if(j==0){
                        dp[i][j]=dp[i-1][j]+grid[i][j];
                    }else{
                        dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                    }
                }
            }
        }
        return dp[n-1][m-1];
    }
    public static int lengthOfLongestSubstring(String s) {
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
    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        int len=s.length();
        int maxlen=0;
        int start=0;int end=0;
        boolean[][] hp=new boolean[len][len];
        for(int i=len-1;i>0;i--){
            for(int j=i;j<len;j++){
                if(hp[i+1][j-1]||(j-i)<2 && s.charAt(i)==s.charAt(j) )  {
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

    public static int maxSubArray(int[] nums) {

        int m=nums.length;
        int[] dp=new int[m];
        dp[0]=nums[0];
        int answer=dp[0];
        for(int i=1;i<m;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            answer=Math.max(answer,dp[i]);
        }
        return answer;
    }
    public  static void main(String[] args){
        String s="asaqeqe";
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
       System.out.println( lengthOfLongestSubstring(s));
    }
}
