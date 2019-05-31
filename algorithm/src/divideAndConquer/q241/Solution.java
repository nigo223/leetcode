package divideAndConquer.q241;

import jdk.internal.util.xml.impl.Input;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
    你需要给出所有可能的组合的结果。
    有效的运算符号包含 +, - 以及 * 。

    示例 1:

    输入: "2-1-1"
    输出: [0, 2]
    解释:
    ((2-1)-1) = 0
    (2-(1-1)) = 2
    示例 2:

    输入: "2*3-4*5"
    输出: [-34, -14, -10, -10, 10]
    解释:
    (2*(3-(4*5))) = -34
    ((2*3)-(4*5)) = -14
    ((2*(3-4))*5) = -10
    (2*((3-4)*5)) = -10
    (((2*3)-4)*5) = 10

*/
class Test {
    public static void main(String[] args) {
        String str = "2-1-1";
        System.out.println(new Solution().diffWaysToCompute(str));

    }
}

class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }

        if (ways.size() == 0) { // 只有一个数字，就加入该数字
            ways.add(Integer.valueOf(input));
        }
        return ways;

    }

}
