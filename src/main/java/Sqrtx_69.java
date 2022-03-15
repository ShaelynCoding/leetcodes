public class Sqrtx_69 {
    public static int mySqrt(int x) {
        if(x==0||x==1) return x;
        int left = 1;
        int right = x;
        int res = 0;
        while(left<right) {
            int mid = (left+right)/2;
            if(mid>x/mid) {
                right=mid-1;
            } else if(mid==x/mid) {
                return mid;
            } else {
                left=mid+1;
                res = mid;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println("3: "+mySqrt(3));
        System.out.println("9: "+mySqrt(9));
        System.out.println("16: "+mySqrt(16));
    }
}
