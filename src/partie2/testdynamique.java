package src.partie2;

public class testdynamique {
	
	public static void main(String[] args) {
		int k = 6;
		int n = 4;
		int b =1; 
		int m=2;
		
		System.out.println("nombre de combinaisons donnees par le programme dynamique : "+dynamique.nbCombinaisons(k, n, b, m));
		int majoration = dynamique.combinaison(b, n) * dynamique.combinaison(m, n-b) * dynamique.arrangement(m, n-b)
				         * dynamique.arrangement(n-b-m, k-n);
		System.out.println("Doit être majoré par : "+majoration);
	}

}
