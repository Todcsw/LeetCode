package greedy.A0860lemonade_change;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/25 19:26 星期四
 * @Description: greedy.A0860lemonade_change
 * @version: 1.0
 */
public class LemonadeChange {

    public static void main(String[] args) {
        int[] bill={5,5,5,10,20};
        boolean b = lemonadeChange(bill);
        System.out.println(b);
    }

    /**
     * 据说是增删改查解法
     * @param bills
     * @return
     */
    public static boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;

        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }else if(bills[i]==10){
                if(five>=1){
                    five--;
                    ten++;
                }else{
                    return false;
                }
            }else{
                if(five>=1&&ten>=1){
                    five--;
                    ten--;
                }else if(five>=3){
                    five=five-3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
