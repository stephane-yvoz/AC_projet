package src.partie2;

public class dynamique {
	
	public static int nbCombinaisons(int k,int n, int b,int m) {
		if(n==0) {
			return 1;
		}
		if(m==0) { // prouvé dans la question 10
			return combinaison(b,n) * arrangement(n-b,k-n);
		}
		if(b==0) {  //le premier élément ne peux pas être bien placé
			if(n==m) { //ni être faux
				if(m==1) { // si la solution envisagée est mauvaise
					return 0;
				}
				return factorielle(m-1);
			}
			return (m-1)* nbCombinaisons(k-1,n-1,b,m-1) + (k-n) * nbCombinaisons(k-1,n-1,b,m) +
					 m *nbCombinaisons(k-1,n-1,b,m-1)+ (k-n)*nbCombinaisons(k-1,n-1,b,m);
		}
		if(n==(b+m)) { // le premier élément ne peux pas être faux
			return nbCombinaisons(k-1,n-1,b-1,m) +(m-1)* nbCombinaisons(k-1,n-1,b,m-1) + (k-n) * nbCombinaisons(k-1,n-1,b,m);
		}
		return nbCombinaisons(k-1,n-1,b-1,m) +(m-1)* nbCombinaisons(k-1,n-1,b,m-1) + (k-n) * nbCombinaisons(k-1,n-1,b,m)
				+  m *nbCombinaisons(k-1,n-1,b,m-1)+ (k-n)*nbCombinaisons(k-1,n-1,b,m); 
	}

	
	public static int factorielle(int n) {
		if(n<=1) {
			return 1;
		}
		return n * factorielle(n-1); 
	}


	public static int arrangement(int k, int n) {
		return factorielle(n)/factorielle(n-k);
	}
	public static int combinaison(int k, int n) {
		return arrangement(k,n)/factorielle(k);
	}
}
