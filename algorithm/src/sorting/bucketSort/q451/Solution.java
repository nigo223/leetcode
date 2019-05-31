package sorting.bucketSort.q451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    需求：给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

        示例 1:

        输入:
        "tree"

        输出:
        "eert"

        解释:
        'e'出现两次，'r'和't'都只出现一次。
        因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
        示例 2:

        输入:
        "cccaaa"

        输出:
        "cccaaa"

        解释:
        'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
        注意"cacaca"是不正确的，因为相同的字母必须放在一起。
        示例 3:

        输入:
        "Aabb"

        输出:
        "bbAa"

        解释:
        此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
        注意'A'和'a'被认为是两种不同的字符。

    分析：
        先遍历字符串，用一个map来记录每个字符出现的频率
        将字符频率和字符数放进桶里面
        倒序遍历桶，如果桶非空，就加入到字符串里面

*/

class Test
{
    public static void main(String[] args)
    {
        Solution so = new Solution();
        System.out.println(so.frequencySort("tree"));

    }
}


class Solution
{
    public String frequencySort(String s)
    {
        // 先遍历字符串，用一个map来记录每个字符出现的频率
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 将字符频率和字符数放进桶里面
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (Character ch : map.keySet())
        {
            int frequency = map.get(ch);
            // 桶里放的是ArrayList对象，所以要先判断非空
            if (buckets[frequency] == null)
            {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(ch);
        }

        // 倒序遍历桶，如果桶非空，就加入到字符串里面
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--)
        {
            if (buckets[i] != null)
            {
                for (Character ch : buckets[i])
                {
                    for (int j = 0; j < i; j++)
                    {
                        sb.append(ch);
                    }
                }
            }
        }

        return sb.toString();

    }
}