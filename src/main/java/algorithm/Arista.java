package algorithm;

public class Arista {
	int from;		//Nodo de origen
	int to;			//Nodo destino
	double cost;	//Costo de usar la arista
	
	public Arista( int from, int to, double cost ){
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
	
	public int getTo(){
		return this.to;
	}
	
	public double getCost(){
		return this.cost;
	}
}
