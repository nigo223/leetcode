package dynamicPlanning.q91;

/*
    一条包含字母 A-Z 的消息通过以下方式进行了编码：

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    给定一个只包含数字的非空字符串，请计算解码方法的总数。

    示例 1:

    输入: "12"
    输出: 2
    解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
    示例 2:

    输入: "226"
    输出: 3
    解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */

/*
class Test {
    public static void main(String[] args) {
        String s = "0";
        System.out.println(new Solution().numDecodings(s));
    }
}

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] arr = generateArr(s.length());
        int ans = 0;
        int cnt = 0;

        // 最前面的0、3-9是没用的，进行剔除
        int index = 0;
        while (index < s.length() && s.charAt(index) == '0') {
            index++;
        }
        if (s.length() == index) {
            return 0;
        }

        while (index < s.length() && s.charAt(index) >= '3' && s.charAt(index) <= '9') {
            index++;
        }
        s = s.substring(index);

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ('1' == c || '2' == c) {
                cnt++;
            } else if (chars[i - 1] == '1' || (c <= '6' && chars[i - 1] == '2')) { // 能和前面连起来
                ans += arr[cnt + 1];
                cnt = 0;
            } else { // 跟前面连不起来
                ans += arr[cnt];
                cnt = 0;
            }
        }

        return ans + arr[cnt];
    }

    private int[] generateArr(int n) {
        if (n <= 2) {
            return new int[]{0, 1, 2};
        }

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr;
    }
}
*/

// 答案
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            if (one != 0) {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) == '0') {
                continue;
            }
            int two = Integer.valueOf(s.substring(i - 2, i));
            if (two <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}









