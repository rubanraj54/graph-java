package com.graph;

import java.util.ArrayList;

/**
 * @author Rubanraj Ravichandran
 */
public class TopologicalSort {

	public Graph doTopologicalSort(Graph graph) {
		AdjacencyMatrices matrix = new TypeConversion().toMatrix(graph);

		ArrayList<Integer> visited = new ArrayList<Integer>();

		Graph sortResult = new Graph();

		int nodeSize = matrix.getNodeSize();

		int counter = 0;
		while (visited.size() != nodeSize) {
			key: for (int i = 0; i < matrix.getNodeSize(); i++) {
				for (int j = 0; j < matrix.getNodeSize(); j++) {
					if (!visited.contains(i) && !visited.contains(j)) {
						if (matrix.hasEdge(j, i) == 0) {
							counter++;
						}
					}
				}
				if (counter == nodeSize - visited.size()) {
					visited.add(i);
					counter = 0;
					break key;
				}
				counter = 0;
			}

		}

		for (int i : visited) {
			sortResult.addNode(graph.getNode(i));
		}

		return sortResult;

	}
}
