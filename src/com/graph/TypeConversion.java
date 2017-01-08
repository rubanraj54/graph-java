package com.graph;

import java.util.LinkedHashSet;

/**
 * @author Rubanraj Ravichandran
 */
public class TypeConversion {

	public Graph toGraph(AdjacencyMatrices matrix) {
		Graph graph = new Graph();
		int[][] newMatrix = matrix.getMatrix();
		for (int i = 0; i < matrix.getNodeSize(); i++) {
			Node node = new Node();
			node.setNodeName(i);
			for (int j = 0; j < matrix.getNodeSize(); j++) {
				if (newMatrix[i][j] > 0) {
					Edge edge = new Edge();
					edge.setEdgeName(j);
					edge.setWeight(newMatrix[i][j]);
					node.addEdge(edge);
				}
			}
			graph.addNode(node);
		}
		return graph;
	}

	public AdjacencyMatrices toMatrix(Graph graph) {

		int nodeSize = graph.getNodeSize();

		AdjacencyMatrices matrices = new AdjacencyMatrices(nodeSize);
		LinkedHashSet<Node> newGraph = graph.getNodes();

		int i = 0;
		for (Node node : newGraph) {
			for (Edge edge : node.getEdges()) {
				matrices.addEdge(i, edge.getEdgeName(), edge.getWeight());
			}
			i++;
		}
		return matrices;

	}

}
