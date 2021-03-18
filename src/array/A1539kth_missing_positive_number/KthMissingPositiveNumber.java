package array.A1539kth_missing_positive_number;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/18 21:44 星期四
 * @Description: array.A1539kth_missing_positive_number leetCode 1539.第k个缺失的正整数
 * @version: 1.0
 */
public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        int kthPositive = findKthPositive(arr, k);
        System.out.println(kthPositive);
    }


    /**
     * 解法一:
     *
     * 缺失的正整数一定 >= k
     * 数组中每出现一个 <= k 的数字, 意味着少了一个缺失的数字, 此时k+1
     *
     * @param arr
     * @param k
     * @return
     */
    public static int findKthPositive(int[] arr, int k) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                k++;
            }
        }
        return k;
    }

    /**
     * 二分
     * @param arr
     * @param k
     * @return
     */
    public static int findKthPositive2(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }

        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            int x = mid < arr.length ? arr[mid] : Integer.MAX_VALUE;
            if (x - mid - 1 >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return k - (arr[l - 1] - (l - 1) - 1) + arr[l - 1];
    }




}
