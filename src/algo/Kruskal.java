package src.algo;

import java.util.ArrayList;
import java.util.Collections;

import src.graphe.*;


public class Kruskal {
	
	public static Graph Kruskal(Graph g) {
		
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
		// TODO Auto-generated method stub
		return false;
	}
	
	
		
		
		
		return arbre;
	}

}
