package greedy.A1716calculate_money_in_leetcode_bank;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/26 14:18 星期五
 * @Description: greedy.A1716calculate_money_in_leetcode_bank
 * @version: 1.0
 */
public class CalculateMoneyInLeetcodeBank {
    public static void main(String[] args) {

    }

    /**
     * 找规律
     * @param n
     * @return
     */
    public static int totalMoney(int n) {
        int a=n/7;
        int b=n%7;
        if(a==0){
            return n*(n+1)/2;
        }else if(a==1&&b==0){
            return 28*a;
        }else if(a==1&&b!=0){
            return 28*a+(a+1+b+a)*b/2;
        }else if(a>1&&b==0){
            return 28*a+(a-1)*a/2*7;
        }else{
            return 28*a+(a-1)*a/2*7+(a+1+b+a)*b/2;
        }
    }

    public static int totalMoney2(int n) {
        int sum=0,week=0,offset=0;
        for(int i=0;i<n;i++){
            week=i/7;
            offset=i%7+1;
            sum+=week+offset;
        }
        return sum;
    }

    public static int totalMoney3(int n){
        return 28*(n/7)+ (((n/7)*(n/7-1))/2)*7+ (n/7)*(n%7) + (((n%7)*(n%7+1))/2);
    }
}
