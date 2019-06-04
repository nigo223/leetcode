package dynamicPlanning.longestIncreasingSubsequence.q300;

/*
    给定一个无序的整数数组，找到其中最长上升子序列的长度。

    示例:

    输入: [10,9,2,5,3,7,101,18]
    输出: 4
    解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
    说明:

    可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
    你算法的时间复杂度应该为 O(n2) 。
    进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

    分析：

 */
/*class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { // 满足递增条件
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                } else {
                    dp[i] = Math.max(1, dp[i]);
                }
            }
        }

        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = ans > dp[i] ? ans : dp[i];
        }

        return ans;
    }
}*/

import java.util.Arrays;

// 答案写法
/*class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int maxValue = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxValue = Math.max(maxValue, dp[j] + 1);
                }
            }
            dp[i] = maxValue;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans > dp[i] ? ans : dp[i];
        }

        return ans;
    }
}*/

// 优化解法 O(NlogN)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int len = 0;
        for (int num : nums) {
            int index = binarySearch(tails, len, num);
            tails[index] = num;
            if (index == len) {
                len++;
            }
        }
        return len;
    }

    private int binarySearch(int[] tails, int len, int key) {
        int l = 0, h = len;
        while (l < h) {
            int mid = l + (h - 1) / 2;
            if (tails[mid] == key) {
                return mid;
            } else if (tails[mid] > key) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }


}
















