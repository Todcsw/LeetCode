#### [628. 三个数的最大乘积](https://leetcode-cn.com/problems/maximum-product-of-three-numbers/)



给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

 

示例 1：

```
输入：nums = [1,2,3]
输出：6
```


示例 2：

```
输入：nums = [1,2,3,4]
输出：24
```


示例 3：

```
输入：nums = [-1,-2,-3]
输出：-6
```


提示：

```
3 <= nums.length <= 104
-1000 <= nums[i] <= 1000
```

> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 解法一：

先给数组排序找出最大的三个数和最小的两个数时间复杂度：O(NlogN)，其中 N为数组长度。排序需要 O(NlogN) 的时间。

空间复杂度：O(logN)，主要为排序的空间开销。

```java
/**
     * 先排序然后比较最大的三个数或者是最小的2个数乘以最大的一个正数
     * @param nums
     * @return
     */
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[nums.length-3]*nums[nums.length-2]*nums[nums.length-1],nums[0]*nums[1]*nums[nums.length-1]);
    }
```

### 解法二：

在方法一中，我们实际上只要求出数组中最大的三个数以及最小的两个数，因此我们可以不用排序，用线性扫描直接得出这五个数。

时间复杂度：O(N)，其中 NN 为数组长度。我们仅需遍历数组一次。

空间复杂度：O(1)。

```java
public static int maximumProduct2(int[] nums) {
        // 最小的和第二小的数
        Integer min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;

        // 最大的和第二大的和第三大的数
        Integer max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE;

        for(Integer num:nums){
            if(num<min1){
                min2=min1;
                min1=num;
            }else if(num<min2){
                min2=num;
            }

            if(num>max1){
                max3=max2;
                max2=max1;
                max1=num;
            }else if(num>max2){
                max3=max2;
                max2=num;
            }else if(num>max3){
                max3=num;
            }

        }
        return Math.max(max3*max2*max1,min1*min2*max1);
```

