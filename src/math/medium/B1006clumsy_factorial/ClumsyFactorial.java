package math.medium.B1006clumsy_factorial;

import java.util.LinkedList;

/**
 * @Auther: 行路
 * @Email: 1759864302@qq.com
 * @Date: Created on 2021/4/1 20:57 星期四
 * @Description: 笨阶乘
 * @version: 1.0
 */
public class ClumsyFactorial {
    public static void main(String[] args) {
        System.out.println(clumsy(10));
    }

    public static int clumsy(int N) {
        LinkedList<Integer> stack=new LinkedList<Integer>();
        stack.push(N);
        N--;
        int index=0;
        while(N>0){
            if(index%4==0){
                stack.push(stack.pop()*N);
            }else if(index%4==1){
                stack.push(stack.pop()/N);
            }else if(index%4==2){
                stack.push(stack.pop()+N);
            }else {
                stack.push(-N);
            }
            index++;
            N--;
        }
        int sum=0;
        while (!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }


    /**
     * 数学解法
     * @param N
     * @return
     */
    public static int clumsy2(int N) {
        if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N == 3) {
            return 6;
        } else if (N == 4) {
            return 7;
        }

        if (N % 4 == 0) {
            return N + 1;
        } else if (N % 4 <= 2) {
            return N + 2;
        } else {
            return N - 1;
        }
    }

}
