package two_pointers.q633;

/*
    需求：给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。

        示例1:

        输入: 5
        输出: True
        解释: 1 * 1 + 2 * 2 = 5


        示例2:

        输入: 3
        输出: False

    分析：
        双指针的思想，low是1，high是Math.floor(Math.sqrt(c))

*/
class Solution
{
    public boolean judgeSquareSum(int c)
    {
        int low = 0;
        int high = (int) Math.floor(Math.sqrt(c));
        int sum = 0;

        while (low <= high)
        {
            sum = low * low + high * high;
            if (sum == c)
            {
                return true;
            }
            else if (sum > c)
            {
                high--;
            }
            else if (sum < c)
            {
                low++;
            }
        }
        return false;
    }
}
