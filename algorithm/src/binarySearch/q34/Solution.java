package binarySearch.q34;

import java.util.Arrays;

/*
    给定一个按照升序排列的整数数组 nums，和一个目标值 target。
    找出给定目标值在数组中的开始位置和结束位置。

    你的算法时间复杂度必须是 O(log n) 级别。

    如果数组中不存在目标值，返回 [-1, -1]。

    示例 1:

    输入: nums = [5,7,7,8,8,10], target = 8
    输出: [3,4]
    示例 2:

    输入: nums = [5,7,7,8,8,10], target = 6
    输出: [-1,-1]

    分析：
        1、先做一次二分查找，找到有8的位置
        2、再分成两半，左边和右边分别二分查找，得到区间

*/
class Test {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 1;
        System.out.println(Arrays.toString(new Solution().searchRange(nums, target)));

    }
}


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        int m = 0;
        while (l <= h) {
            m = l + (h - l) / 2;
            if (nums[m] == target) {
                break;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        if (l > h) { // 没找到
            return new int[]{-1, -1};
        }

        int low = findLow(nums, l, m, target);
        int high = findHigh(nums, m, h, target);

        return new int[]{low, high};

    }

    private int findHigh(int[] nums, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return hi;

    }

    private int findLow(int[] nums, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}