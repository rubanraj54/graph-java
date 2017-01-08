package com.graph;

import java.util.LinkedHashSet;

/**
 * @author Rubanraj Ravichandran
 */
public class Graph {
	private LinkedHashSet<Node> graph = new LinkedHashSet<Node>();

	public int getNodeSize() {
		return graph.size();
	}

	public LinkedHashSet<Node> getNodes() {
		return graph;
	}

	public void addNode(Node node) {
		graph.add(node);
	}

	public Node getNode(int index) {
		for (Node node : graph) {
			if (index == node.getNodeName()) {
				return node;
			}
		}
		return null;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		for (Node node : graph) {
			sb.append(node.getNodeName()).append("--->");
			for (Edge edge : node.getEdges()) {
				sb.append(edge.getEdgeName());
			}
			sb.append("\n");
		}

		return sb.toString();
	}

}
