package search.dfs.backtracking.q79;

/*
    给定一个二维网格和一个单词，找出该单词是否存在于网格中。

    单词必须按照字母顺序，通过相邻的单元格内的字母构成，
    其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
    同一个单元格内的字母不允许被重复使用。

    示例:

    board =
    [
      ['A','B','C','E'],
      ['S','F','C','S'],
      ['A','D','E','E']
    ]

    给定 word = "ABCCED", 返回 true.
    给定 word = "SEE", 返回 true.
    给定 word = "ABCB", 返回 false.

*/
class Solution {
    private final static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m;
    private int n;

    public boolean exist(char[][] board, String word) {
        // word为空，则返回true
        if (word == null || word.length() == 0) {
            return true;
        }
        // board为空，则返回false
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        m = board.length;
        n = board[0].length;
        boolean[][] hasVisited = new boolean[m][n]; // 记录是否已经有访问过了

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 遍历数组，有一个字符满足了条件，就返回true
                if (backtracking(0, i, j, hasVisited, board, word)) {
                    return true;
                }
            }
        }

        return false;

    }

    private boolean backtracking(int curLen, int i, int j, boolean[][] hasVisited, final char[][] board, final String word) {
        // 如果当前的长度已经和word的长度相等了，那么返回true
        if (curLen == word.length()) {
            return true;
        }
        // 如果当前数组越界、字符不等、已经访问过。就直接返回false
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(curLen) || hasVisited[i][j]) {
            return false;
        }

        hasVisited[i][j] = true; // 将当前的位置标记为已访问
        for (int[] d : directions) {
            if (backtracking(curLen + 1, i + d[0], j + d[1], hasVisited, board, word)) {
                return true;
            }
        }
        hasVisited[i][j] = false; // 将当前的位置重新标记为未访问

        return false;
    }

}
