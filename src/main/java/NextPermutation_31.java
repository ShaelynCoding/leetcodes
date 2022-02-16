public class NextPermutation_31 {
    public static void nextPermutation(int[] nums) {
        int len = nums.length;

    }


    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3 };
        nextPermutation(nums);
        System.out.println("[1,2,3]: ");
        print(nums);
        nums = new int[] { 3, 2, 1 };
        nextPermutation(nums);
        System.out.println("[3,2,1]: ");
        print(nums);
        nums = new int[] { 1, 1, 5 };
        nextPermutation(nums);
        System.out.println("[1,1,5]: ");
        print(nums);
    }

    public static void print(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            System.out.println(nums[i]);
        }
    }

}
