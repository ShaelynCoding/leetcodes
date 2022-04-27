import java.util.LinkedList;
import java.util.List;


/**
 * 买卖股票问题
 */
public class BestTimeToBuyAndSellStock_Multi {
    /**
     * Leetcode 121
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * Solution 1: 暴力求解，两两组队(i,j)，max(price[j]-price[i]),两层for->O(n平方）
     * Solution 2: 一次遍历，记录最小价格和最大利润
     * */
    public int maxProfit_121(int[] prices) {
        int len = prices.length;
        if(len==0||len==1) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i=0;i<len;i++) {
            if(minPrice>prices[i]) {
                minPrice=prices[i];
            }
            if(prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }


    /**
     * Leetcode 122
     * 给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。
     *
     * 在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
     * 返回 你能获得的 最大 利润 。
     *
     * Solution 1: 贪心算法: 查看相邻两天的价格，后一天更高的邻对累加（后一天-前一天）即为最大利润
     * Solution 2: dp
     */
    public int maxProfit_122(int[] prices) {
        int len = prices.length;
        if(len==0||len==1) {
            return 0;
        }
        int profit = 0;
        for(int i=1;i<len;i++) {
            if(prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }

    /**
     * Leetcode 123
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 输入：prices = [3,3,5,0,0,3,1,4]
     * 输出：6
     * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     *
     * Solution DP
     * dp[i][j] => 在 [0, i] 区间里，状态为 j 时的现金数
     * j=0 : 没有操作
     * j=1 : 第一次买入
     * j=2 : 第一次卖出
     * j=3 : 第二次买入
     * j=4 : 第二次卖出
     */
    public int maxProfit_123(int[] prices) {
        int len = prices.length;
        if(len==0||len==1) {
            return 0;
        }
        int[][] dp = new int[len][5];
        dp[0][1]=-prices[0];
        dp[0][3]=-prices[0];
        for(int i=1;i<len;i++) {
            dp[i][0]=dp[i-1][0];
            dp[i][1]=Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
            dp[i][2]=Math.max(dp[i-1][2], dp[i-1][1]+prices[i]);
            dp[i][3]=Math.max(dp[i-1][3], dp[i-1][2]-prices[i]);
            dp[i][4]=Math.max(dp[i-1][4], dp[i-1][3]+prices[i]);
        }
        return dp[len-1][4];
    }

    /**
     * Leetcode 188
     * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * Solution DP
     * dp[i][j] => 在 [0, i] 区间里，状态为 j 时的现金数
     */
    public static int maxProfit_188(int k, int[] prices) {
        int len = prices.length;
        if(len==0||len==1) {
            return 0;
        }
        int[][] dp = new int[len][2*k+1];

        for(int i=0;i<k;i++) {
            dp[0][2*i+1]= -prices[0];
        }

        for(int i=1;i<len;i++) {
            dp[i][0]=dp[i-1][0];
            for(int j=1;j<=k;j++) {
                dp[i][2*j-1] = Math.max(dp[i-1][2*j-1], dp[i-1][2*j-2]-prices[i]);
                dp[i][2*j] = Math.max(dp[i-1][2*j], dp[i-1][2*j-1]+prices[i]);
            }
        }
        return dp[len-1][2*k];
    }

    /**
     * Leetcode 188
     * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * eg.
     * 输入: prices = [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     * dp[i][j] => 在 [0, i] 区间里，状态为 j 时的现金数
     * j=0 目前持有一支股票
     * j=1 目前不持有股票并且处于冷冻期
     * j=2 目前不持有股票并且不处于冷冻期
     */
    public static int maxProfit_309(int[] prices) {
        int len = prices.length;
        if(len==0||len==1) {
            return 0;
        }
        int[][] dp = new int[len][3];
        dp[0][0] = -prices[0];
        dp[0][1]=0;
        dp[0][2]=0;
        for(int i=1;i<len;i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]-prices[i]);
            dp[i][1] = dp[i-1][0]+prices[i];
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]);
        }
        return Math.max(dp[len-1][1], dp[len-1][2]);
    }

    /**
     * Leetcode 714
     * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     * 返回获得利润的最大值。
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     *
     * eg.
     * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
     * 输出：8
     * 解释：能够达到的最大利润:
     * 在此处买入 prices[0] = 1
     * 在此处卖出 prices[3] = 8
     * 在此处买入 prices[4] = 4
     * 在此处卖出 prices[5] = 9
     * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
     *
     * Solution1 - DP
     * dp[i][j] => 在 [0, i] 区间里，状态为 j 时的收益
     * j=0 目前持有一支股票
     * j=1 目前不持有股票
     * 状态转移方程：
     * dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
     * dp[i][1]=Math.max(dp[i-1][0]+prices[i]-fee, dp[i-1][1]);
     *
     * Solution2 - 两个参数替代 buy->dp[i-1][0] sell->dp[i-1][1];
     *
     * Solution3
     */
    public int maxProfit_714(int[] prices, int fee) {
        int len = prices.length;
        if(len==0||len==1) {
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for(int i=0;i<len;i++) {
            dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][0]+prices[i]-fee, dp[i-1][1]);
        }
        return dp[len-1][1];
    }

    public int maxProfit_714_Solution2(int[] prices, int fee) {
        int len = prices.length;
        if(len==0||len==1) {
            return 0;
        }
        int buy = -prices[0];
        int sell = 0;
        for(int i=0;i<len;i++) {
            buy=Math.max(buy, sell-prices[i]);
            sell=Math.max(buy+prices[i]-fee, sell);
        }
        return sell;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit_309(prices));
    }
}
