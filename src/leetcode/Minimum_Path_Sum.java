package leetcode;
/*
64：https://leetcode.com/problems/minimum-path-sum/description/
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
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
        return dp[m-1][n-1];
    }

}
