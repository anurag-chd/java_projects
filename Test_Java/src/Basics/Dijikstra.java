package Basics;
import java.util.*;
public class Dijikstra {
	static HashMap<Vertex,Integer> unvisited_list = new HashMap<Vertex,Integer>();
	static HashMap<Vertex,Integer> visited_list = new HashMap<Vertex,Integer>();
	static HashMap<Vertex,Integer> distance = new HashMap<Vertex,Integer>();
	static HashMap<Vertex,Vertex> previous = new HashMap<Vertex,Vertex>();
	static Queue<Vertex> q = null;
	public static void main(String args[]){
		Graph g = new Graph();
		Collections.addAll(g.vertex_list,new Vertex("A"),new Vertex("B"),new Vertex("C"),new Vertex("D"),new Vertex("E"),new Vertex("F"));
		g.edge_list.add(new Edge(g.vertex_list.get(0),g.vertex_list.get(1),7));
		g.edge_list.add(new Edge(g.vertex_list.get(0),g.vertex_list.get(2),9));
		g.edge_list.add(new Edge(g.vertex_list.get(0),g.vertex_list.get(5),14));
		g.edge_list.add(new Edge(g.vertex_list.get(1),g.vertex_list.get(2),10));
		g.edge_list.add(new Edge(g.vertex_list.get(1),g.vertex_list.get(3),13));
		g.edge_list.add(new Edge(g.vertex_list.get(2),g.vertex_list.get(3),11));
		g.edge_list.add(new Edge(g.vertex_list.get(2),g.vertex_list.get(5),2));
		g.edge_list.add(new Edge(g.vertex_list.get(3),g.vertex_list.get(4),6));
		g.edge_list.add(new Edge(g.vertex_list.get(4),g.vertex_list.get(5),9));
		unvisited_list.put(g.vertex_list.get(1),100);
		unvisited_list.put(g.vertex_list.get(2),100);
		unvisited_list.put(g.vertex_list.get(3),100);
		unvisited_list.put(g.vertex_list.get(4),100);
		unvisited_list.put(g.vertex_list.get(5),100);
		visited_list.put(g.vertex_list.get(0),0);
		
		Dijikstra di = new Dijikstra();
		di.go(g,g.vertex_list.get(0));
		
	}
	
	public void go(Graph g, Vertex v){
		q = new PriorityQueue<>(50,  new DistanceComparator<Vertex>());
		for(Vertex ve : g.vertex_list){
			if(ve.name.equals(v.name)){
				distance.put(ve,0);
				q.add(ve);
			}
			else{
				distance.put(ve, 10000000);
				previous.put(ve, null);
				q.add(ve);
			}
			
		}
		
		/*for(Vertex ve:q){
			System.out.println(ve.name+" "+distance.get(ve));
		}*/
		//Iterator it = q.iterator();
		//while(it.hasNext()){
		while(!q.isEmpty()){
			Vertex u = q.remove();
			if(distance.get(u) == 10000000){
				break;
			}
			else{
				HashMap<Vertex,Integer> neighbour = g.findNeighbour(u);
				Set<Vertex> keyset = neighbour.keySet();
				for(Vertex ve : keyset){
					int alternate_distance = distance.get(u) + neighbour.get(ve);
					if(distance.get(ve) > alternate_distance){
						distance.put(ve,alternate_distance);
						previous.put(ve, u);
						q.remove(ve);
						q.add(ve);
					}
				}
			}
		}
		Set<Vertex> keyset2 = distance.keySet();
		for(Vertex ve : keyset2){
			System.out.println(ve.name+" "+ distance.get(ve));
		}
	}
}
	
 class DistanceComparator<Vertex> implements Comparator<Vertex>{
	public int compare(Vertex v1, Vertex v2){
		int v1_distance = Dijikstra.distance.get(v1);
		int v2_distance = Dijikstra.distance.get(v2);
		//return Math.min(v1_distance, v2_distance);
		return (int)(v1_distance - v2_distance);
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

