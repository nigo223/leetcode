package two_pointers.q524;

import java.util.List;

/*
    需求：
        给定一个字符串和一个字符串字典，找到字典里面最长的字符串，
        该字符串可以通过删除给定字符串的某些字符来得到。
        如果答案不止一个，返回长度最长且字典顺序最小的字符串。
        如果答案不存在，则返回空字符串。

        示例 1:

        输入:
        s = "abpcplea", d = ["ale","apple","monkey","plea"]

        输出:
        "apple"
        示例 2:

        输入:
        s = "abpcplea", d = ["a","b","c"]

        输出:
        "a"
        说明:

        所有输入的字符串只包含小写字母。
        字典的大小不会超过 1000。
        所有输入的字符串长度不会超过 1000。

*/

class Solution
{
    /*
        判断某字符串是否可以通过给定串删除字符得到
    */
    private boolean check(String s, String target)
    {
        // 改进版的判断
        int start = -1;
        for (char c : target.toCharArray())
        {
            int index;
            if ((index = s.indexOf(c, start + 1)) == -1)
            {
                return false;
            }
            start = index; // 记录找到该字符的位置
        }
        return true;
    }

    public String findLongestWord(String s, List<String> d)
    {
        String ans = "";
        for (String ss : d)
        {
            int l1 = ans.length();
            int l2 = ss.length();
            if (l1 > l2 || (l1 == l2 && ans.compareTo(ss) < 0))
            {
                continue;
            }
            if (check(s, ss))
            {
                ans = ss;
            }

        }
        return ans;
    }
}