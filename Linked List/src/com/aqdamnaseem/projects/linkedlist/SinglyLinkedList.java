package com.aqdamnaseem.projects.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<Item> implements Iterable<Item> {

	private Node<Item> head; // pointer to first element
	private int size;

	public SinglyLinkedList() {
		head = null;
		size = 0;
	}

	/**
	 * Insert element at the beginning
	 * 
	 * @param item
	 */
	public void insertFirst(Item item) {
		head = new Node<Item>(item, head);
		size++;
	}

	/**
	 * Insert element at the end
	 * 
	 * @param item
	 */
	public void insertLast(Item item) {
		if (head == null)
			// list is empty
			head = new Node<Item>(item, null);
		else {
			Node<Item> curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			if (curr != null) {
				curr.next = new Node<Item>(item, null);
			}
		}
		size++;
	}

	/**
	 * Insert element after provided element, if exist
	 * 
	 * @param item
	 * @param itemToInsert
	 */
	public void insertAfter(Item item, Item itemToInsert) {
		if (head == null)
			// list is empty
			throw new NoSuchElementException("No such element exist " + item);

		Node<Item> curr = head;
		while (curr != null && !curr.data.equals(item)) {
			curr = curr.next;
		}
		if (curr == null)
			// element not found
			throw new NoSuchElementException("No such element exist " + item);

		Node<Item> tempNext = curr.next;
		curr.next = new Node<Item>(itemToInsert, tempNext);
		size++;
	}

	/**
	 * Insert element before provided element, if exist
	 * 
	 * @param item
	 * @param itemToInsert
	 */
	public void insertBefore(Item item, Item itemToInsert) {
		if (head == null)
			// list is empty
			throw new NoSuchElementException("No such element exist " + item);
		if (head.data.equals(item))
			insertFirst(itemToInsert);
		else {
			Node<Item> curr = head;
			Node<Item> prev = null;
			while (curr != null && !curr.data.equals(item)) {
				prev = curr;
				curr = curr.next;
			}
			if (curr == null)
				// element not found
				throw new NoSuchElementException(
						"No such element exist " + item);
			if (prev != null)
				// ideally prev will never be null at this point
				prev.next = new Node<Item>(itemToInsert, curr);
			size++;
		}

	}

	/**
	 * Insert element at index position
	 * 
	 * @param item
	 * @param index
	 */
	public void insertAt(Item item, int index) {
		if (head == null)
			// list is empty
			throw new NoSuchElementException("No such element exist");
		if (index < 0 || index >= size)
			throw new IllegalArgumentException("Invalid arguement " + index);
		int counter = 0;
		if (index == 0)
			insertFirst(item);
		else if (index == size - 1)
			insertLast(item);
		else {
			Node<Item> curr = head;
			Node<Item> prev = null;
			while (curr != null && counter != index) {
				prev = curr;
				curr = curr.next;
				counter++;
			}
			if (counter == index) {
				prev.next = new Node<Item>(item, curr);
			}
			size++;
		}
	}

	/**
	 * Delete first element of the list
	 * 
	 * @return
	 */
	public Item deleteFirst() {
		if (head == null)
			throw new NoSuchElementException("No such element exist");
		Item item = head.data;
		head = head.next;
		size--;
		return item;
	}
	/**
	 * Delete last element of the list
	 * 
	 * @return
	 */
	public Item deleteLast() {
		Item item = null;
		if (head == null)
			throw new NoSuchElementException("No such element exist");
		if (head.next == null) {
			item = head.data;
			head = null;
		} else {
			Node<Item> curr = head;
			Node<Item> prev = null;

			while (curr.next != null) {
				prev = curr;
				curr = curr.next;
			}

			if (prev != null) {
				// ideally prev will never be null at this point
				item = curr.data;
				prev.next = null;
			}
		}
		size--;
		return item;
	}

	/**
	 * Delete provided item from the list,if exist
	 * 
	 * @param item
	 */
	public void delete(Item item) {
		if (head == null)
			throw new NoSuchElementException("No such element exist " + item);
		if (head.data.equals(item))
			deleteFirst();
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
			prev.next = curr.next;
			size--;
		}
	}

	/**
	 * Delete element at provide index(0 to size-1) position
	 * 
	 * @param index
	 * @return
	 */
	public Item deleteAt(int index) {
		Item item = null;
		if (head == null)
			throw new NoSuchElementException("No such element exist");
		if (index < 0 || index >= size)
			throw new IllegalArgumentException("Invalid arguement " + index);
		if (index == 0)
			item = deleteFirst();
		else if (index == size - 1) {
			item = deleteLast();
		} else {
			int counter = 0;
			Node<Item> curr = head;
			Node<Item> prev = null;
			while (curr != null && counter != index) {
				prev = curr;
				curr = curr.next;
				counter++;
			}
			if (counter == index) {
				// ideally index should match with one value
				item = curr.data;
				prev.next = curr.next;
			}
			size--;
		}
		return item;
	}

	/**
	 * Returns element at index position
	 * 
	 * @param index
	 * @return
	 */
	public Item get(int index) {
		if (head == null)
			throw new NoSuchElementException("No such element exist");
		if (index < 0 || index >= size)
			throw new IllegalArgumentException("Invalid arguement " + index);
		int counter = 0;
		Node<Item> curr = head;
		Item item = null;
		while (curr != null && counter != index) {
			curr = curr.next;
			counter++;
		}
		if (counter == index)
			item = curr.data;
		return item;
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

	private static class Node<Item> {
		private Item data;
		private Node<Item> next;

		/**
		 * @param data
		 * @param next
		 */
		public Node(Item data, Node<Item> next) {
			super();
			this.data = data;
			this.next = next;
		}

	}
	/**
	 * Return and iterator over list
	 */
	@Override
	public Iterator<Item> iterator() {
		return new LinkedListIterator();
	}

	/**
	 * Custom Linked List Iterator to iterate over list
	 *
	 */
	private class LinkedListIterator implements Iterator<Item> {

		private Node<Item> curr;

		public LinkedListIterator() {
			curr = head;
		}

		@Override
		public boolean hasNext() {
			return curr != null;
		}

		@Override
		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException("No Such element exist");
			Item item = curr.data;
			curr = curr.next;
			return item;
		}

	}

	public static void main(String[] args) {
		SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
		linkedList.insertFirst("A");
		linkedList.insertAfter("A", "C");
		linkedList.insertBefore("C", "B");
		linkedList.insertAt("D", 2);
		linkedList.insertLast("E");
		System.out.println(linkedList.toString());// print A B C D E
		System.out.println(linkedList.get(4));// print E
		System.out.println(linkedList.deleteFirst());// print A
		System.out.println(linkedList.deleteLast());// print E
		linkedList.delete("B");
		System.out.println(linkedList.deleteAt(0)); // print C
		System.out.println(linkedList.size);// print 1
		System.out.println(linkedList.isEmpty());// print false
		linkedList.clear();
		System.out.println(linkedList.isEmpty());// print true

	}

}
