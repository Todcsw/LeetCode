package array.A1550three_consecutive_odds;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/10 9:06 星期三
 *
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 *
 * @Description: array.A1550three_consecutive_odds leetCode1550. 存在连续三个奇数的数组
 * @version: 1.0
 */
public class ThreeConsecutiveOdds {
    public static void main(String[] args) {
        int[] arr={1,2,34,3,4,5,7,23,12};
        System.out.println(threeConsecutiveOdds(arr));

    }

    /**
     * 枚举所有的连续的三个元素，判断这三个元素是否都是奇数，如果是，则返回 true。如果所有的连续的三个元素中，没有一个满足条件，返回 false。
     * @param arr
     * @return
     */
    public static boolean threeConsecutiveOdds(int[] arr) {


        boolean flag=false;

        for(int i=0;i<arr.length-2;i++){
            if(arr[i]%2!=0&&arr[i+1]%2!=0&&arr[i+2]%2!=0) {
                flag = true;
            }
        }

        if(arr.length<3){
            flag=false;
        }

        return flag;
    }
}
