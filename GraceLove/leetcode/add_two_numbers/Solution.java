package leetcode.add_two_numbers;

public class Solution {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //기본 제공되는 메서드
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(l1.val + l2.val);
        result = nextTwoNumbers(result, l1.next, l2.next);
        digitCarry(result);
        return result;
    }

    //ListNode
    private ListNode nextTwoNumbers(ListNode result, ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return result;
        }else if(l1 == null){
            nextTwoNumbers(result, l2);
        }else if(l2 == null){
            nextTwoNumbers(result, l1);
        }else {
            int sum = l1.val + l2.val;
            result.next = new ListNode(sum);
            nextTwoNumbers(result.next, l1.next, l2.next);
        }

        return result;
    }

    private ListNode nextTwoNumbers(ListNode result, ListNode list) {
        if(list != null) {
            result.next = new ListNode(list.val);
            nextTwoNumbers(result.next, list.next);
        }

        return result;
    }

    private void digitCarry(ListNode result) {
        if(result == null) {
            return;
        }

        if(result.val >= 10) {
            int carryNum = result.val / 10;
            result.val = result.val % 10;
            if(result.next != null) {
                result.next.val += carryNum;
            }else {
                result.next = new ListNode(carryNum);
            }

        }

        digitCarry(result.next);
    }
}
