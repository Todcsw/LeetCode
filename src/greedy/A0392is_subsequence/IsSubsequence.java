package greedy.A0392is_subsequence;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/25 13:28 星期四
 * @Description: greedy.A0392is_subsequence
 * @version: 1.0
 */
public class IsSubsequence {
    public static void main(String[] args) {
        String s="a";
        String t="ahbgdc";
        boolean subsequence = isSubsequence(s, t);
        System.out.println(subsequence);
    }

    /**
     * 双指针
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }
        for(int i=0,j=0;i<t.length();){
            if(s.charAt(j)==t.charAt(i)){
                j++;
                if(j==s.length()){
                    return true;
                }
            }
            i++;
        }


        return false;
    }
}
