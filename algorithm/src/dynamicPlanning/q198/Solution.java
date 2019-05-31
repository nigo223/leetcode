package dynamicPlanning.q198;

import java.util.Arrays;

/*
    你是一个专业的小偷，计划偷窃沿街的房屋。
    每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
    如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

    给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

    示例 1:

    输入: [1,2,3,1]
    输出: 4
    解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
         偷窃到的最高金额 = 1 + 3 = 4 。
    示例 2:

    输入: [2,7,9,3,1]
    输出: 12
    解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
         偷窃到的最高金额 = 2 + 9 + 1 = 12 。

*/
class Test {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        System.out.println(new Solution().rob(nums));
    }
}

/*
太笨拙了
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        int[] maxValues = new int[len];

        maxValues[0] = nums[0];
        maxValues[1] = nums[1];

        for (int i = 2; i < len; i++) {
            if (i == 2) {
                maxValues[2] = nums[0] + nums[2];
            } else { // i>=3时
                maxValues[i] = bigger(maxValues[i - 2], maxValues[i - 3]) + nums[i];
            }
        }

        return bigger(maxValues[len - 1], maxValues[len - 2]);

    }

    private int bigger(int a, int b) {
        return a > b ? a : b;
    }
}
*/

// 答案
class Solution{
    public int rob(int[] nums) {
        int pre2 = 0; // 设置两个虚的pre，从而不用判断0或是1的情形了
        int pre1 = 0;

        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }

        return pre1;
    }
}