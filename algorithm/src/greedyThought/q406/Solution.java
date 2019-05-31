package greedyThought.q406;

import java.net.Socket;
import java.util.*;

/*
    假设有打乱顺序的一群人站成一个队列。
    每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
    编写一个算法来重建这个队列。

    注意：
    总人数少于1100人。

    示例

    输入:
    [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

    输出:
    [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

    分析：
        1、排序，按照身高从低到高，k从大到小排序（k从小到大是为了让先放入的元素对后放入的元素没有影响）
        2、新建一个二维数组，遍历，循环，直到找到第k个空位，插入元素

*/
class Test {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        int[][] ints = new Solution().reconstructQueue(people);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }

    }

}


class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 排序
        /*
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0]
                        ? o1[0] - o2[0]
                        : o2[1] - o1[1];
            }
        });
        */

        /*
        int len = people.length;
        int[][] ans = new int[len][];

        for (int[] p : people) {
            int count = 0;
            for (int i = 0; i < len; i++) {
                // 遍历目标数组
                if (ans[i] == null) { // 若当前位置没有元素
                    if (count == p[1]) { // 且当前的count和当前人的位置相同，就插入
                        ans[i] = p;
                        break;
                    } else { // 有空位但和位置不同，则count++
                        count++;
                    }
                }
            }
        }
        */

        // 用ArrayList改进

        // 按照身高从高到低，排位从小到大排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0]
                        ? o2[0] - o1[0]
                        : o1[1] - o2[1];
            }
        });

        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p); // 在指定位置之前插入元素
        }
        return list.toArray(new int[list.size()][]);
    }
}