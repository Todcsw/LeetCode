package greedy.C0135candy;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/12 8:11 星期五
 * @Description: greedy.C0135candy  leetCode 135.分发糖果
 * @version: 1.0
 */
public class Candy {
    public static void main(String[] args) {
        int[] num={1,0,2};
        int candy = candy(num);
        System.out.println(candy);
    }

    /**
     *
     * 我们可以将「相邻的孩子中，评分高的孩子必须获得更多的糖果」这句话拆分为两个规则，分别处理。
     * 左规则：当 {ratings}[i - 1] < {ratings}[i] 时，i 号学生的糖果数量将比 i−1 号孩子的糖果数量多。
     * 右规则：当 {ratings}[i] > {ratings}[i + 1] 时，i号学生的糖果数量将比 i+1 号孩子的糖果数量多。
     * 我们遍历该数组两次，处理出每一个学生分别满足左规则或右规则时，最少需要被分得的糖果数量。
     * 每个人最终分得的糖果数量即为这两个数量的最大值。
     * 具体地，以左规则为例：我们从左到右遍历该数组，假设当前遍历到位置 i，如果有 ratings[i−1]<ratings[i] 那么 i 号学生的糖果数量将比i−1 号孩子的糖果数量多，
     * 我们令 {left}[i] ={left}[i - 1] + 1 即可，否则我们令 \{left}[i] = 1。
     *
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {

        int n = ratings.length;

        int[] left = new int[n];

        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }


        int right = 0, ret = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }

            ret += Math.max(left[i], right);
        }
        return ret;

    }
}
