package com.graph;

import java.util.ArrayList;

public class Node {

	private int nodeName;

	private ArrayList<Edge> edges = new ArrayList<Edge>();

	public int getNodeName() {
		return nodeName;
	}

	public void setNodeName(int nodeName) {
		this.nodeName = nodeName;
	}

	@Override
	public String toString() {
		return "Node [nodeName=" + nodeName + "]";
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void addEdge(Edge edge) {
		this.edges.add(edge);
	}

	public Edge getEdge(int edgeName) {
		for (Edge edge : edges) {
			if (edgeName == edge.getEdgeName()) {
				return edge;
			}
		}
		return null;
	}

}
