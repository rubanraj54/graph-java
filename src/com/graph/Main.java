package com.graph;

import java.util.ArrayList;

/**
 * @author Rubanraj Ravichandran
 */
public class Main {

	public static void main(String[] args) {

		AdjacencyMatricesRW readWrite = new AdjacencyMatricesRW();

		AdjacencyMatrices matrix = readWrite.readMatrix("complex_weighted_graph");

		TypeConversion typeConversion = new TypeConversion();

		ShortestPath shortestPath = new ShortestPath();

		Graph graph = typeConversion.toGraph(matrix);

		// Topological sorting
		TopologicalSort sort = new TopologicalSort();

		if (matrix.isCyclic()) {
			System.out.println("Graph is cyclic");
		} else if (!matrix.isDirected()) {
			System.out.println("Graph is not directed");
		} else {
			System.out.println(sort.doTopologicalSort(graph).toString());
		}

		// shortest path

		Node startNode = graph.getNode(1);

		Node endNode = graph.getNode(8);

		if (startNode != null && endNode != null) {
			ArrayList<Node> traversalList = shortestPath.findShortestPath(graph, startNode, endNode);

			for (Node node : traversalList) {
				System.out.println(node.getNodeName());
			}
		} else {
			System.out.println("Start node or End node not found in the graph");
		}

	}

}
