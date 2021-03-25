package greedy.A1725number_of_rectangles_that_can_form_the_largest_square;

import java.util.Arrays;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/25 13:50 星期四
 * @Description: greedy.A1725number_of_rectangles_that_can_form_the_largest_square
 * @version: 1.0
 */
public class NumberOfRectanglesThatCanFormTheLargestSquare {
    public static void main(String[] args) {
        int[][] rectangles ={{5,8},{3,9},{5,12},{16,5}};
        int i = countGoodRectangles2(rectangles);
        System.out.println(i);
    }

    public static int countGoodRectangles(int[][] rectangles) {
        int[] nums=new int[rectangles.length];
        for(int i=0;i<rectangles.length;i++){
            nums[i]=(Math.min(rectangles[i][0],rectangles[i][1]));
        }
        Arrays.sort(nums);
        int max=nums[nums.length-1];
        int count=0;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]==max){
                count+=1;
            }else{
                break;
            }

        }
        return count;
    }


    /**
     * 贪心解法
     * @param rectangles
     * @return
     */
    public static int countGoodRectangles2(int[][] rectangles) {

       // int b=0;
        int max=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<rectangles.length;i++){
            int b=Math.min(rectangles[i][0],rectangles[i][1]);
            if(b>max){
                max=b;
                count=1;
            }else if(b==max){
                count++;
            }
        }
        return count;

    }
}
