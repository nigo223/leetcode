package two_pointers.q141;

/*
    需求：给定一个链表，判断链表中是否有环。

        为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
        如果 pos 是 -1，则在该链表中没有环。

        进阶：

        你能用 O(1)（即，常量）内存解决此问题吗？

    分析：
        用双指针实现，
        一个指针一次走一步，一个指针一次走两步，
        如果两个指针相遇，就有环
        如果走两步的指针遇到了null，说明无环


*/

class ListNode
{
    int val;
    ListNode next;

    ListNode(int x)
    {
        val = x;
        next = null;
    }
}

public class Solution
{
    public boolean hasCycle(ListNode head)
    {
        if (head == null)
        {
            return false;
        }

        ListNode l1 = head;
        ListNode l2 = head;

        while (l1.next != null && l2.next!= null)
        {
            l2 = l2.next.next;
            if (l2 == null)
            {
                break;
            }
            l1 = l1.next;
            if (l1 == l2)
            {
                return true;
            }
        }
        return false;
    }
}
