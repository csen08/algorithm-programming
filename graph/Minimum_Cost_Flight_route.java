package programming.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Minimum_Cost_Flight_route {
	
	/*A adjacency list to represent the graph */
	List<List<Node>> adjacency_list;//insertion order maintained in list
	
	/*Number of vertices in the graph */
	int V;
	
	/* int array containing minimum cost of all locations from source*/
	int[] cost_from_source;
	
	/* Set of nodes that are visited when algorithm runs*/
	Set<String> visitedNodes;
	
	PriorityQueue<String> pq;
	
	/*Map to map location,int position in the adj. list */
	Map<String, Integer> location_position_map;
			
	
	public static void main(String[] args) {
		
		Minimum_Cost_Flight_route cfr= new Minimum_Cost_Flight_route();
		String[][] flight_schedule = 
			{
					{"A","C","100"},
					{"A","B","20"},
					{"B","C","50"}
			};
		String source="A";
		String destination="C";
		
		int val = cfr.best_price(flight_schedule, source, destination);
		System.out.println("Minimum cost from "+source+" to "+destination +" is:"+val);
		
		source="C";
		destination="A";
		val = cfr.best_price(flight_schedule, source, destination);
		System.out.println("Minimum cost from "+source+" to "+destination +" is:"+val);
	}
	
	
	public int best_price(String[][] flight_schedule, String source, String destination) {
			
		create_the_graph(flight_schedule, source);
		set_all_destination_cost_with_max_value();
		
		pq = new PriorityQueue<String>();
		pq.add(source);
		visitedNodes = new HashSet<>(V);
		while (visitedNodes.size() != V-1) { //we will visit all nodes except the destination
			String curr_loc = pq.poll();
			if (!curr_loc.equals(destination)) {
				visitedNodes.add(curr_loc);
				visit_neighbors(curr_loc);
			}
		}
		return cost_from_source[location_position_map.get(destination)];
	}
	
	/**
	 * visit all neighboring locations of this location 
	 */
	private void visit_neighbors(String location) {
		
		int edgeCost=-1;
		int newCost=-1;
		int current_node_index = location_position_map.get(location);
		
		//Run loop on all nodes surrounding current location
		for (int i=0; i<adjacency_list.get(current_node_index).size(); i++) {
			
			Node v = adjacency_list.get(current_node_index).get(i);
			if (!visitedNodes.contains(v.destination)) {
				int visiting_node_index = location_position_map.get(v.destination);
				edgeCost=Integer.parseInt(v.cost);
				newCost = edgeCost+cost_from_source[current_node_index]; //new cost is equals to edge cost plus cost till source from
				
				//If new cost is less, it is the new cost
				if (newCost < cost_from_source[visiting_node_index]) {
					cost_from_source[visiting_node_index] = newCost;
				}
				
				//add the node to queue
				pq.offer(v.destination);
			}
		}
	}
	
	
	class Node implements Comparable<Node>{
		String destination;
		String cost;
		Node (String dest, String weight) {
			this.destination=dest;
			this.cost=weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.destination.compareTo(o.destination);
		}
	}
	
	
	public void create_the_graph(String[][] flight_schedule, String source) {

		//-----------------------------------
		//1. Need all vertices in the graph
		//-----------------------------------
		//location_position_map - Holds location and its corresponding assigned numeric value
		//source location has position 0
		
		int index=1;
		location_position_map =new HashMap<String, Integer>();
		for (int i=0;i<flight_schedule.length;i++) {
			for (int j=0;j<2;j++) {
				
				String location = flight_schedule[i][j];
				if (location_position_map.get(location) == null) //If location already filled, ignore
				{
					if (location==source)
						location_position_map.put(location, 0);
					else
						location_position_map.put(location, index++);
				}
			}	
		}
		
		V = location_position_map.size();	
		
		//-----------------------------------
		//2. Prepare the adjacency list
		//-----------------------------------
		adjacency_list = new ArrayList<>(V);
		//initialize with null
		for (int i=0;i<V;i++) {
			adjacency_list.add(null);
		}
		
		for (int i=0;i<flight_schedule.length;i++) {

			if (adjacency_list.get(location_position_map.get(flight_schedule[i][0]))==null) //if we do not init the list with null, we get ArrayIndexOutOfBoundsException here 
				//check only the 0'th element, because it is source. and we create adjacency list w.r.t the source vertex
			{ 
				List<Node> llist = new ArrayList<>();
				llist.add(new Node(flight_schedule[i][1],flight_schedule[i][2])); // So adjacency list will hold a Node, which is {destination and cost} w.r.t source
				
				adjacency_list.
					set(location_position_map.get(flight_schedule[i][0]), llist);
			}
			else
			{
				adjacency_list.get(location_position_map.get(flight_schedule[i][0]))
					.add(new Node(flight_schedule[i][1],flight_schedule[i][2]));
			}
			
			//[A,C,100] mean [C,A,100] as well
			if (adjacency_list.get(location_position_map.get(flight_schedule[i][1]))==null) //if we do not init the list with null, we get ArrayIndexOutOfBoundsException here 
				//check only the 0'th element, because it is source. and we create adjacency list w.r.t the source vertex
			{ 
				List<Node> llist = new ArrayList<>();
				llist.add(new Node(flight_schedule[i][0],flight_schedule[i][2])); // So adjacency list will hold a Node, which is {destination and cost} w.r.t source
				
				adjacency_list.
					set(location_position_map.get(flight_schedule[i][1]), llist);
			}
			else
			{
				adjacency_list.get(location_position_map.get(flight_schedule[i][1]))
					.add(new Node(flight_schedule[i][0],flight_schedule[i][2]));
			}
		}
	}
	
	private void set_all_destination_cost_with_max_value() {
		
		cost_from_source = new int[adjacency_list.size()];
		for (int i=0;i<cost_from_source.length;i++) {
			cost_from_source[i]=Integer.MAX_VALUE;
		}
		cost_from_source[0]=0; //source to source has no cost 
	}
	
}
