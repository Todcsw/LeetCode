#### [1550. 存在连续三个奇数的数组](https://leetcode-cn.com/problems/three-consecutive-odds/)

给你一个整数数组 `arr`，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 `true` ；否则，返回 `false` 

。



示例 1：

```
输入：arr = [2,6,4,1]
输出：false
解释：不存在连续三个元素都是奇数的情况。
```


示例 2：

```
输入：arr = [1,2,34,3,4,5,7,23,12]
输出：true
解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
```


提示：

```
1 <= arr.length <= 1000
1 <= arr[i] <= 1000
```

> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/three-consecutive-odds
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 解法一：

记原序列的长度为 nn。时间复杂度：O(n)。空间复杂度：O(1)。

```java
/**
     * 枚举所有的连续的三个元素，判断这三个元素是否都是奇数，如果是，则返回 true。如果所有的连续的三个元素中，没有一个满足条件，返回 false。
     * @param arr
     * @return
     */
    public static boolean threeConsecutiveOdds(int[] arr) {


        boolean flag=false;

        for(int i=0;i<arr.length-2;i++){
            if(arr[i]%2!=0&&arr[i+1]%2!=0&&arr[i+2]%2!=0) {
                flag = true;
            }
        }

        if(arr.length<3){
            flag=false;
        }

        return flag;
    }
```

