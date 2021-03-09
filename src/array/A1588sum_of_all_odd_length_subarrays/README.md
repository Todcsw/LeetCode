#### [1588. 所有奇数长度子数组的和](https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/)

给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。

子数组 定义为原数组中的一个连续子序列。

请你返回 arr 中 所有奇数长度子数组的和 。

 

示例 1：

```
输入：arr = [1,4,2,5,3]
输出：58
解释：所有奇数长度子数组和它们的和为：
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
```


示例 2：

```
输入：arr = [1,2]
输出：3
解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
```


示例 3：

```
输入：arr = [10,11,12]
输出：66
```

> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



### 解法一：

使用三重循环,时间复杂度是 O(n^3) 的。

```java
	/**
     * 三重循环,第一重确定数组长度,第二重确定开始位置，最里面循环取值相加求和
     * @param arr
     * @return
     */
    public static int sumOddLengthSubarrays(int[] arr) {
        int i=1;
        int sum=0;
        while (i<=arr.length){
            for(int j=0;j<arr.length;j++){
                if(i+j<=arr.length){
                    for(int s=0;s<i;s++){
                        sum+=arr[s+j];
                    }
                }
            }
            i=i+2;
        }
        return sum;
    }
```

### 解法二：

时间复杂度O(n)

```api
* odd奇数，even偶数
* 对于每个元素i(数组中下标为i)来说，要构成奇数长度的子数组
  即 i左边的元素个数left+i本身自己一个+右边元素的个数right=奇数
  即 left+right=偶数
* 满足a+b=偶数就只有两种情况
  1. 奇数+奇数=偶数
  2. 偶数+偶数=偶数
* 1. 所以只需要求得i左边可以选择奇数长度的可能有多少种，即left_odd,同样求右边奇数right_odd
     就可以求出策略1有多少种可能
  2. 所以只需要求得i左边可以选择偶数长度的可能有多少种，即left_odd,同样求右边偶数right_odd
     就可以求出策略1有多少种可能，注意0也算选择的一种可能
* 即元素i在所有奇数长度子数组出现的次数总和是
  left_odd*right_odd+left_even*right_even
* 元素i左边元素共有i个，右边元素共有siz-i-1个
```

```java
	/**
     * 数学解法
     * @param arr
     * @return
     */
    public static int sumOddLengthSubarrays2(int[] arr) {

        int len = arr.length, res = 0;
        for(int i = 0; i < len; i ++){
            int LeftOdd = (i+1)/2, LeftEven = i/2+1;
            int RightOdd = (len-i)/2, RightEven = (len-1-i)/2+1;
            res += arr[i]*(LeftOdd*RightOdd + LeftEven*RightEven);
        }
        return res;
    }
```

