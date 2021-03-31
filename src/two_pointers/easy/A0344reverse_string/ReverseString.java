package two_pointers.easy.A0344reverse_string;

/**
 * @Auther: 行路
 * @Email: 1759864302@qq.com
 * @Date: Created on 2021/3/31 22:45 星期三
 * @Description:
 * @version: 1.0
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s={'H','a','n','n','a','h'};
        reverseString(s);
        for(int i=0;i<s.length;i++){
            System.out.println(s[i]);
        }
    }

    public static void reverseString(char[] s) {

        for(int i=0;i<s.length/2;i++){
            char a=s[i];
            s[i]=s[s.length-i-1];
            s[s.length-i-1]=a;
        }


    }
}
