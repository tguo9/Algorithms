
/*
 * This is a class for GraphAdjMatrix. By using 2D-Array, for small number.
 * @author Tao Guo
 */

import java.util.Stack;

public class GraphAdjMatrix implements Graph {

	private int[][] edges;

	/*
	 * Constructs and returns a graph with the number of vertices passed as the
	 * argument. Vertices have IDs, numbered 0, 1, ..., vertices-1. No edges exist
	 * between vertices at instantiation.
	 */
	public GraphAdjMatrix(int v) {
		edges = new int[v][v];
	}

	/*
	 * Adds a directed edge between two vertices from src to tar.
	 */
	public void addEdge(int v1, int v2) {
		edges[v1][v2] = 1;
	}

	/*
	 * Prints (to console) one ordering of vertices such that each directed edge
	 * (v1, v2) from vertex v1 to vertex v2, v1 comes before v2 in the ordering. If
	 * such an ordering is not possible (due to cycles, for example), this function
	 * must indicate so, though it may print a partial solution in so doing.
	 */
	public void topologicalSort() {

		boolean[] visited = new boolean[edges.length];

		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == false) {
				explore(i, visited);
			}
		}

	}

	/*
	 * Override explore method. Take int from for loop, and boolean array to keep
	 * track of visited.
	 */
	private void explore(int v, boolean[] visited) {

		Stack<Integer> s = new Stack<Integer>();
		s.push(new Integer(v));

		while (s.empty() == false) {

			int pop = s.pop();
			System.out.print(pop + " ");
			visited[v] = true;

			int[] neighbors = neighbors(pop);

			for (int i = 0; i < neighbors.length; i++) {
				if (visited[neighbors[i]] == false) {
					s.push(new Integer(neighbors[i]));
					visited[neighbors[i]] = true;
				}
			}
		}
		System.out.println();

	}

	/*
	 * Returns an array of vertex IDs such that each ID represents a vertex which is
	 * the destination of the edge origination from the argument.
	 */
	public int[] neighbors(int vertex) {

		int[] vertexs = new int[outDegree(vertex)];
		int index = 0;

		for (int i = 0; i < edges.length; i++) {
			if (edges[vertex][i] == 1) {
				vertexs[index] = i;
				index++;
			}
		}
		return vertexs;
	}

	/*
	 * Helper methods for finding neighbors. By find the out-degree of vertex.
	 */
	private int outDegree(int vertex) {
		int degree = 0;
		for (int i = 0; i < edges.length; i++) {
			if (edges[vertex][i] != Integer.MAX_VALUE && edges[vertex][i] != 0) {
				degree++;
			}
		}
		return degree;
	}

}
