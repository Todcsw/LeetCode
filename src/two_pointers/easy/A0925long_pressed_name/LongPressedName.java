package two_pointers.easy.A0925long_pressed_name;

/**
 * @Auther: 行路
 * @Email: 1759864302@qq.com
 * @Date: Created on 2021/4/1 22:21 星期四
 * @Description: leetCode 925.长按键入
 * @version: 1.0
 */
public class LongPressedName {
    public static void main(String[] args) {
        String name="vtkgn";
        String typed="vttkgnn";
        boolean longPressedName = isLongPressedName(name, typed);
        System.out.println(longPressedName);
    }

    /**
     * 双指针解法
     * @param name
     * @param typed
     * @return
     */
    public static boolean isLongPressedName(String name, String typed) {

        int j=0;
        for(int i=0;i<name.length();){
            if(j<typed.length()&&name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }else if(j<typed.length()&&j>=1&&typed.charAt(j-1)==typed.charAt(j)){
                j++;
            }else{
                return false;
            }
        }

        for(int i=j;i<=typed.length()-1;i++){
            if(typed.charAt(i)!=name.charAt(name.length()-1)){
                return false;
            }


        }

        return true;
    }


    /**
     * 官方双指针
     * @param name
     * @param typed
     * @return
     */
    public static boolean isLongPressedName2(String name, String typed) {

        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();

    }




}
