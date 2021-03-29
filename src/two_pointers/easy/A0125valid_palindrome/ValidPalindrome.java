package two_pointers.easy.A0125valid_palindrome;

/**
 * @Auther: 行路
 * @Email: 1759864302@qq.com
 * @Date: Created on 2021/3/29 20:41 星期一
 * @Description:
 * @version: 1.0
 */
public class ValidPalindrome {
    public static void main(String[] args) {

    }

    public static boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }

    /**
     * 双指针,一前一后移动
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s) {

        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

}
