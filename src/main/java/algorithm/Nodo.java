package algorithm;

import java.util.ArrayList;

public class Nodo {
	ArrayList<Arista> aristas;
	int nodoID;						
	int fromID = -1;			
	boolean done;					
	double doneCost;				
	
	public Nodo( int id ){
		this.nodoID = id;
		this.aristas = new ArrayList<Arista>();
		this.fromID = -1;
		this.done = false;
		this.doneCost = -1;
	}
	
	public void init(){
		fromID = -1;
		done = false;
		doneCost = -1;
	}
	
	public void addArista( int to, double cost ){
		Arista existEdge = getArista(to);
		if( existEdge == null ){
			Arista edge = new Arista(nodoID, to, cost);
			aristas.add( edge );
		} else {
			existEdge.cost = cost;
		}
	}
	
	/**
	 * @param to
	 * @param renewCost
	 */
	public void renewEdge( int toID, double renewCost ){
		Arista arista = getArista(toID);
		if( arista != null ){
			arista.cost = renewCost;
		}
	}
	
	public Arista getArista( int toID ){
		for( Arista arista : aristas ){
			if( arista.to == toID){
				return arista;
			}
		}
		return null;
	}
	
	public ArrayList<Arista> getEdges(){
		return aristas;
	}
	
	public void done(){
		this.done = true;
	}
	
	public boolean getDone(){
		return this.done;
	}
	
	public double getCost(){
		return this.doneCost;
	}
	
	public int getID(){
		return this.nodoID;
	}
	
	public void renewCost( double cost ){
		this.doneCost = cost;
	}
	
	public void renewFrom( int id ){
		this.fromID = id;
	}
	
	public int getFromID(){
		return this.fromID;
	}
}
