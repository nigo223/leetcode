package search.dfs.q547;

/*
    班上有 N 名学生。其中有些人是朋友，有些则不是。
    他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。
    所谓的朋友圈，是指所有朋友的集合。

    给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。
    如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。
    你必须输出所有学生中的已知的朋友圈总数。

    示例 1:

    输入:
    [[1,1,0],
     [1,1,0],
     [0,0,1]]
    输出: 2
    说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
    第2个学生自己在一个朋友圈。所以返回2。
    示例 2:

    输入:
    [[1,1,0],
     [1,1,1],
     [0,1,1]]
    输出: 1
    说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
    注意：

    N 在[1,200]的范围内。
    对于所有学生，有M[i][i] = 1。
    如果有M[i][j] = 1，则有M[j][i] = 1。

    分析：
        dfs，返回区域数量。

*/
class Test {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}};
        System.out.println(new Solution().findCircleNum(nums));

    }
}


class Solution {
    private int n;

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }

        int cnt = 0;
        n = M.length;

        for (int i = 0; i < n; i++) {
            if (M[i][i] != 0) { // 当前的学生没有访问过
                dfs(M, i); // 一次dfs，将所有与当前节点关联的节点都置为0
                cnt++;
            }
        }
        return cnt;

    }

    private void dfs(int[][] m, int i) {
        if (m[i][i] == 0) {
            return;
        }
        m[i][i] = 0; // 当前访问学生置为0
        for (int j = 0; j < n; j++) {
            if (m[i][j] == 1 && m[j][j] == 1) { // 学生j与i有关联,且j没有访问过
                dfs(m, j);
            }
        }

    }
}
