package array.A1588sum_of_all_odd_length_subarrays;

import sun.security.util.Length;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/9 21:15 星期二
 *
 * problems：
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 *
 * 子数组 定义为原数组中的一个连续子序列。
 *
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 *
 * @Description: array.A1588sum_of_all_odd_length_subarrays leetCode 1588. 所有奇数长度子数组的和
 * @version: 1.0
 */
public class SumOfAllOddLengthSubarrays {

    public static void main(String[] args) {
        int[] arr={1,4,2,5,3};
        System.out.println(sumOddLengthSubarrays(arr));

    }

    /**
     * 三重循环,第一重确定数组长度,第二重确定开始位置，最里面循环取值相加求和
     * @param arr
     * @return
     */
    public static int sumOddLengthSubarrays(int[] arr) {
        int i=1;
        int sum=0;
        while (i<=arr.length){
            for(int j=0;j<arr.length;j++){
                if(i+j<=arr.length){
                    for(int s=0;s<i;s++){
                        sum+=arr[s+j];
                    }
                }
            }
            i=i+2;
        }
        return sum;
    }

    /**
     * 数学解法
     * @param arr
     * @return
     */
    public static int sumOddLengthSubarrays2(int[] arr) {

        int len = arr.length, res = 0;
        for(int i = 0; i < len; i ++){
            int LeftOdd = (i+1)/2, LeftEven = i/2+1;
            int RightOdd = (len-i)/2, RightEven = (len-1-i)/2+1;
            res += arr[i]*(LeftOdd*RightOdd + LeftEven*RightEven);
        }
        return res;
    }


}
