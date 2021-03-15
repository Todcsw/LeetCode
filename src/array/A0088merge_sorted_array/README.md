#### [88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)



给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。

 

示例 1：

```
输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
```


示例 2：

```
输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]
```


提示：

```
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[i] <= 109
```

> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/merge-sorted-array
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



### 解法一:双指针

```java
    /**
     * 解法一
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
            for(int i=m;i<m+n;i++){
                nums1[i]=Integer.MAX_VALUE;
            }

            for(int i=0,j=0;i<nums1.length&&j<nums2.length;){
                if(nums1[i]<=nums2[j]){
                    i++;
                }else{

                    for(int x=m+n-1;x>i;x--){ //i=2
                        nums1[x]=nums1[x-1];
                    }
                    nums1[i]=nums2[j];
                    j++;

                }
            }
            System.out.println(Arrays.toString(nums1));
    }
```



### 解法二：先合并,再排序


```java
   /**
     * 解法二:
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {


        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
```


### 解法三：双指针 时间O(N+M)，空间O（M）

```java
   /**
     * 解法三
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {


            // Make a copy of nums1.
            int [] nums1_copy = new int[m];
            System.arraycopy(nums1, 0, nums1_copy, 0, m);

            // Two get pointers for nums1_copy and nums2.
            int p1 = 0;
            int p2 = 0;

            // Set pointer for nums1
            int p = 0;

            // Compare elements from nums1_copy and nums2
            // and add the smallest one into nums1.
            while ((p1 < m) && (p2 < n))
                nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

            // if there are still elements to add
            if (p1 < m)
                System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
            if (p2 < n)
                System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);


        System.out.println(Arrays.toString(nums1));
    }

```

### 解法四：双指针 时间O(N+M)，空间O（1）

```java
   /**
     * 解法四
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge4(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);


    }
```

