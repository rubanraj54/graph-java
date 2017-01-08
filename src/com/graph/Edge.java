package com.graph;

/**
 * @author Rubanraj Ravichandran
 */
public class Edge {

	private int edgeName;
	private int weight;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getEdgeName() {
		return edgeName;
	}

	public void setEdgeName(int edgeName) {
		this.edgeName = edgeName;
	}

	@Override
	public String toString() {
		return "Edge [edgeName=" + edgeName + "]";
	}
}
