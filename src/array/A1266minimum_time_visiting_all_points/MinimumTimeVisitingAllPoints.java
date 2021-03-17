package array.A1266minimum_time_visiting_all_points;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/17 12:45 星期三
 * @Description: array.A1266minimum_time_visiting_all_points leetCode 1266.访问所有点的最小时间
 * @version: 1.0
 */
public class MinimumTimeVisitingAllPoints {

    public static void main(String[] args) {
        int[][] points={{1,1},{3,4},{-1,0}};
        System.out.println(minTimeToVisitAllPoints(points));
    }

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
}
