package programming.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class TopologicalSorting {
	/**
	 * Input: 4, [[0,1],[3,1],[1,3],[3,2]]
	 * Output: []
	 * 
	 * Input: 3, []
	 * Output: [2,1,0]
	 * 
	 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
	 * Output: [0,1,2,3] or [0,2,1,3]
	 */
	public static void main(String[] args) {
		TopologicalSorting ins = new TopologicalSorting();
		
//		int numCourses = 4;
//		int[][] prerequisites= new int[][] {{1,0},{2,0},{3,1},{3,2}};
//				
//		ins.findOrder(numCourses, prerequisites);
//		System.out.println();
//		numCourses = 2;
//		prerequisites= new int[][] {{1,0}};
		
		int numCourses = 2;
		int[][] prerequisites= new int[][] {{0,1}};
		
		ins.findOrder(numCourses, prerequisites);
	}
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		
        List<List<Integer>> adjlist = new ArrayList<List<Integer>>(numCourses);
		
		createAdjList(adjlist, numCourses);
		
		for (int i=0;i<prerequisites.length;i++) {
			addEdge(adjlist,prerequisites[i][1], prerequisites[i][0]);
		}
		
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> finished = new HashSet<>();
        
        for (int i=0;i<adjlist.size(); i++) {
			if (!visited.contains(i)) {
				boolean cycle = dfs_visit(adjlist,i,visited,finished);
                if (cycle) return new int[]{};
			}
		}
        
        visited= new HashSet<>();
        
        for (int i=0;i<adjlist.size(); i++) {
			if (!visited.contains(i)) {
				topologicalSort(adjlist, i, visited, stack);
			}
		}
		
        int[] res = new int[stack.size()];
        int idx=0;
		while (stack.empty()==false)
			res[idx++]=stack.pop();
        
        return res;
    }
	
	// Recursive topological Sort
	//https://java2blog.com/topological-sort-java/
	/*
	 * This algorithm is a variant of Depth-first search.
	 * In depth first search, we first print the vertex and then go to its neighbors 
	 * but  in case of topological sort, we don’t print vertex immediately instead we push it to the Stack.
	 * 
	 * In topological sorting, we will have a temporary stack. 
	 * We are not going to print the vertex immediately, we first recursively call topological sorting for all its neighbor vertices, 
	 * then push it to a stack. We will print stack once we are done with recursive topological sorting.
	 * 
	 * Why it works?
	 * It works because when you push any node to stack, you have already pushed its neighbors(and their neighbors and so on),
	 * so node which does not have any dependency will be on the top of stack.
	 */
	public void topologicalSort(List<List<Integer>> adjlist, int v, Set<Integer> visited, Stack<Integer> stack)
	{
        visited.add(v);
		List<Integer> list = adjlist.get(v);

		for (int i = 0; i < list.size(); i++) {
			Integer n=list.get(i);
			if(n!=null && !visited.contains(n))//set holds visited vertices
			{
				topologicalSort(adjlist, n, visited, stack);
			}
		}
		stack.push(v);
	}
    
    //loop detection
  	// code for cycle detection
	public boolean dfs_visit(List<List<Integer>> adjlist, int v, Set<Integer> visited, Set<Integer> finished)
	{
		boolean cycle = false;
		
		visited.add(v);
		List<Integer> list = adjlist.get(v);
		
		for (int i = 0; i < list.size(); i++) {
			Integer n=list.get(i);
			if (visited.contains(n))
			{
				cycle = true;
				return cycle;
			}
			if (n!=null && !finished.contains(n)) {
				cycle = dfs_visit(adjlist, n, visited, finished);
				if (cycle) return true;
			}
		}
		visited.remove(v);
		finished.add(v);
		
		return cycle;
	}
	
	public void createAdjList(List<List<Integer>> adjlist, int V){
        
		for (int i=0;i<V;i++) {
			adjlist.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(List<List<Integer>> adjlist, int a, int b) {
        
		adjlist.get(a).add(b);
	}	

}
