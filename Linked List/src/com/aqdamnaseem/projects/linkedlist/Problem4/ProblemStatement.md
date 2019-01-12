## Reverse Linked List in blocks of k

Variation 1 :
 
List   :  1 2 3 4 5 6 7
 
k = 2 
Output :  2 1 4 3 6 5 7
 
k = 3 
Output :  3 2 1 6 5 4 7
 
k = 4
Output :  4 3 2 1 5 6 7

k = 5
Output :  5 4 3 2 1 6 7
 
 
A slight variation to this question is

Variation 2:

List   :  1 2 3 4 5 6 7

k = 2
Output :  6 7 4 5 2 3 1

k = 3
Output :  5 6 7 2 3 4 1

k = 4
Output :  4 5 6 7 3 2 1


In both the cases the first block of the resulting list should be maximal with regards to k and last block may contain 
full or lesser elements.

## Solution for Variation 1 :

Simply reverse the linked list like we did in Problem 1 but keep a counter on the no of elements reversed.As soon as the 
couter reaches the block size , check if list has sufficient element left for reversing in block(or check if list has element 
and call reverse function if you simply want to reverse remaining elements), if yes recursively call the reverse function on 
the remaining element.

Time Complexity  : O (N)<br />
Space Complexity : O (1)


## Solution for Variation 2 :

Simply reverse the complete linked list and use solution for variation 1.

Time Complexity  : O (N) +  O (N) = O (N)<br />
Space Complexity : O (1)
