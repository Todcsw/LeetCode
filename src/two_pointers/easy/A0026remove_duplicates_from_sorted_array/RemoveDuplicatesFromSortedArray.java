package two_pointers.easy.A0026remove_duplicates_from_sorted_array;

import java.util.HashSet;

/**
 * @Auther: 行路
 * @Email: 1759864302@qq.com
 * @Date: Created on 2021/3/31 23:01 星期三
 * @Description:
 * @version: 1.0
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums={0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicates(nums);
        for(int a:nums){
            System.out.print(a+",");
        }

        System.out.println(i);
    }


    /**
     * 3 ms, 在所有 Java 提交中击败了7.39% 的用户
     * 39.9 MB, 在所有 Java 提交中击败了97.82% 的用户
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        HashSet<Integer> h=new HashSet<>();

        for(int i=0,j=0;i<nums.length;i++){
            if(h.add(nums[i])){
                nums[j]=nums[i];
                j++;
            }
        }

        return h.size();
    }

    /**
     * 双指针解法
     *
     * 首先注意数组是有序的，那么重复的元素一定会相邻。
     *
     * 要求删除重复元素，实际上就是将不重复的元素移到数组的左侧。
     *
     * 考虑用 2 个指针，一个在前记作 p，一个在后记作 q，算法流程如下：
     *
     * 1.比较 p 和 q 位置的元素是否相等。
     *
     * 如果相等，q 后移 1 位
     * 如果不相等，将 q 位置的元素复制到 p+1 位置上，p 后移一位，q 后移 1 位
     * 重复上述过程，直到 q 等于数组长度。
     *
     * 返回 p + 1，即为新数组长度。
     *
     * 这个双指针真的妙啊！
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0){
            return 0;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }


}
