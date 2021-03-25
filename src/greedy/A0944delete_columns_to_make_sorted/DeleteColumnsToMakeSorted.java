package greedy.A0944delete_columns_to_make_sorted;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/25 20:03 星期四
 * @Description: greedy.A0944delete_columns_to_make_sorted
 * @version: 1.0
 */
public class DeleteColumnsToMakeSorted {
    public static void main(String[] args) {

    }

    /**
     * 解题
     * @param strs
     * @return
     */
    public static int minDeletionSize(String[] strs) {
        int sum=0;
        for(int i=0;i<strs[0].length();i++){
            for(int j=0;j<strs.length-1;j++){
               if( strs[j].charAt(i)>strs[j+1].charAt(i)){
                   sum++;
                   break;
               }
            }
        }
        return sum;
    }
}
