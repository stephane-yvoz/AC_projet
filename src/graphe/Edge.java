package src.graphe;
public class Edge
{
   private int from;
   private int to;
   private boolean used;
    public Edge(int x, int y)
    {
	this.setFrom(x);
	this.setTo(y);
	this.setUsed(false);
    }
    
    public final int other(int v)
    {
	if (this.getFrom() == v) return this.getTo(); else return this.getFrom();
    }
    
    
    /*
     * vérifie l'égalité pour deux Arétes non orienté
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object o) {
    	if(!(o instanceof Edge)) {
    		return false;
    	}
    	return (((Edge)o).getTo() == this.getTo() && ((Edge)o).getFrom() == this.getFrom())
    			||(((Edge)o).getTo() == this.getFrom() && ((Edge)o).getFrom() == this.getTo()); 
    }

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}
    
}
