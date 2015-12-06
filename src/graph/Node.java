package graph;

public class Node {
	
	private int id;
	private String name;
	private int degree = 0;
	
	public Node(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public void increseDegree() {
		this.degree++;
	}
	
	public void decreseDegree() {
		this.degree--;
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
