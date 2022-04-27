import java.util.Arrays;


public class FindFirstLastElementInSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {
        int size = nums.length;
        int[] res = new int[2];
        Arrays.fill(res, -1);
        if (size == 0)
            return res;
        int left = 0;
        int right = size - 1;
        return res;
    }

    public int binarySearchIndex(int[] nums, int target, boolean lower) {
        int size = nums.length;
        int left = 0;
        int right = size - 1;
        while(left<=right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (!lower && mid == size - 1 || nums[mid + 1] > target) {
                    return mid;
                }
                if (lower && mid == 0 || nums[mid - 1] < target) {
                    return mid;
                }


            } else if (nums[mid] < target) {
                right = mid + 1;
            } else {
                left = mid - 1;
            }
        }
        return -1;
    }
}
