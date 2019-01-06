package src.algo;

import src.graphe.Display;
import src.graphe.Edge;
import src.graphe.Graph;
import src.graphe.Test;

public class Laby {

    private int x;
    private int y;
    private Graph laby;
    private Graph inverse;

    public Laby(int x, int y){
        this.x = x;
        this.y = y;
    }

    private void createLaby(){
        laby = new Graph(x*y);
        for(int j = 0 ;j < y;j++) {
            for (int i = 1; i < x; i++) {
                laby.addEdge(new Edge( j * x + i - 1,  j  * x + i));
            }
        }

        for(int j =0; j < y-1; j++){
            for(int i =0; i < x;i++){
                laby.addEdge(new Edge( j * x + i,  (j+1)  * x + i));
            }
        }

    }

    public void labyAldous(){
        createLaby();
        inverse = AldousBroder.couvrant(laby);
        int i;
        int j = 0;

        while(j < inverse.edges().size()){
            i = 0;
            while(i < laby.edges().size()){
                if(laby.edges().get(i).equals(inverse.edges().get(j))){
                    laby.deleteEdge(laby.edges().get(i));
                }
                else {
                    i++;
                }
            }
            j++;
        }
    }

    public void labyKruskal() {
        createLaby();
        inverse = Kruskal.couvrantKruskal(laby);
        int i;
        int j = 0;

        while(j < inverse.edges().size()){
            i = 0;
            while(i < laby.edges().size()){
                if(laby.edges().get(i).equals(inverse.edges().get(j))){
                    laby.deleteEdge(laby.edges().get(i));
                }
                else {
                    i++;
                }
            }
            j++;
        }

    }

    public void labyWilson(){
        createLaby();
        inverse = Wilson.couvrant(laby);
        int i;
        int j = 0;

        while(j < inverse.edges().size()){
            i = 0;
            while(i < laby.edges().size()){
                if(laby.edges().get(i).equals(inverse.edges().get(j))){
                    laby.deleteEdge(laby.edges().get(i));
                }
                else {
                    i++;
                }
            }
            j++;
        }
    }

    public int evalCulSac(){
        int res = 0;
        for(int i = 0; i < inverse.vertices();i++){
            if(inverse.adj(i).size() <= 1){
               res++;
            }
        }
        return res-2;
    }

    public int plusCourt(Graph g){
        int res = 0;

        return res;
    }

    public Graph getLaby() {
        return laby;
    }

    public static void main(String[] argv){
        Laby l = new Laby(5,5);
        l.labyAldous();
        System.out.println(l.evalCulSac());
        Test.printLaby(l.getLaby(),5,"tmp.tex");
    }

}
