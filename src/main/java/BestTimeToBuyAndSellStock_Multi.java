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
}
