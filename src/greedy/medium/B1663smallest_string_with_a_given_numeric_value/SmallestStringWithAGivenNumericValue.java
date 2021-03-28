package greedy.medium.B1663smallest_string_with_a_given_numeric_value;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/28 10:27 星期日
 * @Description: greedy.medium.B1663smallest_string_with_a_given_numeric_value
 * @version: 1.0
 */
public class SmallestStringWithAGivenNumericValue {
    public static void main(String[] args) {
        String smallestString = getSmallestString(3, 27);
        System.out.println(smallestString);
    }

    public static String getSmallestString(int n, int k) {
        StringBuilder ans=new StringBuilder();
        for (int rest = n; rest >= 1; --rest) {
            int bound = k - 26 * (rest - 1);
            if (bound > 0) {
                ans.append((char)(bound + 'a' - 1));
                k -= bound;
            }
            else {
                ans.append('a');
                k -= 1;
            }
        }
        return ans.toString();

    }
}
