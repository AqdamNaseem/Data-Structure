## Merge Two sorted(in ascending order) Linked List into a single sorted Linked List without using additional node.

For Example :

List1 : 1 3 5 7<br/>
List2 : 2 4 6 8 10

Output should be 1 2 3 4 5 6 7 8 10

The important part here is that we are not using any additional node.

### Iterative Solution

Here we take two pointers and treat one of the pointer as target pointer which points to the next smaller element of the two list.
		Time Complexity : O(m + n) or O(max(m,n))
		Space Complexity : O(1)


### Recursive Solution

Recursive solution is very simple and compact but remember this solution can take up space(System Stack) of O(m+n).We may get Stackoverflow if the list have large no of space 
   
   		Time Complexity : O(m + n) or O(max(m,n))
		Space Complexity : O(m+n)
