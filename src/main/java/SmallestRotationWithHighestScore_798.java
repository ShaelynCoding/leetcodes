public class SmallestRotationWithHighestScore_798 {
    public static int bestRotation(int[] nums) {
        int len = nums.length;
        int maxScore = 0;
        int minRotation = len;
        for (int k = 0; k < len; k++) {
            int score = 0;
            for (int i = 0; i < len; i++) {
                int index = i - k;
                if (index < 0) {
                    index = len + index;
                }
                if (nums[i] <= index) {
                    score++;
                }
            }
            if (score > maxScore) {
                maxScore = score;
                minRotation = k;
            } else if (score == maxScore && k < minRotation) {
                minRotation = k;
            }
        }
        return minRotation;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,4,0};
        int res = bestRotation(nums);
        System.out.println("[2,3,1,4,0]: "+res);
        int[] nums2 = {1,3,0,2,4};
        res = bestRotation(nums2);
        System.out.println("[1,3,0,2,4]: "+res);
    }

}
