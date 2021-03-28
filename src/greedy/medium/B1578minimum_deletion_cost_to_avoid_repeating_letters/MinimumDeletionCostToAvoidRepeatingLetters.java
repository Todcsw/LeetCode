package greedy.medium.B1578minimum_deletion_cost_to_avoid_repeating_letters;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/28 8:36 星期日
 * @Description: greedy.medium.B1578minimum_deletion_cost_to_avoid_repeating_letters
 * @version: 1.0
 */
public class MinimumDeletionCostToAvoidRepeatingLetters {
    public static void main(String[] args) {
        String s="aaabbbabbbb";
        int[] cost={3,5,10,7,5,3,5,5,4,8,1};
        int i = minCost(s, cost);
        System.out.println(i);
        int i1 = minNum(7, 11, cost);
        System.out.println(i1);
    }

    /**
     * 在java提交中击败百分之12
     * 可能采用贪心,求局部相同的元素个数,求和去除最大值
     * @param s
     * @param cost
     * @return
     */
    public static int minCost(String s, int[] cost) {

        int sum=0;
        for(int i=0;i<s.length();){
            int a=i;
            while(i<s.length()-1&&s.charAt(i)==s.charAt(i+1)){

                i++;
            }
            i++;
            int b=i;
            sum+=minNum(a,b,cost);
        }

        return sum;

    }

    public static int minNum(int a,int b,int[] cost){
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(;a<b;a++){
            if(cost[a]>max){
                max=cost[a];
            }
            sum+=cost[a];
        }
        return sum-max;
    }


    public static int minCost2(String s, int[] cost) {

        int i = 0, len = s.length();
        int ret = 0;
        while (i < len) {
            char ch = s.charAt(i);
            int maxValue = 0;
            int sum = 0;

            while (i < len && s.charAt(i) == ch) {
                maxValue = Math.max(maxValue, cost[i]);
                sum += cost[i];
                i++;
            }
            ret += (sum - maxValue);
        }
        return ret;


    }

}
