public class SearchInRotatedSortedArray_33 {
    public static int search(int[] nums, int target) {
        int size = nums.length;
        if(size==0) return -1;
        if(size==1) {
            return nums[0]==target?0:-1;
        }
        int start = 0;
        int end = size-1;
        while(start<=end) {
            int mid = (start+end)/2;
            if(nums[mid]==target) {
                return mid;
            }
            if(nums[0] <= nums[mid]) {
                if(nums[0] <= target && target < nums[mid]) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else {
                if(nums[mid] < target && target <= nums[size-1]) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
//        System.out.println(search(nums, 0));
//        System.out.println(search(nums, 3));
        int[] num = {1,3};
        System.out.println(search(num, 3));
    }
}
