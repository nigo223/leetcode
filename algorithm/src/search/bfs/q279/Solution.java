package search.bfs.q279;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
    你需要让组成和的完全平方数的个数最少。

    示例 1:

    输入: n = 12
    输出: 3
    解释: 12 = 4 + 4 + 4.
    示例 2:

    输入: n = 13
    输出: 2
    解释: 13 = 4 + 9.

*/
class Test {
    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(13));
    }
}

class Solution {
    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n); // 产生一个平方序列
        Queue<Integer> queue = new LinkedList<>(); // 用一个队列来记录当前层的节点
        boolean[] marked = new boolean[n + 1]; // 用来标记当前节点是否被访问过
        queue.add(n); // 将n加入队列
        marked[n] = true; // 将n标记为true
        int level = 0; // 层数为0
        while (!queue.isEmpty()) { // 队列非空
            int size = queue.size(); // 得到队列长度
            level++; // 层数加1
            while (size-- > 0) { // 遍历队列中的元素
                int cur = queue.poll(); // 得到队列中的当前值
                for (int s : squares) { // 遍历平方数组
                    int next = cur - s; // next记录差值
                    if (next < 0) { // next小于0，说明遍历完成，break
                        break;
                    }
                    if (next == 0) { // next等于0，说明找到了最佳方案，返回层数
                        return level;
                    }
                    if (marked[next]) { // 如果next已经找过，继续遍历
                        continue;
                    }
                    marked[next] = true;
                    queue.add(cur - s);

                }
            }
        }
        return n;

    }

    /**
     * 生成小于n的平方数序列
     * @param n
     * @return
     */
    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }


}
