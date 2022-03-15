public class ClimbingStairs_70 {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        int index = 3;
        while (index <= n) {
            dp[index]=dp[index-1]+dp[index-2];
            index++;
        }
        return dp[n];
    }
}
