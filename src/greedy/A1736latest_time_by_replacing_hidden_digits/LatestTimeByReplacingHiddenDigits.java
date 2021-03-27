package greedy.A1736latest_time_by_replacing_hidden_digits;

import java.util.HashMap;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/27 9:34 星期六
 * @Description: greedy.A1736latest_time_by_replacing_hidden_digits
 * @version: 1.0
 */
public class LatestTimeByReplacingHiddenDigits {
    public static void main(String[] args) {
        String time="?0:15";
        String s = maximumTime(time);
        System.out.println(s);
    }
    public static String maximumTime(String time) {

        char[] num=new char[5];
        for(int i=0;i<time.length();i++){
            if(time.charAt(i)=='?'){
                if(i==0){

                    if(time.charAt(i+1)<'4'||time.charAt(i+1)=='?'){
                        num[i]='2';
                    }else{
                        num[i]='1';
                    }


                }else if(i==1){
                    if(num[0]=='2'){
                        num[i]='3';

                    }else if(num[0]=='1'||num[0]=='0'){
                        num[i]='9';

                    }

                }else if(i==3){
                    num[i]='5';
                }else if(i==4){
                    num[i]='9';
                }

            }else{
                num[i]=time.charAt(i);
            }
        }
        String str=new String(num);
        return str;

    }
}
