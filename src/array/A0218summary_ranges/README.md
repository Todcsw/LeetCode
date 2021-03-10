#### [228. 汇总区间](https://leetcode-cn.com/problems/summary-ranges/)

给定一个无重复元素的有序整数数组 nums 。

返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。

列表中的每个区间范围 [a,b] 应该按如下格式输出：

"a->b" ，如果 a != b
"a" ，如果 a == b


示例 1：

```
输入：nums = [0,1,2,4,5,7]
输出：["0->2","4->5","7"]
解释：区间范围是：
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
```


示例 2：

```
输入：nums = [0,2,3,4,6,8,9]
输出：["0","2->4","6","8->9"]
解释：区间范围是：
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
```


示例 3：

```
输入：nums = []
输出：[]
```


示例 4：

```
输入：nums = [-1]
输出：["-1"]
```


示例 5：

```
输入：nums = [0]
输出：["0"]
```


提示：

```
0 <= nums.length <= 20
-231 <= nums[i] <= 231 - 1
nums 中的所有值都 互不相同
nums 按升序排列
```

> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/summary-ranges
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



### 解法一：

按照自己的思想写的解法,时间复杂度过高

```java
/**
     * 循环判读太多
     * @param nums
     * @return
     */
    public static List<String> summaryRanges(int[] nums) {
        ArrayList<String> list=new ArrayList<>();

        if(nums.length==0){
            return list;
        }

        if(nums.length==1){
            list.add(nums[0]+"");
            return list;
        }

        int i=0;
        int count=0;
        String s;
        while( i<nums.length-1){
            if(nums[i]+1==nums[i+1]){
                count++;
            }else{
                if(count>=1){
                    s=nums[(i-count)]+"->"+nums[i];

                }else{
                    s=nums[i]+"";
                }
                list.add(s);
                count=0;
            }
            i++;
        }
        if(count>=1){
            list.add(nums[(i-count)]+"->"+nums[i]);
        }else{
            list.add(nums[nums.length-1]+"");
        }


        return list;
    }
```

### 解法二：

- 时间复杂度：O(n)，其中 n为数组的长度。
- 空间复杂度：O(1)。除了用于输出的空间外，额外使用的空间为常数。

```java
/**
     *
     *我们从数组的位置0出发,向有遍历。每次遇到相邻元素之间的差值大于1时，我们就找到了一个区间。
     *遍历完数组之后,就能得到一系列的区间的列表。
     *在遍历过程中,维护小标low和high分别记录区间的起点和终点,对于任何区间都有low<=high.当得到一个
     * 区间时,根据low 和high的值生成区间的字符串表示。
     * 当low <high时,区间的字符串表示为low->high
     * 当low =high时,区间的字符串表示为low
     * @param nums
     * @return
     */
    public static List<String> summaryRanges2(int[] nums) {

        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }
```

