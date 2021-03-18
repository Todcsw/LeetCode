package array.A0509fibonacci_number;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/17 13:27 星期三
 * @Description: array.A0509fibonacci_number leetCode 509.斐波那契数
 * @version: 1.0
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        int b=7;
        System.out.println(fib1(b));
    }

    public static int fib(int n) {
        int[] nums={0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765,10946,17711,28657,46368,75025,121393,196418,317811,514229,832040};
        return nums[n];
    }

    public static int fib1(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibN = Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n);
        return (int) Math.round(fibN / sqrt5);
    }

    public int fib2(int n) {
        if(n<2){
            return n;
        }
        int p=0;
        int q=0;
        int r=1;
        for(int i=2;i<=n;i++){
            p=q;
            q=r;
            r=p+q;
        }
        return r;
    }
}
