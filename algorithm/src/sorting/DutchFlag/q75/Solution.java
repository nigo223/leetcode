package sorting.DutchFlag.q75;

import org.junit.Test;

import java.util.Arrays;

/*
    需求：给定一个包含红色、白色和蓝色，一共 n 个元素的数组，
        原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

        此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

        注意:
        不能使用代码库中的排序函数来解决这道题。

        示例:

        输入: [2,0,2,1,1,0]
        输出: [0,0,1,1,2,2]
        进阶：

        一个直观的解决方案是使用计数排序的两趟扫描算法。
        首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
        你能想出一个仅使用常数空间的一趟扫描算法吗？O(n)

    分析：
        定义三个指针，zero、one、two
        zero记录当前的左边的0的边界
        two记录当前的右边的2的边界
        one在数组中遍历，如果遇到0，就和zero进行交换；如果遇到2，就和two进行交换；

*/
public class Solution
{
    public void sortColors(int[] nums)
    {
        for (int zero = -1, one = 0, two = nums.length; one < two; )
        {
            if (nums[one] == 1)
            {
                one++;
            }
            else if (nums[one] == 0)
            {
                swap(nums, ++zero, one++); // 只跟zero进行交换时指针才后移
            }
            else if (nums[one] == 2)
            {
                swap(nums, --two, one);
            }
        }

    }

    private void swap(int[] nums, int index1, int index2)
    {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
