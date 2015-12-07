package graph;

import java.util.ArrayList;

public class Node {
	
	private int id;
	private String name;
	private int degree = 0;
	private boolean visited = false;
	ArrayList<Node> successors_nodes = new ArrayList<>();
	
	public Node(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public void appendSuccessor(Node n) {
		this.successors_nodes.add(n);
	}
	
	public ArrayList<Node> getSuccessorsList() {
		return this.successors_nodes;
	}
	
	public void increseDegree() {
		this.degree++;
	}
	
	public void decreseDegree() {
		this.degree--;
	}
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		System.out.println("visited: " + this.name);
		this.visited = visited;
	}

	public int getDegree() {
		return this.degree;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	
	@Override
	public String toString() {
		return "{id=" + id + ", name=" + name + ", degree=" + degree + "}";
	}
}
