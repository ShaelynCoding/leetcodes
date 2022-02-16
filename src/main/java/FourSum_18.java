import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class FourSum_18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        if(len<4) return results;
        Arrays.sort(nums);
        for(int i=0;i<len;i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<len;j++) {
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int start = j+1;
                int end = len-1;
                while(start<end) {
                    int sum = nums[i]+nums[j]+nums[start]+nums[end];
                    if(sum==target) {
                        List<Integer> tmp = new LinkedList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[start]);
                        tmp.add(nums[end]);
                        results.add(tmp);
                        while(start<end && nums[start]==nums[start+1]) start++;
                        start++;
                        while (start<end && nums[end]==nums[end-1]) end--;
                        end--;
                    } else if(sum<target) {
                        while(start<end && nums[start]==nums[start+1]) start++;
                        start++;
                    } else {
                        while (start<end && nums[end]==nums[end-1]) end--;
                        end--;
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        int target = 8;
        List<List<Integer>> result = fourSum(nums, target);
        System.out.println("result: "+ result);
    }
}
