package array.A1534count_good_triplets;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/15 14:19 星期一
 *
 * 给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。
 *
 * 如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
 *
 * 0 <= i < j < k < arr.length
 * |arr[i] - arr[j]| <= a
 * |arr[j] - arr[k]| <= b
 * |arr[i] - arr[k]| <= c
 * 其中 |x| 表示 x 的绝对值。
 *
 * 返回 好三元组的数量 。
 *
 * @Description: array.A1534count_good_triplets leetCode 1534.统计好三元组
 * @version: 1.0
 */
public class CountGoodTriplets {
    public static void main(String[] args) {
        int[] nums={3,0,1,1,9,7};
        int a=7,b=2,c=3;
        System.out.println(countGoodTriplets(nums,a,b,c));
    }

    /**
     * 解法一:枚举
     * @param arr
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int countGoodTriplets(int[] arr, int a, int b, int c) {

       int n=arr.length;
       int count=0;
       for(int i=0;i<n;i++){
           for(int j=i+1;j<n;j++){
               for(int k=j+1;k<n;k++){
                   if(Math.abs(arr[i]-arr[j])<=a&&Math.abs(arr[j]-arr[k])<=b&&Math.abs(arr[i]-arr[k])<=c){
                       count++;
                   }
               }
           }
       }
       return count;
    }


    /**
     * 枚举优化
     * @param arr
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int countGoodTriplets2(int[] arr, int a, int b, int c) {

        int ans = 0, n = arr.length;
        int[] sum = new int[1001];
        for (int j = 0; j < n; ++j) {
            for (int k = j + 1 ; k < n; ++k) {
                if (Math.abs(arr[j] - arr[k]) <= b) {
                    int lj = arr[j] - a, rj = arr[j] + a;
                    int lk = arr[k] - c, rk = arr[k] + c;
                    int l = Math.max(0, Math.max(lj, lk)), r = Math.min(1000, Math.min(rj, rk));
                    if (l <= r) {
                        if (l == 0) {
                            ans += sum[r];
                        }
                        else {
                            ans += sum[r] - sum[l - 1];
                        }
                    }
                }
            }
            for (int k = arr[j]; k <= 1000; ++k) {
                ++sum[k];
            }
        }
        return ans;

    }





}
