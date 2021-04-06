package two_pointers.medium.B0080remove_duplicates_from_sorted_array_ii;

/**
 * @Auther: 行路
 * @Email: 1759864302@qq.com
 * @Date: Created on 2021/4/6 23:41 星期二
 * @Description: leetCode 80.删除有序数组中的重复项 II
 * @version: 1.0
 */
public class RemoveDuplicatesFromSortedArrayii {
    public static void main(String[] args) {
        int[] nums={1,1,1,2,2,3};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
