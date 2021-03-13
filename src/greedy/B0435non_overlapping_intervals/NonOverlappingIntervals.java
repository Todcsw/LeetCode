package greedy.B0435non_overlapping_intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/12 8:45 星期五
 *
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 * @Description: greedy.B0435non_overlapping_intervals leetCode 435.无重叠区间
 * @version: 1.0
 */
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] num={{1,2}, {2,3}, {3,4}, {1,3}};
        int i = eraseOverlapIntervals(num);
        System.out.println(i);
    }

    /**
     * 贪心解法
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }
}
