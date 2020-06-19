package programming.graph;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {
	
	/**
	 * Dijkstra's shortest path algorithm using adjacency list and priority queue
	 * 
	 */
	
	class Node {
		
		int destination;
		int weight;
		
		Node (int dest, int weight) {
			this.destination=dest;
			this.weight=weight;
		}
	}
	
	List<List<Node>> adjacency_list; //adjacency list to represent graph
	Set<Integer> visited;               //set of visited nodes
	Map<Integer, Integer> weightedPath;
	PriorityQueue<Node> pq;
	
	
	private void create_the_graph() {
	
		//start from source
		
	}
}
