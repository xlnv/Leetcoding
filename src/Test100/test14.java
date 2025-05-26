package Test100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test14 {
    public static void main(String[] args) {
        /*
        以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
        请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
        示例 1：
        输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        输出：[[1,6],[8,10],[15,18]]
        解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
         */
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] mergedIntervals = merge(intervals);
        System.out.println(Arrays.deepToString(mergedIntervals));
    }

    public static int[][] merge(int[][] intervals) {
        // 如果区间数组为空，直接返回空数组
        if (intervals.length == 0) return new int[0][];

        //1.将区间按照起点进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        //2. 初始化一个列表，用于保持合并之后的区间
        ArrayList<int[]> merged = new ArrayList<>();

        //3.遍历每一个区间
        for (int[] interval : intervals) {
            //如果合并列表为空，或者当前区间与前一个区间不重叠，直接添加
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]){
                merged.add(interval);
            }else {
                //否则，当前区间和前一个区间重叠，进行合并
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1],interval[1]);
            }
        }
        //4.将结果转为二维数组并返回
        return merged.toArray(new int[merged.size()][]);

    }
}
