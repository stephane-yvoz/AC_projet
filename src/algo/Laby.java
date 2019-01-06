package src.algo;

import src.graphe.Display;
import src.graphe.Edge;
import src.graphe.Graph;
import src.graphe.Test;

public class Laby {

    private int x;
    private int y;

    public Laby(int x, int y){
        this.x = x;
        this.y = y;
    }

    private Graph createLaby(){
        Graph g = new Graph(x*y);
        for(int j = 0 ;j < y;j++) {
            for (int i = 1; i < x; i++) {
                g.addEdge(new Edge( j * x + i - 1,  j  * x + i));
            }
        }

        for(int j =0; j < y-1; j++){
            for(int i =0; i < x;i++){
                g.addEdge(new Edge( j * x + i,  (j+1)  * x + i));
            }
        }

        return g;
    }

    public Graph getLabyAldous(){
        Graph g = createLaby();
        Graph g2 = AldousBroder.couvrant(g);
        int i;
        int j = 0;

        while(j < g2.edges().size()){
            i = 0;
            while(i < g.edges().size()){
                if(g.edges().get(i).equals(g2.edges().get(j))){
                    g.deleteEdge(g.edges().get(i));
                }
                else {
                    i++;
                }
            }
            j++;
        }
        return g;
    }

    public Graph getLabyKruskal() {
        Graph g = createLaby();
        Graph g2 = Kruskal.couvrantKruskal(g);
        int i;
        int j = 0;

        while(j < g2.edges().size()){
            i = 0;
            while(i < g.edges().size()){
                if(g.edges().get(i).equals(g2.edges().get(j))){
                    g.deleteEdge(g.edges().get(i));
                }
                else {
                    i++;
                }
            }
            j++;
        }
        return g;
    }

    public Graph getLabyWilson(){
        Graph g = createLaby();
        Graph g2 = Wilson.couvrant(g);
        int i;
        int j = 0;

        while(j < g2.edges().size()){
            i = 0;
            while(i < g.edges().size()){
                if(g.edges().get(i).equals(g2.edges().get(j))){
                    g.deleteEdge(g.edges().get(i));
                }
                else {
                    i++;
                }
            }
            j++;
        }
        return g;
    }

    public int evalCulSac(Graph g){
        int res = 0;
        for(int i = 0; i < g.vertices();i++){
            if(g.adj(i).size() <= 1){
               res++;
            }
        }
        return res;
    }

    public int plusCourt(Graph g){
        int res = 0;

        return res;
    }

}
