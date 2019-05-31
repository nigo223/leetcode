package two_pointers.q680;

/*
    需求：给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

        示例 1:

        输入: "aba"
        输出: True
        示例 2:

        输入: "abca"
        输出: True
        解释: 你可以删除c字符。
        注意:

        字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。

    分析：
        双指针遍历字符串


*/

class Test
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
        String str = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(s.validPalindrome(str));

    }
}

class Solution
{
    private boolean isPalindrome(String s)
    {
        for (int low = 0, high = s.length() - 1; low < high; )
        {
            if (s.charAt(low) != s.charAt(high))
            {
                return false;
            }
            else
            {
                low++;
                high--;
            }
        }
        return true;
    }


    public boolean validPalindrome(String s)
    {
        for (int low = 0, high = s.length(); low < high; )
        {
            char ch1 = s.charAt(low);
            char ch2 = s.charAt(high - 1);
            if (ch1 == ch2) // 遍历，字符相同，就继续
            {
                low++;
                high--;
            }
            else // 如果字符不同
            {
                return isPalindrome(s.substring(low + 1, high)) || isPalindrome(s.substring(low, high - 1));
            }
        }
        // 遍历完成，返回true
        return true;
    }
}
