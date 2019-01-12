Find the intersection point of two Linked List

Again there are many solutions to this problem.We will see some of them here

Before jumping to the solution, Lets analyze the problem.

If the two lists are intersecting then there can be 2 scenarios

Case 1.The two lists terminate with a common null link.If they do they will have a single merge point i.e. the two merging lists 
form a Y structure.

Case 2.The lists are terminating in a cycle.When there is a terminating cycle there are three possibilities - 
   (a) A and B merge before they reach the cycle, 
   (b) they merge at a common entry point, or 
   (c) they enter at different points in the cycle. To distinguish these cases we need to find the entry points for A and B. 
   	   If the entry points are the same treat the common entry point as a list terminator and apply the simple algorithm in 
   	   part I. If they differ we have case (c) - either entry point is a legitimate answer.
   	   
   	   
If the two lists are null terminated the cycle detection algorithm will discover the fact; and in that Approach 1 can be used
otherwise Floyd's algorithm will give one of the entry points.

Lets summarize all the scenarios

Scenraio 1: When lists are null terminating  and do not intersect i.e disjoint lists.

Scenraio 2: When lists are null terminating  and intersect.
 
Scenraio 3: When lists are circular and donot intersect(or donot have common loop), again disjoint list.

Scenraio 4: When lists are circular and are sharing common loop but they merge before starting of the loop.

Scenraio 5: When lists are circular and are sharing common loop but they merge at the starting node of the loop(or have 
common entry point to the loop)

Scenraio 6: When lists are circular and are sharing common loop but they join loop at differentnode(or have different
entry point to the loop).As mentioned there are two solutions in such case and either of the entry point is correct answer


 
 
 
 