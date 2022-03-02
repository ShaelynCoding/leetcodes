import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * Solution 1: hashmap 计数
 * Solution 2: 排序 return中间数
 * Solution 3: 摩尔投票法
     * 投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
     * 且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
     * 因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
     * 这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”
 * */

public class MajorityElement_169 {
    public int majorityElement_Solution1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length;
        int line = len/2+len%2;
        for(int num:nums) {
            if(map.containsKey(num)) {
                int count = map.get(num) + 1;
                if(count >= line)  return num;
                map.put(num, count);
            } else {
                map.put(num, 1);
            }
        }
        return nums[0];
    }

    public int majorityElement_Solution2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElement_Solution3(int[] nums) {
        int cand_num = nums[0];
        int count = 1;
        for(int i=1;i<nums.length;i++) {
            if(cand_num == nums[i]) count++;
            else if(--count == 0) {
                cand_num=nums[i];
                count=1;
            }
        }
        return cand_num;
    }
}
