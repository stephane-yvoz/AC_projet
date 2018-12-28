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
			if(visit[i] == false)
				result =  result || visiter(i,arbre,visit);	
		}
		for(Edge e : arbre.edges()) {
			e.setUsed(false);
		}
		return result;
	}
	
	public static boolean visiter(int depart,Graph arbre, boolean[] visit) {
		int other;
		visit[depart] = true;
		for(Edge e : arbre.adj(depart)) {
			if(e.isUsed()==false) {    // si pas déja passé par la
				e.setUsed(true);
				other = e.other(depart);  
				if(visit[other] == true) {  // si on peut visiter un sommet déja visité == cycle
					return true;
				}else {                     //sinon on doit visiter les voisins de ce sommet 
					return visiter(other,arbre,visit);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(new Edge(0,3));
		g.addEdge(new Edge(2,3));
		g.addEdge(new Edge(1,3));
		
		System.out.println(Kruskal.isCyclique(g));
	}
}
