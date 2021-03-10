package array.A0219contains_duplicate_ii;

import java.util.HashSet;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/10 9:24 星期三
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 * @Description: array.A0219contains_duplicate_ii leetCode 219. 存在重复元素 II
 * @version: 1.0
 */
public class ContainsDuplicate_ii {
    public static void main(String[] args) {

        int[] nums={1,2,3,1,2,3};
        int k=2;
        System.out.println(containsNearbyDuplicate(nums,k));

    }

    /**
     * 利用固定窗口滑动机制,一次遍历。
     * 创建一个set固定其的大小,超过大小移除第一个数
     * 否则继续添加元素。固定的set中包含有该数则返回true;
     * 否则遍历结束返回false;
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<nums.length;i++){

            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size()>k) {
                set.remove(nums[i-k]);
            }
        }

        return false;
    }
}
