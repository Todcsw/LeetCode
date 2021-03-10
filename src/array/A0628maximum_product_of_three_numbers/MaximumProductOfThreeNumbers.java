package array.A0628maximum_product_of_three_numbers;

import sun.security.util.Length;

import java.util.Arrays;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/9 23:35 星期二
 *
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * @Description: array.A0628maximum_product_of_three_numbers 628. 三个数的最大乘积
 * @version: 1.0
 */
public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        int[] num={-100,-98,-1,2,3,4};
        System.out.println(maximumProduct(num));
        System.out.println(maximumProduct2(num));
    }

    /**
     * 先排序然后比较最大的三个数或者是最小的2个数乘以最大的一个正数
     * @param nums
     * @return
     */
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[nums.length-3]*nums[nums.length-2]*nums[nums.length-1],nums[0]*nums[1]*nums[nums.length-1]);
    }

    public static int maximumProduct2(int[] nums) {
        // 最小的和第二小的数
        Integer min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;

        // 最大的和第二大的和第三大的数
        Integer max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE;

        for(Integer num:nums){
            if(num<min1){
                min2=min1;
                min1=num;
            }else if(num<min2){
                min2=num;
            }

            if(num>max1){
                max3=max2;
                max2=max1;
                max1=num;
            }else if(num>max2){
                max3=max2;
                max2=num;
            }else if(num>max3){
                max3=num;
            }

        }
        return Math.max(max3*max2*max1,min1*min2*max1);
    }
}
