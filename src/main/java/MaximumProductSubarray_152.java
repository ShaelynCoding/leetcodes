/**
 * Leetcode 152
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 *
 * 子数组 是数组的连续子序列。
 *
 * Solution:
 * 状态转移方程
 * fmax(i) = max(fmin(i-1)*nums[i], fmax(i-1)*nums[i], nums[i])
 * fmin(i) = min(fmin(i-1)*nums[i], fmax(i-1)*nums[i], nums[i])
 */
public class MaximumProductSubarray_152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len==0) return 0;
        int[] fmax = new int[len];
        int[] fmin = new int[len];
        fmax[0]=nums[0];
        fmin[0]=nums[0];
        for(int i=1;i<len;i++) {
            fmax[i]=max(fmax[i-1]*nums[i], fmin[i-1]*nums[i], nums[i]);
            fmin[i]=min(fmax[i-1]*nums[i], fmin[i-1]*nums[i], nums[i]);
        }
        int maxRes = fmax[0];
        for(int i=1;i<len;i++) {
            if(maxRes < fmax[i]) {
                maxRes = fmax[i];
            }
        }
        return maxRes;
    }

    private int min(int a, int b, int c) {
        int res = a;
        if(b < res) {
            res = b;
        }
        if(c < res) {
            res = c;
        }
        return res;
    }

    private int max(int a, int b, int c) {
        int res = a;
        if(b > res) {
            res = b;
        }
        if(c > res) {
            res = c;
        }
        return res;
    }
}
