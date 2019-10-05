//package middle;
//
//import java.util.List;
//
///**
// * @program:
// * @description:
// * @author: SY_zheng
// * @create: 2019-08-19
// */
//public class addTwoNumbers {
//
//    public static void main(String[] args) {
//
//        ListNode l1 = new ListNode(9);
//        addDate(8, l1);
//        ListNode l2 = new ListNode(1);
//
//        int countL1 = count(l1);
//        int countL2 = count(l2);
//
////        ListNode listNode = new ListNode(0);
////        for (int i = 0; i < countL1 - countL2 - 1; i++) {
////            addDate(0, listNode);
////        }
////        ListNode temp = listNode;
////
////        while (temp.next != null) {
////            temp = temp.next;
////        }
////        temp.next = childNode;
//
//
//
//        if (countL1 > countL2) {
//            l2 = spliceListNode(l2, countL1, countL2);
//        }
//
//        if (countL2 > countL1) {
//            l1 = spliceListNode(l1, countL2, countL1);
//        }
//        System.out.println(printf(l2));
//
////        int carry = 0;
////        ListNode head = new ListNode(0);
////        ListNode res = head;
////        int carry = 0;
////        while (l1 != null || l2 != null) {
////            int x = l1.val;
////            int y = l2.val;
////            int sum = carry + x + y;
////            carry = sum / 10;
////            res.next = new ListNode(sum % 10);
////            res = res.next;
////            l1 = l1.next;
////            l2 = l2.next;
////        }
////        if (carry > 0) {
////            res.next = new ListNode(carry);
////        }
////
////
////        System.err.println(printf(head));
//
//
//    }
//
//    private static String printf(ListNode listNode) {
//        StringBuilder s = new StringBuilder();
//        s.append(listNode.val);
//        while(listNode.next != null) {
//            s.append(listNode.next.val);
//            listNode = listNode.next;
//        }
//        return s.reverse().toString();
//    }
//
//    /**
//     * 计数器
//     * @param listNode
//     * @return
//     */
//    private static Integer count(ListNode listNode) {
//        int count = 1;
//        while(listNode.next != null) {
//            listNode = listNode.next;
//            count++;
//        }
//        return count;
//    }
//
//
//    private static void addDate(Integer data, ListNode header) {
//        ListNode listNode = new ListNode(data);
//        ListNode temp = header;
//
//        while (temp.next != null) {
//            temp = temp.next;
//        }
//        temp.next = listNode;
//    }
//
//
//    /**
//     *
//     * @param childNode
//     * @param big
//     * @param small
//     * @return
//     */
//    private static ListNode spliceListNode(ListNode childNode, int big, int small) {
//        ListNode listNode = new ListNode(0);
//        for (int i = 0; i < big - small - 1; i++) {
//            addDate(0, listNode);
//        }
//        ListNode temp = childNode;
//
//        while (temp.next != null) {
//            temp = temp.next;
//        }
//        temp.next = listNode;
//        return childNode;
//    }
//
//
//}
