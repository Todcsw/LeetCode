#### [747. 至少是其他数字两倍的最大数](https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/)

在一个给定的数组nums中，总是存在一个最大元素 。

查找数组中的最大元素是否至少是数组中每个其他数字的两倍。

如果是，则返回最大元素的索引，否则返回-1。

示例 1:

```
输入: nums = [3, 6, 1, 0]
输出: 1
解释: 6是最大的整数, 对于数组中的其他整数,
6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
```


示例 2:

```
输入: nums = [1, 2, 3, 4]
输出: -1
解释: 4没有超过3的两倍大, 所以我们返回 -1.
```


提示:

```
nums 的长度范围在[1, 50].
每个 nums[i] 的整数范围在 [0, 100].
```

> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。





### 解法一:

```java
/**
     * 解法一:先排序,判断最大数是否大于等于二大数的二倍
     * 在遍历找出最大数的小标
     * @param nums
     * @return
     */
    public static int dominantIndex(int[] nums) {

        int[] clone = nums.clone();
        if(nums.length==1){
            return 0;
        }

        Arrays.sort(nums);

        if(nums[nums.length-1]>=nums[nums.length-2]*2){
            for(int i=0;i<clone.length;i++){
                if(clone[i]==nums[nums.length-1]){
                    return i;
                }
            }
        }

        return -1;

    }
```



### 解法二:

```java
	/**
     * 解法二:方法：线性扫描
     *
     * 扫描数组找到唯一的最大元素 m，并记录它的索引 maxIndex。
     * 再次扫描数组，如果我们找到 x != m，m < 2*x，我们应该返回 -1。
     * 否则返回 maxIndex
     *
     * @param nums
     * @return
     */
    public static int dominantIndex2(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i])
                return -1;
        }
        return maxIndex;
    }
```



