package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rubanraj Ravichandran
 */
public class AdjacencyMatrices {

	//matrix array
	private int[][] matrix;

	public int getNodeSize() {
		return matrix[0].length;
	}

	public AdjacencyMatrices(int size) {
		matrix = new int[size][size];

		for (int[] row : matrix)
			Arrays.fill(row, 0);
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public void addEdge(int i, int j, int weight) {
		matrix[i][j] = weight;
	}

	public void removeEdge(int i, int j) {
		matrix[i][j] = 0;
	}

	public int hasEdge(int i, int j) {
		return matrix[i][j];
	}

	@Override
	public String toString() {

		String lineSeparator = System.lineSeparator();
		String result = "";

		for (int[] row : matrix) {
			for (int val : row) {
				result += val + " ";
			}
			result += lineSeparator;
		}

		return result;
	}

	public boolean isDirected() {

		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix[1].length; j++) {

				if (matrix[i][j] > 0 && matrix[j][i] > 0) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isCyclic() {

		TypeConversion matrixToGraph = new TypeConversion();

		AdjacencyMatrices adjacencyMatrices = new AdjacencyMatrices(getNodeSize());
		adjacencyMatrices.setMatrix(matrix);

		Graph graph = matrixToGraph.toGraph(adjacencyMatrices);

		for (Node node : graph.getNodes()) {
			List<Integer> visited = new ArrayList<Integer>();
			visited.add(node.getNodeName());

			if (depthFirstSearch(node, visited, graph)) {
				return true;
			}
		}

		return false;

	}

	private boolean depthFirstSearch(Node current, List<Integer> visited, Graph graph) {

		for (Edge edge : current.getEdges()) {
			if (visited.contains(edge.getEdgeName())) {
				return true;
			}

			visited.add(edge.getEdgeName());
			if (depthFirstSearch(graph.getNode(edge.getEdgeName()), visited, graph)) {
				return true;
			}
			visited.remove(visited.size() - 1);
		}
		return false;

	}

}
