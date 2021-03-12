package array.A0832flipping_an_image;

import java.util.Arrays;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/11 10:52 星期四
 * @Description: array.A0832flipping_an_image leetCode 832.翻转图像
 * @version: 1.0
 */
public class FlippingAnImage {
    public static void main(String[] args) {

        int[][] num={{1,1,0},{1,0,1},{0,0,0}};
        int[][] ints = flipAndInvertImage(num);
        for(int i=0;i<ints.length;i++){
            System.out.println(Arrays.toString(ints[i]));
        }

        System.out.println();

    }

    /**
     * 循环遍历翻转三目运算来判断0和1,时间复杂度过长
     * @param image
     * @return
     */
    public static int[][] flipAndInvertImage(int[][] image) {
        int[][] image2=new int[image.length][image[0].length];
        for(int i=0;i<image.length;i++){
            for(int j=image[i].length-1,k=0;j>=0&&k<image[i].length;j--,k++){
                image2[i][j]=(image[i][k]==0)?1:0;
            }
        }
        return image2;
    }

    /**
     * 循环遍历翻转使用位运算来翻转
     * @param image
     * @return
     */
    public static int[][] flipAndInvertImage2(int[][] image) {
        int[][] image2=new int[image.length][image[0].length];
        for(int i=0;i<image.length;i++){
            for(int j=image[i].length-1,k=0;j>=0&&k<image[i].length;j--,k++){
                image2[i][j]=(image[i][k]^=1);
            }
        }
        return image2;
    }

    /**
     * 模拟优化 + 双指针 + 位运算
     * @param image
     * @return
     */
    public static int[][] flipAndInvertImage3(int[][] image) {
        int n = image.length;
            for (int i = 0; i < n; i++) {
                int left = 0, right = n - 1;
                while (left < right) {
                    if (image[i][left] == image[i][right]) {
                        image[i][left] ^= 1;
                        image[i][right] ^= 1;
                    }
                    left++;
                    right--;
                }
                if (left == right) {
                    image[i][left] ^= 1;
                }
            }
            return image;
    }

}
