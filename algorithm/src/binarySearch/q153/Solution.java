package binarySearch.q153;

import java.util.Arrays;

/*
    假设按照升序排序的数组在预先未知的某个点上进行了旋转。

    ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

    请找出其中最小的元素。

    你可以假设数组中不存在重复元素。

    示例 1:

    输入: [3,4,5,1,2]
    输出: 1
    示例 2:

    输入: [4,5,6,7,0,1,2]
    输出: 0

    分析：
        二分法

*/
class Test {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(new Solution().findMin(nums));
    }
}


class Solution {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}
