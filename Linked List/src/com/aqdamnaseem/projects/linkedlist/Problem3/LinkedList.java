package com.aqdamnaseem.projects.linkedlist.Problem3;

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

	// Alogorithm supporting methods

	/**
	 * Finds intersection point for two null terminating linked list.Return null
	 * if two linked list doesnot intersect
	 * 
	 * @param headNode1
	 * @param headNode2
	 * @return
	 */
	public static Node findIntersectionPointWhenNoLoopExist(Node head1,
			Node head2, Node lastNode) {
		if (head1 == null || head2 == null)
			return null;

		Node intersectionNode = null;
		int noOfNodesList1 = 0;
		int noOfNodesList2 = 0;
		int diff = 0;

		Node temp = head1;
		while (temp != lastNode) {
			noOfNodesList1++;
			temp = temp.next;
		}

		temp = head2;
		while (temp != lastNode) {
			noOfNodesList2++;
			temp = temp.next;
		}

		// deciding which list is bigger
		if (noOfNodesList1 > noOfNodesList2) {
			diff = noOfNodesList1 - noOfNodesList2;
		} else {
			temp = head2;
			head2 = head1;
			head1 = temp;
			diff = noOfNodesList2 - noOfNodesList1;
		}

		// got the bigger list and next through diff no of elements in the
		// bigger list where diff is difference in no of elements for two lists
		int counter = 0;
		while (counter != diff) {
			head1 = head1.next;
			counter++;
		}

		while (head1 != lastNode && head2 != lastNode) {
			head1 = head1.next;
			head2 = head2.next;
			if (head1 == head2) {
				intersectionNode = head1;
				break;
			}
		}

		return intersectionNode;

	}

	/**
	 * Generic Approach to find intersection of two lists(if they
	 * intersect).Return null if two linked list doesnot intersect.It covers
	 * both loop terminating and null terminating lists
	 * 
	 * @param headNode1
	 * @param headNode2
	 * @return
	 */
	public static Node findIntersectionPointWhenLoopExist(Node headNode1,
			Node headNode2) {

		Node meetingPoint1 = hasLoop(headNode1);
		Node meetingPoint2 = hasLoop(headNode2);

		if (null == meetingPoint1 && null == meetingPoint2) {

			/**
			 * Scenario 1 : Both list are null terminating
			 */
			// both list are null terminating
			// calling findIntersectionPointWhenNoLoopExist method
			return findIntersectionPointWhenNoLoopExist(headNode1, headNode2,
					null);

		}

		// finding Entry points for both the lists
		Node entryPoint1 = getLoopStartPoint(meetingPoint1, headNode1);
		Node entryPoint2 = getLoopStartPoint(meetingPoint2, headNode2);

		if (entryPoint1 == entryPoint2)
			// entry point is same , treating entry point as last node call
			// findIntersectionPointWhenNoLoopExist method to get intersection
			// ndoe
			return findIntersectionPointWhenNoLoopExist(headNode1, headNode2,
					entryPoint1);

		// check if both list share common loop with different entry point
		int list1LoopLength = loopLength(meetingPoint1);
		int list2LoopLength = loopLength(meetingPoint2);
		if (list1LoopLength != list2LoopLength)
			// disjoint lists
			return null;

		// Loop length is equal. Check if entry point of one list is reachable
		// from entry list of other list, if yes any entry point is correct as
		// answer otherwise the lists are disjoint one
		Node temp = entryPoint1;
		do {
			temp = temp.next;
		} while (temp != entryPoint1 && temp != entryPoint2);

		if (temp != entryPoint2)
			/**
			 * Scenario 4 covered
			 */
			// disjoint lists
			return null;
		else/**
			 * Scenario 5 covered
			 */
			return entryPoint2;

	}

	/**
	 * Return starting point of the loop
	 * 
	 * @param meetingPoint
	 * @param headNode
	 * @return
	 */
	private static Node getLoopStartPoint(Node meetingPoint, Node headNode) {
		Node ptr1 = headNode;
		Node ptr2 = meetingPoint;
		while (ptr1 != ptr2) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		return ptr1;
	}

	/**
	 * Return slow and fast pointer meeting point if there is a loop otherwise
	 * return null
	 * 
	 * @param headNode
	 * @return
	 */
	private static Node hasLoop(Node headNode) {
		if (headNode == null) {
			return null;
		}
		Node fast = headNode;
		Node slow = headNode;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return slow;
			}
		}
		return null;
	}

	/**
	 * Return loop length of a list
	 * 
	 * @param anyNodeInLoop
	 * @return
	 */
	public static int loopLength(Node anyNodeInLoop) {
		Node temp = anyNodeInLoop;
		int length = 0;
		do {
			length++;
			temp = temp.next;
		} while (temp != anyNodeInLoop);
		return length;
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
		LinkedList list2 = new LinkedList();
		list2.add(10);
		list2.add(11);
		list2.add(12);
		list2.add(13);
		list2.add(14);
		list2.add(15);

		/**
		 * Scenraio 1: When the linked list do not intersect i.e they are
		 * disjoint list
		 */
		Node node = findIntersectionPointWhenLoopExist(list1.head, list2.head);
		System.out.println(node); // it should print null

		/**
		 * Scenraio 2: When the linked lists intersect and both are null
		 * terminating
		 */
		list2.get(5).next = list1.get(7);
		node = findIntersectionPointWhenLoopExist(list1.head, list2.head);
		System.out.println(node.data);// it should print 8

		/**
		 * Scenraio 3: When the linked lists intersect and both are
		 * circular.They intersect at a point which is before starting of the
		 * loop
		 */
		list1.get(8).next = list1.get(4);
		list2.get(5).next = list1.get(2);
		node = findIntersectionPointWhenLoopExist(list1.head, list2.head);
		System.out.println(node.data); // it should print 3

		/**
		 * Scenraio 4: When both list are circular, sharing same loop and entry
		 * point to loop is also same
		 */
		list2.get(5).next = list1.get(4);
		node = findIntersectionPointWhenLoopExist(list1.head, list2.head);
		System.out.println(node.data); // it should print 5

		/**
		 * Scenraio 5: When both list are circular, sharing same loop and entry
		 * point to loop is different
		 */
		list2.get(5).next = list1.get(6);
		node = findIntersectionPointWhenLoopExist(list1.head, list2.head);
		System.out.println(node.data);// it should print 7 or 5

		/**
		 * Scenraio 6: When both list are circular, and but the loops are
		 * different i.e disjoint lists
		 */
		list2.get(5).next = list2.get(2);
		node = findIntersectionPointWhenLoopExist(list1.head, list2.head);
		System.out.println(node);// it should print null

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
