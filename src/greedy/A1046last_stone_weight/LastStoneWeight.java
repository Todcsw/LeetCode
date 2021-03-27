package greedy.A1046last_stone_weight;

import java.util.Arrays;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/27 8:38 星期六
 * @Description: greedy.A1046last_stone_weight
 * @version: 1.0
 */
public class LastStoneWeight {
    public static void main(String[] args) {
        int[] nums={2,7,4,1,8,1};
        System.out.println(lastStoneWeight(nums));

    }

    public static int lastStoneWeight(int[] stones) {
        int r=stones.length-1;
        for(;r>=1;r--){
            Arrays.sort(stones);
            stones[r-1]=stones[r]-stones[r-1];
        }
        return stones[0];
    }
}


