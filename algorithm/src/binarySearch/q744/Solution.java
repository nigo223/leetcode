package binarySearch.q744;

/*
    给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。

    数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。

    示例:

    输入:
    letters = ["c", "f", "j"]
    target = "a"
    输出: "c"

    输入:
    letters = ["c", "f", "j"]
    target = "c"
    输出: "f"

    输入:
    letters = ["c", "f", "j"]
    target = "d"
    输出: "f"

    输入:
    letters = ["c", "f", "j"]
    target = "g"
    输出: "j"

    输入:
    letters = ["c", "f", "j"]
    target = "j"
    输出: "c"

    输入:
    letters = ["c", "f", "j"]
    target = "k"
    输出: "c"
    注:

    letters长度范围在[2, 10000]区间内。
    letters 仅由小写字母组成，最少包含两个不同的字母。
    目标字母target 是一个小写字母。

    分析：
        有序的小写字母集合，所以采用二分查找法
        因为是循环数组，相当于如果找不到比target大的字符，就返回char[0]即可

*/
class Test {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'k';
        System.out.println(new Solution().nextGreatestLetter(letters, target));

    }
}

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int lo = 0, hi = len - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (letters[mid] <= target) { // 当前的字符小于等于目标，就继续在后面查找，即查找到第一个比target大的字符
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        // lo<len，表示找到了目标，就返回letters[lo]
        // 不然，表示没有找到，就返回letters[0]
        return lo < len ? letters[lo] : letters[0];

    }
}
