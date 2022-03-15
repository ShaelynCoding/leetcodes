import java.util.Arrays;


/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 */

public class CoinChange_322 {
    //贪心算法不适合
    // eg. coins=[1,7,10], amount=14 贪心算法会得出10+1+1+1+1，但7+7更优
    /*
    public static int coinChange(int[] coins, int amount) {
        int len = coins.length;
        if(len==0) return -1;
        if(amount==0) return 0;
        Arrays.sort(coins);
        int count=0;
        for(int i=len-1;i>=0;i--) {
            while(amount>=coins[i]) {
                count++;
                amount -= coins[i];
            }
        }
        if(amount==0) return count;
        return -1;
    }
    */

    //递归
    private static int res = Integer.MAX_VALUE;
    public static int coinChange(int[] coins, int amount) {
        int len = coins.length;
        if(len==0) return -1;
        if(amount==0) return 0;
        findWays(coins, amount, 0);
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }

    private static void findWays(int[] coins, int amount, int count) {
        if(amount<0) return;
        if(amount == 0) {
            res = Math.min(res, count);
        }
        for(int i=0;i<coins.length;i++){
            findWays(coins, amount-coins[i], count+1);
        }
    }

    //记忆搜索
    public static int coinChange_memo(int[] coins, int amount) {
        int len = coins.length;
        if(len==0) return -1;
        if(amount==0) return 0;
        int[] count = new int[amount];
        return findWays_memo(coins, amount, count);
    }

    private static int findWays_memo(int[] coins, int amount, int[] count) {
        if(amount<0) return -1;
        if(amount == 0) {
            return 0;
        }
        if(count[amount-1]!=0) {
            return count[amount-1];
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int res = findWays_memo(coins, amount-coins[i], count);
            if(res>=0 && res<min) {
                min = res+1;
            }
        }
        count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount - 1];
    }

    public static int coinChange_dp(int[] coins, int amount) {
        int len = coins.length;
        if(len==0) return -1;
        if(amount==0) return 0;
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        dp[0]=0;

        for(int i=1;i<=amount;i++) {
            int min = amount;
            for(int j=0;j<len&&i>=coins[j];j++) {
                if(dp[i-coins[j]]<min) {
                    min = dp[i-coins[j]];
                }
            }
            dp[i]=min+1;
        }
        if(dp[amount]==amount+1) return -1;
        return dp[amount];
    }



    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(coinChange_memo(coins, 11));
        int[] coins2 = {186,419,83,408};
        System.out.print(coinChange_memo(coins2, 6249));

    }
}
