package two_pointers.InterviewQuestions.A1721volume_of_histogram_lcci;

/**
 * @Auther: 行路
 * @Email: 1759864302@qq.com
 * @Date: Created on 2021/4/2 23:18 星期五
 * @Description:
 * @version: 1.0
 */
public class VolumeOfHistogramLcci {


    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trap(height);
        System.out.println(trap);
    }


    public static int trap(int[] height) {
        int sum = 0;
        for(int i = 0;i<height.length;i++) {
            sum += height[i];
        }//求数组总和
        int volume = 0; // 总体积和高度初始化
        int high = 1;
        int size = height.length;
        int left = 0; // 双指针初始化
        int right = size - 1;
        while (left <= right) {
            while (left <= right && height[left] < high) {
                left++;
            }
            while (left <= right && height[right] < high) {
                right--;
            }
            volume += right - left + 1; // 每一层的容量都加起来
            high++; // 高度加一
        }
        return volume -sum; // 总体积减去柱子体积，即雨水总量
    }
}

