package algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Dijkstra {

	ArrayList<Nodo> nodos;

	public Dijkstra(){
		this.nodos = new ArrayList<Nodo>();
	}
	
	public void initNodes(){
		for( Nodo nodo : nodos ){
			nodo.init();
		}
	}

	/**
	 * Algoritmo de Dijkstra
	 * @param startNodeID
	 */
	public void excute( int startNodeID ){
		initNodes();
		getNodo(startNodeID).renewCost(0.0);

		while(true){
			Nodo doneNodo = null;
			for( Nodo nodo : nodos ){
				if( nodo.getDone() || nodo.getCost() < 0 ){
					continue;
				}
				if( doneNodo == null || nodo.getCost() < doneNodo.getCost() ){
					doneNodo = nodo;
				}
			}
			if( doneNodo == null ){
				break;
			}

			doneNodo.done();
			for( Arista arista : doneNodo.aristas ){
				double cost = doneNodo.getCost() + arista.getCost();

				if( getNodo(arista.getTo()).getCost() < 0 || cost < getNodo(arista.getTo()).getCost() ){
					getNodo(arista.getTo()).renewCost(cost);
					getNodo(arista.getTo()).renewFrom(doneNodo.getID());
				}
			}
		}
	}

	/**
	 * 
	 * @param startID
	 * @param goalID
	 * @return
	 */
	public ArrayList<Integer> getTransitionStartToGoal( int startID, int goalID ){
		ArrayList<Integer> transition = new ArrayList<Integer>();

		transition.add( goalID );
		while(true){
			int to = transition.get(transition.size()-1);
			int from = getNodo(to).getFromID();
			if( from < 0){	//
				break;
			}

			transition.add(from);
			if( from == startID ){
				break;
			}
		}
		Collections.reverse(transition);
		return transition;
	}

	public Nodo getNodo( int id ){
		if( nodos.size() > 0 ){
			for( Nodo nodo : nodos ){
				if( nodo.getID() == id ){
					return nodo;
				}
			}
		}
		return null;
	}

	public void addNode( Nodo node ){
		this.nodos.add( node );
	}

	public void addNodeAndEdge( int fromID, int toID, double cost){
		Nodo node = getNodo(fromID);
		if( node != null ){
			node.addArista(toID, cost);
		} else {
			node = new Nodo(fromID);
			node.addArista(toID, cost);
			addNode(node);
		}
		
		if( getNodo(toID) == null ){
			Nodo toNodo = new Nodo(toID);
			addNode(toNodo);
		}
	}
	
	/**
	 * Dijkstra
	 */
	public void showAllNodeAndEdge(){
		System.out.println("!!!!! dijkstra node and edge !!!!!" );
		for( Nodo nodo : nodos ){
			System.out.print("node:" + nodo.nodoID);
			for( Arista arista : nodo.aristas){
				System.out.print(" edge:" + arista.to + "(" + arista.cost + ")");
			}
			System.out.println("");
		}
	}
}
