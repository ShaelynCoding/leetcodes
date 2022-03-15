import java.util.LinkedList;
import java.util.List;


/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * example: 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * Solution 1 - DP
 * Solution 2 - 二分+贪心
 */
public class LongestIncreasingSubsequence_300 {
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len<=1) return len;
        int[] dp = new int[len];
        dp[0] = 1;
        int maxRes = 1;
        for(int i=1;i<len;i++) {
            int max=1;
            for(int j=0;j<i;j++) {
                if(nums[i]>nums[j]) {
                    max=Math.max(max, dp[j]+1);
                }
            }
            dp[i]=max;
            if(maxRes<max) {
                maxRes = max;
            }
        }
        return maxRes;
    }

    public static int lengthOfLIS_Two(int[] nums) {
        int len = nums.length;
        if(len<=1) return len;
        int[] tailer = new int[len];
        tailer[0] = nums[0];
        int index=0;
        for(int i=1;i<len;i++) {
            if(nums[i]>tailer[index]) {
                tailer[++index]=nums[i];
            } else {
                int left = 0;
                int right = index;
                while (left<right) {
                    int mid = (left+right)/2;
                    if(tailer[mid]>=nums[i]) {
                        right = mid;
                    } else {
                        left = mid+1;
                    }
                }
                tailer[left]=nums[i];
            }
        }
        return index+1;
    }

    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        int res =  lengthOfLIS_Two(nums);
        System.out.print(res);
    }
}
