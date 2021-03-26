package greedy.A1710maximum_units_on_a_truck;

import java.util.Arrays;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/26 13:02 星期五
 * @Description: greedy.A1710maximum_units_on_a_truck
 * @version: 1.0
 */
public class MaximumUnitsOnATruck {
    public static void main(String[] args) {
        int[][] boxType={{5,10},{2,5},{4,7},{3,9}};
        int[][] boxType1={{1,3},{2,2},{3,1}};
        int truckSize=10;
        int i = maximumUnits(boxType1, 4);
        System.out.println(i);
    }

    /**
     * 冒泡排序
     * @param boxTypes
     * @param truckSize
     * @return
     */
    public static int maximumUnits(int[][] boxTypes, int truckSize) {

        int[] nums=null;
        int sum=0;
        int n=boxTypes.length-1;


        for(int i=0;i<boxTypes.length;i++){


            for(int j=0;j<boxTypes.length-i-1;j++){
                if(boxTypes[j][1]>boxTypes[j+1][1]){
                    nums=boxTypes[j+1];
                    boxTypes[j+1]=boxTypes[j];
                    boxTypes[j]=nums;

                }
            }

            if(truckSize-boxTypes[n][0]>0){
                sum=sum+boxTypes[n][0]*boxTypes[n][1];
                truckSize=truckSize-boxTypes[n][0];
            }else{
                sum=sum+truckSize*boxTypes[n][1];
                break;
            }
            n--;

        }


        return sum;

    }
}
