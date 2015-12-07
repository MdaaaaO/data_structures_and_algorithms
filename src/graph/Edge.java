package graph;

public class Edge {
	
	Node v0;
	Node v1;
	double weight = 0.0;
	
	public Edge(Node v0, Node v1, double weight) {
		this.v0 = v0;
		this.v0.increseDegree();
		this.v1 = v1;
		this.v1.increseDegree();
		this.weight = weight;
		this.v0.appendSuccessor(v1);
	}
	
	/**
	 * Decreases the degree of used node by this edge.
	 * 
	 * Note: Not used yet, but you have to make sure to decrese the degree of 
	 * 		 used nodes as soon as you have destroyed this edge.
	 * 
	 */
	public void decreaseDegreeOfUsedNodes() {
		this.v0.decreseDegree();
		this.v1.decreseDegree();
	}

	@Override
	public String toString() {
		return "{FROM " + v0.getName() 
				+ " TO " + v1.getName() 
				+ " | W=" + weight + "}";
	}
	
	

}
