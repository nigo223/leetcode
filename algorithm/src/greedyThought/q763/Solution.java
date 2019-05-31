package greedyThought.q763;

import java.util.*;

/*
    字符串 S 由小写字母组成。
    我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。
    返回一个表示每个字符串片段的长度的列表。

    示例 1:

    输入: S = "ababcbacadefegdehijhklij"
    输出: [9,7,8]
    解释:
    划分结果为 "ababcbaca", "defegde", "hijhklij"。
    每个字母最多出现在一个片段中。
    像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
    注意:

    S的长度在[1, 500]之间。
    S只包含小写字母'a'到'z'。

    分析：
        贪心的思想：每次都找到局部最优解，最后得到全局最优解
        没做出来

*/
class Solution {
    public List<Integer> partitionLabels(String S) {
        // 先记录每个字符最后一次出现的位置
        int[] lastIndexOfChar = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndexOfChar[char2Index(S.charAt(i))] = i;
        }

        List<Integer> partitions = new ArrayList<>(); // 记录分区大小
        // 双指针遍历字符串
        int firstIndex = 0;
        while (firstIndex < S.length()) {
            int lastIndex = firstIndex;
            for (int i = firstIndex; i < S.length() && i <= lastIndex; i++) {
                int index = lastIndexOfChar[char2Index(S.charAt(i))]; // 当前字符最后一次出现的位置
                if (index > lastIndex) {
                    lastIndex = index;
                }
            }
            partitions.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }

        return partitions;





    }

    private int char2Index(char ch) {
        return ch - 'a';
    }
}
