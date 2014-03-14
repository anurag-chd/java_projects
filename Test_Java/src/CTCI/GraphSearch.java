package CTCI;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Queue;
import java.util.Iterator;
import java.util.Set;

public class GraphSearch {
	
	public static void main(String args[]){
		Graph g = new Graph();
		Collections.addAll(g.vertex_list,new Vertex("A"),new Vertex("B"),new Vertex("C"),new Vertex("D"),new Vertex("E"),new Vertex("F"),new Vertex("G"));
		g.edge_list.add(new Edge(g.vertex_list.get(0),g.vertex_list.get(1),7));
		g.edge_list.add(new Edge(g.vertex_list.get(0),g.vertex_list.get(2),9));
		g.edge_list.add(new Edge(g.vertex_list.get(0),g.vertex_list.get(5),14));
		g.edge_list.add(new Edge(g.vertex_list.get(1),g.vertex_list.get(2),10));
		g.edge_list.add(new Edge(g.vertex_list.get(1),g.vertex_list.get(3),13));
		g.edge_list.add(new Edge(g.vertex_list.get(2),g.vertex_list.get(3),11));
		g.edge_list.add(new Edge(g.vertex_list.get(2),g.vertex_list.get(5),2));
		g.edge_list.add(new Edge(g.vertex_list.get(3),g.vertex_list.get(4),6));
		g.edge_list.add(new Edge(g.vertex_list.get(4),g.vertex_list.get(5),9));
		
		GraphSearch gs = new GraphSearch();
		if(gs.search(g, g.vertex_list.get(0) ,g.vertex_list.get(6))){
			System.out.println("The path between the two exists");
		}
		else{
			System.out.println("Their is no path between the two");
		}
		
		
	} 
	
	public enum State{UnVisited, Visiting, Visited};
	
	public boolean search(Graph g, Vertex A , Vertex B){
		Queue<Vertex> q =  new java.util.LinkedList<Vertex>();
		Iterator<Vertex> it = g.vertex_list.iterator();
		ArrayList<Vertex> visited_vertex = new ArrayList<Vertex>();
		q.add(A);
		while(!q.isEmpty()){
			Vertex v = q.remove();
			visited_vertex.add(v);
			HashMap<Vertex, Integer> neighbours = g.findNeighbour(v);
			Set<Vertex> neighbour_set = neighbours.keySet();
			for(Vertex v1: neighbour_set){
				System.out.println("Visited Vertex"+v1.name);
				q.add(v1);
			}
			
		}
		if(visited_vertex.contains(B)){
			return true;
		}
		else{
			return false;
		}
	}

}







class Vertex{
	String name;
	public Vertex(String name){
		this.name = name;
	}
}

 class Edge{
	Vertex first;
	Vertex second;
	int distance;
	public Edge(Vertex first, Vertex second, int distance){
		this.first = first;
		this.second = second;
		this.distance = distance;
		
	}
}

 class Graph{
	ArrayList<Vertex> vertex_list = new ArrayList<Vertex>();
	ArrayList<Edge> edge_list = new ArrayList<Edge>();
	
	/*public List<Vertex> findNeighbour(Vertex A){
		List<Vertex> nextNeighbour = new ArrayList<Vertex>();
		for(int i =0; i< edge_list.size();i++){
			if(A.name.equals(edge_list.get(i).first)){
				nextNeighbour.add(edge_list.get(i).second);
			}
			
		}
		return nextNeighbour;
	}*/
	
	public HashMap<Vertex,Integer> findNeighbour(Vertex A){
		HashMap<Vertex,Integer> nextNeighbour = new HashMap<Vertex,Integer>();
		for(int i =0; i< edge_list.size();i++){
			
			if(A.name.equals(edge_list.get(i).first.name)){
				nextNeighbour.put(edge_list.get(i).second,edge_list.get(i).distance);
			}
			
		}
		return nextNeighbour;
	}
	
}

