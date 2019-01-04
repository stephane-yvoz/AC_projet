package src.algo;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import src.graphe.*;


public class Wilson {

    public static Graph couvrant(Graph g) {

        Graph arbre = new Graph(g.vertices());
        int current = 0;
        ArrayList<Edge> edges = new ArrayList<>();
        ArrayList<Edge> tmpEdge = new ArrayList<>();
        boolean[] visite = new boolean[g.vertices()];
        ArrayList<Integer> tmp = new ArrayList<>();

        //initialisation
        for(int i =0;i < visite.length;i++){
            visite[i] = false;
        }

        visite[0] = true; // on ajoute le sommet de depart qui est forcement visité

        while(!complet(visite)){

            current = getNextSommet(visite);
            tmp.add(current);
            // marche aléatoire
            while(!visite[current]){
                edges = g.adj(current);
                Collections.shuffle(edges);  // on mélange les arétes

                // on selectionne la première arrete
                tmpEdge.add(edges.get(0));

                current = edges.get(0).other(current); // on se place sur le nouveau sommet
                tmp.add(current);

                edges = g.adj(current); // on recupère les arrete du nouveau sommets
            }

            //on élimine les boucles
            int j;
            boolean stop;
            for(int i = 0;i < tmp.size();i++){
                j = tmp.size()-1;
                stop = false;
                while( j > i && !stop){
                    if(tmp.get(i) == tmp.get(j)){
                        for(int k = i;k < j ;k++){
                            tmp.remove(i);
                            tmpEdge.remove(i);
                        }
                        stop = true;
                    }
                    j--;
                }
            }


            //on ajoute les sommets et les arretes
            for(int i = 0;i < tmp.size();i++){
                visite[tmp.get(i)] = true;
            }
            for(int i = 0; i < tmpEdge.size();i++){
                arbre.addEdge(tmpEdge.get(i));
            }

            tmp.clear();
            tmpEdge.clear();


        }
        return arbre;
    }

    /**
     *
     * @param t un tableau représentant l'etat des sommets du graphs : visité ou non
     * @return vrai si tout les sommet sont visité
     */
    private static boolean complet(boolean[] t) {
        boolean res = false;
        int i = 0;
        while(i < t.length && t[i]){
            i++;
        }
        if(i >= t.length)
            res = true;

        return res;
    }

    /**
     *
     * @param t l'etat des sommets du graphe : visité = true, false sinon
     * @return un sommet qui n'est pas encore visité
     */
    private static int getNextSommet(boolean[] t){
        ArrayList<Integer> ar = new ArrayList<>();

        for(int i = 0; i < t.length;i++){
            if(!t[i])
                ar.add(i);
        }

        Collections.shuffle(ar);

        return ar.get(0);
    }
}
