import java.util.Arrays;


public class RemoveDuplicatesFromSortedArray_26 {
    public static int removeDuplicates(int[] nums) {
        int size = nums.length;
        if(size==0 || size==1) return size;
        int lastIndex=1;
        int duplicateNum=nums[0];
        for(int i=1;i<size;i++) {
            if(nums[i]!=duplicateNum) {
                nums[lastIndex]=nums[i];
                duplicateNum=nums[i];
                lastIndex++;
            }
        }
        return lastIndex;
    }
    public static void main(String[] args) {
        int[] nums={1,1,2};
        System.out.println(removeDuplicates(nums));
    }

}
