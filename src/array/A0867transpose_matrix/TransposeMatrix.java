package array.A0867transpose_matrix;


/**
 * @Auther: 行路
 * @Date: Created on 2021/3/7 22:17 星期日
 * @Description: array.A0867transpose_matrix  leetcode867. 转置矩阵
 * @version: 1.0
 */
public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6}};
        /**
         * {1,2,3}    {1,4}
         * {4,5,6}    {2,5}
         *            {3,6}
         */
        transpose(matrix);
    }

    public static int[][] transpose(int[][] matrix) {


        int a=matrix.length; // a=2
        int b=matrix[0].length; //b=3
        int[][] out=new int[b][a];

        for(int i=0;i<b;i++){
            for(int j=0;j<a;j++){
                out[i][j]=matrix[j][i];
            }
        }
        return out;
    }
}

