package algorithm;

/**
 * 
 * @author Adán Méndez
 * Esta clase guarda la informacion de las aristas
 */
public class Arista {
	int from;		//Nodo de origen
	int to;			//Nodo destino
	double cost;	//Costo de usar la arista
	
	/**
	 * Constructor
	 * @param from Nodo origen
	 * @param to Nodo destino
	 * @param cost Coste de la arista
	 */
	public Arista( int from, int to, double cost ){
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
	
	/**
	 * 
	 * @return to Devuelve el nodo destino
	 */
	public int getTo(){
		return this.to;
	}
	
	/**
	 * 
	 * @return devuelve el costo
	 */
	public double getCost(){
		return this.cost;
	}
}
