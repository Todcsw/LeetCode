#### [1266. 访问所有点的最小时间](https://leetcode-cn.com/problems/minimum-time-visiting-all-points/)



平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi] 。请你计算访问所有这些点需要的 最小时间（以秒为单位）。

你需要按照下面的规则在平面上移动：

每一秒内，你可以：
沿水平方向移动一个单位长度，或者
沿竖直方向移动一个单位长度，或者
跨过对角线移动 sqrt(2) 个单位长度（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
必须按照数组中出现的顺序来访问这些点。
在访问某个点时，可以经过该点后面出现的点，但经过的那些点不算作有效访问。


示例 1：

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/24/1626_example_1.png)



```
输入：points = [[1,1],[3,4],[-1,0]]
输出：7
解释：一条最佳的访问路径是： [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]   
从 [1,1] 到 [3,4] 需要 3 秒 
从 [3,4] 到 [-1,0] 需要 4 秒
一共需要 7 秒
```


示例 2：

```
输入：points = [[3,2],[-2,2]]
输出：5
```


提示：

```
points.length == n
1 <= n <= 100
points[i].length == 2
-1000 <= points[i][0], points[i][1] <= 1000
```

> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/minimum-time-visiting-all-points
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



### 解法一:

```java
   /**
     *
     * 这道题从某种程度上来说是道数学题,我们需要找到两点之间最小移动距离的规律,然后移动
     *
     * 两点之间横坐标的距离为dx,两点之间纵坐标的距离为dy
     *
     * 当dx == dy时
     * 当两点在一条斜率为1的直线上的话(此时dx=dy),那么两点之间移动的最短距离就是dx或者dy,也就是沿着这条直线移动
     * 当dx > dy时
     * 当两点不再斜率为1的直线上的话,那么可以从起始点开始按照在斜率为1的直线上移动方式移动,直到y坐标大于终点的y坐标时终止
     * 此时移动到现有位置的点与终点在同一条直线上,需要再移动相应的距离即可
     * 也就是说,首先移动的距离为dy;然后再移动dx - dy的距离;综合距离就是dy + (dx - dy) = dx;
     *
     * 当dx < dy时
     * 当两点不再斜率为1的直线上的话,那么可以从起始点开始按照在斜率为1的直线上移动方式移动,直到x坐标大于终点的x坐标时终止
     * 此时移动到现有位置的点与终点在同一条直线上,需要再移动相应的距离即可
     * 也就是说,首先移动的距离为dx;然后再移动dy - dx的距离;综合距离就是dx + (dy - dx) = dy;
     *
     * 综上所述:
     * 当dx >= dy时,最小距离为dx
     * 当dx < dy时,最小距离为dy
     *
     * 详细实现如代码所示
     *
     * @param points
     * @return
     */
    public static int minTimeToVisitAllPoints(int[][] points) {

        int sum = 0;
        for (int i = 0 , j = i + 1; j < points.length; i++,j++) {
            int x = Math.abs(points[j][0] - points[i][0]);
            int y = Math.abs(points[j][1] - points[i][1]);
            sum += y >= x ? y : x ;
        }
        return sum;

    }
```

 