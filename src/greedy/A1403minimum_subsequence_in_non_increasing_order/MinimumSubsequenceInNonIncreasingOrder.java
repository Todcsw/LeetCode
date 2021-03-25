package greedy.A1403minimum_subsequence_in_non_increasing_order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/25 12:44 星期四
 * @Description: greedy.A1403minimum_subsequence_in_non_increasing_order
 * @version: 1.0
 */
public class MinimumSubsequenceInNonIncreasingOrder {
    public static void main(String[] args) {
        int[] num={4,4,7,6,7};
        List<Integer> integers = minSubsequence(num);
        System.out.println(integers.toString());
    }


    public static List<Integer> minSubsequence(int[] nums) {
        ArrayList<Integer> list=new ArrayList();

        Arrays.sort(nums);
        int count=0;
        for(int i=0;i<nums.length;i++){
            count+=nums[i];
        }
        int count1=0;
        for(int i=nums.length-1;i>=0;i--){
            count1+=nums[i];
            if(count1>count-count1){
                list.add(nums[i]);
                break;
            }else{
                list.add(nums[i]);

            }
        }


        return list;
    }

}
