package binarySearch.q69;

/*
    实现 int sqrt(int x) 函数。

    计算并返回 x 的平方根，其中 x 是非负整数。

    由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

    示例 1:

    输入: 4
    输出: 2
    示例 2:

    输入: 8
    输出: 2
    说明: 8 的平方根是 2.82842...,
         由于返回类型是整数，小数部分将被舍去。

    分析：
        使用二分查找法查找开方根


*/
class Test {
    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println(new Solution().mySqrt(x));

    }
}

class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int lo = 1, hi = x;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int sqrt = x / mid;
            if (mid == sqrt) {
                return mid;
            } else if (mid > sqrt) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }
}
