package two_pointers.easy.A0844backspace_string_compare;

/**
 * @Auther: 行路
 * @Email: 1759864302@qq.com
 * @Date: Created on 2021/3/31 23:28 星期三
 * @Description:
 * @version: 1.0
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
      String  S = "ab#c", T = "ad#c";
      System.out.println(build(S).equals(build(T)));
    }

    //方法一：重构字符串
    public static String build(String str) {
        StringBuffer ret = new StringBuffer();

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!='#'){
                ret.append(str.charAt(i));
            }else{
                if(ret.length()>0){
                    ret.deleteCharAt(ret.length() -1);
                }
            }
        }

        return ret.toString();
    }

    /**
     * 双指针
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}

