package com.aqdamnaseem.projects.linkedlist.Problem5;

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
	 * Merge two sorted linked list into one using iterative approach
	 * 
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static Node mergeIterative(Node head1, Node head2) {
		Node list1 = head1;
		Node list2 = head2;
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		Node resulthead = null;
		if (list1.data < list2.data) {
			resulthead = list1; // both list1 and resulthead pointing to same
			// node
		} else {
			resulthead = list2;
			list2 = list1;
			list1 = resulthead;// both list1 and resulthead pointing to same
			// node
		}
		/**
		 * Since we dont have to use additional node, what we will do is that
		 * lets take two pointers list1 and list2.list1 pointing to head node of
		 * first list and list2 pointing to head node of second list.
		 * 
		 * We will compare element by element and whichever node comes smaller,
		 * list1 point to that node and list2 point to other compairing node. We
		 * may have to swap pointers if required , because the next smaller
		 * element may be part of any of the list
		 */
		while (list1.next != null) {
			if (list1.next.data > list2.data) {
				Node temp = list1.next;
				list1.next = list2;
				list2 = temp;
			}
			list1 = list1.next;

		}
		// appending remaing element of list2
		list1.next = list2;
		return resulthead;

	}

	/**
	 * Merge two sorted linked list into one using recursive approach
	 * 
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static Node mergeRecursive(Node head1, Node head2) {
		Node list1 = head1;
		Node list2 = head2;
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		if (list1.data < list2.data) {
			list1.next = mergeRecursive(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeRecursive(list2.next, list1);
			return list2;
		}
	}
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.add(9);
		list1.add(7);
		list1.add(5);
		list1.add(3);
		list1.add(1);
		System.out.println(list1.toString());
		LinkedList list2 = new LinkedList();
		list2.add(8);
		list2.add(6);
		list2.add(4);
		list2.add(2);
		System.out.println(list2.toString());
		LinkedList list3 = new LinkedList();
		list3.head = mergeIterative(list1.head, list2.head);
		System.out.println(list3.toString());// 1 2 3 4 5 6 7 8 9
		LinkedList list4 = new LinkedList();
		list4.add(10);
		list4.add(8);
		list4.add(6);
		list4.add(2);
		list4.head = mergeRecursive(list3.head, list4.head);
		System.out.println(list4.toString());// 1 2 2 3 4 5 6 6 7 8 8 9 10
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
