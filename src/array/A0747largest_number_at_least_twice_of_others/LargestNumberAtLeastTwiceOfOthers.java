package array.A0747largest_number_at_least_twice_of_others;

import java.util.Arrays;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/17 12:55 星期三
 * @Description: array.A0747largest_number_at_least_twice_of_others leetCode 747.至少是其他数字两倍的最大数
 * @version: 1.0
 */
public class LargestNumberAtLeastTwiceOfOthers {

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(dominantIndex(nums));
    }


    /**
     * 解法一:先排序,判断最大数是否大于等于二大数的二倍
     * 在遍历找出最大数的小标
     * @param nums
     * @return
     */
    public static int dominantIndex(int[] nums) {

        int[] clone = nums.clone();
        if(nums.length==1){
            return 0;
        }

        Arrays.sort(nums);

        if(nums[nums.length-1]>=nums[nums.length-2]*2){
            for(int i=0;i<clone.length;i++){
                if(clone[i]==nums[nums.length-1]){
                    return i;
                }
            }
        }

        return -1;

    }


    /**
     * 解法二:方法：线性扫描
     *
     * 扫描数组找到唯一的最大元素 m，并记录它的索引 maxIndex。
     * 再次扫描数组，如果我们找到 x != m，m < 2*x，我们应该返回 -1。
     * 否则返回 maxIndex
     *
     * @param nums
     * @return
     */
    public static int dominantIndex2(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i])
                return -1;
        }
        return maxIndex;
    }

}
