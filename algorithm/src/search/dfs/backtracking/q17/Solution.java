package search.dfs.backtracking.q17;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。


    示例:

    输入："23"
    输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

*/
class Test {
    public static void main(String[] args) {
        new Solution().letterCombinations("23456");

    }
}

class Solution {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return combinations;
        }

        doCombination(new StringBuilder(), combinations, digits);
        return combinations;
    }

    private void doCombination(StringBuilder prefix, List<String> combinations, String digits) {
        if (prefix.length() == digits.length()) { // 找到指定长度的字符串了，就添加进combinations
            combinations.add(prefix.toString());
            return;
        }
        int curDigits = digits.charAt(prefix.length()) - '0';
        String letters = KEYS[curDigits];
        for (char c : letters.toCharArray()) {
            prefix.append(c);                           // 添加
            doCombination(prefix, combinations, digits);
            prefix.deleteCharAt(prefix.length() - 1);   // 删除
        }
    }

}