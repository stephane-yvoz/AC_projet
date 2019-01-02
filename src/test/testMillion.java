package src.test;

import src.algo.AldousBroder;
import src.algo.Kruskal;
import src.graphe.Edge;
import src.graphe.Graph;

public class testMillion {
	
	private static Graph[] types;
	
	private static void  initTypesArbre(Graph g) {
		types = new Graph[8];
		for(int i=0;i<8;i++) {
			types[i] = new Graph(4);
		}
		Edge AB = new Edge(0,1);
		Edge BD = new Edge(1,3);
		Edge CD = new Edge(2,3);
		Edge AC = new Edge(0,2);
		Edge AD = new Edge(0,3);
		
		types[0].addEdge(AB);
		types[0].addEdge(BD);
		types[0].addEdge(CD);
		
		types[1].addEdge(AC);
		types[1].addEdge(CD);
		types[1].addEdge(BD);
		
		types[2].addEdge(AD);
		types[2].addEdge(BD);
		types[2].addEdge(CD);
		
		types[3].addEdge(AB);
		types[3].addEdge(BD);
		types[3].addEdge(AC);
		
		types[4].addEdge(CD);
		types[4].addEdge(AC);
		types[4].addEdge(AB);
		
		types[5].addEdge(AD);
		types[5].addEdge(AB);
		types[5].addEdge(AC);
		
		types[6].addEdge(AB);
		types[6].addEdge(AD);
		types[6].addEdge(CD);
		
		types[7].addEdge(BD);
		types[7].addEdge(AD);
		types[7].addEdge(AC);
	}
	
	private static int getTypeArbre(Graph arbre) {
		for(int i =0;i<types.length;i++) {
			if(types[i].equals(arbre)) {
				return i;
			}
		}
		return -1;
	}
	
	private static void testMillionKruskal(Graph g) {
		int[] occurence = new int[8];
		for(int i=0;i<8;i++) {
			occurence[i] = 0;
		}	
		for(int i=0;i<1000000;i++) {
			Graph couvrant = Kruskal.couvrantKruskal(g);
			int type = getTypeArbre(couvrant);
			occurence[type] ++;
		}
		
		for(int i=0;i<8;i++) {
			System.out.println("occurence du type "+i+" : "+occurence[i]);
		}
		
	}

	private static void testMillionAldous(Graph g){
		int[] occurence = new int[8];
		for(int i=0;i<8;i++) {
			occurence[i] = 0;
		}
		for(int i=0;i<1000000;i++) {
			Graph couvrant = AldousBroder.couvrant(g);
			int type = getTypeArbre(couvrant);
			occurence[type] ++;
		}

		for(int i=0;i<8;i++) {
			System.out.println("occurence du type "+i+" : "+occurence[i]);
		}
	}

	private static void testMillion(Graph g) {
		int[] occurence = new int[8];
		for(int i=0;i<8;i++) {
			occurence[i] = 0;
		}
		for(int i=0;i<1000000;i++) {
			Graph couvrant = Kruskal.couvrantKruskal(g);
			int type = getTypeArbre(couvrant);
			occurence[type] ++;
		}

		for(int i=0;i<8;i++) {
			System.out.println("occurence du type "+i+" : "+occurence[i]);
		}

	}

	
	public static void main(String[] args) {
		Graph g1 = new Graph(4);
		g1.addEdge(new Edge(0,1));
		g1.addEdge(new Edge(0,2));
		g1.addEdge(new Edge(0,3));
		g1.addEdge(new Edge(1,3));
		g1.addEdge(new Edge(2,3));
		
		
		
		testMillion.initTypesArbre(g1);

		testMillionAldous(g1);
	}
}
