package interview;

/**
 * Created by ASUS on 2016/7/23.
 * 链表类算法
 */
public class CommonNode {
    class ListNode {
        public int val;
        public ListNode next;
        public Object x;

        ListNode(Object x) {
            this.x = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    /**
     * 获取链表长度
     *
     * @param list
     * @return
     */
    private int getListLength(ListNode list) {
        int length = 0;

        while (list.getNext() != null) {
            ++length;
            list = list.next;
        }
        return length;
    }

    /**
     * 获取两个链表的第一个公共节点----------也可以使用堆栈
     *
     * @param listA
     * @param listB
     * @return
     */
    public ListNode getFirstCommonNode(ListNode listA, ListNode listB) {
        if (listA == null || listB == null)
            return null;

        int aLength = getListLength(listA);
        int bLength = getListLength(listB);

        //把长的链表头部移位到和短链表一样长的位置
        int lengthDif = aLength - bLength;
        ListNode longListNode = listA;
        ListNode shortListNode = listB;
        if (aLength < bLength) {
            longListNode = listB;
            shortListNode = listA;
            lengthDif = bLength - aLength;
        }

        for (int i = 0; i < bLength; i++) {
            longListNode = longListNode.next;
        }

        //循环同时比较两个链表的每个节点
        while (longListNode != null && shortListNode != null) {
            if (longListNode == shortListNode) {
                return longListNode;
            }
            longListNode = longListNode.next;
            shortListNode = shortListNode.next;
        }

        //----------------------stack方法  找出第一组不一样的节点，那么下一个就是公共节点-  多使用了空间O(n)--------------------
/*        Stack<ListNode> aStack = new Stack<ListNode>();
        Stack<ListNode> bStack = new Stack<ListNode>();

        for (int i = 0; i < aLength; i++) {
            aStack.push(listA);
            listA = listA.next;
        }

        for (int j = 0; j < bLength; j++) {
            bStack.push(listB);
            listB = listB.next;
        }

        ListNode lastA = aStack.pop();
        ListNode lastB = bStack.pop();
        while (lastA != null && lastB != null && lastA == lastB) {
            lastA = aStack.pop();
            lastB = bStack.pop();
        }

        if (lastA == null || lastB == null)
            return lastA == null ? lastA : lastB;
        else return lastA.next;*/
        //----------------------stack方法---------------------

        return null;
    }

    /**
     * 带有头节点的链表插入，头节点位置不能插入
     *
     * @param head
     * @param i
     * @param x
     * @throws Exception
     */
    public void insert(ListNode head, int i, Object x) throws Exception {
        ListNode p = head;
        int j = -1;
        //找到插入目标位置的前一个节点（前驱节点）
        while (p != null && j < i - 1) {
            p = p.next;
            ++j;
        }

        if (j > i - 1 || p == null) {
            throw new Exception("插入位置不合法");
        }
        //插入动作
        ListNode s = new ListNode(x);
        s.next = p.next;
        p.next = s;

        /**
         * 不带头节点的单链表的 插入位置 可以在头节点，这里做一个判断  插入位置是不是在头节点

         if (i == 0){
         s.next = head;
         head = s;
         } else {
         s.next = p.next;
         p.next = s;
         }
         */
    }

    public void deleteValueNode(ListNode head, int v) {
        if (head == null) {
            return;
        }

        ListNode toBeDeleteNode = null;
        while (head != null && head.val != v) {
            head = head.next;
            toBeDeleteNode = head;
        }

        //找到了
        if (head != null) {
            toBeDeleteNode = head;
            head = head.next;
            //没找到
        } else {
            return;
        }

    }

    /**
     * leetcode19删除列表倒数Nth个节点
     * 考虑特殊情况，头节点和尾节点都能够被删除
     */
    private ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p1 = dummy;
        ListNode p2 = head;

        while (n > 0) {
            p2 = p2.next;
            n--;
        }

        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p1.next = p1.next.next;
        return dummy.next;

    }

    /**
     * 反转链表
     *
     * @param node
     */
    public static ListNode reverse(ListNode node) {
        ListNode reverseNode = null;
        ListNode pNode = node;
        ListNode head = null;

        while (pNode != null) {
            ListNode nextNode = pNode.next;
            if(nextNode == null) {
                reverseNode = pNode;
            }
            pNode.next = head;
            head = pNode;
            pNode = nextNode;
        }
        return reverseNode;
    }

}