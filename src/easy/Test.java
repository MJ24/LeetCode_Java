package easy;

public class Test {

	public static void main(String[] args) {
		System.out.println(isPalindrome("1a2"));
	}

	// 删除单链表的倒数第n个节点:
	// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head;
		ListNode slow = head;
		ListNode preSlow = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			preSlow = slow;
			slow = slow.next;
			fast = fast.next;
		}
		if (preSlow == slow && n == 1) {
			return null;
		}
		if (slow == head) {
			head = head.next;
		} else {
			preSlow.next = slow.next;
		}
		return head;
	}

	// 反转单链表: https://leetcode.com/problems/reverse-linked-list/
	public static ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode pre = null;
		ListNode cur = head;
		ListNode post = head.next;
		while (true) {
			cur.next = pre;
			if (post == null) {
				break;
			}
			pre = cur;
			cur = post;
			post = post.next;
		}
		head = cur;
		return head;
	}

	// 删除单链表节点:
	// https://leetcode.com/problems/remove-linked-list-elements/
	public static ListNode removeElements(ListNode head, int val) {
		ListNode p = head;
		while (p != null && p.val == val) {
			p = p.next;
		}
		head = p;
		ListNode pre = head;
		while (p != null) {
			if (p.val == val) {
				pre.next = p.next;
			} else {
				pre = p;
			}
			p = p.next;
		}
		return head;
	}

	// 验证字符串是否是回文字符串: https://leetcode.com/problems/valid-palindrome/
	public static boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			char leftChar = s.charAt(left);
			char rightChar = s.charAt(right);
			if (!Character.isLetterOrDigit(leftChar)) {
				left++;
			} else if (!Character.isLetterOrDigit(rightChar)) {
				right--;
			} else if (Character.toLowerCase(leftChar) != Character
					.toLowerCase(rightChar)) {
				return false;
			} else {
				left++;
				right--;
			}
		}
		return true;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}