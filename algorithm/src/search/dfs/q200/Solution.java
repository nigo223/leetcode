package search.dfs.q200;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
    一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
    你可以假设网格的四个边均被水包围。

    示例 1:

    输入:
    11110
    11010
    11000
    00000

    输出: 1
    示例 2:

    输入:
    11000
    11000
    00100
    00011

    输出: 3

*/
class Test {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'0', '0', '1', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '0', '0', '0'},
                {'0', '1', '1', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '1', '0', '0', '1', '1', '0', '0', '1', '0', '1', '0', '0'},
                {'0', '1', '0', '0', '1', '1', '0', '0', '1', '1', '1', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0'}};
        System.out.println(new Solution().numIslands(grid));

    }
}


class Solution {

    private int row;
    private int col;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        row = grid.length; // 行
        col = grid[0].length; // 列
        int cnt = 0; // 岛屿数量

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != '0') {
                    dfs(grid, i, j); // 一次dfs，将所有与当前节点相连的地都置为'0'
                    cnt++;
                }
            }
        }

        return cnt;

    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0'; // 直接将该处的字符数组标记为'0'
        for (int[] d : direction) {
            dfs(grid, i + d[0], j + d[1]);
        }
    }
}
