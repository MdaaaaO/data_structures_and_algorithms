package graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Graph {
	
	int number_of_nodes;
	HashMap<Integer, Node> hash_nodes = new HashMap<Integer, Node>();
	ArrayList<Edge> edges = new ArrayList<>();

	/**
	 * Constructor from a file.
	 * 
	 * Explanation of Input FILE:
	 * 		l1 		= Number of nodes 	[11]
	 * 		l2 		= Node names		[A,B,C,D]
	 * 		l3-ln 	= edges				[1, 2, 12]
	 * 		(EDGE from ID=1 to ID=2 with Weight=12)
	 * 
	 * @param file
	 */
	public Graph(String file) {

		try {
			
			// init readers
			FileReader file_r = new FileReader(file);
			BufferedReader buffered_r = new BufferedReader(file_r);
			
			// read first line, which contains number of nodes
			this.number_of_nodes = Integer.parseInt(buffered_r.readLine());
			
			// read second line, which contains names of nodes
			createNodes(buffered_r.readLine().split("\\s*,\\s*"));
			
			// read lines 3 to N, which contains edges
			String line3toN;
			while ((line3toN = buffered_r.readLine()) != null) {
				line3toN = line3toN.trim(); 	// remove white spaces
				if (line3toN.length() > 0) {	// check for empty lines
					createEdges(line3toN.split("\\s* \\s*"));
				}
			}
			
			// close readers
			buffered_r.close();
			file_r.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	
	/**
	 * Creating the Edges out of a line which looks like:
	 * 
	 * Assumptions: 
	 * 		1. There are only unique IDs for our Nodes
	 * 
	 * @param String[] line with line[0] = id_1, 
	 * 							 line[1] = id_2, 
	 * 							 line[2] = weight
	 */
	private void createEdges(String[] line) {
		int id_1 = Integer.parseInt(line[0]);
		int id_2 = Integer.parseInt(line[1]);
		double weight = Double.parseDouble(line[2]);
		
		Edge edge = new Edge(hash_nodes.get(id_1), hash_nodes.get(id_2), weight);
		edges.add(edge);
	}
	
	/**
	 * Creating nodes using the String[] names, starting with ID=1 for first 
	 * name.
	 * 
	 * @param String[] names
	 */
	private void createNodes(String[] names) {
		for (int i = 0; i < names.length; i++) {
			int node_id_and_key = i + 1;
			Node node = new Node(names[i], node_id_and_key);	// +1 because INPUT file
			hash_nodes.put(node_id_and_key, node);				// IDs starts with 1
		}
	}

	/**
	 * Given a nodeID, this method will return the degree of the node within 
	 * this graph.
	 * 
	 * wiki: In graph theory, the degree (or valency) of a vertex of a graph is 
	 * 		 the number of edges incident to the vertex, with loops counted 
	 * 		 twice.
	 * 
	 * @param int nodeID
	 * @return int nodeDegree 	
	 */
	int getDegree(int nodeID) {
		return this.hash_nodes.get(nodeID).getDegree();
	}
	
	/**
	 * This method checks all nodes, to find out whether this is an euler graph
	 * or not, see wiki definition for more information.
	 * 
	 * wiki: The term Eulerian graph has two common meanings in graph theory. 
	 *       One meaning is a graph with an Eulerian circuit, and the other is 
	 *       a graph with every vertex of even degree. 
	 * 
	 *       These definitions coincide for connected graphs.
	 * 
	 * @return boolean True if this is an Eulerian graph
	 */
	public boolean isEulerianGraph() {
		//TODO: Improve iterator, looks off atm.
		int oddNodes = 0;
		if (isConnected()) {
			Iterator it = hash_nodes.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        // Assumption - ID and KEY have same value and are unique
		        int id = Integer.parseInt(pair.getKey().toString());
		        int degree = getDegree(id);
		        if (degree % 2 == 1) {
		        	oddNodes++;
		        }
		        it.remove(); // avoids a ConcurrentModificationException
		    }
		    return (oddNodes == 0);
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * 
	 * wiki: Breadth-first search (BFS) is an algorithm for traversing or 
	 *       searching tree or graph data structures.
	 */
	public void graphBFS(int ID) {
		Queue queue = new LinkedList<Node>();
		queue.add(hash_nodes.get(ID));
		while(!queue.isEmpty()) {
			Node node = (Node) queue.poll();
			node.setVisited(true);
			for (int i = 0; i < node.getSuccessorsList().size(); i++) {
				if (!node.getSuccessorsList().get(i).isVisited() &&
						!queue.contains(node.getSuccessorsList().get(i))) {
					queue.add(node.getSuccessorsList().get(i));
				}
			}
		}
	}
	
	/**
	 * This method will perform a DFS on the current Graph and print out the
	 * visited node to the terminal.
	 * 
	 * We are using a directed graph, every Node has a list of successors which
	 * helps us to perform DFS.
	 * 
	 *  wiki: Depth-first search (DFS) is an algorithm for traversing or 
	 *        searching tree or graph data structures.
	 */
	public void graphDFS(int ID) {
		Node node = hash_nodes.get(ID);
		node.setVisited(true);
		for (int i = 0; i < node.getSuccessorsList().size(); i++) {
			if (!node.getSuccessorsList().get(i).isVisited()) {
				graphDFS(node.getSuccessorsList().get(i).getId());
			}
		}
		System.out.println("No more successors for " + node.getName());
	}
	
	private boolean isConnected() {
		//TODO: check connection with BFS or DFS
		return true;
	}

	@Override
	public String toString() {
		return "+++ GRAPH TO STRING +++"
				+ "\n[number_of_nodes=" + number_of_nodes + "]"
				+ "\n[nodes=" + hash_nodes + "]"
				+ "\n[edges=" + edges + "]"
				+ "\n+++ THE END +++";
	}
}