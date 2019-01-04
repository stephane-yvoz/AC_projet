package src.algo;

import java.util.ArrayList;
import java.util.Collections;
import src.graphe.*;


public class AldousBroder {

    public static Graph couvrant(Graph g) {

        Graph arbre = new Graph(g.vertices());
        int current = 0;
        ArrayList<Edge> edges = g.adj(current); // on choisit le sommet de départ : 0, pour que l'algorithme fonctionne on a pas besoin de chosir aléatoirement
        boolean[] visite = new boolean[g.vertices()];

        //initialisation
        for(int i =0;i < visite.length;i++){
            visite[i] = false;
        }

        visite[0] = true; // on ajoute le sommet de depart qui est forcement visité

        while(!complet(visite)){
            Collections.shuffle(edges);  // on mélange les arétes

            // on selectionne la première arrete, si on a pas visiter le sommet ou on arrive, on l'ajoute a la liste des sommet visité et on ajotue l'arète au graph couvrant
            if(!visite[edges.get(0).other(current)]){
                arbre.addEdge(edges.get(0));
                visite[edges.get(0).other(current)] = true;
            }
            current = edges.get(0).other(current); // on se place sur le nouveau sommet
            edges = g.adj(current); // on recupère les arrete du nouveau sommets
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
}
