package leetcode;

/**
 * 62
 *
 * Input: m = 3, n = 2
 Output: 3
 Explanation:
 From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 1. Right -> Right -> Down
 2. Right -> Down -> Right
 3. Down -> Right -> Right
 Example 2:

 Input: m = 7, n = 3
 Output: 28
 */
public class Unique_Paths {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0){ dp[i][j]=1;}
                else if(j==0){
                    dp[i][j]=1;
                }else{dp[i][j]=dp[i][j-1]+dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
