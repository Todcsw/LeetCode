package array.A1331rank_transform_of_an_array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/16 20:04 星期二
 *
 * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
 * 序号代表了一个元素有多大。序号编号的规则如下：
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 *
 * @Description: array.A1331rank_transform_of_an_array leetCode 1331.数组序号转换
 * @version: 1.0
 */
public class RankTransformOfAnArray {


    public static void main(String[] args) {
        int[] nums={40,10,20,30};
        int[] ints = arrayRankTransform(nums);
        System.out.println(Arrays.toString(ints));

    }

    /**
     * 解法一,先排序再遍历
     * @param arr
     * @return
     */
    public static int[] arrayRankTransform(int[] arr) {

        int a[]=new int[arr.length];

        a=arr.clone();

        Arrays.sort(a);

        HashMap<Integer, Integer> map = new HashMap<>();

        int index=1;

        for(int i=0;i<a.length;i++){
            if(i>0&&a[i]!=a[i-1]){
                map.put(a[i],index);
                index++;
            }
            if(i==0){
                map.put(a[i],index);
                index++;
            }
        }

        for(int i=0;i<arr.length;i++){
            arr[i]=map.get(arr[i]);
        }

        return arr;

    }
}
