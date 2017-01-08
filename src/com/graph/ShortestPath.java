package com.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ShortestPath {

	public ArrayList<Node> findShortestPath(Graph graph, Node startNode, Node endNode) {

		List<Integer> visited = new ArrayList<Integer>();
		visited.add(startNode.getNodeName());
		List<String> shortest_paths = new ArrayList<String>();
		shortest_paths = depthFirstSearch(startNode, endNode, visited, shortest_paths, graph);

		ArrayList<Node> traversalList = new ArrayList<>();

		String shortest_path = calculateShortestPath(shortest_paths, graph, startNode, endNode);
		for (String node : shortest_path.split(" ")) {
			traversalList.add(graph.getNode(Integer.parseInt(node)));
		}

		return traversalList;
	}

	private List<String> depthFirstSearch(Node current, Node goal, List<Integer> visited, List<String> shortest_paths,
			Graph graph) {

		for (Edge edge : current.getEdges()) {
			if (edge.getEdgeName() == goal.getNodeName()) {
				String result = "";
				for (int i : visited) {
					result += i + " ";
				}
				result += goal.getNodeName();
				shortest_paths.add(result);
				return shortest_paths;
			}

			if (!visited.contains(edge.getEdgeName())) {
				visited.add(edge.getEdgeName());
				shortest_paths = depthFirstSearch(graph.getNode(edge.getEdgeName()), goal, visited, shortest_paths,
						graph);
				visited.remove(visited.size() - 1);
			}
		}
		return shortest_paths;
	}

	private String calculateShortestPath(List<String> paths, Graph graph, Node startNode, Node endNode) {
		int shortest_distance = Integer.MAX_VALUE;
		String shortest_path = paths.get(0);
		int[] nodes;
		int length;

		for (String path : paths) {
			nodes = Stream.of(path.split(" ")).mapToInt(Integer::parseInt).toArray();
			length = 0;
			for (int i = 0; i < nodes.length - 1; i++) {
				length += graph.getNode(nodes[i]).getEdge(nodes[i + 1]).getWeight();
			}
			if (length < shortest_distance) {
				shortest_distance = length;
				shortest_path = path;
			}
		}

		System.out.println("The shortest path between " + startNode.getNodeName() + " and " + endNode.getNodeName()
				+ " is : " + shortest_path + " and the distance is " + shortest_distance);

		return shortest_path;
	}
}
