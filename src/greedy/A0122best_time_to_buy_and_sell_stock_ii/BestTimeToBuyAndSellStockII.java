package greedy.A0122best_time_to_buy_and_sell_stock_ii;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/24 23:34 星期三
 * @Description: greedy.A0122best_time_to_buy_and_sell_stock_ii
 * @version: 1.0
 */
public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int[] price={7,1,5,3,6,4};
        int i = maxProfit(price);
        System.out.println(i);
    }

    /**
     * 贪心解法,遇涨就卖,遇跌就不卖
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int count=0;
        for(int i=1;i<prices.length;i++){
            int a=prices[i]-prices[i-1];
            if(a>0){
                count=a+count;
            }
        }
        return count;
    }
}
