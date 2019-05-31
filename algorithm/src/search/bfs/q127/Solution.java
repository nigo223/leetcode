package search.bfs.q127;

import java.util.*;

/*
    给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。
    转换需遵循如下规则：

    每次转换只能改变一个字母。
    转换过程中的中间单词必须是字典中的单词。
    说明:

    如果不存在这样的转换序列，返回 0。
    所有单词具有相同的长度。
    所有单词只由小写字母组成。
    字典中不存在重复的单词。
    你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
    示例 1:

    输入:
    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]

    输出: 5

    解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
         返回它的长度 5。
    示例 2:

    输入:
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log"]

    输出: 0

    解释: endWord "cog" 不在字典中，所以无法进行转换。

    分析：
        1、如果endWord不在字典中，直接返回0
        2、用BFS进行遍历，将beginWord作为根节点，level作为层数
        3、找到目标单词后，返回对应的层数

*/
class Test {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(new Solution2().ladderLength(beginWord, endWord, wordList));

    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new LinkedList<>(); // 队列
        Set<String> marked = new HashSet<>();
        int level = 1; // 记录层数

        queue.add(beginWord);
        marked.add(beginWord);
        while (!queue.isEmpty()) { // 队列非空，进入下一层
            int size = queue.size();
            level++;
            while (size-- > 0) {
                String cur = queue.poll();
                for (String w : wordList) {
                    if (isRelated(cur, w)) { // 有关联
                        if (marked.contains(w)) { // 已经找过这个单词了，pass
                            continue;
                        }
                        if (w.equals(endWord)) {
                            return level;
                        }
                        marked.add(w);
                        queue.add(w);
                    }
                }
            }
        }

        return 0;

    }

    private boolean isRelated(String w1, String w2) {
        int count = 0;
        for (int i = 0, j = 0; i < w1.length() && j < w2.length(); i++, j++) {
            if (w1.charAt(i) != w2.charAt(j)) {
                count++;
            }
        }
        return count == 1; // 是否只有一个字符不相同
    }
}

class Solution2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return 0;
        return bfs(beginSet, endSet, dict, 0);
    }

    private int bfs(Set<String> beginSet, Set<String> endSet, Set<String> dict, int step){
        if(beginSet.isEmpty() || endSet.isEmpty()) return 0;
        step++;
        dict.removeAll(beginSet);
        Set<String> nextSet = new HashSet<>();
        for(String str : beginSet){
            char[] chs = str.toCharArray();
            for(int i = 0; i < chs.length; i++){
                char old = chs[i];
                for(char c = 'a'; c <= 'z'; c++){
                    chs[i] = c;
                    String next = new String(chs);
                    if(!dict.contains(next)) continue;
                    if(endSet.contains(next)) return step + 1;
                    nextSet.add(next);
                }
                chs[i] = old;
            }
        }
        return nextSet.size() > endSet.size() ? bfs(endSet, nextSet, dict, step) : bfs(nextSet, endSet, dict, step);
    }
}
