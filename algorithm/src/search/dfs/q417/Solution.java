package search.dfs.q417;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。
    “太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。

    规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。

    请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。



    提示：
        输出坐标的顺序不重要
        m 和 n 都小于150


    示例：



    给定下面的 5x5 矩阵:

      太平洋 ~   ~   ~   ~   ~
           ~  1   2   2   3  (5) *
           ~  3   2   3  (4) (4) *
           ~  2   4  (5)  3   1  *
           ~ (6) (7)  1   4   5  *
           ~ (5)  1   1   2   4  *
              *   *   *   *   * 大西洋

    返回:

    [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).

    分析：
        对每个元素采用DFS，如果途径的一个已经是false，则表示该条线路是false。


*/
class Solution {
    private int row;
    private int col;
    private int[][] matrix;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> list = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return list;
        }

        row = matrix.length;
        col = matrix[0].length;
        this.matrix = matrix;
        boolean[][] canReachP = new boolean[row][col]; // 能否到达太平洋
        boolean[][] canReachA = new boolean[row][col]; // 能否到达大西洋

        for (int i = 0; i < row; i++) { // 遍历所有行
            dfs(i, 0, canReachP); // i行0列能否到达太平洋
            dfs(i, col - 1, canReachA); // i行col-1列能否到达大西洋
        }

        for (int i = 0; i < col; i++) {
            dfs(0, i, canReachP); // 0行i列能否到达太平洋
            dfs(row - 1, i, canReachA); // row-1行i列能否到达大西洋
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (canReachA[i][j] && canReachP[i][j]) {
                    list.add(new int[]{i, j});
                }
            }
        }

        return list;

    }

    private void dfs(int r, int c, boolean[][] canReach) {
        if (canReach[r][c]) {
            return;
        }
        canReach[r][c] = true;

        for (int[] d : direction) {
            int nextR = d[0] + r;
            int nextC = d[1] + c;
            if (nextR < 0 || nextR >= row || nextC < 0 || nextC >= col || matrix[r][c] > matrix[nextR][nextC]) {
                continue;
            }
            dfs(nextR, nextC, canReach);
        }

    }

}
