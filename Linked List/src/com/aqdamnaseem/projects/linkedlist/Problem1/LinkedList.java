package com.aqdamnaseem.projects.linkedlist.Problem1;

public class LinkedList {

	private Node head;

	// Alogorithm supporting methods

	/**
	 * Recursive approach to reverse a linked list
	 */
	public void recursiveReverse() {
		if (head == null)
			return;
		reverseUtil(head);
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

	/**
	 * Iterative approach to reverse a linked list
	 */
	public void iterativeReverse() {
		if (head == null)
			return;
		Node curr = head;
		Node prev = null;
		Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

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

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		System.out.println("Actual List : " + list.toString());
		list.recursiveReverse();
		System.out.println(
				"Reversed List with Recursive Reverse : " + list.toString());
		list.iterativeReverse();
		System.out.println(
				"Reversed List with Iterative Reverse : " + list.toString());

	}

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
