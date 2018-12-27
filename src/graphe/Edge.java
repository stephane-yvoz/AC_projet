package src.graphe;
public class Edge
{
   int from;
   int to;
   boolean used;
    Edge(int x, int y)
    {
	this.from = x;
	this.to = y;
	this.used = false;
    }
    
    final int other(int v)
    {
	if (this.from == v) return this.to; else return this.from;
    }
    
    public boolean equals(Object o) {
    	if(!(o instanceof Edge)) {
    		return false;
    	}
    	return ((Edge)o).to == this.to && ((Edge)o).from == this.from; 
    }
    
}
