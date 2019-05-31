package sorting.bucketSort.q347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/*
    给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

    示例 1:

    输入: nums = [1,1,1,2,2,3], k = 2
    输出: [1,2]
    示例 2:

    输入: nums = [1], k = 1
    输出: [1]
    说明：

    你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
    你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。

    分析：
        桶排序 List<Integer>[] bucket = new ArrayList[nums.length-1];

*/
class Solution
{
    public List<Integer> topKFrequent(int[] nums, int k)
    {

        // 数字和数量的映射
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
        {
            /*
            if (map.containsKey(num))
            {
                map.replace(num, map.get(num) + 1);
            }
            else
            {
                map.put(num, 1);
            }
            */
            // 用map的getOrDefault()方法改进
            map.put(num, map.getOrDefault(num, 0) + 1); // 有就加1，没有就0

        }

        // 设置一个桶
        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (Integer num : map.keySet())
        {
            int count = map.get(num);
            if (buckets[count] == null)
            {
                buckets[count] = new ArrayList<>(); // 如果当前桶为空，需要新建一个ArrayList对象，否则会NullPointerException
            }
            buckets[count].add(num);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && ans.size() < k; i--)
        {
            if (buckets[i] != null)
            {
                ans.addAll(buckets[i]);
            }
        }

        return ans;

    }
}
