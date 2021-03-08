#### [977. 有序数组的平方](https://leetcode-cn.com/problems/squares-of-a-sorted-array/)

给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

示例 1：

```
输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]
```

示例 2：

```
输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]
```


提示：

```
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 已按 非递减顺序 排序
```

##### 解法一：

先数字平方再排序

```java
public static int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
}
```

```
时间复杂度：O(nlog n)，其中 n是数组 nums 的长度。
空间复杂度：O(log n)。除了存储答案的数组以外，我们需要 O(log n)的栈空间进行排序
```

##### 解法二：

通过前后双指针进行移动比较插入新数组

```java
public static int[] sortedSquares2(int[] nums) {
        int length=nums.length;

        int[] num=new int[length];

        for(int i=0,j=length-1,pos=length-1;i<=j;){
            if(nums[i]*nums[i]>nums[j]*nums[j]){
                num[pos]=nums[i]*nums[i];
                i++;
            }else{
                num[pos]=nums[j]*nums[j];
                j--;
            }
            pos--;
        }
        return num;

}
```

```
时间复杂度：O(n)
空间复杂度：O(1)
```

