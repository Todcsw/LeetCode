package array.A1672richest_customer_wealth;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/13 9:22 星期六
 *
 * 给你一个 m x n 的整数网格 accounts ，
 * 其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
 * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
 *
 * @Description: array.A1672richest_customer_wealth     leetCode 1672.最富有客户的资产总量
 * @version: 1.0
 */
public class RichestCustomerWealth {
    public static void main(String[] args) {
        int[][] accounts={{2,8,7},{7,1,3},{1,9,5}};
        System.out.println(maximumWealth(accounts));
    }

    /**
     * 循环遍历,累计求和比较
     * @param accounts
     * @return
     */
    public static int maximumWealth(int[][] accounts) {

        int max=Integer.MIN_VALUE;

        for(int i=0;i<accounts.length;i++){
            int count=0;
            for(int j=0;j<accounts[i].length;j++){
                count+=accounts[i][j];
            }
            if(count>max){
                max=count;
            }

        }

        return max;
    }
}
