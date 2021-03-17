#### [1260. 二维网格迁移](https://leetcode-cn.com/problems/shift-2d-grid/)



给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。

每次「迁移」操作将会引发下述活动：

位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
请你返回 k 次迁移操作后最终得到的 二维网格。

 

示例 1：

```
输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
输出：[[9,1,2],[3,4,5],[6,7,8]]
```

示例 2：



```
输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
```


示例 3：

```
输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
输出：[[1,2,3],[4,5,6],[7,8,9]]
```


提示：

```
m == grid.length
n == grid[i].length
1 <= m <= 50
1 <= n <= 50
-1000 <= grid[i][j] <= 1000
0 <= k <= 100
```

> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/shift-2d-grid
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

解法一:

```java
/**
     * 第一种解法
     *
     * 重复 k次迁移操作。
     * 算法
     * 迁移过程一共有 3 种情况。为了确保理解正确，下面使用 3 张图说明每种情况。
     * 元素 grid[i][j] 迁移到 grid[i][j + 1]。
     *
     *
     * @param grid
     * @param k
     * @return
     */
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {



        // Repeat the transform k times.
        for (;k > 0; k--) {
            // We'll write the transform into a new 2D array.
            int[][] newGrid = new int[grid.length][grid[0].length];

            // Case #1: Move everything not in the last column.
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length - 1; col++) {
                    newGrid[row][col + 1] = grid[row][col];
                }
            }

            // Case #2: Move everything in last column, but not last row.
            for (int row = 0; row < grid.length - 1; row++) {
                newGrid[row + 1][0] = grid[row][grid[0].length - 1];
            }

            // Case #3: Move the bottom right.
            newGrid[0][0] = grid[grid.length - 1][grid[0].length - 1];

            // Update grid to be the transformed grid.
            grid = newGrid;
        }

        // Copy the grid into a list for returning.
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> listRow = new ArrayList<>();
            result.add(listRow);
            for (int v : row) listRow.add(v);
        }

        return result;

    }
```



### 解法二:

```java
	/**
     * 解法二:第二种很好理解,先移动k次,然后再放进list集合中
     *
     * 方法一创建了 k 个新数组，本方法简化了该过程，在原地迁移。
     * 首先了解单个元素在数组中的移动，这是解决二维数组移动的基本策略。下面动画中黄色表示当前位置，数字表示移动的距离。
     *每一步都需要跟踪当前迁移值。在 Java 中，最后需要将输出复制到二维列表中操作。如果想在自己的代码中实现原地操作，可以设置相同	   *的输入和输出类型。
     *
     * @param grid
     * @param k
     * @return
     */
    public static List<List<Integer>> shiftGrid2(int[][] grid, int k) {

        // Repeat the transform k times.
        for (;k > 0; k--) {

            int previous = grid[grid.length - 1][grid[0].length - 1];
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    int temp = grid[row][col];
                    grid[row][col] = previous;
                    previous = temp;
                }
            }
        }
		
        // Copy the grid into a list for returning.
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : grid) {
            
            List<Integer> listRow = new ArrayList<>();
            
            result.add(listRow);
            
            for (int v : row) listRow.add(v);
        }

        return result;
    }
```

