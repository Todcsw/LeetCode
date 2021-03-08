package array.D1710find_majority_element_lcci;

import java.util.HashMap;

import java.util.Map;


/**
 * @Auther: 行路
 * @Date: Created on 2021/3/7 23:14 星期日  找到数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 * @Description: array.D1710find_majority_element_lcci  leetcode面试题 17.10. 主要元素
 * @version: 1.0
 */
public class FindMajorityElementLcci {


    public static void main(String[] args) {

        int[] nums={1};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement2(nums));
    }

    public static int majorityElement(int[] nums) {


        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        int b = -1;
        for(int a:nums){
            if(map.get(a)==null){
                map.put(a,1);
            }else if(map.get(a)<=nums.length/2){
                map.put(a,map.get(a)+1);
                if(map.get(a)>nums.length/2){
                    b=a;
                    break;
                }
            }
        }
        if (nums.length==1){
            b=nums[0];
        }
        return b;

    }

    public static int majorityElement2(int[] nums){
        int temp = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == temp) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                temp = nums[i];
                count = 1;
            }
        }
        count=0;
        for(int num:nums){
            if(num==temp) count++;
            if(count==nums.length/2+1) return temp;
        }
        return -1;
    }
}
