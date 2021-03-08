package array.A0977squares_of_a_sorted_array;

import java.util.Arrays;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/8 12:06 星期一  给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * @Description: array.A0977squares_of_a_sorted_array  leetcode 977. 有序数组的平方
 * @version: 1.0
 */
public class SquaresOfASortedArray {

    public static void main(String[] args) {
        int[] nums={-4,-1,0,3,10};
        int[] ints = sortedSquares2(nums);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 直接排序
     * @param nums 数字平方后直接排序
     * @return
     */
    public static int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 双指针 通过前后指针的移动同时判断大小
     * @param nums
     * @return
     */
    public static int[] sortedSquares2(int[] nums) {
        int length=nums.length;

        int[] num=new int[length];

        for(int i=0,j=length-1,pos=length-1;i<=j;){
            if(nums[i]*nums[i]>nums[j]*nums[j]){
                num[pos]=nums[i]*nums[i];
                i++;
            }else{
                num[pos]=nums[j]*nums[j];
                j--;
            }
            pos--;
        }
        return num;

    }




}
