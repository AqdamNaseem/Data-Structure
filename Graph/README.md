Graph
-----
A Graph is a set of vertices and a collection of edges that each connect a pair of vertices. We use the names 0 through V-1 for the vertices in a V-vertex graph.

![alt text](https://github.com/AqdamNaseem/Data-Structure/blob/master/Graph/images/Graph.png)

Graph Terminology
-----------------
1. When an edge connects two vertices, we say that the vertices are adjacent to each other and the edge is incident on both vertices

2. The degree of a vertex is the no. of edges incident on it.

3. Two edges are parallel if they connect the same pair of vertices.

4. A SubGraph is a subset of graph's edges(and associated vertices) that constitute a graph.

5. A path in a graph is a sequence of vertices connected by edges.A simple path is one with no repeating vertices.

6. A Cycle is a path whose first and last vertices are same.

7. The length of a path or a cycle is its number of edges.

8. A Graph is Connected if there is a path from every vertex to every other vertex.

9. An Acyclic Graph hasno cycles.

10. A Graph that is not connected consist of a set of connected components which are maximal connected SubGraph.

11. A Tree is a acyclic connected Graph

12. A Weighted Graph is a Graph which has an associated numerical value known as weight/cost for each edge.Weighted Graph may be either Directed or Undirected.

13. A Graph is Sparse if it has very few edges as compared to its vertices.

14. A Graph is dense if it has many edges(n(n-1)/2 edges for a complete Graph which has n vertices).

Graph Representation
--------------------
A Graph can be represented in different ways.

1. Array of Edges :

Here we maintain an array of edges which exist between vertices.This direct representation is simple but finding adjacent vertices for a given vertex will require to examine each and every edge in the array.

2. Adjacency Matrix

Here we maintain a V by V boolean array, with the entry in row v and column w defined to be true if there is an edge adjacent 0 to both vertex v and vertex w in the graph, and to be false otherwise. 

![alt text](https://github.com/AqdamNaseem/Data-Structure/blob/master/Graph/images/Adjacency_Matrix.png)

Graphs with millions of vertices are common and the space cost with this representation for the v^2 boolean values needed is prohibitive.

3. Array of Adjacency List

Here we maintain a vertex-indexed array of lists of the vertices adjacent to each vertex

![alt text](https://github.com/AqdamNaseem/Data-Structure/blob/master/Graph/images/Adjacency_List.png)
