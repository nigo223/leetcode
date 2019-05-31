package two_pointers.q345;

import java.util.Arrays;
import java.util.HashSet;

/*
    需求：编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

        示例 1:

        输入: "hello"
        输出: "holle"
        示例 2:

        输入: "leetcode"
        输出: "leotcede"
        说明:
        元音字母不包含字母"y"。

    分析：
        双指针

*/
class Test
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.reverseVowels("hello"));
    }
}

class Solution
{
    private boolean isVowel(char ch)
    {
        return ch == 'a' || ch == 'A' ||
                ch == 'e' || ch == 'E' ||
                ch == 'i' || ch == 'I' ||
                ch == 'o' || ch == 'O' ||
                ch == 'u' || ch == 'U';
    }
    public String reverseVowels(String s)
    {
        char[] chars = s.toCharArray();

        for (int low = 0, high = chars.length - 1; low < high; )
        {
            if (!isVowel(chars[low])) // low下标处不是元音，且没有越界
            {
                low++;
                continue;
            }
            if (!isVowel(chars[high])) // high下标处不是元音，且没有越界
            {
                high--;
                continue;
            }
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }

        return new String(chars);
    }
}

// 答案版
// 用HashSet存储来判断会比较费时间
/*
class Solution
{
    // 用private static final 修饰HashSet
    private final static HashSet<Character> vowels =
            new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s)
    {
        char[] chars = s.toCharArray();

        for (int low = 0, high = chars.length - 1; low < high; )
        {
            if (!vowels.contains(chars[low])) // low下标处不是元音，且没有越界
            {
                low++;
                continue;
            }
            if (!vowels.contains(chars[high])) // high下标处不是元音，且没有越界
            {
                high--;
                continue;
            }
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }

        return new String(chars);
    }
}
*/