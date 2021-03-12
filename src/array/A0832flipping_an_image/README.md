#### [832. 翻转图像](https://leetcode-cn.com/problems/flipping-an-image/)

给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。

水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。

反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。

 

示例 1：

```
输入：[[1,1,0],[1,0,1],[0,0,0]]
输出：[[1,0,0],[0,1,0],[1,1,1]]
解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
```


示例 2：

```
输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
```


提示：

```
1 <= A.length = A[0].length <= 20
0 <= A[i][j] <= 1
```

> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/flipping-an-image
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



### 解法一：

```java
	/**
     * 循环遍历翻转三目运算来判断0和1,时间复杂度过长
     * @param image
     * @return
     */
    public static int[][] flipAndInvertImage(int[][] image) {
        int[][] image2=new int[image.length][image[0].length];
        for(int i=0;i<image.length;i++){
            for(int j=image[i].length-1,k=0;j>=0&&k<image[i].length;j--,k++){
                image2[i][j]=(image[i][k]==0)?1:0;
            }
        }
        return image2;
    }
```



### 解法二：

```java
	/**
     * 循环遍历翻转使用位运算来翻转
     * @param image
     * @return
     */
    public static int[][] flipAndInvertImage2(int[][] image) {
        int[][] image2=new int[image.length][image[0].length];
        for(int i=0;i<image.length;i++){
            for(int j=image[i].length-1,k=0;j>=0&&k<image[i].length;j--,k++){
                image2[i][j]=(image[i][k]^=1);
            }
        }
        return image2;
    }
```



### 解法三：

```java
	/**
     * 模拟优化 + 双指针 + 位运算
     * @param image
     * @return
     */
    public static int[][] flipAndInvertImage3(int[][] image) {
        int n = image.length;
            for (int i = 0; i < n; i++) {
                int left = 0, right = n - 1;
                while (left < right) {
                    if (image[i][left] == image[i][right]) {
                        image[i][left] ^= 1;
                        image[i][right] ^= 1;
                    }
                    left++;
                    right--;
                }
                if (left == right) {
                    image[i][left] ^= 1;
                }
            }
            return image;
    }
```

