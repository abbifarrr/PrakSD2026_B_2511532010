package pekan9_2511532010;

import java.util.*;
public class GraphTransversal_2511532010 {
	private Map<String, List<String>> graph_2010 = new HashMap<>();
	
	// Menambahkan edge (graf tak berarah)
	public void addEdge (String node1_2010, String node2_2010) {
		graph_2010.putIfAbsent(node1_2010, new ArrayList<>());
		graph_2010.putIfAbsent(node2_2010, new ArrayList<>());
		graph_2010.get(node1_2010).add(node2_2010);
		graph_2010.get(node2_2010).add(node1_2010);
	}
	
	// Menampilkan graf awal
	public void printGraph() {
		System.out.println("Graf Awal (Adjacency List): ");
		for (String node_2010 : graph_2010.keySet() ) {
			System.out.print(node_2010 + " -> ");
			List<String> neighbors_2010 = graph_2010.get(node_2010);
			System.out.println(String.join(", ",  neighbors_2010));
		}
		System.out.println();
	}
	
	// DFS rekursif
	public void dfs (String start_2010) {
		Set<String> visited_2010 = new HashSet<>();
		System.out.println("Penelusuran DFS: ");
		dfsHelper(start_2010, visited_2010);
		System.out.println();
	}
	
	private void dfsHelper(String current_2010, Set<String> visited_2010) {
		if (visited_2010.contains(current_2010)) return;
		visited_2010.add(current_2010);
		System.out.print(current_2010 + " ");
		for (String neighbor_2010 : graph_2010.getOrDefault(current_2010, new ArrayList<>())) {
			dfsHelper(neighbor_2010, visited_2010);
		}
	}
	
	// BFS iteratif
	public void bfs(String start_2010) {
		Set<String> visited_2010 = new HashSet<>();
		Queue<String> queue_2010 = new LinkedList<>();
		queue_2010.add(start_2010);
		visited_2010.add(start_2010);
		System.out.println("Penelusuran BFS:");
		while (!queue_2010.isEmpty()) {
			String current_2010 = queue_2010.poll();
			System.out.print(current_2010 + " ");
			for (String neighbor_2010 : graph_2010.getOrDefault(current_2010, new ArrayList<>())) {
				if (!visited_2010.contains(neighbor_2010)) {
					queue_2010.add(neighbor_2010);
					visited_2010.add(neighbor_2010);
				}
			}
		}
		System.out.println();
	}
	
	// Main
	public static void main (String[] args) {
		GraphTransversal_2511532010 graph_obj_2010 = new GraphTransversal_2511532010();
		
		// Contoh graf: A-B, A-C, B-D, B-E
		graph_obj_2010.addEdge("A", "B");
		graph_obj_2010.addEdge("A", "C");
		graph_obj_2010.addEdge("B", "D");
		graph_obj_2010.addEdge("B", "E");
		
		// Cetak graf awal
		graph_obj_2010.printGraph();
		
		// Lakukan penelusuran
		graph_obj_2010.dfs("A");
		graph_obj_2010.bfs("A");
	}
}