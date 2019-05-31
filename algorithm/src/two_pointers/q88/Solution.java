package two_pointers.q88;

import java.util.Arrays;

/*
    需求：给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

        说明:

        初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
        你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
        示例:

        输入:
        nums1 = [1,2,3,0,0,0], m = 3
        nums2 = [2,5,6],       n = 3

        输出: [1,2,2,3,5,6]

    分析：
        用三个指针实现，
        数组nums1上两个指针：i=m-1,从后往前遍历元素，
                            k=m+n-1,从数组末尾往前找空位
        数组nums2上一个指针：j=n-1,从后往前遍历元素

        如果nums2[j] >= nums1[i]
            nums1[k]=nums2[j] k-- j--
        如果nums2[j] < nums1[i]
            nums1[k]=nums1[i] nums1[i]=nums2[j]
            k--,j--,i--

        循环条件，j>=0


*/
class Test
{
    public static void main(String[] args)
    {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        Solution so = new Solution();
        so.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

    }
}

class Solution
{
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        int index1 = m - 1;
        int index2 = n - 1;
        int mergerIndex = m + n - 1;

        while (index1 >= 0 || index2 >= 0) // 至少有一个数组没有扫描完成
        {
            if (index1 < 0) // nums1扫描完了，则直接将nums2合并过来
            {
                nums1[mergerIndex--] = nums2[index2--];
            }
            else if (index2 < 0) // nums2扫描完了，直接break
            {
                break;
            }
            else if (nums1[index1] <= nums2[index2]) // nums2中的数比较大，就把nums2中的数添加到末尾
            {
                nums1[mergerIndex--] = nums2[index2--];
            }
            else if (nums1[index1] > nums2[index2]) // nums1中的数比较大，就把nums1中的数添加到末尾
            {
                nums1[mergerIndex--] = nums1[index1--];
            }

        }

    }
}
