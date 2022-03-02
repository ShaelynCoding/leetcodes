public class NextPermutation_31 {
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len<=1) return;
        int j = len-1;
        int i = j-1;
        while(i>=0 && nums[i]>=nums[j]) {
            i--;
            j--;
        }
        if(i>=0) {
            int k=len-1;
            while(k>j && nums[k]<=nums[i]) {
                k--;
            }
            swap(nums, i, k);
        }

        reverse(nums, j, len-1);
    }

    private static void reverse(int[] nums, int begin, int end) {
        int len = end-begin+1;
        if(len == 1) return;
        int start = len/2+len%2+begin;
        while (start<=end) {
            swap(nums, start, begin+end-start);
            start++;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }


    public static void main(String[] args) {
        int[] nums = new int[] { 1, 3, 2 };
        nextPermutation(nums);
        System.out.print("[1,3,2]: ");
        print(nums);
        nums = new int[] { 3, 2, 1 };
        nextPermutation(nums);
        System.out.print("[3,2,1]: ");
        print(nums);
        nums = new int[] { 1, 1, 5 };
        nextPermutation(nums);
        System.out.print("[1,1,5]: ");
        print(nums);
        nums = new int[] {1,2,3,8,5,7,6,4};
        nextPermutation(nums);
        System.out.print("[1,2,3,8,5,7,6,4]: ");
        print(nums);
    }

    public static void print(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println("");
    }

}
