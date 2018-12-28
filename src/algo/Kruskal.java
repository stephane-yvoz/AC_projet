package src.algo;

import java.util.ArrayList;
import java.util.Collections;
import src.graphe.*;


public class Kruskal {
	
	public static Graph couvrantKruskal(Graph g) {
		
		Graph arbre = new Graph(g.vertices());
		ArrayList<Edge> edges = g.edges();
		Collections.shuffle(edges);  // on mélange les arétes
		for(Edge e : edges) {
			arbre.addEdge(e);
			if(isCyclique(arbre)) {
				arbre.deleteEdge(e);
			}
		}
		return arbre;
	}

	private static boolean isCyclique(Graph arbre) {
		boolean result = false;
		boolean[] visit = new boolean[arbre.vertices()];
		//ArrayList<Integer> aCheck = new ArrayList<Integer>();
		for(int i =0;i<visit.length;i++) {
			visit[i]=false;
		}
		for(int i =0;i<visit.length;i++) {
			if(!visit[i])
				result =  (result || visiter(i,arbre,visit,-1));	
		}
		return result;
	}
	
	public static boolean visiter(int depart,Graph arbre, boolean[] visit,int parent) {
		int other;
		visit[depart] = true;
		for(Edge e : arbre.adj(depart)) {
			other = e.other(depart);
			if(!visit[other]) {
				if(visiter(other,arbre,visit,depart)) {
					return true;
				}
			}else if(other != parent) {
				return true;
			}
			
		}
		return false;
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(new Edge(0,3));
		g.addEdge(new Edge(3,2));
		g.addEdge(new Edge(1,3));
		
		System.out.println(Kruskal.isCyclique(g));
	}
}
