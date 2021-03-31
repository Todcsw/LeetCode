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
