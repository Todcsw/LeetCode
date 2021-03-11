package greedy.A0455assign_cookies;

import java.util.Arrays;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/11 10:03 星期四
 * @Description: greedy.A0455assign_cookies leetCode 455.分发饼干
 * @version: 1.0
 */
public class AssignCookies {
    public static void main(String[] args) {

        int[] num={1,2,3};
        int[] s={1,1};

        System.out.println(findContentChildren(num,s));

    }

    /**
     * 排序加贪心算法
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        int child=0,cookie=0;
        while(child<g.length&&cookie<s.length){
            if(g[child]<=s[cookie]){
                child++;
            }
            cookie++;
        }
        return child;
    }
}
