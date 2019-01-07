package com.aqdamnaseem.projects.linkedlist.Problem2;

public class LinkedList {

	private Node head;
	public void add(Integer data) {
		head = new Node(data, head);
	}

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
