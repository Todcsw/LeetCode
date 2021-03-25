package greedy.A1217minimum_cost_to_move_chips_to_the_same_position;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/25 13:20 星期四
 * @Description: greedy.A1217minimum_cost_to_move_chips_to_the_same_position
 * @version: 1.0
 */
public class MinimumCostToMoveChipsToTheSamePosition {
    public static void main(String[] args) {
        int[] nums={2,2,2,3,3};
        int i = minCostToMoveChips(nums);
        System.out.println(i);
    }


    public static int minCostToMoveChips(int[] position) {
        int old=0,even=0;
        for(int i:position){
            if(i%2==0){
                old++;
            }else{
                even++;
            }
        }

        return Math.min(old,even);
    }
}
