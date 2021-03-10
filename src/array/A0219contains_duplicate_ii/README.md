#### [219. 存在重复元素 II](https://leetcode-cn.com/problems/contains-duplicate-ii/)

给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

 

示例 1:

```
输入: nums = [1,2,3,1], k = 3
输出: true
```


示例 2:

```
输入: nums = [1,0,1,1], k = 1
输出: true
```


示例 3:

```
输入: nums = [1,2,3,1,2,3], k = 2
输出: false
```

> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



### 解法一：

#### 思路

用散列表来维护这个k大小的滑动窗口。

#### 算法

在之前的方法中，我们知道了对数时间复杂度的 搜索 操作是不够的。在这个方法里面，我们需要一个支持在常量时间内完成 搜索，删除，插入 操作的数据结构，那就是散列表。这个算法的实现跟方法二几乎是一样的。

遍历数组，对于每个元素做以下操作：
在散列表中搜索当前元素，如果找到了就返回 true。
在散列表中插入当前元素。
如果当前散列表的大小超过了 kk， 删除散列表中最旧的元素。
返回 false。



#### 复杂度分析

时间复杂度：O(n)
我们会做 n 次 搜索，删除，插入 操作，每次操作都耗费常数时间。

空间复杂度：O(\min(n, k))
开辟的额外空间取决于散列表中存储的元素的个数，也就是滑动窗口的大小 O(\min(n,k))。



```java
/**
     * 利用固定窗口滑动机制,一次遍历。
     * 创建一个set固定其的大小,超过大小移除第一个数
     * 否则继续添加元素。固定的set中包含有该数则返回true;
     * 否则遍历结束返回false;
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<nums.length;i++){

            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size()>k) {
                set.remove(nums[i-k]);
            }
        }

        return false;
    }
```

