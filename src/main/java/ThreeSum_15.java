import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class ThreeSum_15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        int len = nums.length;
        for(int i=0;i<len;i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int start = i+1;
            int end = len-1;
            while(start<end) {
                int sum = nums[i]+nums[start]+nums[end];
                if(sum==0) {
                    List<Integer> res = new LinkedList<Integer>();
                    res.add(nums[i]);
                    res.add(nums[start]);
                    res.add(nums[end]);
                    results.add(res);
                    while(start<end &&nums[start]==nums[start+1]) start++;
                    start++;
                    while(start<end &&nums[end]==nums[end-1]) end--;
                    end--;
                } else if(sum<0) {
                    while(start<end &&nums[start]==nums[start+1]) start++;
                    start++;
                } else {
                    while(start<end &&nums[end]==nums[end-1]) end--;
                    end --;
                }
            }
        }
        return results;
    }



    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        List<List<Integer>> result = threeSum(nums);
        System.out.println("result: "+ result);
    }
}
