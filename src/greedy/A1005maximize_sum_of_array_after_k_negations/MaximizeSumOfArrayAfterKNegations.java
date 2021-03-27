package greedy.A1005maximize_sum_of_array_after_k_negations;

import java.util.Arrays;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/27 9:29 星期六
 * @Description: greedy.A1005maximize_sum_of_array_after_k_negations
 * @version: 1.0
 */
public class MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        int[] a={2,-3,-1,5,-4};
        int k=2;
        int i = largestSumAfterKNegations(a, k);
        System.out.println(i);
    }

    public static int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        for(int i=0;i<A.length;i++){
            if(A[i]<0&&K>0){
                A[i]=A[i]*(-1);
                K--;
            }
        }
        Arrays.sort(A);
        if(K%2==1){
            A[0]=A[0]*-1;
        }
        int sum=0;
        for(int a:A){
            sum+=a;
        }
        return sum;
    }
}
