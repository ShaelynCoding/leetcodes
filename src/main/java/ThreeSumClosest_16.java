import java.util.Arrays;


public class ThreeSumClosest_16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int closet = nums[0]+nums[1]+nums[2];
        for(int i=0;i<len;i++) {
            int start = i+1;
            int end = len - 1;
            while(start < end) {
                int sum = nums[i]+nums[start]+nums[end];
                if(Math.abs(sum-target) < Math.abs(closet-target)) {
                    closet = sum;
                }
                if(sum < target) {
                    start++;
                } else {
                    end --;
                }
            }
        }
        return closet;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,-1,-1,3};
        int target = -1;
        int result = threeSumClosest(nums, target);
        System.out.println("result: "+ result);
    }
}
