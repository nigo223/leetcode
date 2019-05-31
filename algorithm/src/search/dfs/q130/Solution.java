package search.dfs.q130;

import sun.java2d.pipe.SolidTextRenderer;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

    找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

    示例:

    X X X X
    X O O X
    X X O X
    X O X X
    运行你的函数后，矩阵变为：

    X X X X
    X X X X
    X X X X
    X O X X
    解释:

    被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
     任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
     如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

    分析：
        遍历四周，将所有沾到边的块都先dfs变成'T'，
        再顺序遍历数组，将'O'变成'X'，将'T'变成'O'即可

 */
class Test {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        new Solution().solve(board);
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }

    }
}

class Solution {
    private int row;
    private int col;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        row = board.length;
        col = board[0].length;

        // dfs四周的块，将所有触及到边的'O'先变成'T'
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0);
            dfs(board, i, col - 1);
        }
        for (int i = 0; i < col; i++) {
            dfs(board, 0, i);
            dfs(board, row - 1, i);
        }

        // 遍历矩阵，将所有T变成O，所有O变成X
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'T';
        for (int[] d : direction) {
            dfs(board, i + d[0], j + d[1]);
        }
    }


}