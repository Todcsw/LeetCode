#### [605. 种花问题](https://leetcode-cn.com/problems/can-place-flowers/)



假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。

 

示例 1：

```
输入：flowerbed = [1,0,0,0,1], n = 1
输出：true
```


示例 2：

```
输入：flowerbed = [1,0,0,0,1], n = 2
输出：false
```


提示：

```
1 <= flowerbed.length <= 2 * 104
flowerbed[i] 为 0 或 1
flowerbed 中不存在相邻的两朵花
0 <= n <= flowerbed.length
```

> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/can-place-flowers
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



### 解法一：

时间复杂度O(n)

```java
/**
     * 自己解法。循环判断当三个中都是0则必然会种花,种完将0变成1.
     * 同时还要注意边界问题
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int num=0;

        /**
         * 该部分代码处理便捷问题
         */
        if(flowerbed.length>=3){
            if(flowerbed[0]==0&&flowerbed[1]==0){
                num++;
                flowerbed[0]=1;
            }
            if(flowerbed[flowerbed.length-1]==0&&flowerbed[flowerbed.length-2]==0){
                flowerbed[flowerbed.length-1]=1;
                num++;
            }
        }

        /**
         * 处理中间的问题
         */
        for(int i=1;i< flowerbed.length-2;i++){
            if(flowerbed[i]==0&&flowerbed[i-1]==0&&flowerbed[i+1]==0){
                num++;
                flowerbed[i]=1;
            }
            if(num>=n){
                return true;
            }
        }

        /**
         * 处理当数组小于3时的问题
         */
        if(flowerbed.length==1&&flowerbed[0]==0){
            num++;
        }
        if(flowerbed.length==2&&flowerbed[0]==0&&flowerbed[1]==0){
            num++;
        }

        //判断最终输出
        if(num>=n){
            return true;
        }


        return false;
    }
```



### 解法二：

```java
/**
     * 贪心解法
     */
    public static boolean canPlaceFlowers2(int[] flowerbed, int n) {

        int count = 0;
        int m = flowerbed.length;
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    count += i / 2;
                } else {
                    count += (i - prev - 2) / 2;
                }
                prev = i;
            }
        }
        if (prev < 0) {
            count += (m + 1) / 2;
        } else {
            count += (m - prev - 1) / 2;
        }
        return count >= n;
    }
```

