Abstract Data Type(ADT)
-----------------------

Abstract Data Type(ADT) is a model of Data Structure that specifies

   1. Characteristic of collection of data
   
   2. Operations that can be performed on the collection
   
It is abstract, because it doesnot specify how ADT will be implemented.

Ex - Linked List, Stack, Queue etc

Data Structures are basically implementation of ADTs.

Linked List(as ADT)
-------------------

If Linked List is an ADT, then it must possess properties of ADT described above.So here they are

   1. In its most basic form, Linked List is a collection of nodes, where each node contains: data, and a reference(in other        words, a link) to the next node in the sequence.
   
   2. It supports a no of operations like insert, delete etc.
   
Types of Linked List
--------------------
   
There are three common types of Linked List.

  1. Singly Linked List
  2. Doubly Linked List
  3. Circular Linked List
  
Singly Linked List
------------------
It is the most common form of Linked List. Each node has data and a pointer to the next node.

Node is represented as a static nested class

      public class SinglyLinkedList < Item > {

         private Node < Item > head;  // pointer to the first element of Linked List

            // static nested node class
            private static class Node < Item > {

               private Item data;
               private Node < Item > next; //pointer to next element

               public Node(Item data, Node < Item > next) {
               this.data = data;
               this.next = next;
            }
         }
      }

Note : Node class has been implemented as nested class because it is only useful to Linked List class, so it is logical to embed it in that class and keep the two together. It is static because we are not directly accessing any instance variables or methods defined in enclosing Linked List class

Optionally you can also have a tail element for the Linked List, which will point to the last element.It can be useful in some usecases like inserting element at the end or deleting last element.Time Complexity can be reduced to O(1)

Doubly Linked List
------------------
In Doubly Linked List, we add a pointer to the previous node. Thus, we can go in either direction: forward or backward.

      public class DoublyLinkedList < Item > {

         private Node < Item > head;  // pointer to the first element of Linked List

            // static nested node class
            private static class Node < Item > {

               private Item data;
               private Node < Item > prev;  // pointer to prev element
               private Node < Item > next;  // pointer to next element
               
               public Node(Item data, Node < Item > prev, Node < Item > next) {
               this.data = data;
               this.prev = prev;
               this.next = next;
            }
         }
      }

Circular Linked List
--------------------
A Circular Linked List is a variation of linked list in which the last element is linked to the first element. This forms a circular loop.

A circular Linked List can be either Singly Lnked or Doubly Linked.

In Singly Linked List, next pointer of last item points to the first item while in Doubly Linked List, prev pointer of first item points to last item as well.


      public class CircularSinglyLinkedList < Item > {

         private Node < Item > tail;  // pointer to the last element of Linked List

            // static nested node class
            private static class Node < Item > {

               private Item data;
               private Node < Item > next; //pointer to next element

               public Node(Item data, Node < Item > next) {
               this.data = data;
               this.next = next;
            }
         }
      }


Here instead of head pointer, we are maintaing a tail pointer because next element of tail will be the head,so we can access both head and tail element.But with head pointer, if we want to access last element then we have to iterate through the list.

