package com.aqdamnaseem.projects.linkedlist.Problem4;

public class LinkedList {

	private Node head;

	// API methods

	/**
	 * Add element to the front of list
	 * 
	 * @param data
	 */
	public void add(Integer data) {
		head = new Node(data, head);
	}

	/**
	 * Print Linked List element
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		Node curr = head;
		while (curr != null) {
			result.append(curr.data).append(" ");
			curr = curr.next;
		}
		return result.toString();
	}

	// Algorithm supporting methods

	/**
	 * Reverse elements of linked list in block of k 
	 * List : 1 2 3 4 5 6 7 
	 * k = 5
	 * Output : 5 4 3 2 1 6 7
	 */
	public void reverseInBlock_Variation1(int k) {
		if (head == null || !hasKElements(head, k))
			return;
		head = reverseUtilVar1(head, k);
	}

	/**
	 * Reverse Util Variation 1
	 * 
	 * @param headNode
	 * @param k
	 * @return
	 */
	private Node reverseUtilVar1(Node headNode, int k) {
		Node curr = headNode;
		Node prev = null;
		Node next = null;
		int count = 0;
		while (curr != null && count != k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		// if you just want to reverse remaining elements irrespective of
		// whether k elements are left or not just pt a null check on curr and
		// call reverse util
		// if(curr!=null)
		// headNode.next = reverseUtilVar1(curr, k);
		if (hasKElements(curr, k))
			headNode.next = reverseUtilVar1(curr, k);
		else
			headNode.next = curr;
		return prev;
	}

	/**
	 * Reverse elements of linked list in block of k 
	 * List : 1 2 3 4 5 6 7 
	 * k = 4
	 * Output : 4 5 6 7 1 2 3
	 * Here first reverse entire list and then use above method on the list
	 */
	public void reverseInBlock_Variation2(int k) {
		if (head == null || !hasKElements(head, k))
			return;
		reverseUtil(head);
		reverseInBlock_Variation1(k);
	}

	/**
	 * Return True if list has atleast k node left from the provided startNode
	 * 
	 * @param startNode
	 * @param k
	 * @return
	 */
	public boolean hasKElements(Node startNode, int k) {
		int count = 0;
		Node curr = startNode;
		while (curr != null && count != k) {
			curr = curr.next;
			count++;
		}
		if (count == k)
			return true;
		return false;
	}

	/**
	 * Reverse Util
	 * 
	 * @param node
	 * @return
	 */
	public Node reverseUtil(Node node) {
		if (node.next == null) {
			head = node;
			return node;
		}
		Node reversedNode = reverseUtil(node.next);
		reversedNode.next = node;
		node.next = null;
		return node;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		System.out.println("Original List : " + list.toString());
		// list is empty scenario
		list.reverseInBlock_Variation1(2);
		System.out.println("Reverse Output : " + list.toString());
		list.add(10);
		list.add(9);
		list.add(8);
		list.add(7);
		list.add(6);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		System.out.println("Original List : " + list.toString());
		list.reverseInBlock_Variation1(4);
		System.out.println(
				"Reverse Output with k = " + 4 + " : " + list.toString());

		LinkedList list2 = new LinkedList();
		list2.add(16);
		list2.add(15);
		list2.add(14);
		list2.add(13);
		list2.add(12);
		list2.add(11);
		System.out.println("Original List : " + list2.toString());
		list2.reverseInBlock_Variation2(4);
		System.out.println(
				"Reverse Output with k = " + 4 + " : " + list2.toString());

	}

	/**
	 * Node class
	 *
	 */
	private static class Node {

		private Integer data;
		private Node next;

		public Node(Integer data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

	}

}
