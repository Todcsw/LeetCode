package greedy.A1518water_bottles;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/25 13:40 星期四
 * @Description: greedy.A1518water_bottles
 * @version: 1.0
 */
public class WaterBottles {
    public static void main(String[] args) {
        int numBottles = 2, numExchange = 3;
        int i = numWaterBottles(numBottles, numExchange);
        System.out.println(i);
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int sum=numBottles;
        while(numBottles/numExchange!=0){
            sum+=numBottles/numExchange;
            numBottles=numBottles/numExchange+numBottles%numExchange;

        }
        return sum;
    }
}
