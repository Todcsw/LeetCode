package dynamic_programming.A0070climbing_stairs;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/24 16:47 星期三
 * @Description: dynamic_programming.A0070climbing_stairs
 * @version: 1.0
 */
public class ClimbingStairs {
    public static void main(String[] args) {
//        int a=5;
//        int i = climbStairs(5);
//        System.out.println(i);
        int n=5;
        int[] num =new int[n+1];
        int i1 = climbStairs2(num, 5);System.out.println(i1);

        int i = climbStairs3(n);
        System.out.println(i);

        int i2 = climbStairs4(n);
        System.out.println(i2);

    }


    /**
     * 递归
     * @param n
     * @return
     */
    public static int climbStairs(int n) {

        if(n==1){
            return n;
        }
        if(n==2){
            return n;
        }

        return climbStairs(n-1)+climbStairs(n-2);
    }


    /**
     * 递归优化,将结果保存到数组中
     * @param num
     * @param n
     * @return
     */
    public static int climbStairs2(int[] num,int n) {

        if(num[n]>0){
            return num[n];
        }

        if(n==1){
            num[n]=1 ;
        }
        else if(n==2){
            num[n]=2;
        }else{
            num[n]=climbStairs2(num,n-1)+climbStairs2(num,n-2);
        }

        return num[n];
    }


    /**
     * 动态规划
     * 状态转移方程为:dp[i]=dp[i-1]+dp[i-2]
     * @param n
     * @return
     */
    public static int climbStairs3(int n) {
        if(n==1){
            return n;
        }
        if(n==2){
            return n;
        }

        int[]  dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];

    }


    /**
     * 斐波那契
     * @param n
     * @return
     */
    public static int climbStairs4(int n) {
        if(n==1){
            return n;
        }
        if(n==2){
            return n;
        }

        int first=1;
        int second=2;
        int third=0;
        for(int i=3;i<=n;i++){
            third=first+second;
            first=second;
            second=third;
        }

        return third;

    }




}
