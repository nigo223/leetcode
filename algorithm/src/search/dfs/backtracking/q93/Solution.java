package search.dfs.backtracking.q93;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

    示例:

    输入: "25525511135"
    输出: ["255.255.11.135", "255.255.111.35"]

*/
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> addresses = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        doRestore(0, sb, addresses, s);

        return addresses;

    }

    private void doRestore(int k, StringBuilder sb, List<String> addresses, String s) {
        if (k == 4 || s.length() == 0) { // k记录划分的个数
            if (k == 4 && s.length() == 0) {
                addresses.add(sb.toString()); // 如果划分为4个且长度为0，则成功添加
            }
            return; // 没有成功划分，直接返回
        }

        for (int i = 0; i < s.length() && i <= 2; i++) { // 在一位或是和三位之间遍历
            if (i != 0 && s.charAt(0) == '0') { // 若是不是第一位且第一位为0，则直接break
                break;
            }
            String part = s.substring(0, i + 1);
            if (Integer.valueOf(part) <= 255) {
                if (sb.length() != 0) {
                    part = "." + part;
                }
                sb.append(part);
                doRestore(k + 1, sb, addresses, s.substring(i + 1)); // k+1，递归深入
                sb.delete(sb.length() - part.length(), sb.length()); // 回溯
            }
        }

    }

}
