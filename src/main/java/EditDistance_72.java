/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * eg. 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 * Solution DP
 * dp[i][j] => 从word1的第i位 到 word2的第j位 的编辑距离
 * 如果word1[i] == word2[j], dp[i][j] = dp[i-1][j-1]
 * !=, dp[i][j]=min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])+1
 *  替换 dp[i][j]=dp[i-1][j-1]
 *  删除 dp[i][j]=dp[i-1][j]
 *  插入 dp[i][j]=dp[i][j-1]
 */
public class EditDistance_72 {
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1==0) return len2;
        if(len2==0) return len1;
        int[][] dp = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++) {
            dp[i][0]=i;
        }
        for(int i=0;i<=len2;i++) {
            dp[0][i]=i;
        }
        for(int i=1;i<=len1;i++) {
            for(int j=1;j<=len2;j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1];
                } else {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1])+1;
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.print(minDistance("distance", "springbok"));
    }
}
