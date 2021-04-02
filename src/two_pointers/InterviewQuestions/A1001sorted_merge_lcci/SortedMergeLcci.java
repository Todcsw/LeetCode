package two_pointers.InterviewQuestions.A1001sorted_merge_lcci;

import java.util.Arrays;

/**
 * @Auther: 行路
 * @Email: 1759864302@qq.com
 * @Date: Created on 2021/4/2 23:38 星期五
 * @Description:
 * @version: 1.0
 */
public class SortedMergeLcci {
    public static void main(String[] args) {

    }

    /**
     * 合并排序
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void merge(int[] A, int m, int[] B, int n) {
        for(int i=m,j=0;i<A.length;i++,j++){
            A[i]=B[j];
        }
        Arrays.sort(A);
    }

    /**
     * 双指针
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void merge2(int[] A, int m, int[] B, int n) {
        int pa = 0, pb = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (pa < m || pb < n) {
            if (pa == m) {
                cur = B[pb++];
            } else if (pb == n) {
                cur = A[pa++];
            } else if (A[pa] < B[pb]) {
                cur = A[pa++];
            } else {
                cur = B[pb++];
            }
            sorted[pa + pb - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            A[i] = sorted[i];
        }
    }
}
