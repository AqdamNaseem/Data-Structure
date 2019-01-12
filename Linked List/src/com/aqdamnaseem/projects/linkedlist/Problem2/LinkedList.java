package com.aqdamnaseem.projects.linkedlist.Problem2;

import java.util.NoSuchElementException;

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
	 * Return node at index.Works on 0 based indexing
	 * 
	 * @param index
	 * @return
	 */
	public Node get(int index) {
		int counter = 0;
		Node curr = head;
		while (curr != null && counter != index) {
			curr = curr.next;
			counter++;
		}
		if (curr == null)
			throw new NoSuchElementException();
		return curr;
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

	// Alogorithm supporting methods

	/**
	 * Returns True if linked list has loop and has been removed, False
	 * otherwise
	 * 
	 * @return
	 */
	public boolean removeLoopIfExist() {
		if (head == null)
			return false;
		Node slow = head;
		Node fast = head;
		boolean hasLoop = false;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				hasLoop = true;
				break;
			}
		}
		if (hasLoop) {
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
				if (slow == fast) {
					break;
				}
			}

			int counter = 0;
			if (slow == fast) {
				do {
					slow = slow.next;
					counter++;
				} while (slow.next != fast);

				System.out.println("Loop length is " + (counter + 1));
				// removing loop
				slow.next = null;
			}

		}
		return hasLoop;
	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.add(9);
		list1.add(8);
		list1.add(7);
		list1.add(6);
		list1.add(5);
		list1.add(4);
		list1.add(3);
		list1.add(2);
		list1.add(1);
		System.out.println(list1.removeLoopIfExist());
		list1.get(8).next = list1.get(4);
		System.out.println(list1.removeLoopIfExist());
		System.out.println(list1.toString());
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
