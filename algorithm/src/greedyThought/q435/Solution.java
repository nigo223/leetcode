package greedyThought.q435;

import java.util.Arrays;
import java.util.Comparator;

/*
    给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

    注意:

    可以认为区间的终点总是大于它的起点。
    区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
    示例 1:

    输入: [ [1,2], [2,3], [3,4], [1,3] ]

    输出: 1

    解释: 移除 [1,3] 后，剩下的区间没有重叠。
    示例 2:

    输入: [ [1,2], [1,2], [1,2] ]

    输出: 2

    解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
    示例 3:

    输入: [ [1,2], [2,3] ]

    输出: 0

    解释: 你不需要移除任何区间，因为它们已经是无重叠的了。

    分析：
        1、如果数组长度是0或1，直接返回0
        2、对Interval进行排序，按照start从小到大，start相同，则按照end从小到大
        3、用currentEnd记录当前的end值，从第二个元素遍历该数组，
            if重叠，修改currentEnd，j++
            else，j++，count++
        4、返回count

*/
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

class Test {
    public static void main(String[] args) {
        Interval[] intervals = {new Interval(1, 2)
                , new Interval(2, 3), new Interval(3, 4), new Interval(1, 3)};
        System.out.println(new Solution().eraseOverlapIntervals(intervals));
    }
}

class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        /*Arrays.sort(intervals, (o1, o2) -> o1.start != o2.start
                ? o1.start - o2.start
                : o1.end - o2.end);
        */
        // 只需要按照end排序即可
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.end));

        int count = 0;
        int currentEnd = Integer.MIN_VALUE;

        for (Interval interval : intervals) {
            if (interval.end > currentEnd) { // 区间没有重叠
                currentEnd = interval.end;
            } else { // 区间重叠
                count++;
            }
        }
        return count;
    }
}
