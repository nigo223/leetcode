package binarySearch.q540;

/*
    给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。

    示例 1:

    输入: [1,1,2,3,3,4,4,8,8]
    输出: 2
    示例 2:

    输入: [3,3,7,7,10,11,11]
    输出: 10

    注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。

    分析：
        要求O(log n)的时间复杂度，所以采用二分查找法，
        二分查找，根据序号来判断在左边还是右边
        如果一个数相邻两边都不想等，那就是所求
        奇+左等或偶+右等       右移
        奇+右等或偶+左等       左移

*/
class Test {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 2, 2, 5, 5};
        System.out.println(new Solution().singleNonDuplicate(nums));
    }
}

class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int lo = 0, hi = nums.length;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid == 0 || mid == nums.length - 1) { // mid到了边界，说明就是所求
                return nums[mid];
            } else if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) // 奇+左等或偶+右等。右移
                    || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                lo = mid + 1;
            } else if ((mid % 2 == 1 && nums[mid] == nums[mid + 1]) // 奇+右等或偶+左等，左移
                    || (mid % 2 == 0 && nums[mid] == nums[mid - 1])) {
                hi = mid - 1;
            }
        }
        return -1;

    }
}
