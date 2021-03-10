package array.A0218summary_ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/10 11:05 星期三
 * @Description: array.A0218summary_ranges leetCode 228.汇总区间
 * @version: 1.0
 */
public class SummaryRanges {
    public static void main(String[] args) {
        int[] num={0}; //4
        System.out.println(summaryRanges(num).toString());

    }

    /**
     * 循环判读太多
     * @param nums
     * @return
     */
    public static List<String> summaryRanges(int[] nums) {
        ArrayList<String> list=new ArrayList<>();

        if(nums.length==0){
            return list;
        }

        if(nums.length==1){
            list.add(nums[0]+"");
            return list;
        }

        int i=0;
        int count=0;
        String s;
        while( i<nums.length-1){
            if(nums[i]+1==nums[i+1]){
                count++;
            }else{
                if(count>=1){
                    s=nums[(i-count)]+"->"+nums[i];

                }else{
                    s=nums[i]+"";
                }
                list.add(s);
                count=0;
            }
            i++;
        }
        if(count>=1){
            list.add(nums[(i-count)]+"->"+nums[i]);
        }else{
            list.add(nums[nums.length-1]+"");
        }


        return list;
    }


    /**
     *
     *我们从数组的位置0出发,向有遍历。每次遇到相邻元素之间的差值大于1时，我们就找到了一个区间。
     *遍历完数组之后,就能得到一系列的区间的列表。
     *在遍历过程中,维护小标low和high分别记录区间的起点和终点,对于任何区间都有low<=high.当得到一个
     * 区间时,根据low 和high的值生成区间的字符串表示。
     * 当low <high时,区间的字符串表示为low->high
     * 当low =high时,区间的字符串表示为low
     * @param nums
     * @return
     */
    public static List<String> summaryRanges2(int[] nums) {

        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }

}
