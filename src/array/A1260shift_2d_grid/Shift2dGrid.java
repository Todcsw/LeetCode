package array.A1260shift_2d_grid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/16 21:59 星期二
 * @Description: array.A1260shift_2d_grid leetCode 1260.二维网格迁移
 * @version: 1.0
 */
public class Shift2dGrid {

    public static void main(String[] args) {
        int[][] grid={{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
        int k=4;

        List<List<Integer>> lists = shiftGrid(grid, k);

        for(List<Integer> list:lists){
            System.out.println(list.toString());
        }
    }

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


    /**
     * 解法二:第二种很好理解,先移动k次,然后再放进list集合中
     *
     * 方法一创建了 k 个新数组，本方法简化了该过程，在原地迁移。
     * 首先了解单个元素在数组中的移动，这是解决二维数组移动的基本策略。下面动画中黄色表示当前位置，数字表示移动的距离。
     *每一步都需要跟踪当前迁移值。在 Java 中，最后需要将输出复制到二维列表中操作。如果想在自己的代码中实现原地操作，可以设置相同的输入和输出类型。
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


}
