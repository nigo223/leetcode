package search.dfs.q695;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    给定一个包含了一些 0 和 1的非空二维数组 grid ,
    一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
    你可以假设二维矩阵的四个边缘都被水包围着。

    找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)

    示例 1:

    [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     [0,0,0,0,0,0,0,1,1,1,0,0,0],
     [0,1,1,0,1,0,0,0,0,0,0,0,0],
     [0,1,0,0,1,1,0,0,1,0,1,0,0],
     [0,1,0,0,1,1,0,0,1,1,1,0,0],
     [0,0,0,0,0,0,0,0,0,0,1,0,0],
     [0,0,0,0,0,0,0,1,1,1,0,0,0],
     [0,0,0,0,0,0,0,1,1,0,0,0,0]]
    对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。

    示例 2:

    [[0,0,0,0,0,0,0,0]]
    对于上面这个给定的矩阵, 返回 0。

    注意: 给定的矩阵grid 的长度和宽度都不超过 50。

    分析：
        遍历这个矩阵，采用深度优先搜索遍历，遍历过程中对遍历过的进行标记，
        没有标记过的就加上个数，最后返回个数最大的个数。

*/
class Test {
    public static void main(String[] args) {
//        int[][] grid = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}};
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(new Solution().maxAreaOfIsland(grid));
    }
}

class Solution {

    private int row;
    private int col;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        row = grid.length;
        col = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 0) {
                    cnt = Math.max(cnt, dfs(grid, i, j));
                }
            }
        }
        return cnt;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int area = 1; // 递归前记录当前为1
        for (int[] d : direction) {
            area += dfs(grid, i + d[0], j + d[1]); // 边递归边累加area
        }
        return area; // 返回area
    }
}
