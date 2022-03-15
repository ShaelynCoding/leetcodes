public class PowerOfTwo_231 {
    public static boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        while(n>=2) {
            if(n%2!=0) {
                return false;
            }
            n=n/2;
        }
        return true;
    }

    //2的幂的数 二进制只有一位是1 n&(n-1)=0
    public static boolean isPowerOfTwo_bit(int n) {
        return n>0 && (n & (n-1))==0;
    }
    public static void main(String[] args) {
        System.out.println("1: "+isPowerOfTwo(1));
        System.out.println("-16: "+isPowerOfTwo(-16));
        System.out.println("3: "+isPowerOfTwo(3));
        System.out.println("4: "+isPowerOfTwo(4));
        System.out.println("5: "+isPowerOfTwo(5));
    }
}
