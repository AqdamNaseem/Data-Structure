## Reverse a Linked List


For Example - 

If input provided is   1 2 3 4 5 6
Output should be       6 5 4 3 2 1


This problem can be solved in many ways, but we will see 2 ways to solve this problem

### Recursive Approach

Here we make use of Implicit(System) Stack to reverse the linked list.There are two main requirements of a recursive function:

A Stop Condition   – the function returns a value when a certain condition is satisfied, without a further recursive call
The Recursive Call – the function calls itself with an input which is a step closer to the stop condition

Each recursive call will add a new frame to the stack memory of the JVM. So, if we don’t pay attention to how deep our 
recursive call can dive, an out of memory exception may occur.Thus this approach is not suitable for list with large no of 
elements.

The stop condition in this case is reaching the end of linked list.

Using master theorem, we can say that the time taken to reverse a linked list of N elements can be expressed as
	
					T(N) = T(N-1) + c
									
where T(N) is the overall steps for N nodes, in order to reverse N nodes you just reverse N-1 in T(N-1) and add the Nth 
node by doing constant operations which cost c (constant value doesn't matter).
			
            			or	T(N) = T(N-2) + c + c
            			or	T(N) = T(N-3) + c + c + c 
            
a general expression for such kth undwinding will be  T(N) = T(N-k) + kc
            
Obviously we will stop at T(0)(when we reach the end of linked list), or when k = N

            				T(N) = T(0)+ Nc
            				T(N) = O(N) where T(0) is a constant

Time Complexity : O(N)<br />
Space Complxity : O(1)


### Iterative Approach

This approach makes use of 3 pointers prev, curr, next to reverse linked list.

Time Complexity : O(N)<br />
Space Complxity : O(1)


### Using an Stack

We can store the elements of the list on a Stack and then pop elements one by one.Since Stack is a LIFO(Last In First Out) 
data structure, the pop order will be like iterating linked list elements in reverse order.

Time Complexity : O(N)<br />
Space Complxity : O(N)
