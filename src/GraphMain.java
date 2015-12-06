import graph.Graph;

public class GraphMain {

	public static void main(String[] args) {
		
		String file = "/home/mdaaaa/projects/data_structures_and_algorithms/input/GRAPH";
		Graph graph = new Graph(file);
		System.out.println(graph.toString());
	}
}
