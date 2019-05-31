package dynamicPlanning.q64;

/*
    给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

    说明：每次只能向下或者向右移动一步。

    示例:

    输入:
    [
      [1,3,1],
      [1,5,1],
      [4,2,1]
    ]
    输出: 7
    解释: 因为路径 1→3→1→1→1 的总和最小。

*/
class Test {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 3, 1, 4},
                {1, 5, 1, 3},
                {4, 2, 1, 5}
        };
        // int[][] nums = null;
        System.out.println(new Solution().minPathSum(nums));

    }
}

/*
class Solution {
    public int minPathSum(int[][] grid) {
        // 网格为空或行为0或列为0，则直接返回零
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length; // 行
        int n = grid[0].length; // 列
        int[][] minValues = new int[m][n]; // 存储每个节点的最小值

        for (int step = 0; step < m + n - 1; step++) {
            for (int i = 0; i < m; i++) {
                int j = step - i;
                if (j >= 0 && j < n) { // j合法
                    if (i == 0 && j == 0) {
                        minValues[i][j] = grid[i][j];
                        continue;
                    }
                    int pre1 = i == 0 ? Integer.MAX_VALUE : minValues[i - 1][j];
                    int pre2 = j == 0 ? Integer.MAX_VALUE : minValues[i][j - 1];
                    minValues[i][j] = Math.min(pre1, pre2) + grid[i][j];
                }
            }
        }
        return minValues[m - 1][n - 1];
    }
}
*/

// 答案
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j != 0) {
                    if (i == 0) {
                        dp[j] = dp[j - 1];
                    } else {
                        dp[j] = Math.min(dp[j - 1], dp[j]);
                    }
                }
                dp[j] += grid[i][j];
            }
        }
        return dp[n - 1];
    }
}