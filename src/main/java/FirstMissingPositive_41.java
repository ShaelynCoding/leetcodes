public class FirstMissingPositive_41 {
    public static int firstMissingPositive(int[] nums) {
        int size = nums.length;
        if(size==0) return 1;
        int[] existed = new int[size+1];
        for(int i=0;i<size;i++) {
            if(nums[i]>0 && nums[i]<=size) {
                existed[nums[i]]=1;
            }
        }
        int index=1;
        while(existed[index]==1) {
            index++;
            if(index==size+1) return index;
        }
        return index;
    }

    public static int firstMissingPositive_swap(int[] nums) {
        int size = nums.length;
        if(size==0) return 1;
        if(size==1) return nums[0]==1?2:1;

        for(int i=0;i<size;i++) {
            while (nums[i]>0 && nums[i]<=size && nums[i]!=i+1 && nums[nums[i]-1]!=nums[i]) {
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=tmp;
            }
        }
        for(int i=0;i<size;i++) {
            if(nums[i]!=i+1) return i+1;
        }
        return size;
    }


    public static void main(String[] args) {
        int[] nums = {2,1};
        System.out.println(firstMissingPositive_swap(nums));
    }


}
