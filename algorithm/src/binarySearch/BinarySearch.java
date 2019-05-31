package binarySearch;

public class BinarySearch {
    /**
     * 二分查找法
     * @param nums
     * @param key
     * @return
     */
    public int binarySearch(int[] nums, int key) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            // 之所以不用mid=(hi+lo)/2这种方式，是为了防止加法溢出
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] > key) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
