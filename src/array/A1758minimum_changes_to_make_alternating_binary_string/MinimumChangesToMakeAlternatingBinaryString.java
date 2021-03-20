package array.A1758minimum_changes_to_make_alternating_binary_string;

import static java.lang.Math.min;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/19 15:01 星期五
 * @Description: array.A1758minimum_changes_to_make_alternating_binary_string leetCode 1758.生成交替二进制字符串的最少操作数
 * @version: 1.0
 */
public class MinimumChangesToMakeAlternatingBinaryString {
    public static void main(String[] args) {
        String s="11110111";
        System.out.println(minOperations(s));

    }

    public static int minOperations(String s) {

        int n=s.length(),cnt1=0,cnt2=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)%2!=i%2)  cnt1++;
            else cnt2++;
        }
        return Math.min(cnt1,cnt2);



    }

    public int minOperations2(String s) {
        char[] sChars = s.toCharArray();
        int length = sChars.length;
        int count1 = 0;
        int count2 = 0;

        for(int i=0;i<sChars.length;i++){
            if(i%2==0){
                if(sChars[i]=='0'){
                    count1++;
                }else{
                    count2++;
                }
            }else{
                if(sChars[i]=='1'){
                    count1++;
                }else{
                    count2++;
                }
            }
        }

        return count1<count2?count1:count2;

    }
}
