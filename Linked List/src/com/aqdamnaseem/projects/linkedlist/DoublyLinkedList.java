package com.aqdamnaseem.projects.linkedlist;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<Item> implements Iterable<Item> {

	private Node<Item> head;
	private int size;

	public DoublyLinkedList() {
		head = null;
		size = 0;
	}

	/**
	 * Insert element at the beginning of the list
	 * 
	 * @param item
	 */
	public void add(Item item) {
		Node<Item> node = new Node<Item>(item, null, null);
		if (head != null) {
			head.prev = node;
			node.next = head;
		}
		head = node;
		size++;
	}

	/**
	 * Delete provided item from the list, if exist
	 * 
	 * @param item
	 */
	public void remove(Item item) {
		if (head == null)
			throw new NoSuchElementException("No such element exist " + item);

		if (head.data.equals(item))
			head = null;
		else {
			Node<Item> curr = head;
			Node<Item> prev = null;
			while (curr != null && !curr.data.equals(item)) {
				prev = curr;
				curr = curr.next;
			}

			if (curr == null)
				throw new NoSuchElementException(
						"No such element exist " + item);

			if (curr.data.equals(item)) {
				Node<Item> tempNext = curr.next;
				prev.next = tempNext;
				if (tempNext != null)
					tempNext.prev = prev;
			}
		}
		size--;
	}

	/**
	 * Return no.of elements in the list
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * Return True if list is empty, False otherwise
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Removes all element from the list
	 */
	public void clear() {
		head = null;
		size = 0;
	}

	/**
	 * Return String form of list
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		for (Item item : this) {
			result.append(item).append(" ");
		}
		return result.toString();
	}
	/**
	 * Return True, if list contain element,False otherwise
	 * 
	 * @param item
	 * @return
	 */
	public boolean contains(Item item) {
		for (Item listItem : this) {
			if (listItem.equals(item))
				return true;
		}
		return false;

	}

	/**
	 * 
	 * Nested Node class
	 *
	 */
	private static class Node<Item> {

		private Item data;
		private Node<Item> prev;
		private Node<Item> next;

		public Node(Item data, Node<Item> prev, Node<Item> next) {
			super();
			this.data = data;
			this.prev = prev;
			this.next = next;
		}

	}

	/**
	 * 
	 * Custom List Iterator which allows to iterate in both forward and backward
	 * directions
	 *
	 */
	private class DoublyLinkedListIterator implements ListIterator<Item> {

		private Node<Item> lastAccessed;
		private Node<Item> curr;
		private int index;

		public DoublyLinkedListIterator() {
			lastAccessed = null;
			curr = head;
			index = 0;
		}

		@Override
		public boolean hasNext() {
			return index < size;
		}

		@Override
		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException("No Such Element exist");
			Item item = curr.data;
			lastAccessed = curr;
			curr = curr.next;
			index++;
			return item;
		}

		@Override
		public boolean hasPrevious() {
			return index > 0;
		}

		@Override
		public Item previous() {
			if (!hasPrevious())
				throw new NoSuchElementException("No Such Element exist");
			lastAccessed = curr = (curr == null) ? lastAccessed : curr.prev;
			index--;
			return lastAccessed.data;
		}

		@Override
		public int nextIndex() {
			return index;
		}

		@Override
		public int previousIndex() {
			return index - 1;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Operation not supported");
		}

		@Override
		public void set(Item e) {
			throw new UnsupportedOperationException("Operation not supported");
		}

		@Override
		public void add(Item e) {
			throw new UnsupportedOperationException("Operation not supported");
		}

	}

	@Override
	public ListIterator<Item> iterator() {
		return new DoublyLinkedListIterator();
	}

	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		System.out.println("List Elements : " + list.toString());
		ListIterator<Integer> itr = list.iterator();
		System.out.println("Iterating element in forward direction");
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println("\nIterating element in reverse direction");
		while (itr.hasPrevious()) {
			System.out.print(itr.previous() + " ");
		}

	}

}
